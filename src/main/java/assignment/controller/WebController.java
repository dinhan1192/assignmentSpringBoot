package assignment.controller;

import assignment.entity.ProductEntity;
import assignment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    ProductService productService;

    @GetMapping({"/home"})
    public String home(Model model) {
        model.addAttribute("name", "T1808A");
        return "home";
    }

    @GetMapping("/getProduct/{id}")
    public String detailProduct(Model model, @PathVariable("id") int productid) {
        ProductEntity product = productService.getById(productid);
        model.addAttribute("product", product);
        return "detailProduct";
    }

    @GetMapping("/editProduct/{id}")
    public String editProduct(Model model, @PathVariable("id") int productid) {
        ProductEntity product = productService.getById(productid);
        model.addAttribute("product", product);
        return "editProduct";
    }

    @PostMapping("/updateProduct/{id}")
    public String editProduct(@PathVariable("id") int id, @Valid ProductEntity productEntity,
                              BindingResult result, Model model) {
        /*if (result.hasErrors()) {
            productEntity.setId(id);
            return "update-user";
        }*/

        productService.save(productEntity);
        model.addAttribute("products", productService.getAll());
        return "redirect:/listproduct";
    }

    @GetMapping("/addproduct")
    public String openAddProduct(Model model) {
        ProductEntity product = new ProductEntity();
        model.addAttribute("product", product);
        return "addproduct";
    }

    @PostMapping("/addproduct")
    public String addProduct(@ModelAttribute ProductEntity product) {
        productService.saveProduct(product);
        return "redirect:/listproduct";
    }

    @GetMapping({"/listproduct","/"})
    public String getAllProduct(Model model) {
        List<ProductEntity> list = productService.getAll();
        model.addAttribute("products", list);
        return "listproduct";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        ProductEntity productEntity = productService.getById(id);
        productService.delete(productEntity);
        model.addAttribute("products", productService.getAll());
        return "redirect:/listproduct";
    }
}

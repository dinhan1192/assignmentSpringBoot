package assignment.controller;

import assignment.dto.BaseDTO;
import assignment.entity.ProductEntity;
import assignment.service.ProductService;
import assignment.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

//    @RequestMapping(method = RequestMethod.GET)
//    @GetMapping
//    public BaseDTO getAllProduct() {
//        BaseDTO res = new BaseDTO();
//        res.setMessage("success");
//        res.setStatus(1);
//        List<ProductEntity> list = productService.getAll();
//        res.setData(list.get(0));
//        res.setDatas(list);
//        return res;
//    }


//    @GetMapping
//    public BaseDTO getAllProduct(@Param("name") String name, @Param("page") int page, @Param("limit") int limit) {
//        BaseDTO res = new BaseDTO();
//        res.setMessage("success");
//        res.setStatus(1);
//        Pageable pageable = PageRequest.of(page, limit);
//        Page<List<ProductEntity>> list = productService.findAllByName(name, pageable);
////        res.setData(list.getContent());
//        res.setDatas(list.getContent());
//        return res;
//    }

    @GetMapping
    public BaseDTO getAllProduct(@RequestHeader Map<String, String> allHeader, @RequestParam Map<String, String> allParams) {
        String name = allParams.get("name");
        int page = Utils.convertToInt(allParams.get("page"), 0);
        int limit = Utils.convertToInt(allParams.get("limit"), 3);
        String token = allHeader.get("token");

        BaseDTO res = new BaseDTO();
        res.setMessage("success");
        res.setStatus(1);
        Pageable pageable = PageRequest.of(page, limit);
        Page<List<ProductEntity>> list = productService.findAllByName(name, pageable);
//        res.setData(list.getContent());
        res.setDatas(list.getContent());
        return res;
    }
}

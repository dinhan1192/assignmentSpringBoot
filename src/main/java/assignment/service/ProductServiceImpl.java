package assignment.service;

import assignment.entity.ProductEntity;
import assignment.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepo productRepo;

    @Override
    public List<ProductEntity> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Page<List<ProductEntity>> findAllByName(String name, Pageable pageable) {
        return productRepo.findAllByName(name, pageable);
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        return productRepo.save(productEntity);
    }

    @Override
    public ProductEntity getById(int id) {
        return productRepo.getOne(id);
    }

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        productRepo.save(productEntity);
        return null;
    }

    @Override
    public ProductEntity delete(ProductEntity productEntity) {
        productRepo.delete(productEntity);
        return null;
    }

    public void handlerData() {

    }
}

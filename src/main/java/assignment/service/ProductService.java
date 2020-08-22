package assignment.service;

import assignment.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    List<ProductEntity> getAll();
    Page<List<ProductEntity>> findAllByName(String name, Pageable pageable);
    ProductEntity saveProduct(ProductEntity productEntity);
    ProductEntity getById(int id);
    ProductEntity save(ProductEntity productEntity);
    ProductEntity delete(ProductEntity productEntity);
}

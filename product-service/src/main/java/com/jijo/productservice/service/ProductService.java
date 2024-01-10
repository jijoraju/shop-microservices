package com.jijo.productservice.service;

import com.jijo.productservice.dto.ProductRequest;
import com.jijo.productservice.dto.ProductResponse;
import com.jijo.productservice.model.Product;
import com.jijo.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        var product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price()).build();
        productRepository.save(product);
        log.info("Product with id {} Created", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapProductToResponse).toList();
    }

    private ProductResponse mapProductToResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}

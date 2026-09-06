package com.example.ProyectoFinal.Service;

import com.example.ProyectoFinal.Dto.ProductDTO;
import com.example.ProyectoFinal.Model.ProductModel;
import com.example.ProyectoFinal.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProductService {private static ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        ProductService.productRepository = productRepository;
    }

    public ProductModel saveProduct(ProductModel product) {return productRepository.save(product);}

    public List<ProductModel> findAll() {return productRepository.findAll();}

    public static Optional<ProductModel> findById(Long id) {return productRepository.findById(id);}

    public ProductDTO findDTOById(Long id) {ProductModel product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return  new ProductDTO(product.getId(), product.getNombre(), product.getDescripcion(), product.getPrecio(), product.getCanDisp(), product.getCategoria(), product.getFecha());
    }

    public void deleteById(Long id) {productRepository.deleteById(id);}
}

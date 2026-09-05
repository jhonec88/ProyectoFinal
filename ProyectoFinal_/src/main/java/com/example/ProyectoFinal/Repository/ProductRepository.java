package com.example.ProyectoFinal.Repository;

import com.example.ProyectoFinal.Model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Collection;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

}
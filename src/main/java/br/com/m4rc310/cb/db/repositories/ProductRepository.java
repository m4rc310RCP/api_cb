package br.com.m4rc310.cb.db.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.m4rc310.cb.dto.products.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findByCodeProduct(Long codeProduct);
	Optional<Product> findByCodeProductAndCancelProductFalse(Long codeProduct);
}

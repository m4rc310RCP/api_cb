package br.com.m4rc310.cb.db.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.m4rc310.cb.dto.products.Product;
import br.com.m4rc310.cb.dto.products.ProductPrice;
import br.com.m4rc310.cb.dto.products.ProductPriceFK;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, ProductPriceFK> {
	List<ProductPrice> findAllByIdProduct(Product product);
	Optional<ProductPrice> findAllByIdProductAndDateInitLessThanEqualAndDateEndGreaterThanEqual(Product product, Date dateInit, Date dateEnd);
	List<ProductPrice> findAllByDateInitLessThanEqualAndDateEndGreaterThanEqual(Date dateInit, Date dateEnd);
	
    Optional<ProductPrice> findTopByIdProductOrderByIdSequenceDesc(Product product);

}

package br.com.m4rc310.cb.services;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.m4rc310.cb.dto.products.Product;
import br.com.m4rc310.cb.dto.products.ProductPrice;
import br.com.m4rc310.cb.dto.products.ProductPriceFK;
import br.com.m4rc310.gql.dto.MUser;
import br.com.m4rc310.gql.mappers.annotations.MAuth;
import br.com.m4rc310.gql.mappers.annotations.MDate;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Service
@GraphQLApi
public class StartupService extends MService {

	@Value("${IS_DEV:false}")
	private boolean isDev;

	@GraphQLQuery(name = QUERY$test_api, description = DESC$query_test_api)
	public String testAPI() {
		return "OK";
	}

	@MAuth(roles = "TEST_A")
	@GraphQLQuery(name = QUERY$user_token, description = DESC$query_user_token)
	public String createToken(@GraphQLArgument(name = NAME$username, description = DESC$name_username) String username,
			@GraphQLArgument(name = VALUE$password, description = DESC$value_password) String password) {
		MUser user = new MUser();
		user.setUsername(username);
		user.setPassword(username);
		user.setRoles("ADMIN".split(";"));
		if (isDev) {
			return jwt.generateToken(user);
		}
		return "";
	}
	
	@GraphQLQuery(name=QUERY$list_product, description=DESC$query_list_product)
	public List<Product> listProduct(){
		return productRepository.findAll();
	}
	
	@GraphQLQuery(name=QUERY$product, description=DESC$query_product)
	public Product getProduct(@GraphQLArgument(name = CODE$product, description = DESC$code_product) Long codeProduct) {
		return productRepository.findById(codeProduct).orElse(null);
	}

	@GraphQLMutation(name = MUTATION$product, description = DESC$mutation_product)
	public Product persistProduct(
			@GraphQLArgument(name = ARGUMENT$product, description = DESC$argument_product) Product product) {

		Long code = product.getCodeProduct();

		Product local = new Product();
		if (code != null) {
			local = productRepository.findByCodeProduct(code).orElse(local);
			flux.cloneAtoB(product, local);
		}

		return productRepository.saveAndFlush(product);
	}

	@GraphQLQuery(name = NAME$product, description = DESC$name_product)
	public String getProductName(@GraphQLContext ProductPrice pp) {
		try {
			return pp.getId().getProduct().getNameProduct();
		} catch (Exception e) {
			return null;
		}
	}
	
	@GraphQLQuery(name=VALUE$product, description=DESC$value_product)
	public BigDecimal getProductValue(@GraphQLContext Product product) {
		try {
			Date now = new Date();
			Optional<ProductPrice> opp = productPriceRepository.findAllByIdProductAndDateInitLessThanEqualAndDateEndGreaterThanEqual(product, now, now);
			if (opp.isPresent()) {
				return opp.get().getProductValue();
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}
	

	@GraphQLQuery(name = QUERY$list_product_price, description = DESC$query_list_product_price)
	public List<ProductPrice> getProductPriceList() {
		Date now = new Date();
		return productPriceRepository.findAllByDateInitLessThanEqualAndDateEndGreaterThanEqual(now, now);
	}

	@GraphQLMutation(name = MUTATION$price_product, description = DESC$mutation_price_product)
	public ProductPrice mutationPriceProduct(
			@GraphQLArgument(name = CODE$product, description = DESC$code_product) Long codeProduct,
			@GraphQLArgument(name = VALUE$product, description = DESC$value_product) BigDecimal productValue,
			@MDate("dd/MM/yyyy HH:mm:ss") @GraphQLArgument(name = DATE$end, description = DESC$date_end) Date dateEnd)
			throws Exception {

		Product product = productRepository.findByCodeProductAndCancelProductFalse(codeProduct).orElse(new Product());
		product.setCodeProduct(codeProduct);

		Date now = new Date();
		if (now.after(dateEnd)) {
			throw new Exception("Date os end vigency as before to now");
		}

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);

		Optional<ProductPrice> optionalProductPrice = productPriceRepository
				.findAllByIdProductAndDateInitLessThanEqualAndDateEndGreaterThanEqual(product, now, now);

		if (optionalProductPrice.isPresent()) {
			ProductPrice pp = optionalProductPrice.get();
			pp.setDateEnd(now);
			productPriceRepository.save(pp);
		}

		calendar.add(Calendar.SECOND, 1);
		ProductPrice pp = new ProductPrice();
		pp = new ProductPrice();
		pp.setDateInit(calendar.getTime());
		pp.setDateEnd(dateEnd);
		
		pp.setProductValue(productValue);
		
		Long sequence = productPriceRepository.findTopByIdProductOrderByIdSequenceDesc(product)
				.map(p -> p.getId().getSequence()).orElse(0L);
		sequence++;

		pp.setId(new ProductPriceFK());
		pp.getId().setProduct(product);
		pp.getId().setSequence(sequence);

		return productPriceRepository.save(pp);
	}

}

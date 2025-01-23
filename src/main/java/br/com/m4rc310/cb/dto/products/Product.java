package br.com.m4rc310.cb.dto.products;

import br.com.m4rc310.cb.i18n.MConst;
import io.leangen.graphql.annotations.GraphQLQuery;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = MConst.TYPE$product)
public class Product implements MConst {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = CODE$product)
	@GraphQLQuery(name=CODE$product, description=DESC$code_product)
	private Long codeProduct;
	
	@Column(name = NAME$product)
	@GraphQLQuery(name=NAME$product, description=DESC$name_product)
	private String nameProduct;
	
	@Column(name = INDICATOR$cancel)
	@GraphQLQuery(name=INDICATOR$cancel, description=DESC$indicator_cancel)
	private boolean cancelProduct;
}

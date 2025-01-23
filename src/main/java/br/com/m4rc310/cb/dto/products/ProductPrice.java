package br.com.m4rc310.cb.dto.products;

import java.math.BigDecimal;
import java.util.Date;

import br.com.m4rc310.cb.i18n.MConst;
import io.leangen.graphql.annotations.GraphQLIgnore;
import io.leangen.graphql.annotations.GraphQLQuery;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = MConst.TYPE$product_price)
public class ProductPrice implements MConst{
	
	@EmbeddedId
	@GraphQLIgnore
	private ProductPriceFK id;
	
	@Column(name = VALUE$product)
	@GraphQLQuery(name=VALUE$product, description=DESC$value_product)
	private BigDecimal productValue;
	
	@Column(name = DATE$init)
	@GraphQLQuery(name=DATE$init, description=DESC$date_init)
	private Date dateInit;
	
	@Column(name = DATE$end)
	@GraphQLQuery(name=DATE$end, description=DESC$date_end)
	private Date dateEnd;
}

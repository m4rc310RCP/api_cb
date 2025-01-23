package br.com.m4rc310.cb.dto.products;

import br.com.m4rc310.cb.i18n.MConst;
import io.leangen.graphql.annotations.GraphQLQuery;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Embeddable
public class ProductPriceFK implements MConst{
	
	@ManyToOne()
	@JoinColumn(name = CODE$product)
	private Product product;
	
	@GraphQLQuery(name=NUMBER$sequence, description=DESC$number_sequence)
	@Column(name = NUMBER$sequence)
	private Long sequence;
}

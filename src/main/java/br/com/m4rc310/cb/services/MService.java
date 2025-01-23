package br.com.m4rc310.cb.services;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.m4rc310.cb.db.repositories.ProductPriceRepository;
import br.com.m4rc310.cb.db.repositories.ProductRepository;
import br.com.m4rc310.cb.i18n.MConst;

public class MService extends br.com.m4rc310.gql.services.MService implements MConst {
	
	@Autowired
	protected ProductRepository productRepository;

	@Autowired
	protected ProductPriceRepository productPriceRepository;
	
	
}

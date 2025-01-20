package br.com.m4rc310.cb.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.m4rc310.gql.dto.MUser;
import br.com.m4rc310.gql.mappers.annotations.MAuth;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Service
@GraphQLApi
public class StartupService extends MService{
	
	@Value("${IS_DEV:false}")
	private boolean isDev;
	
	
	@GraphQLQuery(name=QUERY$test_api, description=DESC$query_test_api)
	public String testAPI() {
		return "OK";
	}
	
	@MAuth(roles = "TEST_A")
	@GraphQLQuery(name=QUERY$user_token, description=DESC$query_user_token)
	public String createToken(
			@GraphQLArgument(name=NAME$username, description=DESC$name_username)String username,
			@GraphQLArgument(name=VALUE$password, description=DESC$value_password)String password) {
		MUser user = new MUser();
		user.setUsername(username);
		user.setPassword(username);
		user.setRoles("ADMIN".split(";"));
		if (isDev) {
			return jwt.generateToken(user);			
		}
		return "";
	}
	
	
}

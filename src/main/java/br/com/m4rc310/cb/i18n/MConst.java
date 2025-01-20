package br.com.m4rc310.cb.i18n;


import br.com.m4rc310.gql.annotations.MConstants;

@MConstants
public interface MConst {
	//--------------------------------------------------
	// ********** DESC **********
	//--------------------------------------------------
	public static final String DESC$name_username = "${desc.name.username}";
	public static final String DESC$query_test_api = "${desc.query.test.api}";
	public static final String DESC$query_user_token = "${desc.query.user.token}";
	public static final String DESC$value_password = "${desc.value.password}";

	//--------------------------------------------------
	// ********** NAME **********
	//--------------------------------------------------
	// @GraphQLQuery(name=NAME$username, description=DESC$name_username)
	public static final String NAME$username = "${name.username}";

	//--------------------------------------------------
	// ********** QUERY **********
	//--------------------------------------------------
	// @GraphQLQuery(name=QUERY$test_api, description=DESC$query_test_api)
	public static final String QUERY$test_api = "${query.test.api}";
	// @GraphQLQuery(name=QUERY$user_token, description=DESC$query_user_token)
	public static final String QUERY$user_token = "${query.user.token}";

	//--------------------------------------------------
	// ********** VALUE **********
	//--------------------------------------------------
	// @GraphQLQuery(name=VALUE$password, description=DESC$value_password)
	public static final String VALUE$password = "${value.password}";


}

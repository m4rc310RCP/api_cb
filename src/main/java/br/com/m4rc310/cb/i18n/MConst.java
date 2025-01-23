package br.com.m4rc310.cb.i18n;


import br.com.m4rc310.gql.annotations.MConstants;

@MConstants
public interface MConst {
	//--------------------------------------------------
	// ********** ARGUMENT **********
	//--------------------------------------------------
	// @GraphQLArgument(name=ARGUMENT$product, description=DESC$argument_product)
	public static final String ARGUMENT$product = "${argument.product}";

	//--------------------------------------------------
	// ********** CODE **********
	//--------------------------------------------------
	// @GraphQLQuery(name=CODE$product, description=DESC$code_product)
	public static final String CODE$product = "${code.product}";

	//--------------------------------------------------
	// ********** DATE **********
	//--------------------------------------------------
	// @GraphQLQuery(name=DATE$end, description=DESC$date_end)
	public static final String DATE$end = "${date.end}";
	// @GraphQLQuery(name=DATE$init, description=DESC$date_init)
	public static final String DATE$init = "${date.init}";

	//--------------------------------------------------
	// ********** DESC **********
	//--------------------------------------------------
	public static final String DESC$argument_product = "${desc.argument.product}";
	public static final String DESC$code_product = "${desc.code.product}";
	public static final String DESC$date_end = "${desc.date.end}";
	public static final String DESC$date_init = "${desc.date.init}";
	public static final String DESC$indicator_cancel = "${desc.indicator.cancel}";
	public static final String DESC$mutation_price_product = "${desc.mutation.price.product}";
	public static final String DESC$mutation_product = "${desc.mutation.product}";
	public static final String DESC$name_product = "${desc.name.product}";
	public static final String DESC$name_username = "${desc.name.username}";
	public static final String DESC$number_sequence = "${desc.number.sequence}";
	public static final String DESC$query_list_product = "${desc.query.list.product}";
	public static final String DESC$query_list_product_price = "${desc.query.list.product.price}";
	public static final String DESC$query_product = "${desc.query.product}";
	public static final String DESC$query_test_api = "${desc.query.test.api}";
	public static final String DESC$query_user_token = "${desc.query.user.token}";
	public static final String DESC$type_product = "${desc.type.product}";
	public static final String DESC$type_product_price = "${desc.type.product.price}";
	public static final String DESC$value_password = "${desc.value.password}";
	public static final String DESC$value_product = "${desc.value.product}";

	//--------------------------------------------------
	// ********** INDICATOR **********
	//--------------------------------------------------
	// @GraphQLQuery(name=INDICATOR$cancel, description=DESC$indicator_cancel)
	public static final String INDICATOR$cancel = "${indicator.cancel}";

	//--------------------------------------------------
	// ********** MUTATION **********
	//--------------------------------------------------
	// @GraphQLMutation(name=MUTATION$price_product, description=DESC$mutation_price_product)
	public static final String MUTATION$price_product = "${mutation.price.product}";
	// @GraphQLMutation(name=MUTATION$product, description=DESC$mutation_product)
	public static final String MUTATION$product = "${mutation.product}";

	//--------------------------------------------------
	// ********** NAME **********
	//--------------------------------------------------
	// @GraphQLQuery(name=NAME$product, description=DESC$name_product)
	public static final String NAME$product = "${name.product}";
	// @GraphQLQuery(name=NAME$username, description=DESC$name_username)
	public static final String NAME$username = "${name.username}";

	//--------------------------------------------------
	// ********** NUMBER **********
	//--------------------------------------------------
	// @GraphQLQuery(name=NUMBER$sequence, description=DESC$number_sequence)
	public static final String NUMBER$sequence = "${number.sequence}";

	//--------------------------------------------------
	// ********** QUERY **********
	//--------------------------------------------------
	// @GraphQLQuery(name=QUERY$list_product, description=DESC$query_list_product)
	public static final String QUERY$list_product = "${query.list.product}";
	// @GraphQLQuery(name=QUERY$list_product_price, description=DESC$query_list_product_price)
	public static final String QUERY$list_product_price = "${query.list.product.price}";
	// @GraphQLQuery(name=QUERY$product, description=DESC$query_product)
	public static final String QUERY$product = "${query.product}";
	// @GraphQLQuery(name=QUERY$test_api, description=DESC$query_test_api)
	public static final String QUERY$test_api = "${query.test.api}";
	// @GraphQLQuery(name=QUERY$user_token, description=DESC$query_user_token)
	public static final String QUERY$user_token = "${query.user.token}";

	//--------------------------------------------------
	// ********** TYPE **********
	//--------------------------------------------------
	// @GraphQLType(name=MConst.TYPE$product, description=MConst.DESC$type_product)
	public static final String TYPE$product = "${type.product}";
	// @GraphQLType(name=MConst.TYPE$product_price, description=MConst.DESC$type_product_price)
	public static final String TYPE$product_price = "${type.product.price}";

	//--------------------------------------------------
	// ********** VALUE **********
	//--------------------------------------------------
	// @GraphQLQuery(name=VALUE$password, description=DESC$value_password)
	public static final String VALUE$password = "${value.password}";
	// @GraphQLQuery(name=VALUE$product, description=DESC$value_product)
	public static final String VALUE$product = "${value.product}";


}

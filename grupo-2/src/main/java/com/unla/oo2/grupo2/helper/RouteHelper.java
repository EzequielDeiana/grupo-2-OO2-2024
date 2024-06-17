package com.unla.oo2.grupo2.helper;

public class RouteHelper {

	// Routes for the home page
	public static final String INDEX = "/index";
	public static final String HOME_INDEX = "/home/index";

	// Routes for the user pages
	public static final String USER_LOGIN = "/user/login";
	public static final String USER_LOGOUT = "/user/logout";
	public static final String USER_LOGIN_PROCESS = "/user/loginprocess";
	public static final String USER_LOGIN_SUCCESS = "/user/loginsucces";

	// Routes for the login pages
	public static final String LOGIN = "/login";
	public static final String LOGIN_SUCCESS = "/loginsuccess";
	public static final String LOGOUT = "/logout";
	public static final String LOGOUT_SUCCESS = "/logoutsuccess";

	// Routes for compra pages
	public static final String COMPRA_INDEX = "/compra/index";
	public static final String COMPRA_NEW = "/compra/new";
	public static final String COMPRA_UPDATE = "/compra/update";

	// Routes for pedidocompra pages
	public static final String PEDIDOCOMPRA_INDEX = "/pedidocompra/index";
	public static final String PEDIDOCOMPRA_NEW = "/pedidocompra/new";
	public static final String PEDIDOCOMPRA_UPDATE = "/pedidocompra/update";

	// Routes for producto pages
	public static final String PRODUCTO_INDEX = "/producto/index";
	public static final String PRODUCTO_NEW = "/producto/new";
	public static final String PRODUCTO_UPDATE = "/producto/update";

	// Routes for productovendido pages
	public static final String PRODUCTOVENDIDO_INDEX = "/productovendido/index";

	// Routes for venta pages
	public static final String VENTA_INDEX = "/venta/index";
	public static final String VENTA_NEW = "/venta/new";
	public static final String VENTA_UPDATE =  "/venta/update";
	
	// Routes generic
	public static final String EMPTY = "";
	public static final String SLASH = "/";

	// Routes resources
	public static final String STATIC_ALL = "/static/*";

	// Routes custom
	public static final String CUSTOM_ERROR = "/error/error";



}

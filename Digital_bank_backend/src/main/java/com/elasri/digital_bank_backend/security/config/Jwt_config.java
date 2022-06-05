package com.elasri.digital_bank_backend.security.config;

public class Jwt_config {

    public static String REFRESH_PATH = "/api/refresh-token";
    public static String SECRET_PHRASE = "yousk2";
    public static String AUTHORIZATION_HEADER = "Authorization";
    public static String TOKEN_HEADER_PREFIX = "Bearer ";
    public static int ACCESS_TOKEN_EXPIRATION = 2*24*60*60*1000; // 2mins
    public static int REFRESH_TOKEN_EXPIRATION = 30*24*60*60*1000; // 10 mins

}

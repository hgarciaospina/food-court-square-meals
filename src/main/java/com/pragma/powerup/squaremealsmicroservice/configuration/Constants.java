package com.pragma.powerup.squaremealsmicroservice.configuration;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }
    public static final int TIN_NUMBER_LENGTH = 9;
    public static final String NAME_PATTERN = "^[a-zA-Z\\s]+$";
    public static final String DESCRIPTION_PATTERN = "^[a-zA-Z\\s]+$";
    public static final Long OWNER_ROLE_ID = 4L;
    public static final int MAX_PAGE_SIZE = 2;
    public static final String TIN_NUMBER_FORMAT = "^[1-9]\\d{0,8}$";
    public static final String DATE_TIME_FORMAT ="yyyy-MM-dd";
    public static final String RESPONSE_MESSAGE_KEY = "message";
    public static final String CATEGORY_NAME_ALREADY_EXISTS_MESSAGE = "A category already exists with the name provided";
    public static final String CATEGORY_NAME_INVALID_MESSAGE = "The category name must be alphabetic";
    public static final String  CATEGORY_NAME_NULL_EMPTY_BLANK_INVALID_MESSAGE = "The category name cannot be null, blank or empty";
    public static final String  CATEGORY_DESCRIPTION_NULL_EMPTY_BLANK_INVALID_MESSAGE = "The category description cannot be null, blank or empty";
    public static final String CATEGORY_DESCRIPTION_INVALID_MESSAGE = "The category description must be alphabetic";
    public static final String RESTAURANT_CREATED_MESSAGE = "Restaurant created successfully";
    public static final String RESTAURANT_DELETED_MESSAGE = "Restaurant deleted successfully";
    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error";
    public static final String WRONG_CREDENTIALS_MESSAGE = "Wrong credentials or role not allowed";
    public static final String NO_DATA_FOUND_MESSAGE = "No data found for the requested petition";
    public static final String TIN_ALREADY_EXISTS_MESSAGE = "A restaurant already exists with the tin provided";
    public static final String  TIN_LENGTH_INVALID_MESSAGE = "The tin number must have 9 digits";
    public static final String RESTAURANT_NAME__ALREADY_EXISTS_MESSAGE = "A restaurant already exists with the name provided";
    public static final String OWNER_NOT_FOUND_MESSAGE = "No owner found with the id provided";
    public static final String OWNER_IS_NOT_MESSAGE = "Not a user with owner role or the user does not exist";
    public static final String RESTAURANT_NOT_FOUND_MESSAGE = "No restaurant found with the id provided";
    public static final String ROLE_NOT_ALLOWED_MESSAGE = "No permission granted to create users with this role";
    public static final String  OWNER_ALREADY_EXISTS_MESSAGE = "A owner already exists with the id provided";
    public static final String SWAGGER_TITLE_MESSAGE = "Food Court API Pragma Power Up";
    public static final String SWAGGER_DESCRIPTION_MESSAGE = "Food Court microservice";
    public static final String SWAGGER_VERSION_MESSAGE = "1.0.0";
    public static final String SWAGGER_LICENSE_NAME_MESSAGE = "Apache 2.0";
    public static final String SWAGGER_LICENSE_URL_MESSAGE = "http://springdoc.org";
    public static final String SWAGGER_TERMS_OF_SERVICE_MESSAGE = "http://swagger.io/terms/";
}
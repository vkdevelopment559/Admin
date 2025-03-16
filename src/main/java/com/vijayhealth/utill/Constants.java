package com.vijayhealth.utill;

public class Constants {

    private Constants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    //Constant
    public static final String SUCCESSFULLY_DELETED = "Deleted Successfully";
    public static final String message = "message";
    public static final String field = "Fields:";
    public static final String missing = " are missing";
    public static final String comma_operator = ",";
    public static final String error = "error";
    public static final String mandatory_field = "Mandatory fields are empty";


    public static String deleteResponse(Enums.Feature feature, String msg) {
        return feature.getMessage() + " with ResId/tag " + msg + " deleted successfully";
    }

    public static String deleteActiveResponse(Enums.Feature feature, String msg) {
        return feature.getMessage() + " with ResId/tag " + msg + " is active and cannot be deleted.";
    }

    public static String getDeleteNotSuccessMessage(Enums.Feature feature, String message, String name) {
        return feature.getMessage() + " with ResId/tag " + message + "." + " contains existing " + name;
    }

    //triggers Constant
    public static final String QUERY ="SELECT 1 FROM information_schema.triggers WHERE trigger_name = ?";
    public static final String USER_DETAIL_TRIGGERS= "classpath:triggers/academic_year_triggers.sql";
    public static final String BOOK_DETAIL_TRIGGERS= "classpath:triggers/book_detail_trigger.sql";
}

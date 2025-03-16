package com.vijayhealth.utill;

public class Constants {

    private Constants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static final String QUERY ="SELECT 1 FROM information_schema.triggers WHERE trigger_name = ?";
    public static final String USER_DETAIL_TRIGGERS= "classpath:triggers/academic_year_triggers.sql";
    public static final String BOOK_DETAIL_TRIGGERS= "classpath:triggers/book_detail_trigger.sql";
}

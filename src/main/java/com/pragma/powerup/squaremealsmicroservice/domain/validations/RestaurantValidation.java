package com.pragma.powerup.squaremealsmicroservice.domain.validations;
import com.pragma.powerup.squaremealsmicroservice.configuration.Constants;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.pragma.powerup.squaremealsmicroservice.configuration.Constants.TIN_NUMBER_FORMAT;
import static com.pragma.powerup.squaremealsmicroservice.configuration.Constants.TIN_NUMBER_LENGTH;

public class RestaurantValidation {
    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern(
            Constants.DATE_TIME_FORMAT);

    public static boolean dateValidFormat(String birthdate) {
        try {
            DATETIME_FORMATTER.parse(birthdate);
            return true;
        } catch (DateTimeParseException exception) {
            return false;
        }
    }
    public static boolean validateTin(String tin) {
        try {
            Pattern pattern = Pattern.compile((TIN_NUMBER_FORMAT));
            Matcher matcher = pattern.matcher(tin);
            return matcher.matches();
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean idRolValid(Long idRol) {
        return (idRol >=1 && idRol <=5);
    }
    public static boolean lengthValidTinNumber(String tin) {
        return tin.length() == TIN_NUMBER_LENGTH; }
}
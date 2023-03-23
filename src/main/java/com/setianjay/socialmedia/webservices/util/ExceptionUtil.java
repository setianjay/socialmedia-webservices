package com.setianjay.socialmedia.webservices.util;

import org.springframework.validation.FieldError;

import java.util.*;

public class ExceptionUtil {

    public static Map<String, List<String>> getFieldsWithError(List<FieldError> fieldsError){
        Map<String, List<String>> errorsData = new HashMap<>();
        for(FieldError fieldError: fieldsError){
            String fieldName = fieldError.getField();

            if(errorsData.containsKey(fieldName)){
                errorsData.get(fieldName).add(fieldError.getDefaultMessage());
            }else{
                errorsData.put(fieldName, new ArrayList<>(){{ add(fieldError.getDefaultMessage()); }});
            }
        }

        return Collections.unmodifiableMap(errorsData);
    }
}

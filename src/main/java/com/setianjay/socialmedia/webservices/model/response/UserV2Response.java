package com.setianjay.socialmedia.webservices.model.response;

import java.time.LocalDate;

public record UserV2Response(Long id, String name, LocalDate birthDate, Integer age) {
}

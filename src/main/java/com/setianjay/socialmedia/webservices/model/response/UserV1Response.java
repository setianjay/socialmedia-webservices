package com.setianjay.socialmedia.webservices.model.response;

import java.time.LocalDate;

public record UserV1Response(Long id, String name, LocalDate birthDate) {
}

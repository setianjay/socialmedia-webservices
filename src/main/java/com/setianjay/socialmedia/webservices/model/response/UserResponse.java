package com.setianjay.socialmedia.webservices.model.response;

import java.time.LocalDate;

public record UserResponse(Long id, String name, LocalDate birthDate) {
}

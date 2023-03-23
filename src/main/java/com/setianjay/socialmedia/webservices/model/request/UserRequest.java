package com.setianjay.socialmedia.webservices.model.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UserRequest(
        @Size(min = 3, message = "Name must be at least 3 characters long") @NotEmpty(message = "Name can't be empty") String name,
        @Past(message = "Date of birth must be in the past") LocalDate birthDate) {
}

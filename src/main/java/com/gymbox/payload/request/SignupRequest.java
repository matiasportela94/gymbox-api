package com.gymbox.payload.request;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.Set;

@Data
public class SignupRequest {
    @NotEmpty(message = "The email is required.")
    @NotNull
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotEmpty(message = "The password is required.")
    @NotNull
    @NotBlank
    @Size(min = 6, max = 40, message = "The length of password must be between 2 and 40 characters.")
    private String password;

    @NotEmpty(message = "The DNI is required.")
    @NotNull
    @NotBlank
    private Long dni;

    @NotEmpty(message = "The full name is required.")
    @NotNull
    @NotBlank
    @Size(min = 2, max = 100, message = "The length of first name must be between 2 and 100 characters.")
    private String firstName;

    @NotEmpty(message = "The full name is required.")
    @NotNull
    @NotBlank
    @Size(min = 2, max = 100, message = "The length of last name must be between 2 and 100 characters.")
    private String lastName;

    private Set<String> role;
}

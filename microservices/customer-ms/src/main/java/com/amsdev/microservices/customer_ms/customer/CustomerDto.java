package com.amsdev.microservices.customer_ms.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerDto(
        String id,

        @NotNull(message = "Nombre es requerido")
        @NotBlank(message = "Nombre no puede ser vacio")
        String firstName,

        @NotNull(message = "Apellidos es requerido")
        @NotBlank(message = "Los apellidos no pueden ser vacios")
        String lastName,

        @NotNull(message = "Correo electronico es requerido")
        @NotBlank(message = "El correo electronico no puede ser vacio")
        @Email(message = "Correo Electronico no es valido")
        String email,

        String phone,

        String address,

        String city
) {


}

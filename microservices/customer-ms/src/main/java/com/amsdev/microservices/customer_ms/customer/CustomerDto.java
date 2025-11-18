package com.amsdev.microservices.customer_ms.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerDto(
        String id,

        @NotNull(message = "Nombre es requerido")
        String firstName,

        @NotNull(message = "Apellidos es requerido")
        String lastName,

        @NotNull(message = "Correo electronico es requerido")
        @Email(message = "Correo Electronico no es valido")
        String email,

        String phone,

        String address,

        String city
) {


}

package com.example.demothymeleaf.Service.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long customerId;
    private Long storeId;
    private String firstName;
    private String lastName;
    private String email;
    private Long addressId;
    private Boolean active;
}

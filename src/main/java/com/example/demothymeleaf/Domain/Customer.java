package com.example.demothymeleaf.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Customer.getCustomerDetailsById", query = "select  c.customerId, c.firstName, c.lastName, c.email, c.address.address, c.address.district, c.address.postalCode from Customer c where c.customerId = :id"),
        @NamedQuery(name = "Customer.getSimilarFirstLastName", query = "select c.customerId, c.firstName, c.lastName, c.email from Customer c where c.firstName like concat('%', :query, '%') or c.lastName like concat('%', :query, '%')"),
        @NamedQuery(name = "Customer.getCustomerDetailsByName", query = "select c.customerId, c.firstName, c.lastName, c.email, c.address.address, c.address.district, c.address.postalCode from Customer c where c.firstName = :name"),
        @NamedQuery(name = "Customer.getCustomerDetailsByDate", query = "select c.customerId, c.firstName, c.lastName, c.email from Customer c where c.lastUpdate > :date"),
})

public class Customer {
    @Id
    @Column(name = "customer_id")
    private int customerId;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @JoinColumn(name = "address_id")
    @OneToOne
    private Address address;

    @Column(name = "active")
    private Byte active;

    @Column(name = "create_date")
    private java.sql.Timestamp createDate;

    @Column(name = "last_update")
    private java.sql.Timestamp lastUpdate;
}


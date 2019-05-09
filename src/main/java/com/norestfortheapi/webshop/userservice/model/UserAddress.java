package com.norestfortheapi.webshop.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserAddress {

    @Id
    @GeneratedValue
    private Long id;

    private String country;
    private String city;
    private String address;
    private Integer zipCode;

    @OneToOne(mappedBy = "address")
    @EqualsAndHashCode.Exclude
    @JsonIgnoreProperties("address")
    private ShitwishUser user;

}

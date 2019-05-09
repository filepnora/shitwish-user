package com.norestfortheapi.webshop.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Builder
@Entity
public class ShitwishUser {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique=true, nullable = false)
    private String userName;
    private String password;
    private String email;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonIgnoreProperties({"user"})
    private UserAddress address;

}

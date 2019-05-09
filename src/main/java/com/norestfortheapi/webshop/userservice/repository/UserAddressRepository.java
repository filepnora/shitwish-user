package com.norestfortheapi.webshop.userservice.repository;

import com.norestfortheapi.webshop.userservice.model.ShitwishUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<ShitwishUser, String> {

}

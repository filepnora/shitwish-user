package com.norestfortheapi.webshop.userservice.repository;

import com.norestfortheapi.webshop.userservice.model.ShitwishUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShitwishUserRepository extends JpaRepository<ShitwishUser, String> {

    ShitwishUser getById(Long userId);

    ShitwishUser findByUserName(String username);

}

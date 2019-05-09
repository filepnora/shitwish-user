package com.norestfortheapi.webshop.userservice.service;

import com.norestfortheapi.webshop.userservice.model.ShitwishUser;
import com.norestfortheapi.webshop.userservice.model.UserAddress;
import com.norestfortheapi.webshop.userservice.repository.ShitwishUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private ShitwishUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ShitwishUser getUserById(Long userId) {
        return userRepository.getById(userId);
    }

    public ShitwishUser authenticateUser(ShitwishUser user) {
        ShitwishUser userToLogIn = userRepository.findByUserName(user.getUserName());

        if (userToLogIn != null){
            if (passwordEncoder.matches(user.getPassword(), userToLogIn.getPassword())){
                return userToLogIn;
            }
        }
        return null;
    }


    public void registerUser(ShitwishUser newUser) {
        UserAddress newAddress = UserAddress.builder().country("").city("").address("").zipCode(0).build();
        newUser.setAddress(newAddress);

        newAddress.setUser(newUser);
        userRepository.save(newUser);
    }
}

package com.learn.jpa.domain;

import com.learn.jpa.dto.*;
import jakarta.persistence.*;

import java.util.*;

/**
 * @author Krishna Chaitanya
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false)
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static User fromUserDTO(UserDTO dto) {
        User user = new User();
        if (Objects.nonNull(dto.id())) {
            user.setId(dto.id());
        }
        user.setName(dto.name());
        user.setAddress(dto.address());
        return user;
    }

    public static UserDTO toUserDTO(User user) {
        return new UserDTO(user.id, user.name, user.address);
    }

}

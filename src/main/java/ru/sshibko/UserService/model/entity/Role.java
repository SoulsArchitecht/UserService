package ru.sshibko.UserService.model.entity;

import lombok.Getter;
import java.io.Serializable;

@Getter
public enum Role implements Serializable {
    USER("USER"),
    ADMIN("ADMIN");

    private final String role;

    Role(String role) {
        this.role = role;
    }
}

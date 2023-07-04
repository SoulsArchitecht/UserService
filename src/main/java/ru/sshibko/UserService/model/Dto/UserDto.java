package ru.sshibko.UserService.model.Dto;

import ru.sshibko.UserService.model.entity.Role;

import java.time.LocalDate;

public record UserDto(long id, String firstName, String lastName, String email, LocalDate birthday, Role role) {
}

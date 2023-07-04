package ru.sshibko.UserService.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sshibko.UserService.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

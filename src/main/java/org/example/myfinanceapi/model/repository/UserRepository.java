package org.example.myfinanceapi.model.repository;

import org.example.myfinanceapi.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    public Optional<UserEntity> findByCpf(String cpf);
}

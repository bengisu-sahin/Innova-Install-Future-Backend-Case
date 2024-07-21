package com.installfuturecase.InstallFutureBackendCase.dataAcces.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.installfuturecase.InstallFutureBackendCase.entities.User;

@Repository
public interface IUsersRepository extends JpaRepository<User, Integer> {
    Optional<User> findByIdAndEmail(int id, String email);
    boolean existsByEmail(String email);
}

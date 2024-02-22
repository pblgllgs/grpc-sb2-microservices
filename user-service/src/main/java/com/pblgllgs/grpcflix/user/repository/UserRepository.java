package com.pblgllgs.grpcflix.user.repository;

import com.pblgllgs.grpcflix.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}

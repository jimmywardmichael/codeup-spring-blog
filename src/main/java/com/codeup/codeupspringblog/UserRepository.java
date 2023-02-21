package com.codeup.codeupspringblog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
public interface UserRepository extends JpaRepository<User, Long> {

}
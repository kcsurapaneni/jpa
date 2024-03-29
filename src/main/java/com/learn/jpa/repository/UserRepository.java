package com.learn.jpa.repository;

import com.learn.jpa.domain.*;
import org.springframework.data.jpa.repository.*;

/**
 * @author Krishna Chaitanya
 */

public interface UserRepository extends JpaRepository<User, Integer> {
}

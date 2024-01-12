package com.learn.jpa.repository;

import com.learn.jpa.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;

public interface CategoryRepository extends JpaRepository<Category, Integer>, JpaSpecificationExecutor<Category>, QueryByExampleExecutor<Category> {
}
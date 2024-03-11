package com.bfi.backend.admin.repository;

import com.bfi.backend.admin.entities.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blogs, Long> {
}

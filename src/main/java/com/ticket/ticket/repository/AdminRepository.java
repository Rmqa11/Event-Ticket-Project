package com.ticket.ticket.repository;

import com.ticket.ticket.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin , Integer>{

    Admin findByUsername(String username);
}

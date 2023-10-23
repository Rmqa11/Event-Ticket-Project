package com.ticket.ticket.service.interfaces;

import com.ticket.ticket.entity.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAdmin();

    void createAdmin(Admin admin);
}

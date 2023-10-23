package com.ticket.ticket.service.Implemntation;

import com.ticket.ticket.entity.Admin;
import com.ticket.ticket.repository.AdminRepository;
import com.ticket.ticket.service.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAdmin() {
        return adminRepository.findAll();
    }
    public void createAdmin(Admin admin){
        adminRepository.save(admin);
    }


//    public List<Admin> getAdmin() {
//        return adminRepository.findAll();
//    }
}

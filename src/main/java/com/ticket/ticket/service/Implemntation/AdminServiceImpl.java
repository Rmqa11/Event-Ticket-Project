package com.ticket.ticket.service.Implemntation;

import com.ticket.ticket.entity.Admin;
import com.ticket.ticket.repository.AdminRepository;
import com.ticket.ticket.service.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public String updateAdmin(int adminId, Admin admin) {
        Optional<Admin> adminFound = adminRepository.findById(adminId);
        if(adminFound.isPresent()){
            admin.setUsername(admin.getUsername());
            adminRepository.save(admin);
            return "Admin Details Updated";
        }
        else {
            return "Admin with course code " + adminId + " not found";

        }
    }

    @Override
    public String deleteAdmin(int adminId) {
        if(adminRepository.existsById(adminId)){
            adminRepository.deleteById(adminId);
            return "Admin deleted Successfully";
        }
        else{
            return "Admin not found";
        }

    }


}

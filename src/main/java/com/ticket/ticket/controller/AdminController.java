package com.ticket.ticket.controller;

import com.ticket.ticket.entity.Admin;
import com.ticket.ticket.entity.Event;
import com.ticket.ticket.repository.AdminRepository;
import com.ticket.ticket.repository.EventRepository;
import com.ticket.ticket.service.Implemntation.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminServiceImpl adminServiceImpl;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private AdminRepository adminRepository;

    // Handle HTTP GET requests to retrieve a list of admins
    @GetMapping("/admin")
    public List<Admin> getAdmin(){
        return adminServiceImpl.getAdmin();
    }

    // Handle HTTP POST requests to create a new admin
    @PostMapping("/create")
    public ResponseEntity<String> createAdmin(@RequestBody Admin admin){
        try{
            adminServiceImpl.createAdmin(admin);
            String message = "Admin Added Successfully";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }
        catch(Exception e){
            String errorMessage = "Admin Not Added successfully" + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }
    // Handle HTTP PUT requests to update an admin by ID
    @PutMapping("/update/{adminId}")
    public String updateAdmin(@PathVariable int adminId, @RequestBody Admin admin){
        return adminServiceImpl.updateAdmin(adminId, admin);
    }
    // Handle HTTP DELETE requests to delete an admin by ID
    @DeleteMapping("/delete/{adminId}")
    public String deleteAdmin(@PathVariable int adminId) {
        try {
            adminServiceImpl.deleteAdmin(adminId);
            return "Admin deleted successfully";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}

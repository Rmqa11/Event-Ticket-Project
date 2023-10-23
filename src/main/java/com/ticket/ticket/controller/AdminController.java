package com.ticket.ticket.controller;

import com.ticket.ticket.entity.Admin;
import com.ticket.ticket.service.Implemntation.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminServiceImpl adminServiceImpl;
    @GetMapping("/users")
    public List<Admin> getAdmin(){
        return adminServiceImpl.getAdmin();
    }

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

}

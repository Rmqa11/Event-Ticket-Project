package com.ticket.ticket;

import com.ticket.ticket.entity.Admin;
import com.ticket.ticket.entity.RegisterUser;
import com.ticket.ticket.entity.User;
import com.ticket.ticket.repository.AdminRepository;
import com.ticket.ticket.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TicketApplicationTests {
@Autowired
private UserRepository userRepository;
@Autowired
private AdminRepository adminRepository;
	@Test
	void contextLoads() {
		//RegisterUser registerUser = new RegisterUser("rahaf");
		Admin admin = new Admin(1,"rahaf1","r123","admin");
		adminRepository.save(admin);



	}

}

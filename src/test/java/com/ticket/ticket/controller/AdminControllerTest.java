package com.ticket.ticket.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticket.ticket.entity.Admin;
import com.ticket.ticket.service.Implemntation.AdminServiceImpl;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class AdminControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    @MockBean
    private AdminServiceImpl adminServiceImpl;

    private final ObjectMapper objectMapper = new ObjectMapper();
    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();    }
    @Test
    public void testGetAdmin() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/admin"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("admin5"));
    }

    @Test
    public void testCreateAdmin() throws Exception {
        Admin admin = new Admin();
        admin.setUsername("admin5");
        doNothing().when(adminServiceImpl).createAdmin(admin);
        String adminJson = "{\n" +
                "  \"userId\": 3,\n" +
                "  \"username\": \"admin5\",\n" +
                "  \"password\": \"cv55\",\n" +
                "  \"role\": \"Admin\"\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post("/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(adminJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Admin Added Successfully"));
    }
    @Test
    public void testDeleteAdminSuccess() throws Exception {
        int adminId = 1;
        when(adminServiceImpl.deleteAdmin(adminId)).thenReturn(String.valueOf(true));
        mockMvc.perform(MockMvcRequestBuilders.delete("/delete/{adminId}", adminId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Admin deleted successfully"));
    }


}
package com.ticket.ticket.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticket.ticket.entity.Ticket;
import com.ticket.ticket.repository.TicketRepository;
import com.ticket.ticket.service.Implemntation.TicketServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.when;
@SpringBootTest
class TicketControllerTest {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private TicketRepository ticketRepository;

    @MockBean
    private TicketServiceImpl ticketServiceImpl;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }
    @Test
    public void testCreateTicket() throws Exception {
        Ticket ticket = new Ticket();
        ticket.setTicketId(3);
        ticket.setPrice(200.0);
        ticket.setType("VIP");
        when(ticketServiceImpl.createTicket(ticket)).thenReturn(ticket);
        ObjectMapper objectMapper = new ObjectMapper();
        String ticketJson = objectMapper.writeValueAsString(ticket);

        mockMvc.perform(MockMvcRequestBuilders.post("/create/ticket")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ticketJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Ticket Added Successfully"));
    }
    @Test
    public void testDeleteTicket() throws Exception {
        int ticketId = 3;
        mockMvc.perform(MockMvcRequestBuilders.delete("/ticket/delete/{ticketId}", ticketId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Ticket deleted successfully"));
    }
    @Test
    public void testGetAllTickets() throws Exception {
        List<Ticket> tickets = Arrays.asList(new Ticket(), new Ticket());
        when(ticketRepository.findAll()).thenReturn(tickets);

        mockMvc.perform(MockMvcRequestBuilders.get("/ticket"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

}
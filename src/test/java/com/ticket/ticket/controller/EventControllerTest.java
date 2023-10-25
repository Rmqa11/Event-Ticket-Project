package com.ticket.ticket.controller;

import com.ticket.ticket.entity.Event;
import com.ticket.ticket.repository.EventRepository;
import com.ticket.ticket.service.Implemntation.EventServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class EventControllerTest {

    private MockMvc mockMvc;

    private EventRepository eventRepository;
    @MockBean
    private EventServiceImpl eventServiceImpl;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void testUpdateEvent() throws Exception {
        int eventId = 2;
        Event updatedEvent = new Event();
        when(eventServiceImpl.updateEvent(eventId, updatedEvent)).thenReturn("Event Details Updated");
        String updatedEventJson = "{\n" +
                "        \"eventId\": 2,\n" +
                "        \"title\": \"Mohammed\",\n" +
                "        \"date\": \"2023-11-23\",\n" +
                "        \"description\": \"Music\",\n" +
                "        \"location\": \"Abha\",\n" +
                "        \"eventType\": \"Concerts\"\n" +
                "  \n" +
                "    }";
        mockMvc.perform(MockMvcRequestBuilders.put("/event/{eventId}", eventId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedEventJson))
                .andExpect(MockMvcResultMatchers.status().isOk()) // Expect HTTP 200
                .andExpect(MockMvcResultMatchers.content().string("Event Details Updated"));
    }
}
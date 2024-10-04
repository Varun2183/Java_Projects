package com.tnsif.placement.demo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.placement.demo.controller.ChaitraCertificateController;
import com.placement.demo.model.ChaitraCertificate;
import com.placement.demo.service.ChaitraCertificateService;

@WebMvcTest(ChaitraCertificateController.class)
public class ChaitraCertificateControllerTest {
 

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ChaitraCertificateService service;

    @Autowired
    private ObjectMapper objectMapper; // To serialize and deserialize JSON

    private ChaitraCertificate chaitraCertificate;

    @BeforeEach
    void setUp() {
        // Initialize the Certificate object with sample data
        chaitraCertificate = new ChaitraCertificate(1, 2003, "ABC College", 701);
    }

    @Test
    public void testGetCollegeById() throws Exception {
        // Mock the service to return the Certificate object when get() is called
        when(service.get(1)).thenReturn(chaitraCertificate);

        // Perform a GET request and verify the response
        mockMvc.perform(get("/Certificate/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(chaitraCertificate.getId()))
                .andExpect(jsonPath("$.year").value(chaitraCertificate.getYear()))
                .andExpect(jsonPath("$.college").value(chaitraCertificate.getCollege()));
    }

    @Test
    public void testGetAllCertificate() throws Exception {
        // Mock the service to return a list containing the certificate object
        when(service.listAll()).thenReturn(Arrays.asList(chaitraCertificate));

        // Perform a GET request and verify the response
        mockMvc.perform(get("/Certificate"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(chaitraCertificate.getId()))
                .andExpect(jsonPath("$[0].year").value(chaitraCertificate.getYear()))
                .andExpect(jsonPath("$[0].college").value(chaitraCertificate.getCollege()));
    }

    @Test
    public void testAddCertificate() throws Exception {
        // Handle the void method by doing nothing when save() is called
         doNothing().when(service).create(any(ChaitraCertificate.class)); 

        // Perform a POST request to add a new CollegeService object
        mockMvc.perform(post("/Certificate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(chaitraCertificate)))
                .andExpect(status().isOk());
    }
}



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
import com.placement.demo.controller.SahanaSACollegeController;
import com.placement.demo.model.RahulUser;
import com.placement.demo.model.SahanaSACollege;
import com.placement.demo.DTO.SahanaDTO;
import com.placement.demo.service.RahulUserService;
import com.placement.demo.service.SahanaSACollegeService;

/**
 * Unit tests for the SahanaSACollegeController class.
 */
@WebMvcTest(SahanaSACollegeController.class)
public class CollegeServicesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SahanaSACollegeService service;

    @MockBean
    private RahulUserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    private SahanaSACollege collegeService;
    private RahulUser rahulUser;

    @BeforeEach
    void setUp() {
        // Initialize the test data
        collegeService = new SahanaSACollege(1, "John Doe", "ABC College", "New York", 101);
        rahulUser = new RahulUser(101, "Rahul", "rahul@example.com", "45565", 101);
    }

    @Test
    public void testGetCollegeById() throws Exception {
        // Mock the service methods
        when(service.get(1)).thenReturn(collegeService);
        when(userService.get(101)).thenReturn(rahulUser);

        // Mock SahanaDTO
        SahanaDTO sahanaDTO = new SahanaDTO(collegeService.getCollege_id(),
                                            collegeService.getCollegeAdmin(),
                                            collegeService.getCollegeName(),
                                            collegeService.getLocation(),
                                            rahulUser);

        // Perform a GET request and validate the response
        mockMvc.perform(get("/colleges/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.college_id").value(sahanaDTO.getCollege_id()))
                .andExpect(jsonPath("$.collegeAdmin").value(sahanaDTO.getCollegeAdmin()))
                .andExpect(jsonPath("$.collegeName").value(sahanaDTO.getCollegeName()))
                .andExpect(jsonPath("$.location").value(sahanaDTO.getLocation()))
                .andExpect(jsonPath("$.rahulUser.userId").value(sahanaDTO.getUser().getId()))
                .andExpect(jsonPath("$.rahulUser.userName").value(sahanaDTO.getUser().getName()));
    }

    @Test
    public void testGetAllColleges() throws Exception {
        // Mock the service method to return a list of colleges
        when(service.listAll()).thenReturn(Arrays.asList(collegeService));

        // Perform a GET request and validate the response
        mockMvc.perform(get("/colleges"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].college_id").value(collegeService.getCollege_id()))
                .andExpect(jsonPath("$[0].collegeAdmin").value(collegeService.getCollegeAdmin()))
                .andExpect(jsonPath("$[0].collegeName").value(collegeService.getCollegeName()))
                .andExpect(jsonPath("$[0].location").value(collegeService.getLocation()));
    }

    @Test
    public void testAddCollege() throws Exception {
        // Mock the save method to do nothing
        doNothing().when(service).save(any(SahanaSACollege.class));

        // Perform a POST request and validate the response
        mockMvc.perform(post("/colleges")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(collegeService)))
                .andExpect(status().isOk());
    }
}




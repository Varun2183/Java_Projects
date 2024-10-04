package com.tnsif.placement.demo;

import static org.junit.jupiter.api.Assertions.*;


import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.placement.demo.model.RonitPlacement;
import com.placement.demo.repository.RonitPlacementRepository;
import com.placement.demo.service.RonitPlacementService;

class PlacementTests {
	//Mock instance is used to create an instance that does not affect the the entity
	@Mock
	private RonitPlacementRepository repo;
	
	@InjectMocks
	private RonitPlacementService serv;
	
	private RonitPlacement place;
	
	//Resets the instance every time its called 
	@BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);  // Initialize mocks

        place = new RonitPlacement(1, "dileep","Don Bosco", LocalDate.of(2025, 9, 25),"BE",2025,701);  // Sample Admin instance
    }
	
	//Testing the complete instance 
	@Test
	void testListAll() {
		List<RonitPlacement> places = Arrays.asList(place);
		when(repo.findAll()).thenReturn(places);
		
		List<RonitPlacement> result = serv.listAll();
        assertEquals(1, result.size());
        verify(repo, times(1)).findAll();
	}
	
	//Testing by getting id
	@Test
    void testGetPlacementById() {
        when(repo.findById(1)).thenReturn(Optional.of(place));

        RonitPlacement found = serv.get(1);
        assertNotNull(found);
        assertEquals("dileep", found.getName());
        verify(repo, times(1)).findById(1);
    }
	
	@Test
    void testCreatePlacement() {
        serv.save(place);
        verify(repo, times(1)).save(place);
    }
	
	@Test
    void testUpdatePlacement() {
        // Similar to create since the save method updates if the record exists
        serv.save(place);
        verify(repo, times(1)).save(place);
    }

    @Test
    void testDeletePlacement() {
        serv.delete(1);
        verify(repo, times(1)).deleteById(1);
    }

    @Test
    void testGetPlacementById_NotFound() {
    	int invalidId = 75;
		when(repo.findById(invalidId)).thenReturn(Optional.empty());
		RonitPlacement notFound = serv.get(invalidId);
		assertNull(notFound, "Expected Null when placement not found");
		verify(repo, times(1)).findById(invalidId);
    }

}

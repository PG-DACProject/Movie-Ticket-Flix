package com.multiplex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiplex.dtos.HallCapacityDTO;
import com.multiplex.models.Hall;
import com.multiplex.services.HallService;

@CrossOrigin
@RestController
@RequestMapping("/api/halls")
public class HallController {
	@Autowired private HallService service;

    @PostMapping("seats")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> saveHallSeats(@RequestBody HallCapacityDTO hc){
        service.saveCapacity(hc);
        return ResponseEntity.ok().body("Hall Seats saved successfully");
    }
    
    @DeleteMapping("seats/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteSeat(@PathVariable("id") int id){
        service.deleteSeat(id);
        return ResponseEntity.ok("Seat deleted successfully");
    }
    
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> saveHall(@RequestBody Hall hall){
        service.save(hall);
        return ResponseEntity.ok().body("Hall saved successfully");
    }

    @GetMapping
  // @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> listall(){
        return ResponseEntity.ok(service.listall());
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteHall(@PathVariable("id") int id){
        service.deleteHall(id);
        return ResponseEntity.ok("Hall deleted successfully");
    }

    @GetMapping("{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> findDetails(@PathVariable("id") int id){
        return ResponseEntity.ok().body(service.findById(id));
    }
}

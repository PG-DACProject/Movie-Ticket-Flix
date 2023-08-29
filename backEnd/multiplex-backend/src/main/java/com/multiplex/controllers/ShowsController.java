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

import com.multiplex.dtos.SearchDTO;
import com.multiplex.dtos.ShowDTO;
import com.multiplex.services.ShowsService;

@CrossOrigin
@RestController
@RequestMapping("/api/shows")
public class ShowsController {
	@Autowired private ShowsService mService;
	

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> saveShow(@RequestBody ShowDTO dto){
    	System.out.println(dto);
        mService.save(dto);
        return ResponseEntity.ok().body("Show saved successfully");
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> listall(){
        return ResponseEntity.ok(mService.listall());
    }
    
    @GetMapping("todays")
   // @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> todayShows(){
        return ResponseEntity.ok(mService.todayShows());
    }
    
    @GetMapping("search")
   // @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> searchShows(SearchDTO dto){
        return ResponseEntity.ok(mService.searchShows(dto));
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") int id){
        mService.deleteShow(id);
        return ResponseEntity.ok("Show deleted successfully");
    }

    @GetMapping("{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> findDetails(@PathVariable("id") int id){
        return ResponseEntity.ok().body(mService.findById(id));
    }
}

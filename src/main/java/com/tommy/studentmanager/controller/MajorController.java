package com.tommy.studentmanager.controller;

import com.tommy.studentmanager.model.Major;
import com.tommy.studentmanager.model.Student;
import com.tommy.studentmanager.repository.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class MajorController {
    @Autowired
    private MajorRepository majorRepository;

    @GetMapping("/major")
    public ResponseEntity<List<Major>> get() {
        return ResponseEntity.ok(majorRepository.findAll());
    }

    @GetMapping("/major/{id}")
    public ResponseEntity<Major> getById(@PathVariable(value = "id") Long majorId){
        Optional<Major> major = majorRepository.findById(majorId);
        return ResponseEntity.ok(major.get());
    }

    @PostMapping("/major")
    public ResponseEntity<Major> create(@Valid @RequestBody Major major){

        return ResponseEntity.ok(majorRepository.save(major));
    }

    @PutMapping("/major/{id}")
    public ResponseEntity<Major> update(@PathVariable(value = "id") Long  majorId, @Valid @RequestBody Major majorDetails) {
        if(!majorRepository.findById(majorId).isPresent()){
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(majorRepository.save(majorDetails));
    }

    @DeleteMapping("/major/{id}")
    public  ResponseEntity<Major> deleteById(@PathVariable(value = "id") Long majorId){
        majorRepository.deleteById(majorId);
        return ResponseEntity.ok().build();
    }
}

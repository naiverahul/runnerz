package dev.rahulagar.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/api/runs")
public class RunController {
    private final RunRepository runRepository;

    public  RunController(RunRepository runRepository){
        this.runRepository = runRepository;
    }
    @GetMapping
    List<Run> findAll(){
        return  runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);
        if(run.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return run.get();
    }

    //post
    void create(@RequestBody Run run){
        runRepository.create(run);
    }

    //put



}
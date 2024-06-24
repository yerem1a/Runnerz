package com.example.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> findAll(){
        return runs;
    }

    Run findById(Integer id){
        return runs.stream()
                .filter(run->run.id() == id)
                .findFirst()
                .get();
    }

    @PostConstruct
    private void init(){
        runs.add(new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plus(1,
                ChronoUnit.HOURS), 5, Location.OUTDOOR)
        );
        runs.add(new Run(2, "Second Run", LocalDateTime.now(), LocalDateTime.now().plus(1,
                ChronoUnit.HOURS), 5, Location.INDOOR)
        );
    }



}

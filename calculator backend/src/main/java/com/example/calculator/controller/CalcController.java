package com.example.calculator.controller;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class CalcController {

    @GetMapping("/add")
    public int addition(@RequestParam List<Integer>numbers){
        return numbers
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    @GetMapping("/sub")
    public int subtraction(@RequestParam List<Integer>number){
        return number
                .stream()
                .reduce((a,b)->a-b)
                .orElse(0);
    }

    @GetMapping("/mul")
    public int multiplication(@RequestParam List<Integer>number){
        return number
                .stream()
                .reduce((a,b)->a*b)
                .orElse(1);

    }

    @GetMapping("/div")
    public double division(@RequestParam List<Double>number){
        return number
                .stream()
                .reduce((a,b)->a/b)
                .orElse(Double.NaN);
    }
}

package com.example.demo.controller;

import com.example.demo.entity.GrattaEVinci;
import com.example.demo.repo.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GEVController {

    @Autowired
    DemoRepository demoRepository;

    /*
    Lists the information on all the tickets in the database

    @return: list of info on the tickets
     */
    @GetMapping("/all")
    public List<GrattaEVinci> getAll(){
        return demoRepository.findAll();
    }

    /*
    Checks whether it's a winning or losing ticket

    @param num: number of the ticket

    @return: a simple string containing the result of the check
     */
    @GetMapping("/check/num")
    public String check(@RequestParam(value = "num", defaultValue = "-1") Integer num){
        String result = "";

        if (num < 0){
            return "To search for a ticket the number must be specified!";
        }

        List<GrattaEVinci> list = demoRepository.findByNumber(num);

        if(list.isEmpty()){
            result = "Ticket num. " + num + " not found!";
        }
        else if(list.get(0).getIs_winner()){
            result = "Congratulations, you have won!";
        }
        else{
            result = "Unfortunately you have lost, try again!";
        }

        return result;
    }
}
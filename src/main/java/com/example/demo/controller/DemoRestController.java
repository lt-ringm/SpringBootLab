package com.example.demo.controller;

import com.example.demo.entity.ScratchAndWin;
import com.example.demo.repo.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoRestController {

    /*
        ---------------------
         REST API CONTROLLER
        ---------------------
    */

    @Autowired
    DemoRepository demoRepository;


    /*
    Retrieves the info on a scratch&win by id

    @param id: identifier

    @return: scratch&win
     */
    @GetMapping("/rest")
    public ScratchAndWin getById(@RequestParam Integer id){
        return demoRepository.findById(id).get();
    }

    /*
    Retrieves the info on a scratch&win by number

    @param num: number

    @return: scratch&win
     */
    @GetMapping("/rest/num")
    public ScratchAndWin getByNum(@RequestParam Integer num){
        return demoRepository.findByNumber(num).get(0);
    }

    /*
    Lists the information on all the scratch&win in the database

    @return: list of info on the scratch&win
     */
    @GetMapping("/rest/all")
    public List<ScratchAndWin> getAll(){
        return demoRepository.findAll();
    }

    /*
    Adds a new scratch&win to the database

    @param scratchAndWin: scratch&win to be added

    @return: the resulting new scratch&win
     */

    @PostMapping("/rest")
    public ScratchAndWin add(@RequestBody ScratchAndWin scratchAndWin){
            return demoRepository.save(scratchAndWin);
    }

    /*
    Updates the scratch&win infos

    @param scratchAndWin: scratch&win
    @param id: identifier

    @return: scratch&win
     */
    @PutMapping("/rest")
    ScratchAndWin update(@RequestBody ScratchAndWin scratchAndWin, @RequestParam Integer id) {

        return demoRepository.findById(id).map(gev -> {
            gev.setNumber(scratchAndWin.getNumber());
            gev.setIs_winner(scratchAndWin.getIs_winner());
            return demoRepository.save(gev);
        }).orElseGet(() -> {
            scratchAndWin.setId(id);
            return demoRepository.save(scratchAndWin);
        });
    }

    /*
    Delete a scratch&win

    @param id: identifier

    @return:
     */
    @DeleteMapping("/rest")
    void delete(@RequestParam Integer id) {
        demoRepository.deleteById(id);
    }

    /*
    Delete all records in the database

    @return:
     */
    @DeleteMapping("/rest/all")
    void deleteAll(){
        demoRepository.deleteAll();
    }

}
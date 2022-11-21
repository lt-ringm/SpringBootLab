package com.example.demo.controller;

import com.example.demo.entity.ScratchAndWin;
import com.example.demo.repo.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
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

    @return: scratch&win info if it exists or else error
     */
    @GetMapping("/rest/{id}")
    public ResponseEntity<ScratchAndWin> get(@PathVariable("id") Integer id){

        ResponseEntity<ScratchAndWin> res;

        // Check if the scratch and win exists
        if (demoRepository.findById(id).isPresent()){
            res = new ResponseEntity<>(demoRepository.findById(id).get(), HttpStatus.OK);
        }
        else{
            res = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return res;
    }

    /*
    Lists the information on all the scratch&win in the database

    @return: list of info on all the scratch&win
     */
    @GetMapping("/rest")
    public List<ScratchAndWin> getAll(){
        return demoRepository.findAll();
    }

    /*
    Adds a new scratch&win to the database

    @param scratchAndWin: scratch&win to be added

    @return: the resulting new scratch&win
     */

    @PostMapping("/rest")
    public ResponseEntity<ScratchAndWin> add(@RequestBody ScratchAndWin scratchAndWin){

        ResponseEntity<ScratchAndWin> res;

        try{
            res = new ResponseEntity<>(demoRepository.save(scratchAndWin), HttpStatus.OK);
        }
        catch (TransactionSystemException | DataIntegrityViolationException e){
            res = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return res;
    }

    /*
    Updates the scratch&win infos

    @param scratchAndWin: scratch&win
    @param id: identifier

    @return: scratch&win
     */
    @PutMapping("/rest/{id}")
    public ResponseEntity<ScratchAndWin> update(@RequestBody ScratchAndWin scratchAndWin, @PathVariable("id") Integer id) {

        ResponseEntity<ScratchAndWin> res;

        res = demoRepository.findById(id).map(gev -> {
            gev.setNum1(scratchAndWin.getNum1());
            gev.setNum2(scratchAndWin.getNum2());
            gev.setNum3(scratchAndWin.getNum3());
            gev.setNum4(scratchAndWin.getNum4());
            gev.setWinner(scratchAndWin.getWinner());
            gev.setPrize(scratchAndWin.getPrize());
            gev.setBought(scratchAndWin.isBought());
            return new ResponseEntity<>(demoRepository.save(gev), HttpStatus.OK);
        }).orElseGet(() -> {
            scratchAndWin.setId(id);

            try{
                return new ResponseEntity<>(demoRepository.save(scratchAndWin), HttpStatus.OK);
            }
            catch (TransactionSystemException | DataIntegrityViolationException e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        });

        return res;
    }


    /*
    Delete a scratch&win

    @param id: identifier

    @return:
     */
    @DeleteMapping("/rest/{id}")
    public void delete(@PathVariable("id") Integer id) {
        demoRepository.deleteById(id);
    }

    /*
    Delete all records in the database

    @return:
     */
    @DeleteMapping("/rest/all")
    public void deleteAll(){
        demoRepository.deleteAll();
    }

}
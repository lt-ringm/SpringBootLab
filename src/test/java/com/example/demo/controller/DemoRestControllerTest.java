package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.example.demo.entity.ScratchAndWin;
import com.example.demo.repo.DemoRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.TransactionSystemException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DemoRestController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
class DemoRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DemoRepository demoRepositoryMock;


    @Test
    void getById() throws Exception {

        ScratchAndWin scratchAndWin = new ScratchAndWin(1234, 1, 2, 3, 4, 5, 5.0, false);

        // This scratch and win should be found
        given(demoRepositoryMock.findById(1234)).willReturn(Optional.of(scratchAndWin));

        mvc.perform(get("/rest/1234")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // This shouldn't be found
        given(demoRepositoryMock.findById(5678)).willReturn(Optional.empty());

        mvc.perform(get("/rest/5678")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound())
            .andReturn();

    }

    @Test
    void getAll() throws Exception {

        List<ScratchAndWin> tickets = new ArrayList<>();
        tickets.add(new ScratchAndWin(1234, 1, 2, 3, 4, 5, 5.0, false));
        tickets.add(new ScratchAndWin(4321, 1, 7, 3, 4, 10, 15.0, false));
        tickets.add(new ScratchAndWin(3412, 8, 2, 5, 9, 5, 10.0, true));

        given(demoRepositoryMock.findAll()).willReturn(tickets);

        mvc.perform(get("/rest")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id':1234,'num1':1,'num2':2,'num3':3,'num4':4,'winner':5,'prize':5.0,'bought':false}," +
                        "{'id':4321,'num1':1,'num2':7,'num3':3,'num4':4,'winner':10,'prize':15.0,'bought':false}," +
                        "{'id':3412,'num1':8,'num2':2,'num3':5,'num4':9,'winner':5,'prize':10.0,'bought':true}]"))
                .andReturn();

    }

    @Test
    void add() throws Exception {

        ScratchAndWin good = new ScratchAndWin(1234, 1, 2, 3, 4, 5, 5.0, false);
        ScratchAndWin bad1 = new ScratchAndWin(4321, 15, 12, 23, 54, 75, 5.0, false);
        ScratchAndWin bad2 = new ScratchAndWin(3412, 1, 2, 3, 4, null, 5.0, false);

        given(demoRepositoryMock.save(Mockito.any())).willReturn(good);

        // Should be added
        mvc.perform(post("/rest")
                .contentType(MediaType.APPLICATION_JSON)
                .content(good.toString()))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id':1234,'num1':1,'num2':2,'num3':3,'num4':4,'winner':5,'prize':5.0,'bought':false}"))
                .andReturn();

        // Should not be added
        given(demoRepositoryMock.save(bad1)).willThrow(TransactionSystemException.class);
        given(demoRepositoryMock.save(bad2)).willThrow(DataIntegrityViolationException.class);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteAll() {
    }
}
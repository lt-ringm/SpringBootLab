package com.example.demo.repo;

import com.example.demo.entity.ScratchAndWin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoRepository extends JpaRepository<ScratchAndWin, Integer> {

    List<ScratchAndWin> findAll();

}

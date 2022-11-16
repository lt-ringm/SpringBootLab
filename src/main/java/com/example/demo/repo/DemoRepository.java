package com.example.demo.repo;

import com.example.demo.entity.GrattaEVinci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoRepository extends JpaRepository<GrattaEVinci, Integer> {

    List<GrattaEVinci> findAll();
    List<GrattaEVinci> findByNumber(Integer number);

}

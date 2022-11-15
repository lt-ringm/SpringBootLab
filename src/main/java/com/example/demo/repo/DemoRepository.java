package com.example.demo.repo;

import com.example.demo.entity.GrattaEVinci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends JpaRepository<GrattaEVinci, Integer> {



}

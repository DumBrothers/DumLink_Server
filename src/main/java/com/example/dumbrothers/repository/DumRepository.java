package com.example.dumbrothers.repository;

import com.example.dumbrothers.entity.Dum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface DumRepository extends JpaRepository<Dum,Long> {
    @Override
    ArrayList<Dum> findAll();
}

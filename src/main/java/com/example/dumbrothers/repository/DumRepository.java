package com.example.dumbrothers.repository;

import com.example.dumbrothers.entity.Dum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface DumRepository extends JpaRepository<Dum,Long> {
    @Override
    ArrayList<Dum> findAll();

}

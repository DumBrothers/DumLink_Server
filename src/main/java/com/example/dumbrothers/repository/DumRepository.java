package com.example.dumbrothers.repository;

import com.example.dumbrothers.entity.Dum;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface DumRepository extends CrudRepository<Dum,Long> {
    @Override
    ArrayList<Dum> findAll();
}

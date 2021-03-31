package com.final_exam.module4.service;

import com.final_exam.module4.model.National;
import com.final_exam.module4.repository.NationalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationalServiceImpl implements NationalService{
    @Autowired
    NationalRepository nationalRepository;

    @Override
    public List<National> findAllNational() {
        return nationalRepository.findAll();
    }

}

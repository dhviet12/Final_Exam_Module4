package com.final_exam.module4.service;

import com.final_exam.module4.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService {
    Page<City> findAllCity(Pageable pageable);
    City findById(Long id);
    City save(City city);
    void delete(City city);

}

package com.final_exam.module4.service;

import com.final_exam.module4.model.City;
import com.final_exam.module4.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityRepository cityRepository;

    @Override
    public Page<City> findAllCity(Pageable pageable) {
        return cityRepository.findAllByOrderById(pageable);
    }

    @Override
    public City findById(Long id) {
        return cityRepository.getOne(id);
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void delete(City city) {
        cityRepository.delete(city);
    }
}

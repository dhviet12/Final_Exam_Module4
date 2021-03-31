package com.final_exam.module4.repository;

import com.final_exam.module4.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
    Page<City> findAllByOrderById(Pageable pageable);

}

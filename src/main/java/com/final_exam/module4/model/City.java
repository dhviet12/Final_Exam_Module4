package com.final_exam.module4.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Must not be empty")
    private String name;

    @Min(value = 1, message = "Must be greater than 0")
    private double area;
    @Min(value = 1, message = "Must be greater than 0")
    private int population;
    @Min(value = 1, message = "Must be greater than 0")
    private double gdp;
    private String description;

    @ManyToOne
    private National national;


    public City() {
    }

    public City(Long id, String name, double area, int population, double gdp, String description, National national) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
        this.national = national;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getGdp() {
        return gdp;
    }

    public void setGdp(double gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public National getNational() {
        return national;
    }

    public void setNational(National national) {
        this.national = national;
    }
}

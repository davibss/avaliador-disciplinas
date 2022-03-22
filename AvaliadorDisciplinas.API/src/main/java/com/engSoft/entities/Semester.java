package com.engSoft.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Semester implements Comparable<Semester> {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Semester() {}

    public Semester(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Semester o) {
        String numbersString1 = name.substring(0, 6);
        String numbersString2 = o.getName().substring(0, 6);
        double numbers1 = Double.parseDouble(numbersString1);
        double numbers2 = Double.parseDouble(numbersString2);
        return Double.compare(numbers2, numbers1);
    }
}
package com.example.service;

import java.util.Set;

public interface DataService {

    boolean persist(String problem);

    Set<String> getRandomData();

    String findByDescr(String description);
}
package com.example.service;

import com.example.entity.Data;
import com.example.repository.DataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service("dataService")
public class DataServiceImpl implements DataService {

    private static final Logger LOG = LoggerFactory.getLogger(DataServiceImpl.class);

    private final DataRepository dataRepository;

    @Autowired
    public DataServiceImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public boolean persist(String problem) {
        try {
            dataRepository.save(new Data(0L, problem));
            return true;
        } catch (Exception e) {
            LOG.error("ERROR SAVING DATA: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Set<String> getRandomData() {
        HashSet<String> out = new HashSet<>();
        dataRepository.findAll().forEach(data -> out.add(data.getDescription()));
        return out;
    }

    @Override
    public String findByDescr(String description) {
        LOG.info(description+" "+dataRepository.findByDescription(description).get(0).getDescription());
        return dataRepository.findByDescription(description).get(0).getDescription();
    }
}
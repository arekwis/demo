package com.example.demo.dao;

import com.example.demo.jpa.DataNumber;
import com.example.demo.jpa.repository.IDataNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataNumberDao implements IDataNumberDao {
    private final IDataNumberRepository repository;

    @Autowired
    public DataNumberDao(IDataNumberRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DataNumber> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(DataNumber dataNumber) {
        repository.save(dataNumber);
    }

    @Override
    public void delete(DataNumber dataNumber) {
        repository.delete(dataNumber);
    }
}

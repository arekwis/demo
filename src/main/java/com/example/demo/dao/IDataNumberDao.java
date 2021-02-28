package com.example.demo.dao;

import com.example.demo.jpa.DataNumber;

import java.util.List;

public interface IDataNumberDao {
    List<DataNumber> findAll();

    void save(DataNumber dataNumber);

    void delete(DataNumber dataNumber);
}

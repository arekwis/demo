package com.example.demo.jpa.repository;

import com.example.demo.jpa.DataNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDataNumberRepository extends JpaRepository<DataNumber, Long> {

}

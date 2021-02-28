package com.example.demo.dao;

import com.example.demo.jpa.DataNumber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {InMemoryDbConfig.class, DataNumberDao.class},
        loader = AnnotationConfigContextLoader.class)
@EnableJpaRepositories(basePackages = "com.example.demo.jpa.repository")
public class NumberDaoIT {
    private static final Integer INT_VALUE = 1;

    @Autowired
    private IDataNumberDao dao;

    @Test
    public void shouldReturnListOfEntities() {
        //given
        DataNumber dataNumber = new DataNumber();
        dataNumber.setIntegerValue(INT_VALUE);
        dao.save(dataNumber);

        //when
        List<DataNumber> list = dao.findAll();

        //then
        assertEquals(1, list.size());

        dao.delete(dataNumber);
    }
}

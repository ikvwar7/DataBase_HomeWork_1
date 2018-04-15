package ru.liga.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.liga.config.TestDaoSpringConfig;
import ru.liga.dao.EmployeeDao;
import ru.liga.entity.EmployeeEntity;

import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDaoSpringConfig.class})
public class EmployeeDaoTest {
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void findByFio() {
        assertEquals((Long) 1L, employeeDao.selectByFio("Владимир Николаевич Чубариков").getId());
    }

    @Test
    public void saveInsert() {
        EmployeeEntity employeeEntity = new EmployeeEntity(
                15l,
                "new",
                "male",
                2l,
                "кандидат наук",
                "профессор",
                LocalDate.of(1994, 3, 5)
        );
        employeeDao.save(employeeEntity);
        assertEquals("new", employeeDao.selectById(15l).getFio());
    }

    @Test
    public void saveUpdate() {
        employeeDao.save(new EmployeeEntity(
                15l,
                "newNew",
                "male",
                2l,
                "кандидат наук",
                "профессор",
                LocalDate.of(1994, 3, 5)
        ));
        assertEquals("newNew", employeeDao.selectById(15l).getFio());
    }

    @Test
    public void selectByDepartmentId() {
        assertEquals("Сысоев Николай Николаевич", employeeDao.selectByDepartmentId(2L).get(0).getFio());
    }
}
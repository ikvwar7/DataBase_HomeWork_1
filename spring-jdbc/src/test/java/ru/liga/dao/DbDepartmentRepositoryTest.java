package ru.liga.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.liga.config.TestDaoSpringConfig;
import ru.liga.domain.Employee;
import ru.liga.entity.DepartmentEntity;
import ru.liga.entity.EmployeeEntity;
import ru.liga.entity.StudentEntity;
import ru.liga.repository.DbDepartmentRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDaoSpringConfig.class})
public class DbDepartmentRepositoryTest {

    @Autowired
    private DbDepartmentRepository dbDepRep;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private StudentDao studentDao;

    @Test
    public void save() {
        List<EmployeeEntity> employees = new ArrayList<>(Arrays.asList(
                new EmployeeEntity(
                        16L,
                        "Иванов",
                        "male",
                        4l,
                        "доктор",
                        "профессор",
                        LocalDate.of(1994, 3, 5)
                ),
                new EmployeeEntity(
                        17L,
                        "Петров",
                        "male",
                        4l,
                        "доктор",
                        "профессор",
                        LocalDate.of(1994, 3, 5)
                )
        ));
        List<StudentEntity> students = new ArrayList<>(Arrays.asList(
                new StudentEntity(
                        52L,
                        "Студент1",
                        "Male",
                        4,
                        3,
                        LocalDate.of(1996, 3, 5)
                ),
                new StudentEntity(
                        53L,
                        "Студент2",
                        "Male",
                        4,
                        3,
                        LocalDate.of(1996, 3, 5)
                )
        ));
        DepartmentEntity departmentEntity = new DepartmentEntity(
                4l,
                "newDepartment",
                "newAdress",
                2018,
                employees,
                students
        );
        dbDepRep.save(departmentEntity);
        assertEquals("Студент1", dbDepRep.findById(4l).getStudents().get(0).getFio());
        assertEquals("Иванов", dbDepRep.findById(4l).getEmployees().get(0).getFio());
    }

    @Test
    public void deleteById() {
        dbDepRep.deleteById(4l);
        assertEquals(null, dbDepRep.findById(4l));
        assertEquals(null, employeeDao.selectByDepartmentId(4l));
        assertEquals(null, studentDao.selectByDepartmentId(4l));
    }
}
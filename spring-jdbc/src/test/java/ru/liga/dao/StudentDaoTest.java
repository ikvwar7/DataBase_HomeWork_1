package ru.liga.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.liga.config.TestDaoSpringConfig;
import ru.liga.entity.StudentEntity;
import ru.liga.repository.DbDepartmentRepository;

import java.time.LocalDate;


import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDaoSpringConfig.class})
public class StudentDaoTest {
    @Autowired
    private StudentDao studentDao;

    @Test
    public void selectById() {
        assertEquals("Бардашов Данила Романович", studentDao.selectById(1l).getFio());
    }

    @Test
    public void selectByDepartmentId() {
        assertEquals("Пискарева Вероника Максимовна", studentDao.selectByDepartmentId(2L).get(0).getFio());
    }

    @Test
    public void deleteById() {
        if (studentDao.selectById(51l) != null) {
            studentDao.deleteById(51l);
            assertEquals(null, studentDao.selectById(51l));
        }
    }

    @Test
    public void insert() {
        studentDao.insert(new StudentEntity(
                51L,
                "Петров Пётр Петрович",
                "Male",
                3,
                6,
                LocalDate.of(1994, 3, 5)
        ));
        assertEquals("Петров Пётр Петрович", studentDao.selectById(51l).getFio());
    }

    @Test
    public void update() {
        studentDao.update(
                new StudentEntity(
                        51L,
                        "Иванов Иван Иванович",
                        "Male",
                        3,
                        3,
                        LocalDate.of(1996, 3, 5)
                ));
        assertEquals("Иванов Иван Иванович", studentDao.selectById(51l).getFio());
    }

    @Test
    public void saveUpdate(){
        studentDao.save(
                new StudentEntity(
                        51L,
                        "updated",
                        "Male",
                        3,
                        3,
                        LocalDate.of(1996, 3, 5)
                ));
        assertEquals("updated", studentDao.selectById(51l).getFio());
    }
}
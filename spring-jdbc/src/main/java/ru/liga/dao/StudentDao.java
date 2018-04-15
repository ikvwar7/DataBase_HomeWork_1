package ru.liga.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import ru.liga.dao.mapper.StudentMapper;
import ru.liga.entity.StudentEntity;


import java.util.List;

public class StudentDao {
    private JdbcTemplate jdbcTemplate;

    public StudentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public StudentEntity save(StudentEntity entity) {
        if (selectById(entity.getId()) == null) {
            return insert(entity);
        } else {
            return update(entity);
        }
    }

    public StudentEntity insert(StudentEntity entity) {
        String sqlInsert = "INSERT INTO liga.student (id,fio,gender,course,birthday,department_id )"
                + " VALUES (?,?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlInsert, new Object[]{
                entity.getId(),
                entity.getFio(),
                entity.getGender(),
                entity.getCourse(),
                entity.getBirthday(),
                entity.getDepartment_id()
        });
        return entity;
    }

    public StudentEntity update(StudentEntity entity) {
        String sqlUpdate = "update liga.student set" +
                " fio = ?," +
                " gender = ?," +
                " course = ?," +
                " birthday = ?," +
                " department_id = ?" +
                " where id = ?";
        jdbcTemplate.update(sqlUpdate, new Object[]{
                entity.getFio(),
                entity.getGender(),
                entity.getCourse(),
                entity.getBirthday(),
                entity.getDepartment_id(),
                entity.getId()
        });
        return entity;
    }

    public void deleteById(Long entityId) {
        String sqlDelete = "delete from liga.student where id = ?";
        jdbcTemplate.update(sqlDelete, new Object[]{entityId});
    }

    public StudentEntity selectById(Long id) {
        String sql = "SELECT * FROM liga.student WHERE ID = ?";
        List<StudentEntity> entities = jdbcTemplate.query(
                sql, new Object[]{id}, new StudentMapper());
        return entities.isEmpty() ? null : entities.get(0);
    }

    public List<StudentEntity> selectByDepartmentId(Long department_id) {
        String sql = "SELECT * FROM liga.student WHERE department_id = ?";
        List<StudentEntity> entities = jdbcTemplate.query(
                sql, new Object[]{department_id}, new StudentMapper());
        return entities.isEmpty() ? null : entities;
    }
}

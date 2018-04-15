package ru.liga.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.liga.dao.DepartmentDao;
import ru.liga.dao.EmployeeDao;
import ru.liga.dao.StudentDao;
import ru.liga.entity.DepartmentEntity;
import ru.liga.entity.EmployeeEntity;
import ru.liga.entity.StudentEntity;

import java.util.List;


public class DbDepartmentRepository implements DepartmentRepository {

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private EmployeeDao employeeDao;

    public DbDepartmentRepository() {
    }

    @Override
    public DepartmentEntity save(DepartmentEntity entity) {
        departmentDao.save(entity);
        entity.getEmployees().stream()
                .forEach(employee -> employeeDao.save(employee));
        entity.getStudents().stream()
                .forEach(studentEntity -> studentDao.save(studentEntity));
        return entity;
    }

    @Override
    public void deleteById(Long id) {
        departmentDao.delete(id);
        List<StudentEntity> studEntities = studentDao.selectByDepartmentId(id);
        for (StudentEntity ent : studEntities) {
            studentDao.deleteById(ent.getId());
        }
        List<EmployeeEntity> emplEntities = employeeDao.selectByDepartmentId(id);
        for (EmployeeEntity ent : emplEntities) {
            employeeDao.deleteById(ent.getId());
        }

    }

    @Override
    public DepartmentEntity findById(Long id) {
        DepartmentEntity departmentEntity = departmentDao.findById(id);
        if (departmentEntity == null) {
            return null;
        }
        departmentEntity.setEmployees(employeeDao.selectByDepartmentId(id));
        departmentEntity.setStudents(studentDao.selectByDepartmentId(id));
        return departmentEntity;
    }
}

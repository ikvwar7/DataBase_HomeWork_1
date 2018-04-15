package ru.liga.mybatis.dao;

import org.apache.ibatis.annotations.Select;
import ru.liga.mybatis.domain.Employee;

import java.util.List;

public interface EmployeeDao {
    @Select("SELECT * FROM employee WHERE department_id = #{departmentId}")
    List<Employee> selectByDepartmentId();
}

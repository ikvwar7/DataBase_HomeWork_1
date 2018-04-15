package ru.liga.mybatis.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ru.liga.mybatis.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentDao {


//    @Insert(" insert into department (title, address, foundation_year)\n" +
//            "        values (\n" +
//            "        #{title, jdbcType=VARCHAR},\n" +
//            "        #{address, jdbcType=VARCHAR},\n" +
//            "        #{foundation_year, jdbcType=SMALLINT}\n" +
//            "        )")
    DepartmentEntity insert(DepartmentEntity entity);

//    @Update(" update department\n" +
//            "        SET\n" +
//            "           title = #{title, jdbcType=VARCHAR},\n" +
//            "           address = #{address, jdbcType=VARCHAR},\n" +
//            "           foundation_year = #{foundation_year, jdbcType=SMALLINT}\n" +
//            "        WHERE id = #{id}")
    DepartmentEntity update(DepartmentEntity entity);

//    @Delete(" delete from department where id = #{id}")
    void delete(Long entityId);

//    @Select("SELECT * FROM department\n" +
//            "        WHERE id = #{id}")
    DepartmentEntity select(Long id);

//    @Select("SELECT * FROM department WHERE foundation_year = #{foundationYear}")
    List<DepartmentEntity> selectByFoundationYear(Integer year);
//
//    @Select("SELECT * FROM department WHERE title = #{title}")
    DepartmentEntity selectByTitle(String title);
}

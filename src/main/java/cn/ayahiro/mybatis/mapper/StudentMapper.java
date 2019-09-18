package cn.ayahiro.mybatis.mapper;

import cn.ayahiro.mybatis.entity.Student;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("studentMapper")
public interface StudentMapper {
    List<Student> findAll();

    List<Student> findById(Integer id);

    void create(Student student);

    void update(Student student);

    void delete(Integer id);

    void deleteAll();
}

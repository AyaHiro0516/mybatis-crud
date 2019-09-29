package cn.ayahiro.mybatis.service;

import cn.ayahiro.mybatis.entity.dto.SearchDto;
import cn.ayahiro.mybatis.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll(SearchDto searchDto);

    List<Student> findById(Integer id);

    void create(Student student);

    void delete(Integer... ids);

    void deleteAll();

    void update(Student student);
}

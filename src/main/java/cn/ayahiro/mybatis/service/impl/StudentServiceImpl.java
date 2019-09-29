package cn.ayahiro.mybatis.service.impl;

import cn.ayahiro.mybatis.entity.dto.SearchDto;
import cn.ayahiro.mybatis.entity.Student;
import cn.ayahiro.mybatis.mapper.StudentMapper;
import cn.ayahiro.mybatis.service.StudentService;
import cn.ayahiro.mybatis.utils.GradeComparator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author ayahiro
 * @Description:
 * @Create: 2019/9/18
 */
@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {

    @Resource(name = "studentMapper")
    private StudentMapper studentMapper;

    private List<Comparator<Student>> comparatorList = new ArrayList<>();

    @Override
    public List<Student> findAll(SearchDto searchDto) {
        comparatorList.clear();

        List<Student> studentList = studentMapper.findAll();
        for (String index : searchDto.getIndex()) {
            comparatorList.add(GradeComparator.gerComparator(index));
        }

        Collections.sort(studentList, (Student o1, Student o2) -> {
            for (Comparator<Student> comparator : comparatorList) {
                if (comparator.compare(o1, o2) < 0) {
                    return -1;
                } else if (comparator.compare(o1, o2) > 0) {
                    return 1;
                }
            }
            return 0;
        });
        return studentList;
    }

    @Override
    public List<Student> findById(Integer id) {
        return studentMapper.findById(id);
    }

    @Override
    public void create(Student student) {
        studentMapper.create(student);
    }

    @Override
    public void delete(Integer... ids) {
        for (Integer id : ids) {
            studentMapper.delete(id);
        }
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public void deleteAll() {
        studentMapper.deleteAll();
    }
}

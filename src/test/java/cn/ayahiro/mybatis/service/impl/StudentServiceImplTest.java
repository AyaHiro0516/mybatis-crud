package cn.ayahiro.mybatis.service.impl;

import cn.ayahiro.mybatis.entity.Student;
import cn.ayahiro.mybatis.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTest {

    @Resource(name = "studentMapper")
    private StudentMapper studentMapper;

    @Test
    public void findAll() throws Exception {
        List<Student> students = studentMapper.findAll();
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    @Test
    public void findById() throws Exception {
        List<Student> students = studentMapper.findById(2);
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    @Test
    public void create() throws Exception {
        Student student = new Student("bxy", 99.0, 98.0, 97.0);
        studentMapper.create(student);
    }

    @Test
    public void delete() throws Exception {
        studentMapper.delete(1);
    }

    @Test
    public void deleteAll() throws Exception {
        studentMapper.deleteAll();
    }

    @Test
    public void update() throws Exception {
        Student student = new Student();
        student.setGradeA(77.0);
        student.setId(2);
        studentMapper.update(student);
    }

    @Test
    public void insertStudents() throws Exception {
        studentMapper.deleteAll();
        for (int i = 0; i < 56; ++i) {
            Student student = new Student();
            student.setName("stu" + String.valueOf(i));

            double gradeA = 60 + ((100 - 60) * new Random().nextDouble());
            BigDecimal b1 = new BigDecimal(gradeA);
            gradeA = b1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            student.setGradeA(gradeA);

            double gradeB = 60 + ((100 - 60) * new Random().nextDouble());
            BigDecimal b2 = new BigDecimal(gradeB);
            gradeB = b2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            student.setGradeB(gradeB);

            double gradeC = 60 + ((100 - 60) * new Random().nextDouble());
            BigDecimal b3 = new BigDecimal(gradeC);
            gradeC = b3.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            student.setGradeC(gradeC);

            studentMapper.create(student);
        }
    }
}
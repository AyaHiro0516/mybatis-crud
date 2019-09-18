package cn.ayahiro.mybatis.entity;

import java.io.Serializable;

/**
 * @Author ayahiro
 * @Description:
 * @Create: 2019/9/18
 */
public class Student implements Serializable {
    private Integer id;
    private String name;
    private Double gradeA;
    private Double gradeB;
    private Double gradeC;

    public Student() {
    }

    public Student(String name, Double gradeA, Double gradeB, Double gradeC) {
        this.name = name;
        this.gradeA = gradeA;
        this.gradeB = gradeB;
        this.gradeC = gradeC;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGradeA() {
        return gradeA;
    }

    public void setGradeA(Double gradeA) {
        this.gradeA = gradeA;
    }

    public Double getGradeB() {
        return gradeB;
    }

    public void setGradeB(Double gradeB) {
        this.gradeB = gradeB;
    }

    public Double getGradeC() {
        return gradeC;
    }

    public void setGradeC(Double gradeC) {
        this.gradeC = gradeC;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gradeA=" + gradeA +
                ", gradeB=" + gradeB +
                ", gradeC=" + gradeC +
                '}';
    }
}

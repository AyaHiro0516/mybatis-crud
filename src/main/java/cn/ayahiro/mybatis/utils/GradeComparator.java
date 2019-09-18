package cn.ayahiro.mybatis.utils;

import cn.ayahiro.mybatis.entity.Student;

import java.util.Comparator;

/**
 * @Author ayahiro
 * @Description:
 * @Create: 2019/9/18
 */
public class GradeComparator {

    private static final String GRADE_A_COMPARATOR = "gradeA";
    private static final String GRADE_B_COMPARATOR = "gradeB";
    private static final String GRADE_C_COMPARATOR = "gradeC";

    private static Comparator<Student> gradeAComparator = (Student o1, Student o2) -> {
        if (o1.getGradeA() == o2.getGradeA()) {
            return 0;
        } else {
            return o1.getGradeA() > o2.getGradeA() ? -1 : 1;
        }
    };

    private static Comparator<Student> gradeBComparator = (Student o1, Student o2) -> {
        if (o1.getGradeB() == o2.getGradeB()) {
            return 0;
        } else {
            return o1.getGradeB() > o2.getGradeB() ? -1 : 1;
        }
    };

    private static Comparator<Student> gradeCComparator = (Student o1, Student o2) -> {
        if (o1.getGradeC() == o2.getGradeC()) {
            return 0;
        } else {
            return o1.getGradeC() > o2.getGradeC() ? -1 : 1;
        }
    };

    public static Comparator<Student> gerComparator(String index) {
        Comparator<Student> comparator = null;
        switch (index) {
            case GRADE_A_COMPARATOR:
                comparator = gradeAComparator;
                break;
            case GRADE_B_COMPARATOR:
                comparator = gradeBComparator;
                break;
            case GRADE_C_COMPARATOR:
                comparator = gradeCComparator;
                break;
        }
        return comparator;
    }
}

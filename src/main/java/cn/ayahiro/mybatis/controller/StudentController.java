package cn.ayahiro.mybatis.controller;

import cn.ayahiro.mybatis.entity.Result;
import cn.ayahiro.mybatis.entity.dto.SearchDto;
import cn.ayahiro.mybatis.entity.Student;
import cn.ayahiro.mybatis.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author ayahiro
 * @Description:
 * @Create: 2019/9/18
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource(name = "studentServiceImpl")
    private StudentService studentService;

    @RequestMapping(path = {"/create"}, method = RequestMethod.POST)
    public Result create(@RequestBody Student student) {
        try {
            studentService.create(student);
            return new Result(true, "创建成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    @RequestMapping(path = {"/update"}, method = RequestMethod.POST)
    public Result update(@RequestBody Student student) {
        try {
            studentService.update(student);
            return new Result(true, "更新数据成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    @RequestMapping(path = {"/delete"}, method = RequestMethod.POST)
    public Result delete(@RequestBody Integer... ids) {
        try {
            studentService.delete(ids);
            return new Result(true, "更新数据成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    @RequestMapping(path = {"/findById"}, method = RequestMethod.GET)
    public List<Student> findById(@RequestParam(value = "id", required = false) Integer id) {
        return studentService.findById(id);
    }

    @RequestMapping(path = {"/findByPage"}, method = RequestMethod.GET)
    public PageInfo<Student> findByPage(@RequestParam(value = "page", defaultValue = "1") int page,
                                        @RequestBody SearchDto searchDto) {
        PageHelper.startPage(page, 10);
        List<Student> students = studentService.findAll(searchDto);

        return new PageInfo<>(students);
    }

    @RequestMapping(path = {"/index"}, method = RequestMethod.GET)
    public String index() {
        return "hello ayahiro!";
    }

    @RequestMapping(path = {"/admin"}, method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String auth() {
        return "需要ADMIN角色才可以看到的信息！";
    }
}

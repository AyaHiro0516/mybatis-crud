package cn.ayahiro.mybatis.utils;

import cn.ayahiro.mybatis.entity.Result;
import com.google.gson.Gson;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author ayahiro
 * @Description:
 * @Create: 2019/9/26
 */
public class ResponseUtil {

    public static void out(HttpServletResponse response, Result result) {
        ServletOutputStream out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            out = response.getOutputStream();
            out.write(new Gson().toJson(result).getBytes());
        } catch (Exception e) {
            System.out.println(e + "输出JSON出错");
        } finally {
            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

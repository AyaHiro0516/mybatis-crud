package cn.ayahiro.mybatis.entity;

import java.io.Serializable;

/**
 * @Author ayahiro
 * @Description:
 * @Create: 2019/9/26
 */
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String role;
    private String permission;

    public User() {
    }

    public User(String username, String password, String role, String permission) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.permission = permission;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }
}

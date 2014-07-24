package com.site.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zdsoft on 14-7-24.
 */
public class UserInfo {
    private int id;
    private String name;
    private String password;

    public UserInfo(ResultSet rs) {
        try {
            this.id = rs.getInt("id");
            this.name = rs.getString("name");
            this.password = rs.getString("password");
        } catch (SQLException e){
            System.out.printf(e.getMessage());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

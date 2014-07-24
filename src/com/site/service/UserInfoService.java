package com.site.service;

import com.site.dao.UserInfo;
import com.site.db.DBConnection;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zdsoft on 14-7-24.
 */
public class UserInfoService {

    public List<UserInfo> findUserInfoList(){
        DBConnection db = new DBConnection();
        List<UserInfo> list = new ArrayList<UserInfo>();

        try {
            String sql = "SELECT * from youyiku.user_info";
            ResultSet resultSet = db.executeQuery(sql);
            while (resultSet.next()){
                list.add(new UserInfo(resultSet));
            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            db.close();
        }

        return list;
    }
}

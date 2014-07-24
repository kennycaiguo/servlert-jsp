package com.site.controller;

import com.site.db.DBConnection;
import com.site.service.UserInfoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zdsoft on 14-7-23.
 */
public class ShowBalance extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BankCustomer customer = BankCustomer.getCustomer(req.getParameter("id"));
        String address = "";

        UserInfoService userInfoService = new UserInfoService();
        if (null == customer){
            address = "WEB-INF/page/unknownCustomer.jsp";
            req.setAttribute("firstName", "servlet-jsp");
            req.setAttribute("userInfoList", userInfoService.findUserInfoList());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher(address);
        dispatcher.forward(req, resp);

    }
}

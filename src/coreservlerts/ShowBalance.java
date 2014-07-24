package coreservlerts;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zdsoft on 14-7-23.
 */
public class ShowBalance extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BankCustomer customer = BankCustomer.getCustomer(req.getParameter("id"));
        String address = "";

        if (null == customer){
            address = "WEB-INF/page/unknownCustomer.jsp";
            req.setAttribute("firstName", "servlet-jsp");
        }


        RequestDispatcher dispatcher = req.getRequestDispatcher(address);
        dispatcher.forward(req, resp);

    }
}

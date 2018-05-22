package controller;



import model.User;
import service.DbConnect;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/home")
public class HomeController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private String login;
    private String password;
    private DbConnect dbConnect;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dbConnect = new DbConnect();
        dbConnect.connect(this.getServletContext().getInitParameter("databaseUser"),this.getServletContext().getInitParameter("databasePassword"));
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( "/home.jsp" ).forward( request, response );
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        login = request.getParameter("login");
        password = request.getParameter("password");
        User user = new User(login,password);

        if(dbConnect.verifyUser(user)){
            HttpSession session = request.getSession();
            session.setAttribute( "user",user );
            response.sendRedirect("/profile");
        }else{
            this.getServletContext().getRequestDispatcher( "/" ).forward( request, response );
        }




    }




}
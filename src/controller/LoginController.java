package controller;

import dao.impl.UserDaoImpl;
import model.User;
import service.AuthService;
import service.ConnectionFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginController  extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String login;
    private String password;

    private ConnectionFactory connectionFactory;
    private UserDaoImpl userDao;
    private AuthService authService;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        connectionFactory = new ConnectionFactory();
        connectionFactory.connect(this.getServletContext().getInitParameter("databaseUser"),this.getServletContext().getInitParameter("databasePassword"));
        userDao = new UserDaoImpl(connectionFactory);
        authService = new AuthService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        login = request.getParameter("login");
        password = request.getParameter("password");

        User user = userDao.findByUserName(login);

        if (login.trim().isEmpty() || password.trim().isEmpty() || user == null ){
            response.sendRedirect("/");
        }else{

            if(user.getPassword().equals(password)){
                authService.login(request,user);
                response.sendRedirect("/profile");
            }else{
                response.sendRedirect("/");
            }
        }


    }
}

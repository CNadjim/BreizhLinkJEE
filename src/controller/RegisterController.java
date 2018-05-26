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


@WebServlet("/register")
public class RegisterController  extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String login;
    private String password1;
    private String password2;
    private ConnectionFactory connectionFactory;
    private UserDaoImpl userDao;
    private AuthService authService;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        connectionFactory = new ConnectionFactory();
        userDao = new UserDaoImpl(connectionFactory);
        authService = new AuthService();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( "/view/register.jsp" ).forward( request, response );
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        login = request.getParameter("userName");
        password1 = request.getParameter("password1");
        password2 = request.getParameter("password2");
        User user = null;

        if(login.trim().isEmpty() || password1.trim().isEmpty() || password2.trim().isEmpty() || !password1.equals(password2)){
            response.sendRedirect("/register");
        }else {
            user = userDao.findByUserName(login);
            if (user == null){
                user = userDao.save(new User(login,password1));
                authService.login(request,user);
                response.sendRedirect("/profile");
            }else{
                response.sendRedirect("/register");
            }

        }

    }
}

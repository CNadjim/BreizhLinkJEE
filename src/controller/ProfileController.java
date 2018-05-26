package controller;

import dao.impl.BreizhLinkDaoImpl;
import model.BreizhLink;
import model.User;
import service.AuthService;
import service.DbConnect;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/profile")
public class ProfileController  extends HttpServlet {
    private static final long serialVersionUID = 1L;


    private DbConnect dbConnect;
    private BreizhLinkDaoImpl breizhLinkDao;
    private AuthService authService;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dbConnect = new DbConnect();
        dbConnect.connect(this.getServletContext().getInitParameter("databaseUser"),this.getServletContext().getInitParameter("databasePassword"));
        breizhLinkDao = new BreizhLinkDaoImpl(dbConnect);
        authService = new AuthService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BreizhLink> breizhLinks = breizhLinkDao.findByUserLogin(authService.getCurrentUser(request).getLogin());
        request.setAttribute( "breizhLinks", breizhLinks );
        this.getServletContext().getRequestDispatcher( "/view/profile.jsp" ).forward( request, response );
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

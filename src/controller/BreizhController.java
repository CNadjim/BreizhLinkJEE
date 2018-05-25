package controller;

import model.BreizhLink;
import model.User;
import service.AuthService;
import service.BreizhService;
import service.DbConnect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name="breizh", urlPatterns={"/breizh","/breizh/*"})
public class BreizhController  extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String link_url;
    private String link_password;

    private String guestUrl;

    private DbConnect dbConnect;
    private AuthService authService;
    private BreizhService breizhService;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dbConnect = new DbConnect();
        authService = new AuthService();
        breizhService = new BreizhService();
        dbConnect.connect(this.getServletContext().getInitParameter("databaseUser"),this.getServletContext().getInitParameter("databasePassword"));
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI().trim();
        if(url.length() > 8){
            String short_url = url.substring(8,url.length());
        }

        System.out.println(this.breizhService.createRandomShortUrl());
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        link_url = request.getParameter("link_url");
        link_password = request.getParameter("link_password");

        BreizhLink breizhLink = new BreizhLink();
        breizhLink.setPswd(link_password);
        breizhLink.setUrl(link_url);

        dbConnect.saveLink(breizhLink);

        RequestDispatcher dispatcher;
        if (authService.isConnected(request)){
            dispatcher = getServletContext().getRequestDispatcher( "/view/profile.jsp" );
        }else{

            dispatcher = getServletContext().getRequestDispatcher( "/view/home.jsp" );
        }
        dispatcher.forward( request, response );

    }
}

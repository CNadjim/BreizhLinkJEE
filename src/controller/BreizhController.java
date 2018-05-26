package controller;

import dao.impl.BreizhLinkDaoImpl;
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


    private DbConnect dbConnect;
    private AuthService authService;
    private BreizhService breizhService;
    private BreizhLinkDaoImpl breizhLinkDao;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dbConnect = new DbConnect();
        dbConnect.connect(this.getServletContext().getInitParameter("databaseUser"),this.getServletContext().getInitParameter("databasePassword"));
        authService = new AuthService();
        breizhService = new BreizhService(dbConnect);
        breizhLinkDao = new BreizhLinkDaoImpl(dbConnect);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI().trim();
        BreizhLink breizhLink = null;
        if(url.length() > 8){
            String short_url = url.substring(8,url.length());
            breizhLink = breizhLinkDao.findByShortUrl(short_url);
        }
        if (breizhLink != null ){
            breizhLink.setVisite(breizhLink.getVisite()+1);
            breizhLinkDao.update(breizhLink);
            response.sendRedirect(breizhLink.getUrl());
        }
        else response.sendRedirect("/home");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        link_url = request.getParameter("link_url");
        link_password = request.getParameter("link_password");

        if(!link_url.isEmpty()){
            BreizhLink breizhLink = new BreizhLink();
            breizhLink.setUrl(link_url);
            if(!link_password.isEmpty()) breizhLink.setPswd(link_password);
            if(authService.isConnected(request)) breizhLink.setUserLogin(authService.getCurrentUser(request).getLogin());
            breizhLink.setShortUrl(breizhService.createRandomShortUrl());
            breizhLink.setId(null);
            breizhLinkDao.save(breizhLink);
        }

        if (authService.isConnected(request)){
            response.sendRedirect("/profile");
        }else{
            response.sendRedirect("/home");
        }

    }
}

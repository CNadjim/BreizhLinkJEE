package controller;

import dao.impl.BreizhLinkDaoImpl;
import model.BreizhLink;
import service.AuthService;
import service.BreizhService;
import service.ConnectionFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static java.util.Objects.isNull;

@WebServlet(name="shorten", urlPatterns={"/profile/shorten"})
public class ShortenController extends HttpServlet {

    private String url;
    private String password;
    private Long maxClic;
    private Date dateStart;
    private Date dateEnd;
    private boolean secured;

    private ConnectionFactory connectionFactory;
    private AuthService authService;
    private BreizhLinkDaoImpl breizhLinkDao;
    private BreizhService breizhService;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        authService = new AuthService();
        connectionFactory = new ConnectionFactory();
        breizhLinkDao = new BreizhLinkDaoImpl(connectionFactory);
        breizhService = new BreizhService(connectionFactory);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( "/view/shorten.jsp" ).forward( request, response );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        url = request.getParameter("link_url");
        password = request.getParameter("pswd").trim().isEmpty() ? null : request.getParameter("pswd") ;
        maxClic = request.getParameter("clic").trim().isEmpty() ? null : Long.valueOf(request.getParameter("clic"));
        dateStart = request.getParameter("dateStart").trim().isEmpty() ? null : Date.valueOf(request.getParameter("dateStart"));
        dateEnd = request.getParameter("dateEnd").trim().isEmpty() ? null : Date.valueOf(request.getParameter("dateEnd"));
        if(!isNull(request.getParameter("captcha"))) secured = request.getParameter("captcha").equals("on");
        else secured = false;


        BreizhLink breizhLink = new BreizhLink();
        breizhLink.setUrl(url);
        breizhLink.setUserLogin(authService.getCurrentUser(request).getLogin());
        breizhLink.setMaxVisite(maxClic);
        breizhLink.setDateStart(dateStart);
        breizhLink.setDateEnd(dateEnd);
        breizhLink.setSecured(secured);
        breizhLink.setPswd(password);
        breizhLink.setShortUrl(breizhService.createRandomShortUrl());


        if (breizhLink.getUrl().trim().isEmpty()){
            response.sendRedirect("/profile/shorten");
        }else{
            breizhLinkDao.save(breizhLink);
            response.sendRedirect("/profile");
        }

    }


}

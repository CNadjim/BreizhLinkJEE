package service;

import model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static java.util.Objects.isNull;

public class AuthService {

    public User getCurrentUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        return (User) session.getAttribute("user");
    }

    public boolean isConnected(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        return user != null;
    }

    public void login(HttpServletRequest request,User user){
        HttpSession session = request.getSession();
        session.setAttribute( "user",user );
    }

    public void logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
    }

}

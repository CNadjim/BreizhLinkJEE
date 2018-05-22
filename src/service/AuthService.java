package service;

import model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static java.util.Objects.isNull;

public class AuthService {

    public User getCurrentUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if ( user.isNull() ) return null;
        else return user;
    }

    public boolean isConnected(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        return !isNull(user);
    }

}

package dao.impl;

import dao.UserDao;
import model.User;
import service.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    private DbConnect dbConnect;

    public UserDaoImpl(DbConnect dbConnect){
        this.dbConnect = dbConnect;
    }

    @Override
    public User findOne( Long id ){
        return new User();
    }


    @Override
    public boolean save ( User user ){
        return false;
    }
}

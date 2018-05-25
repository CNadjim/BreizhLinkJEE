package dao;

import model.User;

public interface UserDao {
    boolean save ( User user );
    User findOne( Long id );
}



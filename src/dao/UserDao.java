package dao;

import model.User;

public interface UserDao {
    User save ( User user );
    User findOne( Long id );
    User findByUserName(String userName);
}



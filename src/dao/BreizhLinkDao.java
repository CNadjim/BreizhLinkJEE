package dao;

import model.BreizhLink;
import model.User;

import java.util.List;

public interface BreizhLinkDao {
    void save ( BreizhLink breizhLink );
    void update(BreizhLink breizhLink);
    BreizhLink findByShortUrl(String shortUrl );
    List<BreizhLink> findByUserLogin(String userLogin);
}

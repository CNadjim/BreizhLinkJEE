package dao;

import model.BreizhLink;
import model.User;

import java.util.List;

public interface BreizhLinkDao {
    boolean save ( BreizhLink breizhLink );
    BreizhLink findByShortUrl(String shortUrl );
    List<BreizhLink> findByUserLogin(String userLogin);
}

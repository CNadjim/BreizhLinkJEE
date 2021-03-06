package service;

import dao.impl.BreizhLinkDaoImpl;
import model.BreizhLink;

import java.util.Random;

public final class BreizhService {
    private ConnectionFactory connectionFactory;
    private BreizhLinkDaoImpl breizhLinkDao;

    public BreizhService(ConnectionFactory connectionFactory){
        this.connectionFactory = connectionFactory;
        this.breizhLinkDao = new BreizhLinkDaoImpl(connectionFactory);
    }

    public String createRandomShortUrl(){
        boolean exist = true;
        String shortUrl = null;
        while(exist){
            shortUrl = new String(getRandomAZChar()+""+getRandomAZChar()+""+getRandomAZChar()+""+getRandomAZChar()+""+getRandom09Int()+""+getRandom09Int()+""+getRandom09Int());
            BreizhLink breizhLink = this.breizhLinkDao.findByShortUrl(shortUrl);
            if (breizhLink == null){
                exist = false;
            }
        }
        return shortUrl;
    }

    public char getRandomAZChar(){
        Random rnd = new Random();
        char c = (char) (rnd.nextInt(26) + 'a');
        return Character.toUpperCase(c);
    }

    public int getRandom09Int(){
        Random r = new Random();
        int randint = Math.abs(r.nextInt()) % 11;
        return randint;
    }



}

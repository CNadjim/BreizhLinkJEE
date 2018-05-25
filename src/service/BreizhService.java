package service;

import java.util.Objects;
import java.util.Random;

public final class BreizhService {

    public String createRandomShortUrl(){
        return new String(getRandomAZChar()+""+getRandomAZChar()+""+getRandomAZChar()+""+getRandomAZChar()+""+getRandom09Int()+""+getRandom09Int()+""+getRandom09Int());
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

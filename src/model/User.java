package model;

public class User {

    private Long id;
    private String login;
    private String password;

    public User(){
        super();
    }

    public User(String login, String password){
        this.login = login;
        this.password = password;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isNull(){
        if (this.getPassword().equals("") || this.getLogin().equals("")) return true;
        return false;
    }
}

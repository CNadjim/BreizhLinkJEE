package model;
import java.sql.Date;
import java.util.Calendar;

public class BreizhLink {

    private Long id;

    private String userLogin;
    private String url;
    private String shortUrl;
    private String pswd;
    private Long visite;
    private Date dateStart;
    private Date dateEnd;
    private Long maxVisite;
    private boolean secured;

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Long getVisite() {
        return visite;
    }

    public void setVisite(Long visite) {
        this.visite = visite;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Long getMaxVisite() {
        return maxVisite;
    }

    public void setMaxVisite(Long maxVisite) {
        this.maxVisite = maxVisite;
    }

    public boolean isSecured() {
        return secured;
    }

    public void setSecured(boolean secured) {
        this.secured = secured;
    }

    private boolean isObsolete(){
        java.sql.Date aujourdhui = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        return (aujourdhui.after(dateEnd));
    }
}

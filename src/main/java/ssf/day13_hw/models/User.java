package ssf.day13_hw.models;

public class User {

    private String name;
    private String password;
    private String captcha = "";

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getCaptcha() {return captcha;}
    public void setCaptcha(String captcha) {this.captcha = captcha;}

    @Override
    public String toString() {
        return "User [name=" + name + ", password=" + password + "]";
    }
   
}

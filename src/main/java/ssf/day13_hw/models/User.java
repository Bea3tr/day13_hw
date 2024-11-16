package ssf.day13_hw.models;

import jakarta.validation.constraints.*;

public class User {

    @NotNull(message="Name cannot be null")
    @NotEmpty(message="Name cannot be empty")
    @Size(min=2, max=32, message="Name must be between 2 and 32 characters")
    private String name;

    @NotNull(message="Please enter the password")
    @NotEmpty(message="Please enter the password")
    private String password;

    @NotEmpty(message="Please enter captcha")
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

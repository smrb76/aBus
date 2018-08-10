package Model;

import java.io.Serializable;


public class Passenger extends Employee implements Serializable{
    private String email_id;
    private String web_url;
    
    public Passenger(){}
    public Passenger(String idnumber, String firstname, String lastname, String username, String password, String email_id, String web_url) {
        super(idnumber, firstname, lastname, username, password);
        this.email_id = email_id;
        this.web_url = web_url;
    }
    
    public String getEmail_id(){
        return email_id; 
    }
    public void setEmail_id(String email_id){
        this.email_id = email_id;
    }
  
    public String getWeb_url(){
        return web_url;
    }
    public void setWeb_url(String web_url){
        this.web_url = web_url;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Mohammad Reza
 */
public class Employee extends Admin implements Serializable{
    
    private String idnumber;
    private String firstname;
    private String lastname;
    
       
    public Employee(String idnumber, String firstname, String lastname, String username, String password)
    {
        super(username, password);
        this.idnumber = idnumber;
        this.firstname = firstname;
        this.lastname = lastname;
        
    }

    public Employee()
    {
    }
    public String getIdnumber()
    {
        return idnumber;
    }
    public void setIdnumber(String idnumber)
    {
        this.idnumber = idnumber;
    }
    public String getFirstname()
    {
        return firstname;
    }
    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }
    public String getLastname()
    {
        return lastname;
    }
    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }
}

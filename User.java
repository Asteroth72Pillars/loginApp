/*
 * Main.java
 * this is the main class
 * Author M.Zaihd Behardien(219233829)
 * 23 August 2022
 */
package za.ac.cput.adploginapp;

/**
 *
 * @author zaihd
 */
public class User 
{
    private String titles;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String password;

    public User(String email, String password) 
    {
        this.email = email;
        this.password = password;
    }

    public String getTitles() {
        return titles;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void set(String titles, String firstName, String lastName, String gender)
    {
        this.titles = titles;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    } 
    
    
    
    
    
}

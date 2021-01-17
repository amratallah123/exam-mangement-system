/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl2_project;

public class user {

    private int id;
    private String password;
    private String role;
    private String name;

    user(int id, String password, String role, String name) {
        this.id = id;
        this.password = password;
        this.role = role;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;

    }

    public String getPassword() {
        return password;

    }

    public void setRole(String role) {
        this.role = role;

    }

    public String getRole() {
        return role;

    }

    public void setName(String name) {
        this.name = name;

    }

    public String getName() {
        return name;

    }

}

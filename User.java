/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthproject;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

    @Entity
@Table(name="User")
public class User implements java.io.Serializable {

   @Id
  int id;
@Column(name="username")
   String username;
@Column(name="name")
   String name;
@Column(name="age")
   int age ;
@Column(name="password")
  String password;

    public User() {
    }

    public User(int id, String username, String name, int age, String password) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", name=" + name + ", age=" + age + ", password=" + password + '}';
    }
    
}


package logic;

public class User {

    private int id;
    private String name;
    private String role;
    private String pw;

    public User(String name, String pw, String role) {
        this.name = name;
        this.role = role;
        this.pw = pw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    
    

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", role=" + role + '}';
    }
    
}

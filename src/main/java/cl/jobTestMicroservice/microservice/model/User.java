package cl.jobTestMicroservice.microservice.model;

public class User {
    private String name;
    private String username;
    private String companyName;
    private String email;

    public User() {

    }
    public User(String name, String username, String companyName, String email) {
        this.name = name;
        this.username = username;
        this.companyName = companyName;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

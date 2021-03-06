package myskyscanner.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyUser implements Serializable {

    private static final long serialVersionUID = -2043085192957959900L;
    private String username;
    private char[] password;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private Role role;
    private List<String> notifyLocations;

    public MyUser(String username, char[] password, Role role, String email, String firstName,
            String lastName, String phone) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.notifyLocations = new ArrayList<String>();
    }

    public void print() {
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        if (firstName != null) {
            System.out.println("First name " + firstName);
        }
        if (lastName != null) {
            System.out.println("Last name " + lastName);
        }
        if (phone != null) {
            System.out.println("Phone " + phone);
        }
    }

    public boolean validatePass(char[] passToCheck) {
        return Arrays.equals(password, passToCheck);
    }

    public boolean isAdmin() {
        return role.equals(Role.Admin);
    }

    public void addStartEndLoc(String start, String end) {
        notifyLocations.add(start);
        notifyLocations.add(end);
    }

    public List<String> getLocations() {
        List<String> loc = new ArrayList<String>(notifyLocations);
        return loc;
    }
}

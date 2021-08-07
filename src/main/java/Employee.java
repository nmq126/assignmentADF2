import util.DateTimeUtil;

import java.util.Calendar;
import java.util.Date;

public class Employee {
    private String name;
    private String address;
    private String email;
    private String account;
    private String password;
    private Date createdAt;
    private Date updatedAt;
    private boolean status;

    public Employee() {
        this.createdAt = Calendar.getInstance().getTime();
        this.updatedAt = Calendar.getInstance().getTime();
        this.status = true;
    }


    public Employee(String name, String address, String email, String account, String password) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.account = account;
        this.password = password;
        this.createdAt = Calendar.getInstance().getTime();
        this.updatedAt = Calendar.getInstance().getTime();
        this.status = true;
    }


    public void printInfo() {
        System.out.printf("Name: %s\nAddress: %s\nEmail: %s\nAccount name: %s\nPassword: %s\nCreated at: %s", name, address, email, account, password, createdAt);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCreatedAtString() {
        return DateTimeUtil.formatDateToString(this.createdAt);
    }

    public String getUpdatedAtString() {
        return DateTimeUtil.formatDateToString(this.updatedAt);
    }
}

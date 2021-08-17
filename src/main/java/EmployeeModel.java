import util.ConnectionHelper;

import java.sql.*;

public class EmployeeModel {
    public boolean register(Employee emp) {
        try {
            Connection cnn = ConnectionHelper.getConnection();
            if (cnn == null) {
                System.err.println("Connection error!");
                return false;
            }
            PreparedStatement preparedStatement = cnn.prepareStatement("insert into employees (name , address, email, account, password, createdAt, updatedAt, status) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, emp.getName());
            preparedStatement.setString(2, emp.getAddress());
            preparedStatement.setString(3, emp.getEmail());
            preparedStatement.setString(4, emp.getAccount());
            preparedStatement.setString(5, emp.getPassword());
            preparedStatement.setString(6, emp.getCreatedAtString());
            preparedStatement.setString(7, emp.getUpdatedAtString());
            preparedStatement.setBoolean(8, emp.isStatus());
            preparedStatement.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean checkExistAccount(String account) {
        try {
            Connection cnn = ConnectionHelper.getConnection();
            if (cnn == null) {
                System.err.println("Connection error!");
                return false;
            }
            PreparedStatement stt = cnn.prepareStatement("select account from employees where account = ?");
            stt.setString(1, account);
            ResultSet rs = stt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public Employee login(String account, String password) {
        try {
            Connection cnn = ConnectionHelper.getConnection();
            if (cnn == null) {
                System.err.println("Connection error!");
                return null ;
            }
            PreparedStatement stt = cnn.prepareStatement("select * from employees where account = ?");
            stt.setString(1, account);
            ResultSet rs = stt.executeQuery();
            if (!rs.next()) {
                return null;
            }else {
                if (!password.equals(rs.getString("password"))) {
                    return null;
                }else {
                    Employee employee = new Employee();
                    employee.setName(rs.getString("name"));
                    employee.setEmail(rs.getString("email"));
                    employee.setAddress(rs.getString("address"));
                    employee.setAccount(rs.getString("account"));
                    employee.setPassword(rs.getString("password"));
                    employee.setCreatedAt(rs.getDate("createdAt"));
                    return employee;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}

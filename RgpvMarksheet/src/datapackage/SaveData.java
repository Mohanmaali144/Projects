package datapackage;

import Frame.RollSearch;
import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

import pojopackage.*;

public class SaveData {

    public static void studentSignUp(PojoRGPV std[], int i) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rgpvdata", "root", "root");

        String firstName = std[i].getfirstName();
        System.out.println(firstName);

        String lastName = std[i].getLname();
        String mobile = std[i].getMobile();
        String email = std[i].getEmail();
        String father = std[i].getFname();
        //-----------------------------------------------
        String mother = std[i].getMname();
        System.out.println(mother);

        String address = std[i].getAddress();
        String userName = std[i].getUserName();
        String password = std[i].getPassword();

        String sqlQuery = "INSERT INTO STUDENTDetails(firstname,lastname,mobile,email,father,mother,address,username,password) VALUES(?,?,?,?  ,?,?,?,?  ,?)";

        PreparedStatement ps = con.prepareStatement(sqlQuery); // main

        ps.setString(1, firstName);
        ps.setString(2, lastName);
        ps.setString(3, mobile);
        ps.setString(4, email);
        ps.setString(5, father);
        ps.setString(6, mother);
        ps.setString(7, address);
        ps.setString(8, userName);
        ps.setString(9, password);

        int a = ps.executeUpdate();
        // int a = st.executeUpdate(sqlQuery);

        //int a = ps.executeUpdate(query);
        if (a > 0) {
            System.out.println("savedata");
            System.out.println("Succesfull");
        } else {
            System.out.println("faild");
        }
        con.close();
    }

    //-------------------------------------------------------------------------------------------
    public static void saveData(PojoRGPV std[], int i) throws ClassNotFoundException, SQLException {

        System.out.println("found it");
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rgpvdata", "root", "root");

        // System.out.println("continueee");
        // String sqlQuery = "INSERT INTO studentrecords(physics,chemistry,math,hindi,english,total,year,course,semester,branch,percentage)VALUES(?,?,?,  ?,?,?,  ?,?,?,  ?,?)";
        String sqlQuery = "INSERT INTO studentrecords VALUES(?,?,?,?,  ?,?,?,  ?,?,?,  ?,?)";
        //(physics,chemistry,math,hindi,english,total,year,course,semester,branch)
        PreparedStatement ps = con.prepareStatement(sqlQuery);

        ps.setInt(1, std[i].getRoll());
        ps.setInt(2, std[i].getPhysics());
        ps.setInt(3, std[i].getChemistry());
        ps.setInt(4, std[i].getMath());
        ps.setInt(5, std[i].getHindi());
        ps.setInt(6, std[i].getEnglish());
        ps.setInt(7, std[i].getTotal());
        ps.setInt(8, std[i].getYear());
        ps.setString(9, std[i].getCourse());
        ps.setString(10, std[i].getSem());
        ps.setString(11, std[i].getBranch());
        ps.setDouble(12, std[i].getPer());
//        ps.setInt(1, std[i].getPhysics());
//        ps.setInt(2, std[i].getChemistry());
//        ps.setInt(3, std[i].getMath());
//        ps.setInt(4, std[i].getHindi());
//        ps.setInt(5, std[i].getEnglish());
//        ps.setInt(6, std[i].getTotal());
//        ps.setInt(7, std[i].getYear());
//        ps.setString(8, std[i].getCourse());
//        ps.setString(9, std[i].getSem());
//        ps.setString(10, std[i].getBranch());
//        ps.setDouble(11, std[i].getPer());

        // conitnuee...............c
//        ps.setString(2, std[i].getfirstName());
//        ps.setString(3, std[i].getLastname());
//        ps.setString(4, std[i].getFname());
//        ps.setString(5, std[i].getMname());
        // ps.setInt(6, std[i].getAge());
        System.out.println(std[i].getPer());
        // System.out.println("found it");
        System.out.println("nitin");
        System.out.println("found it again");
        //  int a = ps.executeUpdate();
        System.out.println("10000000000");
        int a = ps.executeUpdate();
        System.out.println("20000000000");

        // System.out.println("found it again");
        if (a > 0) {
            System.out.println("savedata");
            System.out.println("Succesfull");
        } else {
            System.out.println("faild");
        }

        con.close();

    }

    public boolean checkLogIn(String userNameSt, String passwordSt, boolean t) throws SQLException, ClassNotFoundException {

        PreparedStatement ps;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RGPVDATA", "root", "root");

        if (t) {
            ps = con.prepareStatement("SELECT * FROM  AdminData");
        } else {
            ps = con.prepareStatement("SELECT * FROM  STUDENTDETAILS");
        }
        ResultSet rs = ps.executeQuery();
        System.out.println("found resuly");
        String username;
        String password;
        while (rs.next()) {
            if (t) {
                username = rs.getString(1);
                password = rs.getString(2);
            } else {
                username = rs.getString(9);
                password = rs.getString(10);
            }
            System.out.println("checkd");
            System.out.println(username + "    " + password);
            if (username.equals(userNameSt) && password.equals(passwordSt)) {
                return true;
            }
        }
        return false;
    }

    public boolean adminLogin(String userName, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RGPVDATA", "root", "root");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM  Admintdata");
            ResultSet rs = ps.executeQuery();
            System.out.println("found resuly");
            String usname;
            String pass = null;
            while (rs.next()) {
                usname = rs.getString(9);
                password = rs.getString(10);
                System.out.println("checkd");
                System.out.println(usname + "    " + pass);
                if (usname.equals(userName) && pass.equals(password)) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {

        }
        return false;

    }

    public boolean checkRoll(int rollNumber) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        System.out.println("found ");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RGPVDATA", "root", "root");
        PreparedStatement ps = con.prepareStatement("SELECT * FROM  STUDENTRECORDS");

        ResultSet rs = ps.executeQuery();

        boolean b = false;
        while (rs.next()) {
            if (rollNumber == rs.getInt(1)) {
                b = true;
                break;
            }

        }
        ps.close();
        if (b) {
            ps = con.prepareStatement("SELECT * FROM  STUDENTDETAILS");
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rollNumber == rs.getInt(1)) {

                    return true;

                }

            }
        }
        return false;
    }

    public void allData(DefaultTableModel model) {

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RGPVDATA", "root", "root");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM STUDENTDetails");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                model.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(6), rs.getString(7)});
            }

        } catch (ClassNotFoundException | SQLException e) {

        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

    }

    public boolean checkSignUp(String username) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        System.out.println("found ");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RGPVDATA", "root", "root");
        PreparedStatement ps = con.prepareStatement("SELECT * FROM studentdetails");
        ResultSet rs = ps.executeQuery();
        System.out.println("found resuly");
        while (rs.next()) {

            String user = rs.getString("username");
            //System.out.println("checkd");
            if (username.equals(user)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkRegistration(int roll) throws SQLException, ClassNotFoundException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("found ");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RGPVDATA", "root", "root");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM studentdetails");
            ResultSet rs = ps.executeQuery();
            System.out.println("found resuly");
            while (rs.next()) {

                //System.out.println("checkd");
                if (roll == rs.getInt(1)) {
                    return false;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
        }

        return true;

    }

    public boolean rollCheck(int roll) throws SQLException, ClassNotFoundException {

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("found ");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RGPVDATA", "root", "root");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM studentRecords");
            ResultSet rs = ps.executeQuery();
            System.out.println("found resuly");
            while (rs.next()) {

                //System.out.println("checkd");
                if (roll == rs.getInt(1)) {
                    return true;
                }
            }
        } catch (ClassNotFoundException | SQLException E) {
        } finally {

            con.close();

        }
        return false;
    }

    public boolean byName(String name) {

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RGPVDATA", "root", "root");

            String sql = "delete  from  studentdetails where  Firstname = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            int a = ps.executeUpdate();

            if (a > 0) {
                return true;
            }
            System.out.println("found result");

        } catch (ClassNotFoundException | SQLException ex) {

            return false;
        } finally {

            try {
                con.close();
            } catch (SQLException ex) {

            }

        }
        return false;
    }

    /**
     *
     * @param roll
     * @return
     * @throws java.lang.ClassNotFoundException
     */
    public boolean byRollNo(int roll) throws ClassNotFoundException {

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RGPVDATA", "root", "root");
            String sql;

            sql = "delete  from  studentrecords where  roll_no = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, roll);
            int a = ps.executeUpdate();
            if (a > 0) {
                return true;
            }

        } catch (SQLException ex) {
            return false;
        } finally {

            try {
                con.close();
            } catch (SQLException ex) {

            }

        }
        return false;

    }

    public boolean allDelete() throws ClassNotFoundException {

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RGPVDATA", "root", "root");
            String sql;

            sql = "truncate table sturdentrecords";
            PreparedStatement ps = con.prepareStatement(sql);

            int a = ps.executeUpdate();
            if (a > 0) {
                return true;
            }

        } catch (SQLException ex) {
            return false;
        } finally {

            try {
                con.close();
            } catch (SQLException ex) {

            }

        }
        return false;

    }
}

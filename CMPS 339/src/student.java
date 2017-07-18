
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *middleInitial
 * @author Jedarrien
 */
public class student {
    public void insertUpdateDeleteStudent(char operation, Integer id, String firstName, String middleInitial, String lastName, String wNumber, String dob,
                                            String major, String degreeProgram, String gradUndergrad)
    {
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        // i for insert
        if(operation == 'i')
        {
            try {
                ps = con.prepareStatement("INSERT INTO student(firstName, middleInitial, lastName, idWNum, dob, major, degreeProgram, grad/under) VALUES (?,?,?,?,?,?,?,?)");
                ps.setString(1, firstName);
                ps.setString(2, middleInitial);
                ps.setString(3, lastName);
                ps.setString(4, wNumber);
                ps.setString(5, dob);
                ps.setString(6, major);
                ps.setString(7, degreeProgram);
                ps.setString(8, gradUndergrad);
                
                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "New Student Added");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}

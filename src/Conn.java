// JDBC Connectivity
/*JDBC connectivity has 5 steps:
 * 1-> Register the driver
 * 2-> Create connection
 * 3->Create statement
 * 4->Execute query
 * 5->Close connection
 */

import java.sql.*;
public class Conn {

    Connection c; //for creating connection
    Statement s; //for creating statement
    public Conn(){
        // try and catch is being implemented because we are using mysql and it is an external entity. Therefore we might get run time errors.
        try {
            
            //Class.forName(com.mysql.cj.jdbc.Driver); //this Class class is used to register the driver
            c= DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "password"); //for creating connection 
            //"jdbc:mysql://localhost:3306" we can write like this also but by default my sql runs on local host 3306 so we don't have to. But of this changes then we must.
            s=c.createStatement(); // for creating statement
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

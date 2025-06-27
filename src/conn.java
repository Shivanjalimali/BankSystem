import java.sql.*;
public class conn {
    Connection c;
    Statement s;
    public conn()
    {

        try{
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/BankManagementSystem","root","Shivanjali416408");
            s=c.createStatement();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}

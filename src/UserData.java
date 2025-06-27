import java.sql.SQLException;

public class UserData {
    int balance;
    String name;
    String gendre;
    String acct,pin,lnum;
    public UserData() throws SQLException {
        this.showdata();
    }
    public UserData(int balance) throws SQLException {
       this.balance=balance;
       conn c=new conn();
       String q="update UserInformation set balance='"+balance+"' where pin='"+pin+"'";
       c.s.executeUpdate(q);

    }
    public  UserData(String name,String gendre)
    {
        this.name=name;
        this.gendre=gendre;
    }
    public UserData(String acct,String pin,String lnum)
    {
        this.acct=acct;
        this.pin=pin;
        this.lnum=lnum;
    }
    public void showdata() throws SQLException {


    }
    public static void main(String[] args) {

        
    }

}

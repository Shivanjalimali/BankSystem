import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class miniStatements extends JFrame {
    String pinnumber;
    public miniStatements(String pinnumber)
    {

        setLayout(null);
        this.pinnumber=pinnumber;
        setSize(550,700);
        setTitle("Mini Statements");



        JLabel mini=new JLabel();
        add(mini);

        JLabel label=new JLabel("ICICI Bank");
        label.setBounds(200,20,200,30);
        label.setFont(new Font("Raleway",Font.BOLD,28));
        add(label);

        JLabel l4=new JLabel();
        l4.setFont(new Font("Raleway",Font.BOLD,18));
        l4.setBounds(20, 400, 300, 40);
        add(l4);

        JLabel card=new JLabel();
        card.setBounds(50,100,650,30);
        card.setFont(new Font("Raleway",Font.BOLD,22));
        add(card);

        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select *from signupthree where pin='"+pinnumber+"'");
            while (rs.next())
            {
                card.setText("Card No :"+rs.getString("Card_number"));
            }
        }
        catch (Exception exp)
        {
            System.out.println(exp);
        }
        try
        {
            conn c=new conn();
            int balance=0;
            ResultSet rs=c.s.executeQuery("select *from bank where pin='"+pinnumber+"'");
            while(rs.next())
            {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("ammount") + "<br><br><html>");
                if(rs.getString("mode").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            l4.setText("The total balance is :"+balance);
        }
        catch (Exception exp2)
        {
            System.out.println(exp2);
        }
        mini.setBounds(20,200,500,50);
        mini.setFont(new Font("Raleway",Font.BOLD,18));
        setVisible(true);
    }

    public static void main(String[] args) {
        new miniStatements("");
    }
}

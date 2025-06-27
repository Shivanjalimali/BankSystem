import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Deposite extends JFrame implements ActionListener {
    JButton Depos,back;
    String pin;
    JTextField button;
    int balance=0;
    public Deposite(String pin)
    {
        this.pin=pin;
        ImageIcon atm=new ImageIcon(getClass().getResource("atm.jpg"));
        Image icon=atm.getImage().getScaledInstance(900,850, Image.SCALE_DEFAULT);
        ImageIcon atm2=new ImageIcon(icon);
        JLabel je=new JLabel(atm2);
        je.setBounds(0,0,900,850);
        add(je);
        setSize(900,850);
        setLocation(300,0);


        JLabel text=new JLabel("Enter the ammount you want to deposite.");
        text.setFont(new Font("Raleway",Font.BOLD,18));
        text.setBounds(160,290,400,25);
        text.setForeground(Color.white);
        je.add(text);

        button =new JTextField();
        button.setFont(new Font("Raleway",Font.BOLD,22));
        button.setBounds(180,340,320,35);
        je.add(button);

        Depos=new JButton("Deposite");
        Depos.setBounds(370,470,100,30);
        Depos.addActionListener(this);
        je.add(Depos);


        back=new JButton("Back");
        back.setBounds(210,470,100,30);
        back.addActionListener(this);
        je.add(back);



        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
      new Deposite("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==Depos)
        {

            String number=button.getText();
            Date date=new Date();
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposite");

            }
            else
            {
                conn c5=new conn();
                String query="insert into bank values('"+pin+"','"+date+"','Deposite','"+number+"')";

                try
               {

                   c5.s.executeUpdate(query);
                   ResultSet rs=c5.s.executeQuery("select *from bank where pin = '"+pin+"'");
                   int balance=0;
                   while(rs.next())
                   {
                       if(rs.getString("type").equals("Deposite"))
                       {
                           balance+=Integer.parseInt(rs.getString("ammount"));
                       }
                       else if(rs.getString("type").equals("fastcash"))
                       {
                           balance-=Integer.parseInt(rs.getString("ammount"));
                       }
                       else
                       {
                           balance-=Integer.parseInt(rs.getString("ammount"));
                       }

                   }
                   String k="update UserInformation set balance ='"+balance+"'where pin='"+pin+"'";
                   c5.s.executeUpdate(k);


                   JOptionPane.showMessageDialog(null,"RS "+number+"Deposited Successfully");
                   setVisible(false);
                   new TransactionFrame(pin).setVisible(true);
               }
               catch(Exception e)
               {
                   System.out.println(e);
               }
            }

        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
            new TransactionFrame(pin).setVisible(true);
        }
    }
}

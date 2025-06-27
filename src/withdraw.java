import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class withdraw extends JFrame implements ActionListener {
    JButton withdraw,back;
    String pin;
    JTextField button;
    public withdraw(String pin)
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


        JLabel text=new JLabel("Enter the ammount you want to withdraw.");
        text.setFont(new Font("Raleway",Font.BOLD,18));
        text.setBounds(160,290,400,25);
        text.setForeground(Color.white);
        je.add(text);

        button =new JTextField();
        button.setFont(new Font("Raleway",Font.BOLD,22));
        button.setBounds(180,340,320,35);
        je.add(button);

        withdraw=new JButton("Withdraw");
        withdraw.setBounds(370,470,100,30);
        withdraw.addActionListener(this);
        je.add(withdraw);


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
        String amount= button.getText();
        if(ae.getSource()==withdraw)
        {

            String number=button.getText();
            Date date=new Date();
            int balance=0;
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to Withdraw");

            }
            else
            {
                conn c5=new conn();
                String query="insert into bank values('"+pin+"','"+date+"','Withdraw','"+number+"')";
                try
                {
                    c5.s.executeUpdate(query);
                    ResultSet rs=c5.s.executeQuery("select *from bank where pin = '"+pin+"'");

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


                    if(ae.getSource()!=back && balance<Integer.parseInt(amount))
                    {
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        return;
                    }


                    JOptionPane.showMessageDialog(null,"RS "+number+"withdraw Successfully");
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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinnumber;
    JButton back;
    int balance=0;
    public BalanceEnquiry(String pinnumber) throws SQLException {
        this.pinnumber = pinnumber;
        setSize(900, 900);
        setLocation(300, 0);

        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon atm = new ImageIcon(getClass().getResource("atm.jpg"));
        Image icon = atm.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon atm2 = new ImageIcon(icon);
        JLabel je = new JLabel(atm2);
        je.setBounds(0, 0, 900, 900);
        add(je);

        back = new JButton("back");
        back.setBounds(410, 520, 100, 30);
        back.addActionListener(this);
        je.add(back);


        conn c7 = new conn();
        try {


            ResultSet rs = c7.s.executeQuery("select *from bank where pin = '" + pinnumber + "'");
            balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposite")) {
                    balance += Integer.parseInt(rs.getString("ammount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("ammount"));
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel la=new JLabel("Your current balance is :"+balance);
        la.setFont(new Font("Raleway",Font.BOLD,20));
        la.setBounds(170,300,400,70);
        la.setForeground(Color.white);
        je.add(la);

        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==back)
       {
           setVisible(false);
           new TransactionFrame(pinnumber).setVisible(true);
       }
    }

    public static void main(String[] args) throws SQLException {
       new BalanceEnquiry("").setVisible(true);
    }
}
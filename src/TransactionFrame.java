import javax.swing.*;
import java.awt.*;//we get Image class from here
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TransactionFrame extends JFrame implements ActionListener {
    JButton deposite,withdraw,balanceenquiry,miniStatement,pinchanger,fastcash,exit;
    String pinnumber;
    public TransactionFrame(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon atm=new ImageIcon(getClass().getResource("atm.jpg"));
        Image icon=atm.getImage().getScaledInstance(900,850, Image.SCALE_DEFAULT);
        ImageIcon atm2=new ImageIcon(icon);
        JLabel je=new JLabel(atm2);
        je.setBounds(0,0,900,850);
        add(je);

        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(220,280,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        je.add(text);

        deposite=new JButton("Deposite");
        deposite.addActionListener(this);
        deposite.setBounds(170,390,160,30);
        deposite.setFont(new Font("System",Font.BOLD,16));
        je.add(deposite);

        withdraw=new JButton("Cash Withdraw");
        withdraw.addActionListener(this);
        withdraw.setBounds(350,390,160,30);
        withdraw.setFont(new Font("System",Font.BOLD,16));
        je.add(withdraw);

        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(170,425,160,30);
        fastcash.addActionListener(this);
        fastcash.setFont(new Font("System",Font.BOLD,16));
        je.add(fastcash);

        miniStatement=new JButton("Mini Statement");
        miniStatement.setBounds(350,425,160,30);
        miniStatement.setFont(new Font("System",Font.BOLD,16));
        miniStatement.addActionListener(this);

        je.add(miniStatement);

        pinchanger=new JButton("Pin Change");
        pinchanger.setBounds(170,460,160,30);
        pinchanger.setFont(new Font("System",Font.BOLD,16));
        pinchanger.addActionListener(this);
        je.add(pinchanger);


        pinchanger=new JButton("Pin Change");
        pinchanger.setBounds(170,460,160,30);
        pinchanger.setFont(new Font("System",Font.BOLD,16));
        pinchanger.addActionListener(this);
        je.add(pinchanger);

        balanceenquiry=new JButton("Balance Enquiry");
        balanceenquiry.setBounds(350,460,160,30);
        balanceenquiry.setFont(new Font("System",Font.BOLD,16));
        balanceenquiry.addActionListener(this);

        je.add(balanceenquiry);

        exit=new JButton("Exit");
        exit.setBounds(350,495,160,30);
        exit.addActionListener(this);
        exit.setFont(new Font("System",Font.BOLD,16));
        je.add(exit);

        setSize(900,850);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==exit)
       {
           System.exit(0);
       }
       else if(ae.getSource()==deposite)
       {
           setVisible(false);
           new Deposite(pinnumber).setVisible(true);
       }
       else if(ae.getSource()==withdraw)
       {
           setVisible(false);
           new withdraw(pinnumber).setVisible(true);
       }
       else if(ae.getSource()==fastcash)
       {
           setVisible(false);
           new fastcash(pinnumber).setVisible(true);
       }
       else if(ae.getSource()==pinchanger)
       {
           setVisible(false);
           new pinchange(pinnumber).setVisible(true);
       }
       else if(ae.getSource()==balanceenquiry)
       {
           try {
               setVisible(false);
               new BalanceEnquiry(pinnumber).setVisible(true);
           } catch (SQLException e) {
               throw new RuntimeException(e);
           }
       }
       else if(ae.getSource()==miniStatement)
       {
           setVisible(false);
           new miniStatements(pinnumber).setVisible(true);
       }
    }
    public static void main(String[] args) {
        new TransactionFrame("");
    }

}

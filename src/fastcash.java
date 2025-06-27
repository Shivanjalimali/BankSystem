import javax.swing.*;
import java.awt.*;//we get Image class from here
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class fastcash extends JFrame implements ActionListener {
    JButton deposite,withdraw,balanceenquiry,miniStatement,pinchange,fastcash,exit;
    String pinnumber,ammount;
    public fastcash(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon atm=new ImageIcon(getClass().getResource("atm.jpg"));
        Image icon=atm.getImage().getScaledInstance(900,850, Image.SCALE_DEFAULT);
        ImageIcon atm2=new ImageIcon(icon);
        JLabel je=new JLabel(atm2);
        je.setBounds(0,0,900,850);
        add(je);

        JLabel text=new JLabel("Please select withdrawal ammount");
        text.setBounds(220,280,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        je.add(text);

        deposite=new JButton("Rs 100");
        deposite.setBounds(170,390,160,30);
        deposite.setFont(new Font("System",Font.BOLD,16));
        deposite.addActionListener(this);
        je.add(deposite);

        withdraw=new JButton("Rs 500");
        withdraw.addActionListener(this);
        withdraw.setBounds(350,390,160,30);
        withdraw.setFont(new Font("System",Font.BOLD,16));
        je.add(withdraw);

        fastcash=new JButton("Rs 1000");
        fastcash.setBounds(170,425,160,30);
        fastcash.addActionListener(this);
        fastcash.setFont(new Font("System",Font.BOLD,16));
        je.add(fastcash);

        miniStatement=new JButton("Rs 2000");
        miniStatement.setBounds(350,425,160,30);
        miniStatement.setFont(new Font("System",Font.BOLD,16));
        miniStatement.addActionListener(this);

        je.add(miniStatement);

        pinchange=new JButton("Rs 5000");
        pinchange.setBounds(170,460,160,30);
        pinchange.addActionListener(this);
        pinchange.setFont(new Font("System",Font.BOLD,16));
        je.add(pinchange);

        balanceenquiry=new JButton("Rs 10000");
        balanceenquiry.setBounds(350,460,160,30);
        balanceenquiry.addActionListener(this);
        balanceenquiry.setFont(new Font("System",Font.BOLD,16));

        je.add(balanceenquiry);

        exit=new JButton("back");
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
        ammount=null;
        if(ae.getSource()==exit)
        {
            setVisible(false);
            new TransactionFrame(pinnumber).setVisible(true);
        }
        else
        {

            if(ae.getSource()==deposite)
            {
                ammount="100";
            }
            else if(ae.getSource()==withdraw)
            {
                ammount="500";
            }
            else if(ae.getSource()==fastcash)
            {
                ammount="1000";
            }
            else if(ae.getSource()==miniStatement)
            {
                ammount="2000";
            }
            else if(ae.getSource()==pinchange)
            {
                ammount="5000";
            }
            else if(ae.getSource()==balanceenquiry)
            {
                ammount="10000";
            }
            conn c7=new conn();
            try{
                Date date =new Date();
                String query7="INSERT INTO bank VALUES ('"+pinnumber+"', '"+date+"', 'Withdraw', '"+ammount+"')";
                c7.s.executeUpdate(query7);
                ResultSet rs=c7.s.executeQuery("select *from bank where pin = '"+pinnumber+"'");
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
                String k="update UserInformation set balance ='"+balance+"'where pin='"+pinnumber+"'";
                c7.s.executeUpdate(k);
                if(ae.getSource()!=exit && balance<Integer.parseInt(ammount))
                {
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

                System.out.println("statements");
                JOptionPane.showMessageDialog(null,"Rs "+ammount+ "withdraw Successfully");
                setVisible(false);
                new TransactionFrame(pinnumber).setVisible(true);


            }catch (Exception e)
            {
                System.out.println(e);
            }
        }

    }
    public static void main(String[] args) {
        new fastcash("");
    }

}

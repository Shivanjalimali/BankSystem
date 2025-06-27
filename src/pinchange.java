import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pinchange extends JFrame implements ActionListener {
    JPasswordField pinText,pinText2;
    JButton change,back;
    String pinnumber;
    public pinchange(String pinnumber)
    {
        this.pinnumber=pinnumber;
        ImageIcon i=new ImageIcon(getClass().getResource("atm.jpg"));
        Image image=i.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon img=new ImageIcon(image);
        JLabel label=new JLabel(img);
        setSize(900,900);

        label.setBounds(0,0,900,900);
        add(label);

        JLabel text=new JLabel("Change your Pin");
        text.setBounds(250,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,18));
        label.add(text);

        JLabel newpin=new JLabel("New pin:");
        newpin.setBounds(160,350,200,35);
        newpin.setFont(new Font("System",Font.BOLD,18));
        newpin.setForeground(Color.white);
        label.add(newpin);

        JLabel renewpin=new JLabel("Re-enter New pin:");
        renewpin.setBounds(160,390,190,35);
        renewpin.setFont(new Font("System",Font.BOLD,18));
        renewpin.setForeground(Color.white);
        label.add(renewpin);

        pinText=new JPasswordField();
        pinText.setBounds(330,350,180,30);
        pinText.setFont(new Font("System",Font.BOLD,18));
        pinText.setForeground(Color.BLACK);
        label.add(pinText);

        pinText2=new JPasswordField();
        pinText2.setBounds(330,390,180,30);
        pinText2.setFont(new Font("System",Font.BOLD,18));
        pinText2.setForeground(Color.BLACK);
        label.add(pinText2);

        change=new JButton("Change");
        change.setBounds(410,485,100,30);
        change.addActionListener(this);
        label.add(change);

        back=new JButton("back");
        back.setBounds(410,520,100,30);
        back.addActionListener(this);
        label.add(back);


        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);


    }

    public static void main(String[] args) {
        new pinchange("");
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==change)
        {
            try{
                String npin=pinText.getText();
                String rpin=pinText2.getText();
                if(npin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"please enter the new pin");
                    return;
                }
                if(rpin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"please re-enter the new pin");
                    return;
                }
                if(!npin.equals(rpin))
                {
                    JOptionPane.showMessageDialog(null,"pin doesn't msatch");
                    return;
                }

                conn c=new conn();
                String query1="update bank set pin='"+rpin+"' where pin='"+pinnumber+"'";
                //String query2="update signuptwo set PIN='"+rpin+"' where PIN='"+pinnumber+"'";
                String query3="update signupthree set PIN='"+rpin+"' where PIN='"+pinnumber+"'";
                c.s.executeUpdate(query1);
                //c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"Pin changed sucessfully");
                setVisible(false);
                new TransactionFrame(rpin).setVisible(true);

            }
            catch (Exception er)
            {
                System.out.println(er);
            }
        }
        else
        {
            setVisible(false);
            new TransactionFrame(pinnumber).setVisible(true);
        }
    }
}

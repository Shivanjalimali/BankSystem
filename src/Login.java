import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
public class Login extends JFrame implements ActionListener{
    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    public Login() {
        setTitle("ATM management system");
        setSize(800, 500);
        setLocation(350, 200);


        login=new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);

        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);

        login.addActionListener(this);
        add(login);

        clear=new JButton("CLEAR");
        clear.setBounds(450, 300, 100, 30);
        add(clear);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);

        signup=new JButton("SIGN UP");
        signup.setBounds(300, 360, 250, 32);
        add(signup);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);


        ImageIcon icon = new ImageIcon(getClass().getResource("logo.jpg"));
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        Image i2=icon.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(i2);

        JLabel label  = new JLabel(icon2);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text=new JLabel("Welcome to ATM");
        text.setBounds(200,10,400,100);
        add(text);
        text.setFont(new Font("Osward",Font.BOLD,38 ));


        JLabel cardno=new JLabel("Crad No :");
        cardno.setBounds(100,130,140,30);
        add(cardno);
        cardno.setFont(new Font("Osward",Font.BOLD,28 ));

        cardTextField=new JTextField();
        cardTextField.setFont(new Font("SansSerif", Font.PLAIN, 18));

        cardTextField.setBounds(300,130,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin=new JLabel("Pin No :");
        pin.setBounds(100,210,240,40);
        add(pin);
        pin.setFont(new Font("Raleway",Font.BOLD,28 ));

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ac)
    {

        if(ac.getSource() == clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }

        else if(ac.getSource()==signup)
        {
            new SignUp().setVisible(true);
        }
        else if(ac.getSource()==login)
        {
            conn c3=new conn();
            String cardn=cardTextField.getText().trim();
            String pinn=pinTextField.getText().trim();
            String query4="select *from signupThree where card_number ='"+cardn+"' and PIN ='"+pinn+"'";
            try{
               ResultSet rs= c3.s.executeQuery(query4);
               if(rs.next())//menas there are some data in this result set
               {
                   setVisible(false);
                   new TransactionFrame(pinn).setVisible(true);
               }
               else {
                   JOptionPane.showMessageDialog(null,"the incorrect pin or cardno");
               }
            }catch (Exception er)
            {
                System.out.println(er);
            }
        }

    }
    public static void main(String[] args) {
        new Login();
    }
}

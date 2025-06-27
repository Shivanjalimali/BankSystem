import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener {
    JCheckBox required, box1, box2, box3, box4, box5, box6;
    JRadioButton current, fixed, saving, recurring;
    JLabel PIn;
    JButton b2, b3;
    int balance;
    int p = 0;
    int c = 0;
    long number;
    String newname;
    SignUpThree(String newname) {
        setLayout(null);
        this.newname=newname;
        setSize(850, 800);
        setBackground(Color.white);
        setLocation(350, 10);
        ImageIcon t = new ImageIcon(getClass().getResource("logo.jpg"));
        Image img = t.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon t2 = new ImageIcon(img);
        JLabel l = new JLabel(t2);
        getContentPane().setBackground(Color.white);
        l.setBounds(10, 10, 100, 100);
        add(l);

        setTitle("ATM Mangement System");

        JLabel additionalname = new JLabel("Page 3: Account Details");
        additionalname.setFont(new Font("Osward", Font.BOLD, 35));
        additionalname.setBounds(210, 50, 500, 80);
        add(additionalname);


        JLabel acttype = new JLabel("Account Type");
        acttype.setFont(new Font("Osward", Font.BOLD, 30));
        acttype.setBounds(115, 170, 500, 50);
        add(acttype);

        saving = new JRadioButton("Saving Account");
        saving.setBounds(120, 220, 180, 40);
        saving.setFont(new Font("Raleway", Font.BOLD, 18));
        saving.setBackground(Color.white);
        saving.addActionListener(this);
        add(saving);


        current = new JRadioButton("Current Account");
        current.setBounds(120, 270, 180, 40);
        current.setFont(new Font("Raleway", Font.BOLD, 18));
        current.setBackground(Color.white);
        current.addActionListener(this);
        add(current);

        fixed = new JRadioButton("Fixed Deposite Account");
        fixed.setBounds(400, 220, 250, 40);
        fixed.setFont(new Font("Raleway", Font.BOLD, 18));
        fixed.setBackground(Color.white);
        fixed.addActionListener(this);
        add(fixed);

        recurring = new JRadioButton("Recurring Deposite Account");
        recurring.setBounds(400, 270, 280, 40);
        recurring.setFont(new Font("Raleway", Font.BOLD, 18));
        recurring.setBackground(Color.white);
        recurring.addActionListener(this);
        add(recurring);

        ButtonGroup button = new ButtonGroup();
        button.add(saving);
        button.add(current);
        button.add(fixed);
        button.add(recurring);

        JLabel cardno = new JLabel("Card Number");
        cardno.setBounds(115, 320, 200, 50);
        cardno.setFont(new Font("Osward", Font.BOLD, 30));
        add(cardno);

        SecureRandom random = new SecureRandom();
        // Generate a random 16-digit number between 1000000000000000 and 9999999999999999
        number = 1000000000000000L + (Math.abs(random.nextLong()) % 9000000000000000L);
        String No = "" + number;
        int last4Digits = (int) (number % 10000);
        JLabel card = new JLabel("XXXX-XXXX-XXXX-" + last4Digits);
        card.setBounds(400, 330, 600, 50);
        card.setFont(new Font("Osward", Font.BOLD, 25));
        add(card);

        JLabel text = new JLabel("Your 16 Digit card Number");
        text.setBounds(115, 350, 200, 50);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        add(text);

        JLabel pinno = new JLabel("PIN");
        pinno.setBounds(115, 400, 200, 50);
        pinno.setFont(new Font("Osward", Font.BOLD, 30));
        add(pinno);

        Random ran = new Random();
        this.p = (int) Math.round(ran.nextDouble() * 1000 + 1000);

        String PIN = "" + p;
        PIn = new JLabel("XXXX");
        PIn.setBounds(400, 400, 100, 50);
        PIn.setFont(new Font("Osward", Font.BOLD, 25));
        add(PIn);

        JLabel text2 = new JLabel("Your 4 Digit Password");
        text2.setBounds(115, 430, 200, 50);
        text2.setFont(new Font("Raleway", Font.BOLD, 16));
        add(text2);

        JLabel service = new JLabel("Service Required :");
        service.setBounds(115, 475, 300, 50);
        service.setFont(new Font("Osward", Font.BOLD, 30));
        add(service);

        box1 = new JCheckBox("ATM CARD");
        box1.setBounds(115, 520, 200, 50);
        box1.setFont(new Font("Raleway", Font.BOLD, 20));
        box1.setBackground(Color.white);
        box1.addActionListener(this);
        add(box1);

        box2 = new JCheckBox("Mobile Banking");
        box2.setBounds(115, 570, 200, 50);
        box2.setFont(new Font("Raleway", Font.BOLD, 20));
        box2.setBackground(Color.white);
        box2.addActionListener(this);
        add(box2);

        box3 = new JCheckBox("Check Book");
        box3.setBounds(115, 620, 200, 50);
        box3.setFont(new Font("Raleway", Font.BOLD, 20));
        box3.setBackground(Color.white);
        box3.addActionListener(this);
        add(box3);

        box4 = new JCheckBox("Internet Banking");
        box4.setBounds(400, 520, 200, 50);
        box4.setFont(new Font("Raleway", Font.BOLD, 20));
        box4.setBackground(Color.white);
        box4.addActionListener(this);
        add(box4);

        box5 = new JCheckBox("EMAIL & SMS Alerts");
        box5.setBounds(400, 570, 200, 50);
        box5.setFont(new Font("Raleway", Font.BOLD, 20));
        box5.addActionListener(this);
        box5.setBackground(Color.white);
        add(box5);

        box6 = new JCheckBox("E-Statement");
        box6.setBounds(400, 620, 200, 50);
        box6.setFont(new Font("Raleway", Font.BOLD, 20));
        box6.addActionListener(this);
        box6.setBackground(Color.white);
        add(box6);

        required = new JCheckBox("I hereby declares that the above entered details are correct .");
        required.setBounds(115, 670, 600, 30);
        required.setFont(new Font("Raleway", Font.BOLD, 18));
        required.setBackground(Color.white);
        required.addActionListener(this);
        add(required);

        b2 = new JButton("Submit");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        b2.setFont(new Font("Raleway", Font.BOLD, 20));
        b2.setBounds(260, 710, 120, 40);
        add(b2);

        b3 = new JButton("Cancel");
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        b3.addActionListener(this);
        b3.setFont(new Font("Raleway", Font.BOLD, 20));
        b3.setBounds(480, 710, 120, 40);
        add(b3);

        setVisible(true);
    }

    public static void main(String[] args) {
        new SignUpThree("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b2) {
            String Accounttype = null;
            String PINno = ""+PIn.getText();
            String lnumber = "" + number;
            String services = "";

            if (box1.isSelected()) services += "ATM CARD, ";
            if (box2.isSelected()) services += "Mobile Banking, ";
            if (box3.isSelected()) services += "Check Book, ";
            if (box4.isSelected()) services += "Internet Banking, ";
            if (box5.isSelected()) services += "EMAIL & SMS Alerts, ";
            if (box6.isSelected()) services += "E-Statement, ";

            if (!services.isEmpty()) {
                services = services.substring(0, services.length() - 2);
            }

            if (saving.isSelected()) Accounttype = "Saving Account";
            else if (current.isSelected()) Accounttype = "Current Account";
            else if (fixed.isSelected()) Accounttype = "Fixed Deposit Account";
            else if (recurring.isSelected()) Accounttype = "Recurring Deposit Account";

            if (!required.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please check the declaration box.");
                return;
            }

            try
            {
                conn c2 = new conn();
                SignUp si= new SignUp();
                si.setVisible(false);
                //BalanceEnquiry be=new BalanceEnquiry("pin");
                String gender=null;
                if((si.gen).isSelected())
                {
                    gender="male";
                }
                else {
                    gender="female";
                }
                ResultSet rs = c2.s.executeQuery("select *from bank where pin = '" + p + "'");
                balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposite")) {
                        balance += Integer.parseInt(rs.getString("ammount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("ammount"));
                    }
                }
                String n=si.nameText.getText();
                System.out.println(n);
                String query3 = "INSERT INTO SignUpThree (account_type, pin, card_number, services) VALUES ('"
                        + Accounttype + "','" + p+ "','" + lnumber + "','" + services + "')";
                String pin=""+p;
                String query4="INSERT INTO UserInformation(name,account_type, pin, card_number, balance,gender) VALUES ('"
                        +newname+ "','"
                        +Accounttype+ "','" + pin+ "','" + lnumber+ "','" + balance + "','"+gender+"')";
                c2.s.executeUpdate(query4);
                new UserData(Accounttype,pin,lnumber);
                c2.s.executeUpdate(query3);
                //new UserData(balance);

                JOptionPane.showMessageDialog(null, "Signup Completed Successfully");
                JOptionPane.showMessageDialog(null,"Card No:"+lnumber);
                JOptionPane.showMessageDialog(null,"pin number:"+this.p);
                setVisible(false);
                new Login().setVisible(true);

            } catch (Exception e3) {
                System.out.println(e3);
            }
        }

        if (e.getSource() == b3) {
            setVisible(false); // Cancel button closes the window
        }
    }
}

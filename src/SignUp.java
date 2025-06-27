import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
public class SignUp extends JFrame implements ActionListener {
    JDateChooser dateChooser;
    long Random ;
    JButton b,b2,next;
    int k;
    String name;
    JRadioButton status,status2,status3,gen,gen2;
    JTextField nameText,fatherText,emailText,adressText,pinText,stateText,cityText;
    SignUp()
    {
        setLayout(null);
        ImageIcon i=new ImageIcon(getClass().getResource("logo.jpg"));
        Image i2=i.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon icon=new ImageIcon(i2);
        JLabel j=new JLabel(icon);
        j.setBounds(20,10,100,100);
        add(j);

        Random r=new Random();
        k=(int)Math.round(r.nextDouble()*1000+1000);
        setSize(850,800);
        setLocation(350, 10);

        setTitle("ATM Mangement System");
        getContentPane().setBackground(Color.WHITE);

        JLabel l=new JLabel("APPLICATION FORM NO . "+k);
        l.setFont(new Font("Raleway",Font.BOLD,38));
        l.setBounds(140,15,600,60);
        add(l);

        JLabel personLabel=new JLabel("Page 1 : Personal Details");
        personLabel.setFont(new Font("Raleway",Font.BOLD,28));
        personLabel.setBounds(240,80,600,40);
        add(personLabel);

        JLabel name=new JLabel("Name :");
        name.setFont(new Font("Raleway",Font.BOLD,23));
        name.setBounds(60,140,200,40);

        add(name);
        nameText=new JTextField();
        nameText.setFont(new Font("Raleway",Font.BOLD,18));
        nameText.addActionListener(this);
        nameText.setBounds(270,150,400,30);
        add(nameText);

        JLabel FatherName=new JLabel("Father`s Name :");
        FatherName.setFont(new Font("Raleway",Font.BOLD,23));
        FatherName.setBounds(60,190,200,40);
        add(FatherName);
        fatherText=new JTextField();
        fatherText.setFont(new Font("Raleway",Font.BOLD,18));
        fatherText.addActionListener(this);
        fatherText.setBounds(270,200,400,30);
        add(fatherText);

        JLabel DOB=new JLabel("Date of Birth :");
        DOB.setFont(new Font("Raleway",Font.BOLD,23));
        DOB.setBounds(60,240,200,40);
        add(DOB);

        JLabel gender=new JLabel("Gender :");
        gender.setFont(new Font("Raleway",Font.BOLD,23));
        gender.setBounds(60,290,200,40);
        add(gender);

        gen=new JRadioButton("Male");

        gen.setBounds(270,290,100,30);
        add(gen);
        gen.setBackground(Color.WHITE);

        gen2=new JRadioButton("Female");
        gen2.setBounds(400,290,150,30);
        add(gen2);
        gen2.setBackground(Color.WHITE);
        ButtonGroup b=new ButtonGroup();

        b.add(gen) ;
        b.add(gen2) ;
        JLabel email=new JLabel("Email Address :");
        email.setFont(new Font("Raleway",Font.BOLD,23));
        email.setBounds(60,340,200,40);
        add(email);
        emailText=new JTextField();
        emailText.setFont(new Font("Raleway",Font.BOLD,18));
        emailText.addActionListener(this);
        emailText.setBounds(270,350,400,30);
        add(emailText);
        JLabel marry=new JLabel("Marital Status :");
        marry.setFont(new Font("Raleway",Font.BOLD,23));
        marry.setBounds(60,390,100,40);
        add(marry);
        
        status=new JRadioButton("Married");
        status.setBounds(270,390,100,40);
        status.setBackground(Color.WHITE);
        add(status);

        status2=new JRadioButton("UnMarried");
        status2.setBounds(400,390,100,40);
        status2.setBackground(Color.WHITE);
        add(status2);

        status3=new JRadioButton("other");
        status3.setBounds(530,390,100,40);
        status3.setBackground(Color.WHITE);
        add(status3);

        ButtonGroup b2=new ButtonGroup();
        b2.add(status);
        b2.add(status2);
        b2.add(status3);
        JLabel adress=new JLabel("Address :");
        adress.setFont(new Font("Raleway",Font.BOLD,23));
        adress.setBounds(60,440,200,40);


        add(adress);
        adressText=new JTextField();
        adressText.setFont(new Font("Raleway",Font.BOLD,18));
        adressText.setBounds(270,450,400,30);
        add(adressText);

        JLabel city=new JLabel("City :");
        city.setFont(new Font("Raleway",Font.BOLD,23));
        city.setBounds(60,490,200,40);
        add(city);

        cityText=new JTextField();
        cityText.setFont(new Font("Raleway",Font.BOLD,18));
        cityText.setBounds(270,500,400,30);
        add(cityText);

        JLabel pin=new JLabel("Pin Code:");
        pin.setFont(new Font("Raleway",Font.BOLD,23));
        pin.setBounds(60,540,200,40);
        add(pin);

        pinText=new JTextField();
        pinText.setFont(new Font("Raleway",Font.BOLD,18));
        pinText.setBounds(270,550,400,30);
        add(pinText);

        JLabel state=new JLabel("State :");
        state.setFont(new Font("Raleway",Font.BOLD,23));
        state.setBounds(60,590,200,40);
        add(state);

        stateText=new JTextField();
        stateText.setFont(new Font("Raleway",Font.BOLD,18));
        stateText.setBounds(270,600,400,30);
        add(stateText);

        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,18));
        next.setBounds(560,680,110,40);
        next.addActionListener(this);
        add(next);

        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy");
        dateChooser.setBounds(270, 250, 400, 30);
        dateChooser.setForeground(Color.BLACK);
        dateChooser.setFont(new Font("Raleway",Font.BOLD,18));

        add(dateChooser);
        setVisible(true);
    }

    public static void main(String[] args) {

        new SignUp();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            name = nameText.getText();
            String fname = fatherText.getText();
            String adress = adressText.getText();
            String pin = pinText.getText();
            String city = cityText.getText();
            String states = stateText.getText();
            String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
            String genders = null;
            String emailname = emailText.getText();
            String marital = null;
            String formno = "" + k;

            if (gen.isSelected()) {
                genders = "Male";
            } else if (gen2.isSelected()) {
                genders = "Female";
            }

            if (status.isSelected()) {
                marital = "married";
            } else if (status2.isSelected()) {
                marital = "Unmarried";
            } else if (status3.isSelected()) {
                marital = "Other";
            }

            // Field validations
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is required");
            } else if (fname.equals("")) {
                JOptionPane.showMessageDialog(null, "Father Name is required");
            } else if (adress.equals("")) {
                JOptionPane.showMessageDialog(null, "Address is required");
            } else if (pin.equals("")) {
                JOptionPane.showMessageDialog(null, "Pincode is required");
            } else if (city.equals("")) {
                JOptionPane.showMessageDialog(null, "City is required");
            } else if (states.equals("")) {
                JOptionPane.showMessageDialog(null, "State is required");
            } else if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "Date of Birth is required");
            } else if (emailname.equals("")) {
                JOptionPane.showMessageDialog(null, "Email is required");
            } else if (marital == null) {
                JOptionPane.showMessageDialog(null, "Marital status is required");
            } else if (genders == null) {
                JOptionPane.showMessageDialog(null, "Gender is required");
            } else {
                try {
                    conn c = new conn();
                    String query = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + emailname + "','" + marital + "','" + dob + "','" + states + "','" + pin + "','" + city + "','" + adress + "','" + genders + "')";
                    c.s.executeUpdate(query);

                    // Proceed to next form
                    new UserData(name,genders);
                    setVisible(false);
                    new SignUp2Twojava(name,k).setVisible(true);

                } catch (Exception e1) {
                    System.out.println(e1);
                }
            }
        }
    }
}

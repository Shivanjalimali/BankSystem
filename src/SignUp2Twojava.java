import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp2Twojava extends JFrame implements ActionListener {
    JLabel name, eno, eyes, education, income, pan, existAc, category, occupation, citizen, b, Adhar;
    JRadioButton eryes, erno,yes,no;
    JButton b1;
    SignUp s1=new SignUp();
    int k=s1.k;
    JTextField adharText,panText;
    JComboBox edu,cate,Inc,reg,occu;
    String newname;
    public SignUp2Twojava(String newname,int k)
    {
        this.newname=newname;
        setLayout(null);

        setSize(850, 800);
        setLocation(350, 10);
        setTitle("ATM Mangement System");
        ImageIcon i = new ImageIcon(getClass().getResource("logo.jpg"));
        Image i2 = i.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(i2);
        JLabel j = new JLabel(icon);
        j.setBackground(Color.WHITE);
        j.setBounds(20, 10, 100, 100);
        add(j);
        getContentPane().setBackground(Color.WHITE);


        JLabel additionalname = new JLabel("Page:2 Additional Details");
        additionalname.setFont(new Font("Osward", Font.BOLD, 35));
        additionalname.setBounds(210, 80, 500, 30);
        add(additionalname);

        name = new JLabel("Religion :");
        name.setFont(new Font("Raleway", Font.BOLD, 23));
        name.setBounds(60, 160, 200, 30);
        add(name);
        String valreg[] = {"Hindu", "Muslim", "Sikh", "Chrishan", "Others"};
        reg = new JComboBox(valreg);
        reg.setFont(new Font("Raleway", Font.BOLD, 18));
        reg.setBounds(250, 160, 500, 30);
        add(reg);

        category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 23));
        category.setBounds(60, 210, 200, 30);
        add(category);

        String valcategory[] = {"General", "SC/ST", "OBC", "NT/VJNT", "other"};
        cate = new JComboBox(valcategory);
        cate.setFont(new Font("Raleway", Font.BOLD, 18));
        cate.setBounds(250, 210, 500, 30);
        cate.setBackground(Color.WHITE);
        add(cate);

        income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 23));
        income.setBounds(60, 260, 200, 30);
        add(income);


        String valincome[] = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000"};
        Inc = new JComboBox(valincome);
        Inc.setFont(new Font("Raleway", Font.BOLD, 18));
        Inc.setBounds(250, 260, 500, 30);
        Inc.setBackground(Color.WHITE);
        add(Inc);

        education = new JLabel("Educational");
        JLabel q = new JLabel("Qualification :");
        q.setFont(new Font("Raleway", Font.BOLD, 23));
        q.setBounds(60, 350, 200, 30);
        add(q);

        String valeduaction[] = {"non-graduate", "Graduate", "Post-graduate", "doctrate", "others"};
        edu = new JComboBox(valeduaction);
        edu.setFont(new Font("Raleway", Font.BOLD, 18));
        edu.setBounds(250, 330, 500, 30);
        edu.setBackground(Color.WHITE);
        add(edu);


        education.setFont(new Font("Raleway", Font.BOLD, 23));
        education.setBounds(60, 320, 200, 30);
        add(education);

        occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 23));
        occupation.setBounds(60, 420, 200, 30);
        add(occupation);


        String valoccuption[] = {"farmer", "business", "gov-job", "student", "teacher"};
        occu = new JComboBox(valoccuption);
        occu.setFont(new Font("Raleway", Font.BOLD, 18));
        occu.setBounds(250, 420, 500, 30);
        occu.setBackground(Color.WHITE);
        add(occu);

        pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 23));
        pan.setBounds(60, 470, 200, 30);
        add(pan);
        panText = new JTextField();
        panText.setBounds(250, 470, 500, 30);
        panText.setFont(new Font("Raleway", Font.BOLD, 18));
        add(panText);


        Adhar = new JLabel("Adhar Number:");
        Adhar.setFont(new Font("Raleway", Font.BOLD, 23));
        Adhar.setBounds(60, 520, 200, 30);
        add(Adhar);
        adharText = new JTextField();
        adharText.setBounds(250, 520, 500, 30);
        adharText.setFont(new Font("Raleway", Font.BOLD, 18));
        add(adharText);

        citizen = new JLabel("Senior Citizen:");
        citizen.setFont(new Font("Raleway", Font.BOLD, 23));
        citizen.setBounds(60, 570, 200, 30);
        add(citizen);

        yes = new JRadioButton("Yes");
        yes.setBounds(290, 570, 150, 30);
        yes.setFont(new Font("Raleway", Font.BOLD, 18));
        yes.setBackground(Color.white);
        add(yes);

        no = new JRadioButton("No");
        no.setBounds(550, 570, 150, 30);
        no.setFont(new Font("Raleway", Font.BOLD, 18));
        no.setBackground(Color.white);
        add(no);

        ButtonGroup but=new ButtonGroup();
        but.add(yes);
        but.add(no);

        existAc = new JLabel("Existing Account:");
        existAc.setFont(new Font("Raleway", Font.BOLD, 23));
        existAc.setBounds(60, 620, 200, 30);
        add(existAc);

        eryes = new JRadioButton("Yes");
        eryes.setBounds(290, 620, 150, 30);
        eryes.setFont(new Font("Raleway", Font.BOLD, 18));
        eryes.setBackground(Color.white);
        add(eryes);

        erno = new JRadioButton("No");
        erno.setBounds(550, 620, 150, 30);
        erno.setFont(new Font("Raleway", Font.BOLD, 18));
        erno.setBackground(Color.white);
        add(erno);

        ButtonGroup but1=new ButtonGroup();
        but1.add(eryes);
        but1.add(erno);

        b1 = new JButton("Next");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        b1.setFont(new Font("Raleway", Font.BOLD, 20));
        b1.setBounds(650, 650, 100, 40);
        add(b1);
        setVisible(true);
    }


    public static void main(String[] args) {

        new SignUp2Twojava("",0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String scitizen=null;
        String sname=(String) reg.getSelectedItem();
        String scategory=(String) cate.getSelectedItem();
        String sincome=(String) Inc.getSelectedItem();
        String socuption=(String) occu.getSelectedItem();
        String span= panText.getText();
        String sAdhar=adharText.getText();

        String sedu=(String)edu.getSelectedItem();
        if(yes.isSelected())
        {
            scitizen="Yes";
        }
        else {
            scitizen="No";
        }
        String exaccount=null;
        if(eryes.isSelected())
        {
            exaccount="Yes";
        }
        else {
            exaccount="No";
        }
        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "pincode is required");
            } else if (income.equals("")) {
                JOptionPane.showMessageDialog(null, "pincode is required");

            }
            else if(occupation.equals(""))
            {
                JOptionPane.showMessageDialog(null,"pincode is required");

            }
            else if(category.equals(""))
            {
                JOptionPane.showMessageDialog(null,"pincode is required");

            }
            else if(education.equals(""))
            {
                JOptionPane.showMessageDialog(null,"pincode is required");

            }
            else
            {
                conn c1=new conn();
                String querys="insert into signupTwo values('"+sname+"','"+scategory+"','"+sedu+"','"+sincome+"','"+socuption+"','"+span+"','"+sAdhar+"','"+scitizen+"','"+exaccount+"','"+k+"')";
                c1.s.executeUpdate(querys);
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
      if(e.getSource()==b1)
      {
          new SignUpThree(newname).setVisible(true);
      }
    }
}
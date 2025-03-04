import java.awt.*;
import javax.swing.*;
// import java.util.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

    JTextField pannoTextField, aadharnoTextField;
    JButton next;
    JRadioButton yes1, yes2, no1, no2;
    JComboBox relig, categ, inc, edu, occ;
    String formno;
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);

        setTitle("New Account Application Form: Page 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);

        String valreligion[]={"Hindu", "Muslim", "Sikh", "Christian", "Others"};
        relig =new JComboBox(valreligion);
        relig.setBounds(300, 140, 400, 30);
        relig.setBackground(Color.white);
        add(relig);


        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);

        String valcategory[]={"General", "OBC", "SC", "ST", "Others"};
        categ =new JComboBox(valcategory);
        categ.setBounds(300, 190, 400, 30);
        categ.setBackground(Color.white);
        add(categ);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);

        String valincome[]={"Null", "Upto 1, 50, 000", "Upto 2, 50, 000", "Upto 5, 00, 000", "Upto 10, 00, 000"};
        inc =new JComboBox(valincome);
        inc.setBounds(300, 240, 400, 30);
        inc.setBackground(Color.white);
        add(inc);

        JLabel education = new JLabel("Educational:");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100, 290, 200, 30);
        add(education);

        JLabel  qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 315, 200, 30);
        add(qualification);

        String valedu[]={"Doctorate","Graduate", "Post Graduate", "High School", "Senior Secondary", "Others"};
        edu =new JComboBox(valedu);
        edu.setBounds(300, 315, 400, 30);
        edu.setBackground(Color.white);
        add(edu);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 365, 130, 30);
        add(occupation);

        String valocc[]={"Salaried", "Self Employed", "Business", "Student", "Fresher", "Retired", "Others"};
        occ =new JComboBox(valocc);
        occ.setBounds(300, 365, 400, 30);
        occ.setBackground(Color.white);
        add(occ);

        JLabel panno = new JLabel("Pan Number:");
        panno.setFont(new Font("Raleway", Font.BOLD, 20));
        panno.setBounds(100, 415, 150, 30);
        add(panno);

        pannoTextField= new JTextField();
        pannoTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pannoTextField.setBounds(300, 415, 400, 30);
        add(pannoTextField);


        JLabel aadharno = new JLabel("Aadhar Number:");
        aadharno.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharno.setBounds(100, 465, 200, 30);
        add(aadharno);

        aadharnoTextField= new JTextField();
        aadharnoTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharnoTextField.setBounds(300, 465, 400, 30);
        add(aadharnoTextField);

        JLabel sencitizen = new JLabel("Senior Citizen:");
        sencitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        sencitizen.setBounds(100, 515, 150, 30);
        add(sencitizen);

        yes1= new JRadioButton("Yes");
        yes1.setBounds(300, 515, 100, 30);
        yes1.setBackground(Color.white);
        add(yes1);

        no1= new JRadioButton("No");
        no1.setBounds(450, 515, 120, 30);
        no1.setBackground(Color.white);
        add(no1);

        ButtonGroup senGroup= new ButtonGroup();
        senGroup.add(yes1);
        senGroup.add(no1);

        JLabel accexist = new JLabel("Existing Account:");
        accexist.setFont(new Font("Raleway", Font.BOLD, 20));
        accexist.setBounds(100, 565, 200, 30);
        add(accexist);

        yes2= new JRadioButton("Yes");
        yes2.setBounds(300, 565, 100, 30);
        yes2.setBackground(Color.white);
        add(yes2);

        no2= new JRadioButton("No");
        no2.setBounds(450, 565, 120, 30);
        no2.setBackground(Color.white);
        add(no2);

        ButtonGroup accexistGroup= new ButtonGroup();
        accexistGroup.add(yes2);
        accexistGroup.add(no2);


        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 620, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        String religion= (String)relig.getSelectedItem();
        String category= (String)categ.getSelectedItem();
        String income= (String) inc.getSelectedItem();
        String education=(String) edu.getSelectedItem();
        String occupation=(String) occ.getSelectedItem();
        String sencitizen= null;
        if(yes1.isSelected()){
            sencitizen="Yes";
        }else if(no1.isSelected()){
            sencitizen="No";
        }

        String accexist= null;
        if(yes2.isSelected()){
            accexist="Yes";
        }else if(no2.isSelected()){
            accexist="No";
        }

        String panno= pannoTextField.getText();
        String aadharno = aadharnoTextField.getText();

        try {
            Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+education+"', '"+occupation+"', '"+panno+"', '"+aadharno+"', '"+accexist+"', '"+sencitizen+"')";
                c.s.executeUpdate(query);
                //Signup3 object
                setVisible(false);
                new SignupThree(formno).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();

        }


    }

    public static void main(String args[]) {
        new SignupTwo("");
    }
}

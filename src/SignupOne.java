import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{

    JTextField nameTextField, fnameTextField, cityTextField, stateTextField, pincodeTextField,
    emailTextField, addressTextField;
    JButton next;
    JRadioButton male, female, married, unmarried, other;
    JDateChooser dateChooser;
    long random;
    SignupOne(){
        setLayout(null);
        Random ran= new Random();
        random = Math.abs((ran.nextLong()% 9000L)+1000L);

        JLabel formno = new JLabel("Application form no. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel personDetails = new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setBounds(290, 80, 400, 30);
        add(personDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nameTextField= new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnameTextField= new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        // jcalender jar file is required for adding the calender to date

        dateChooser= new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(Color.black);
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 100, 30);
        add(gender);

        male= new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.white);
        add(male);

        female= new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup genderGroup= new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 100, 30);
        add(email);

        emailTextField= new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        JLabel maritalS = new JLabel("Marital Status:");
        maritalS.setFont(new Font("Raleway", Font.BOLD, 20));
        maritalS.setBounds(100, 390, 150, 30);
        add(maritalS);

        married= new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.white);
        add(married);

        unmarried= new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 120, 30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        other= new JRadioButton("Other");
        other.setBounds(630, 390, 100, 30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup maritalGroup= new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 100, 30);
        add(address);

        addressTextField= new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 100, 30);
        add(city);

        cityTextField= new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 100, 30);
        add(state);

        stateTextField= new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);

        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 100, 30);
        add(pincode);

        pincodeTextField= new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTextField.setBounds(300, 590, 400, 30);
        add(pincodeTextField);

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

        String formno= "" + random; //formno through random is originally a long but we can convert it to string like shown here
        String name= nameTextField.getText();
        String fname= fnameTextField.getText();
        String dob=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        //for dob we first go into editor and the the ui component to get the text. The date need to be concatenated to text using JTextField because getText only works on text
        String gender= null;
        if(male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender="Female";
        }
        String email= emailTextField.getText();

        String maritalS= null;
        if(married.isSelected()){
            maritalS="Married";
        }else if(unmarried.isSelected()){
            maritalS="Unmarried";
        }else if(other.isSelected()){
            maritalS="Other";
        }

        String address= addressTextField.getText();
        String city = cityTextField.getText();
        String state= stateTextField.getText();
        String pincode= pincodeTextField.getText();

        //using this because database is an external entity so exception handling is necessary
        try {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name field cannot be empty");
            } else if(fname.equals("")){
                JOptionPane.showMessageDialog(null, "Father's Name field cannot be empty");
            } else if(dob.equals("")){
                JOptionPane.showMessageDialog(null, "Date of Birth field cannot be empty");
            } else if(gender.equals("")){
                JOptionPane.showMessageDialog(null, "Gender field cannot be empty");
            } else if(email.equals("")){
                JOptionPane.showMessageDialog(null, "Email field cannot be empty");
            } else if(maritalS.equals("")){
                JOptionPane.showMessageDialog(null, "Marital Status field cannot be empty");
            } else if(address.equals("")){
                JOptionPane.showMessageDialog(null, "Address field cannot be empty");
            } else if(city.equals("")){
                JOptionPane.showMessageDialog(null, "City field cannot be empty");
            } else if(state.equals("")){
                JOptionPane.showMessageDialog(null, "State field cannot be empty");
            } else if(pincode.equals("")){
                JOptionPane.showMessageDialog(null, "Pincode field cannot be empty");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+maritalS+"', '"+address+"', '"+city+"', '"+state+"', '"+pincode+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new SignupOne();
    }
}

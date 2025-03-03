import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{

    JRadioButton savings, current, dfixed, drecurring;  
    JCheckBox atm, ib, mb, esa, cb, es, declaration;
    JButton submit, cancel;
    String formno;
    SignupThree(String formno){
        this.formno=formno;
        setLayout(null);

        JLabel l1= new JLabel("Page 3: Account Details ");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type= new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 120, 200, 30);
        add(type);

        savings=new JRadioButton("Savings Account");
        savings.setFont(new Font("Raleway", Font.BOLD, 16));
        savings.setBackground(Color.white);
        savings.setBounds(100, 160, 200, 20);
        add(savings);

        dfixed=new JRadioButton("Fixed Deposit Account");
        dfixed.setFont(new Font("Raleway", Font.BOLD, 16));
        dfixed.setBackground(Color.white);
        dfixed.setBounds(350, 160, 200, 20);
        add(dfixed);

        current=new JRadioButton("Current Account");
        current.setFont(new Font("Raleway", Font.BOLD, 16));
        current.setBackground(Color.white);
        current.setBounds(100, 200, 200, 20);
        add(current);

        drecurring=new JRadioButton("Recurring Deposit Account");
        drecurring.setFont(new Font("Raleway", Font.BOLD, 16));
        drecurring.setBackground(Color.white);
        drecurring.setBounds(350, 200, 400, 20);
        add(drecurring);

        ButtonGroup accountGroup= new ButtonGroup();
        accountGroup.add(savings);
        accountGroup.add(dfixed);
        accountGroup.add(current);
        accountGroup.add(drecurring);

        JLabel cardno= new JLabel("Card Number: ");
        cardno.setFont(new Font("Raleway", Font.BOLD, 22));
        cardno.setBounds(100, 250, 200, 30);
        add(cardno);

        JLabel cnum= new JLabel("XXXX-XXXX-XXXX-7865");
        cnum.setFont(new Font("Raleway", Font.BOLD, 22));
        cnum.setBounds(330, 250, 400, 30);
        add(cnum);

        JLabel numinfo= new JLabel("This is your 16 digit Card Number.");
        numinfo.setFont(new Font("Raleway", Font.BOLD, 12));
        numinfo.setBounds(100, 280, 300, 20);
        add(numinfo);

        JLabel pinno= new JLabel("PIN: ");
        pinno.setFont(new Font("Raleway", Font.BOLD, 22));
        pinno.setBounds(100, 320, 200, 30);
        add(pinno);

        JLabel pnum= new JLabel("XXXX");
        pnum.setFont(new Font("Raleway", Font.BOLD, 22));
        pnum.setBounds(330, 320, 100, 30);
        add(pnum);

        JLabel pininfo= new JLabel("This is your 4 digit Password.");
        pininfo.setFont(new Font("Raleway", Font.BOLD, 12));
        pininfo.setBounds(100, 350, 300, 20);
        add(pininfo);

        JLabel services= new JLabel("Services Required: ");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 400, 250, 30);
        add(services);

        atm= new JCheckBox("ATM Card");
        atm.setBackground(Color.white);
        atm.setFont(new Font("Raleway",Font.BOLD, 16));
        atm.setBounds(100, 450, 200, 30);
        add(atm);

        ib= new JCheckBox("Internet Banking");
        ib.setBackground(Color.white);
        ib.setFont(new Font("Raleway",Font.BOLD, 16 ));
        ib.setBounds(350, 450, 200, 30);
        add(ib);

        mb= new JCheckBox("Mobile Banking");
        mb.setBackground(Color.white);
        mb.setFont(new Font("Raleway",Font.BOLD, 16 ));
        mb.setBounds(100, 500, 200, 30);
        add(mb);

        esa= new JCheckBox("Email and SMS Alerts");
        esa.setBackground(Color.white);
        esa.setFont(new Font("Raleway",Font.BOLD, 16 ));
        esa.setBounds(350, 500, 200, 30);
        add(esa);

        cb= new JCheckBox("Checkbook");
        cb.setBackground(Color.white);
        cb.setFont(new Font("Raleway",Font.BOLD, 16 ));
        cb.setBounds(100, 550, 200, 30);
        add(cb);

        es= new JCheckBox("E-Statement");
        es.setBackground(Color.white);
        es.setFont(new Font("Raleway",Font.BOLD, 16 ));
        es.setBounds(350, 550, 200, 30);
        add(es);

        declaration= new JCheckBox("I here by declare that the above entered details are correct to the best of my ability.");
        declaration.setBackground(Color.white);
        declaration.setFont(new Font("Raleway",Font.BOLD, 12 ));
        declaration.setBounds(100, 600, 800, 30);
        add(declaration);

        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 630, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 630, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        

        getContentPane().setBackground(Color.white);
        setSize(850, 850);
        setLocation(350, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String declare= "";
            String accountType= "";
            if(savings.isSelected()){
                accountType="Savings Account";
            }else if(dfixed.isSelected()){
                accountType="Fixed Deposit Account";
            }else if(current.isSelected()){
                accountType="Current Account";
            }else if(drecurring.isSelected()){
                accountType="Recurring Deposit Account";
            }

            Random random= new Random();
            String cardnum=" "+ Math.abs((random.nextLong()%90000000L) + 504093360000000L);
            String pinnum=" "+ Math.abs((random.nextLong()%9000L) + 1000L);
            String facility="";
            if(atm.isSelected()){
                facility= facility + " ATM Card";
            }
            if(ib.isSelected()){
                facility= facility + " Internet Banking";
            }
            if(mb.isSelected()){
                facility= facility + " Mobile Banking";
            }
            if(esa.isSelected()){
                facility= facility + " Email and SMS Alerts";
            }
            if(cb.isSelected()){
                facility= facility + " Checkbook";
            }
            if(es.isSelected()){
                facility= facility + " E-Statement";
            }
            if(declaration.isSelected()){
                declare="yes";
            }

            try {
                if(accountType.equals("")){
                JOptionPane.showMessageDialog(null, "Account Type field cannot be empty");
            }
            else if( facility.equals("")){
                JOptionPane.showMessageDialog(null, "Atleast one service should be checked");
            } 
            else if( declare.equals("")){
                JOptionPane.showMessageDialog(null, "Please accept the declaration");
            }
            else {
                Conn conn= new Conn();
                String query1= "insert into signupthree values('"+formno+"', '"+accountType+"', '"+cardnum+"', '"+pinnum+"','"+facility+"')";
                conn.s.executeUpdate(query1);

                String query2= "insert into login values('"+formno+"', '"+cardnum+"', '"+pinnum+"')";
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Card Number: "+ cardnum+ "\nPin: " + pinnum);
            }
        }
            catch (Exception e) {
                System.out.println(ae);
            }

        }else if(ae.getSource()==cancel){

        }
    }

    public static void main(String args[]){
        new SignupThree(" ");
    }
    
}

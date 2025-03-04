import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{

    String pinnumber;
    JPasswordField pint, repint;
    JButton change, back;

    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text= new JLabel("Change Your PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);

        JLabel pintext= new JLabel("New PIN: ");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165, 320, 180, 25);
        image.add(pintext);

        pint= new JPasswordField();
        pint.setFont(new Font("Raleway", Font.BOLD, 25));
        pint.setBounds(330, 320, 180, 25);
        image.add(pint);

        JLabel repintext= new JLabel("Re-Enter new PIN: ");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165, 360, 180, 25);
        image.add(repintext);

        repint= new JPasswordField();
        repint.setFont(new Font("Raleway", Font.BOLD, 25));
        repint.setBounds(330, 360, 180, 25);
        image.add(repint);

        change = new JButton("Change");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(355, 485, 150, 30);
        back.addActionListener(this);
        image.add(back);


        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==change)
        {
            try {

            String npin= String.valueOf(pint.getPassword());
            String rpin=String.valueOf(repint.getPassword());

            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter new PIN");
                return;
            }
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
                return;
            }

            Conn conn=new Conn();
            String query1= "update bank set pin='"+rpin+"' where pin='"+pinnumber+"'";
            String query2= "update login set pin='"+rpin+"' where pin='"+pinnumber+"'";
            String query3= "update signupthree set pin='"+rpin+"' where pin='"+pinnumber+"'";

            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);

            JOptionPane.showMessageDialog(null,"PIN changed successfully");
            
            setVisible(false);
            new Transactions(rpin).setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }
    }else {
        setVisible(false);
            new Transactions(pinnumber).setVisible(true);
    }
    }
    public static void main(String args[]) {
        new PinChange(""); 
        // new PinChange("").setVisible(true);
        
    }
}

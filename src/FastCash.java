import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{

    JButton oneh, fiveh, onek, twok, fivek, tenk, back;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Select withdrawl amount");
        text.setBounds(225, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        oneh= new JButton("Rs. 100");
        oneh.setBounds(170, 415, 150, 30);
        oneh.addActionListener(this);
        image.add(oneh);

        fiveh= new JButton("Rs. 500");
        fiveh.setBounds(355, 415, 150, 30);
        fiveh.addActionListener(this);
        image.add(fiveh);

        onek= new JButton("Rs. 1000");
        onek.setBounds(170, 450, 150, 30);
        onek.addActionListener(this);
        image.add(onek);

        twok= new JButton("Rs. 2000");
        twok.setBounds(355, 450, 150, 30);
        twok.addActionListener(this);
        image.add(twok);

        fivek= new JButton("Rs. 5000");
        fivek.setBounds(170, 485, 150, 30);
        fivek.addActionListener(this);
        fivek.add(fivek);

        tenk= new JButton("Rs. 10000");
        tenk.setBounds(355, 485, 150, 30);
        tenk.addActionListener(this);
        image.add(tenk);

        back= new JButton("Back");
        back.setBounds(170, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else{
            //.substring helps us remove the staring rs fromm the amount so that subtraction can take place
            String amount= ((JButton) ae.getSource()).getText().substring(3);
            // Conn conn= new Conn();
            try {
                Conn conn= new Conn();
                ResultSet rs = conn.s.executeQuery("selcet * from bank where pin ='"+pinnumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString(amount));
                    } else {
                        balance -= Integer.parseInt(rs.getString(amount));
                    }
                }
                if(ae.getSource()!= back && balance< Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date= new Date();
                String query= "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdraw', '"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" debited succesfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main (String args[]){
        new FastCash("");
    }
}

import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame{

    String pinnumber;
    MiniStatement(String pinnumber){
        this.pinnumber=pinnumber;

        setTitle("Mini Statement");
        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);

        JLabel bank= new JLabel("India Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card= new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel balance= new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);

        try {
            Conn conn= new Conn();
            ResultSet rs= conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+ rs.getString("cardnumber").substring(0, 4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }


        try {
            Conn conn= new Conn();
            int bal=0;
            ResultSet rs= conn.s.executeQuery("select * fro bank where pin ='"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText()+ "<html>"+ rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount")+"<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                        bal += Integer.parseInt(rs.getString("amount"));
                    } else {
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }
            }
            balance.setText("Your current account balance is Rs. "+ bal);
        } catch (Exception e) {
            System.out.println(e);
        }


        getContentPane().setBackground(Color.white);
        setSize(400, 600);
        setLocation(20, 20);
        setVisible(true);

    }

    public static void main(String args[]) {

        new MiniStatement("");
        
    }
    
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    // ActionListener has an abstact class defined which you can see when you 'shift+click' it. That has to be overridden to use it in the class.

    JButton signin, signup, clear; // need to be defined globally so that can be accessed to add event to the buttons
    JTextField cardTextField;
    JPasswordField pinTextField;
    //constructor
    Login(){
        setLayout(null); // Needs to be null to implement custom layout
        setTitle("Automated Teller Machine");
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2= i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); //IMage object needs to be converted into image Icon before adding it to the frame.
        ImageIcon i3= new ImageIcon(i2);
        JLabel label = new JLabel(i3); // Jlabel is used to add any type of components to the frame.
        label.setBounds(70, 10, 100, 100); //used to layout any label
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font ("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card No.:");
        cardno.setFont(new Font ("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 100, 150, 40);
        add(cardno);

        cardTextField = new JTextField(); // to add textfield
        cardTextField.setBounds(300, 105, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font ("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 160, 150, 40);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 165, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        signin = new JButton("Sign In"); // to add button
        signin.setBounds(300, 300, 100, 30);
        signin.setBackground(Color.black);
        signin.setForeground(Color.white);
        signin.addActionListener(this);
        add(signin);

        
        clear = new JButton("Clear");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Sign Up");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.white);  //getcontentpane() is used to select the whole frame
        setSize(800, 480); //dimensions of the frame.
        setVisible(true); //without this the frame woild not show
        setLocation(350, 200); //location of the frame
    }

    public void actionPerformed(ActionEvent ae){
        // getSource method is used to identify the source of click. 
        // ae is the event
        if (ae.getSource()== clear){
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource()==signin){

        }else if (ae.getSource()==signup){
            setVisible(false);
            new SignupOne().setVisible(true); 

        }

    }
    public static void main(String args[]) {
        new Login(); //object
    }
}

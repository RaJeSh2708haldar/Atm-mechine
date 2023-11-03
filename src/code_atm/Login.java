package code_atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    

    Login (){

        setTitle("ATM_machine");

        setLayout(null);

        // display coming to image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));   //imageIcon --->jlabel
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);     // not Image---->jlabel
        JLabel label=new JLabel(i3);
        label.setBounds(140,15,100,100);
        add(label);



        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,40));
        text.setBounds(250,40,400,40);
        text.setBackground(Color.WHITE);
        text.setForeground(Color.BLACK);
        add(text);

        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,35));
        cardno.setBounds(120,150,150,30);
        cardno.setBackground(Color.WHITE);
        cardno.setForeground(Color.BLACK);
        add(cardno);

        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN No:");
        pin.setFont(new Font("Raleway",Font.BOLD,35));
        pin.setBounds(120,220,250,30);
        pin.setBackground(Color.WHITE);
        pin.setForeground(Color.BLACK);
        add(pin);

        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        //Button
        login=new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.CYAN);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        add(login);

        clear=new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.CYAN);
        clear.setForeground(Color.BLACK);
        clear.addActionListener(this);
        add(clear);

        signup=new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.CYAN);
        signup.setForeground(Color.BLACK);
        signup.addActionListener(this);
        add(signup);




        getContentPane().setBackground(Color.WHITE);

        // show on display

        setSize(800,480);   //page size
        setVisible(true);
        setLocation(350,200);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");

        } else if (ae.getSource()==login) {
           Conn c=new Conn();
           String cardnumber=cardTextField.getText();
           String pinnumber=pinTextField.getText();
           String query="SELECT * FROM login WHERE cardnumber = '"+cardnumber+"' and pin ='"+pinnumber+"'";
           try{
              ResultSet rs= c.s.executeQuery(query);
              if(rs.next()){
                  setVisible(false);
                  new Transactions(pinnumber).setVisible(true);
              }else{
                  JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
              }
           }catch (Exception e){
               System.out.println(e);
           }

        } else if (ae.getSource()==signup) {
            setVisible(false);
            new SignupOne().setVisible(true);

        }
    }
    public static void main(String[] args) {

        new Login();

    }
}

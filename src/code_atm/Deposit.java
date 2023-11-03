package code_atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JTextField amount;
    JButton deposit,back;
    String pinnumber;

    Deposit(String pinnumber){
        this.pinnumber=pinnumber;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atmmachine.jpg.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Enter the amount you want to deposit");
        text.setBounds(245,320,670,35);
        text.setBackground(Color.BLUE);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("System",Font.BOLD,14));
        image.add(text);  //pic visible

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBackground(Color.LIGHT_GRAY);
        amount.setBounds(245,370,250,30);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(380,460,130,25);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(380,500,130,25);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);  //web bar no
        setVisible(true);

    }

    public void actionPerformed (ActionEvent ae){
        if (ae.getSource()==deposit){
            String number=amount.getText();
            Date d=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
            }else{
                try {
                    Conn c = new Conn();
                    String query = "INSERT INTO bank VALUES ('"+ pinnumber + "', '" + d + "', 'Deposit','" + number + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs: "+number+" Deposited successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        } else if (ae.getSource()==back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }
}

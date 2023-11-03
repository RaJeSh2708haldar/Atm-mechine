package code_atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton Ddeposit,withdraw,fastcash,minisatatement,pinchange,balance,exit;
    String pinnumber;

    Transactions(String pinnumber){
        this.pinnumber=pinnumber;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atmmachine.jpg.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(260,320,670,35);
        text.setBackground(Color.BLACK);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);  //pic visible

        Ddeposit =new JButton("Deposit");
        Ddeposit.setBounds(235,380,130,25);
        Ddeposit.addActionListener(this);
        image.add(Ddeposit);

        withdraw =new JButton("Withdrawal");
        withdraw.setBounds(390,380,130,25);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcash =new JButton("Fast Cash");
        fastcash.setBounds(235,420,130,25);
        fastcash.addActionListener(this);
        image.add(fastcash);

        minisatatement =new JButton("Mini Statement");
        minisatatement.setBounds(390,420,130,25);
        minisatatement.addActionListener(this);
        image.add(minisatatement);

        pinchange =new JButton("Pin Change");
        pinchange.setBounds(235,460,130,25);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balance =new JButton("Balance Enquiry");
        balance.setBounds(390,460,130,25);
        balance.addActionListener(this);
        image.add(balance);

        exit =new JButton("Exit");
        exit.setBounds(235,500,130,25);
        exit.addActionListener(this);
        image.add(exit);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);  //web bar no
        setVisible(true);

    }

    public void actionPerformed (ActionEvent ae) {
        if(ae.getSource() == exit){
            System.exit(0);
        } else if (ae.getSource()==Ddeposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource()==withdraw) {
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        } else if (ae.getSource()==fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource()==balance) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if (ae.getSource()==minisatatement) {
            new MiniStatement(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transactions("");
    }

}

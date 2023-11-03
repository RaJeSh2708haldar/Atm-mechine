package code_atm;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;

    SignupThree(String formno){
        this.formno=formno;

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");

        JLabel accountDetails=new JLabel("Page 3: Account Details");
        accountDetails.setFont(new Font("Raleway",Font.BOLD,22));
        accountDetails.setBounds(280,40,400,40);
        add(accountDetails);

        JLabel accounttype=new JLabel("Account Type");
        accounttype.setFont(new Font("Raleway",Font.BOLD,22));
        accounttype.setBounds(100,140,200,30);
        add(accounttype);

        r1 =new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(100,180,150,20);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2 =new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(350,180,250,20);
        r2.setBackground(Color.WHITE);
        add(r2);

        r3 =new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(100,220,250,20);
        r3.setBackground(Color.WHITE);
        add(r3);

        r4 =new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(350,220,250,20);
        r4.setBackground(Color.WHITE);
        add(r4);

        ButtonGroup accountgroup=new ButtonGroup();
        accountgroup.add(r1);
        accountgroup.add(r2);
        accountgroup.add(r3);
        accountgroup.add(r4);

        JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);

        JLabel number=new JLabel("XXXX-XXXX-XXXX-4352");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);

        JLabel carddetails=new JLabel("Your 16 Digit Card Number");
        carddetails.setFont(new Font("Raleway",Font.BOLD,12));
        carddetails.setBounds(100,330,300,20);
        add(carddetails);

        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);

        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,370,300,30);
        add(pnumber);

        JLabel pindetail=new JLabel("Your 4 Digit Password");
        pindetail.setFont(new Font("Raleway",Font.BOLD,12));
        pindetail.setBounds(100,400,300,20);
        add(pindetail);

        JLabel srequired=new JLabel("Services Required:");
        srequired.setFont(new Font("Raleway",Font.BOLD,22));
        srequired.setBounds(100,450,400,30);
        add(srequired);

        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);

        c4=new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);

        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);

        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);

        c7=new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,650,600,30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);


        getContentPane().setBackground(Color.WHITE);

        setSize(850,820);
        setLocation(350,0);
        setVisible(true);

    }

    public void actionPerformed (ActionEvent ea) {
        if(ea.getSource()== submit) {
            String accounttype=null;
            if(r1.isSelected()){
                accounttype="Saving Account";
            }else if(r2.isSelected()){
                accounttype="Fixed Deposit Account";
            }else if(r3.isSelected()){
                accounttype="Current Account";
            }else if(r4.isSelected()){
                accounttype="Recurring Deposit Account";
            }

            Random random=new Random();
            String cardnumber= "" + Math.abs((random.nextLong() % 90000000L) + 5089789000000000L);
            String pinnumber= "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String services ="";
            if(c1.isSelected()){
                services=services+"ATM CARD";
            } else if (c2.isSelected()) {
                services= services+"Internet Banking";
            }else if(c3.isSelected()){
                services=services+"Mobile Banking";
            } else if (c4.isSelected()) {
                services=services+"Email & SMS Alerts";
            } else if (c5.isSelected()) {
                services=services+"Cheque Book";
            } else if (c6.isSelected()) {
                services=services+"E-Statement";
            }

            try{
                if(accounttype.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type in Required");
                } else {
                    Conn c=new Conn();
                    String query1 = "INSERT INTO signupthree VALUES('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+services+"')";
                    String query2 = "INSERT INTO login VALUES('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"Card Number: "+cardnumber+"\n Pin: "+pinnumber);
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
            }catch (Exception e) {
                System.out.println(e);
            }

        } else if(ea.getSource()== cancel){
            setVisible(false);
            new Login().setVisible(true);

        }

    }
    public static void main(String[] args) {
        new SignupThree("");
    }
}

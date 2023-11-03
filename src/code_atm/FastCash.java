package code_atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton rs1,rs2,rs3,rs4,rs5,rs6,exit;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atmmachine.jpg.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Select Withdrawal Amount");
        text.setBounds(270,320,670,35);
        text.setBackground(Color.BLACK);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);  //pic visible

        rs1 =new JButton("Rs 100");
        rs1.setBounds(235,380,130,25);
        rs1.addActionListener(this);
        image.add(rs1);

        rs2 =new JButton("Rs 500");
        rs2.setBounds(390,380,130,25);
        rs2.addActionListener(this);
        image.add(rs2);

        rs3 =new JButton("Rs 1000");
        rs3.setBounds(235,420,130,25);
        rs3.addActionListener(this);
        image.add(rs3);

        rs4 =new JButton("Rs 2000");
        rs4.setBounds(390,420,130,25);
        rs4.addActionListener(this);
        image.add(rs4);

        rs5 =new JButton("Rs 5000");
        rs5.setBounds(235,460,130,25);
        rs5.addActionListener(this);
        image.add(rs5);

        rs6 =new JButton("Rs 10000");
        rs6.setBounds(390,460,130,25);
        rs6.addActionListener(this);
        image.add(rs6);

        exit =new JButton("Back");
        exit.setBounds(235,500,130,25);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);  //web bar no
        setVisible(true);
    }
    public void actionPerformed (ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount =((JButton)ae.getSource()).getText().substring(3);  // Rs 500
            Conn c= new Conn();
            try{
                ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin ='"+pinnumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date d = new Date();
                String query= "INSERT INTO bank VALUES ('"+pinnumber+"','"+d+"','Withdrawal','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Withdrawal Successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            } catch (Exception e){
                System.out.println(e);
            }
        }

    }

    public static void main(String[] args) {

        new FastCash("");
    }
}

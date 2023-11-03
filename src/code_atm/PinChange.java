package code_atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pin,textpin;
    JButton change,back;
    String pinnumber;
    PinChange(String pinnumber){

        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atmmachine.jpg.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System",Font.BOLD, 16));
        text.setBounds(300,330,500,35);
        image.add(text);

        JLabel newpin=new JLabel("Enter New PIN:");
        newpin.setForeground(Color.BLACK);
        newpin.setFont(new Font("System",Font.BOLD, 14));
        newpin.setBounds(240,370,130,25);
        image.add(newpin);

        pin =new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(380,370,130,25);
        image.add(pin);

        JLabel repin=new JLabel("Re-Enter New PIN:");
        repin.setForeground(Color.BLACK);
        repin.setFont(new Font("System",Font.BOLD, 14));
        repin.setBounds(240,400,130,25);
        image.add(repin);

        textpin =new JPasswordField();
        textpin.setFont(new Font("Raleway",Font.BOLD,25));
        textpin.setBounds(380,400,130,25);
        image.add(textpin);

        change = new JButton("CHANGE");
        change.setBounds(380,460,130,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(380,500,130,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);  //web bar no
        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae) {
       if(ae.getSource() == change) {
           try {
               String npin = pin.getText();
               String rpin = textpin.getText();

               if (!npin.equals(rpin)) {
                   JOptionPane.showMessageDialog(null, "Entered pin does not match");
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

               Conn c = new Conn();
               String query1="UPDATE bank SET pin ='"+rpin+"' WHERE pin='"+pinnumber+"'";
               String query2="UPDATE login SET pin ='"+rpin+"' WHERE pin='"+pinnumber+"'";
               String query3="UPDATE signupthree SET pin ='"+rpin+"' WHERE pin='"+pinnumber+"'";

               c.s.executeUpdate(query1);
               c.s.executeUpdate(query2);
               c.s.executeUpdate(query3);

               JOptionPane.showMessageDialog(null,"PIN changed Successfully");

               setVisible(false);
               new Transactions(rpin).setVisible(true);


           } catch (Exception e) {
               System.out.println(e);
           }

       } else {
           setVisible(false);
           new Transactions(pinnumber).setVisible(true);
       }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}

package code_atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupTwo extends JFrame implements ActionListener  {

    JButton next;
    JTextField pan,aadh;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,jcategory,occupa,education,kincome;
    String formno;

    SignupTwo(String formno){

        this.formno=formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails=new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(300,80,400,30);
        add(additionalDetails);

        JLabel Religion=new JLabel("Religion:");
        Religion.setFont(new Font("Raleway",Font.BOLD,20));
        Religion.setBounds(100,140,100,30);
        add(Religion);

        String jr[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion= new JComboBox(jr);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel category =new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);

        String cat[] = {"General","OBC","SC","ST","Other"};
        jcategory= new JComboBox(cat);
        jcategory.setBounds(300,190,400,30);
        jcategory.setBackground(Color.WHITE);
        add(jcategory);

        JLabel income =new JLabel("AnnualIncome:");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);

        String inc[] = {"Null","< 150000","< 250000","< 500000","upto 1000000"};
        kincome= new JComboBox(inc);
        kincome.setBounds(300,240,400,30);
        kincome.setBackground(Color.WHITE);
        add(kincome);

        JLabel EducationalQualification =new JLabel("Qualification:");
        EducationalQualification.setFont(new Font("Raleway",Font.BOLD,20));
        EducationalQualification.setBounds(100,290,200,30);
        add(EducationalQualification);

        String eduQ[] = {"Non-Graduation","Graduation","Post Graduation","Doctorate","Other"};
        education= new JComboBox(eduQ);
        education.setBounds(300,290,400,30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel occupation =new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,340,200,30);
        add(occupation);

        String occ[] = {"Salaried","Self-Employed","BussinessMan","Student","Retired","Others"};
        occupa= new JComboBox(occ);
        occupa.setBounds(300,340,400,30);
        occupa.setBackground(Color.WHITE);
        add(occupa);

        JLabel panno =new JLabel("PAN Number:");
        panno.setFont(new Font("Raleway",Font.BOLD,20));
        panno.setBounds(100,390,200,30);
        add(panno);

        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,390,400,30);
        add(pan);

        JLabel aadhar =new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(100,440,200,30);
        add(aadhar);

        aadh = new JTextField();
        aadh.setFont(new Font("Raleway",Font.BOLD,14));
        aadh.setBounds(300,440,400,30);
        add(aadh);

        JLabel sg =new JLabel("Senior Citizen:");
        sg.setFont(new Font("Raleway",Font.BOLD,20));
        sg.setBounds(100,490,200,30);
        add(sg);

        syes =new JRadioButton("YES");
        syes.setBounds(300,490,60,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno=new JRadioButton("NO");
        sno.setBounds(450,490,120,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup sggroup=new ButtonGroup();
        sggroup.add(syes);
        sggroup.add(sno);

        JLabel ea =new JLabel("Existing Account:");
        ea.setFont(new Font("Raleway",Font.BOLD,20));
        ea.setBounds(100,540,200,30);
        add(ea);

        eyes =new JRadioButton("YES");
        eyes.setBounds(300,540,60,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno=new JRadioButton("NO");
        eno.setBounds(450,540,120,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup eagroup=new ButtonGroup();
        eagroup.add(eyes);
        eagroup.add(eno);


        next= new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae)  {

        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)jcategory.getSelectedItem();
        String sincome=(String)kincome.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupa.getSelectedItem();

        String span=pan.getText();
        String saadhar=aadh.getText();

        String scitigen=null;
        if(syes.isSelected()){
            scitigen="Yes";
        }else if(sno.isSelected()){
            scitigen="No";
        }
        String existac=null;
        if(eyes.isSelected()){
            existac="Yes";
        }else if(eno.isSelected()){
            existac="No";
        }

        try{
                Conn c=new Conn();
                String query="INSERT INTO signuptwo VALUES ('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"', '"+scitigen+"','"+existac+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupThree(formno).setVisible(true);
        }catch (Exception e){
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        new SignupTwo("");
    }
}

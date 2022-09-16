import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class practdb extends JFrame implements ActionListener{
    JTextField t1;
    JButton b1;
    JLabel s1,s2;
    JComboBox j1;
    practdb(){
        s1=new JLabel("shashidhar");
        // s1.setBounds(600,100,120,60);
        setLayout(null);
        s1.setBounds(140,20,600,40);
        add(s1);
        s2=new JLabel("NAME");
        // s1.setBounds(600,100,120,60);
        // setLayout(null);
        s2.setBounds(40,80,400,40);
        add(s2);

        t1=new JTextField();
        t1.setBounds(100,80,300,40);
        add(t1);

        b1=new JButton("Next");
        b1.setBounds(300,190,120,30);
        b1.setFont(new Font("Raleway",Font.BOLD,28));
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        add(b1);
        b1.addActionListener(this);

        String branch[]={"CSE","ISE","EC","EEE"};
        j1=new JComboBox<>(branch);
        j1.setBackground(Color.WHITE);
        j1.setBounds(100, 140, 200, 40);
        add(j1);


        getContentPane().setBackground(Color.WHITE);
        setSize(500,800);
        setLocation(500,120);
        setVisible(true);

    }

        public void actionPerformed(ActionEvent ae){
            String name=t1.getText();
            String branc = (String)j1.getSelectedItem();
        try{
           
            if(t1.getText().equals("")||branc.equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{
                Conn c1 = new Conn();
                String q1 = "insert into name values('"+name+"','"+branc+"')";
                c1.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Your details has been saved successfully");
                
                // new Signup2(first).setVisible(true);
                // setVisible(false);

                Conn c2=new Conn();
                String q2="select *from name where name='"+name+"' and branch ='"+branc+"'";
                
                    ResultSet rs = c1.s.executeQuery(q2);
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null, "Your details are present and already saved");
                        setVisible(false);
                        new Login().setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "Your details are present and already saved");
                    }
                }
            }
        catch(Exception e){
            e.printStackTrace();
       }
    }

    
   public static void main(String[] args) {
    new practdb().setVisible(true);;
   } 
}



// import java.awt.*;
// import java.awt.event.*;
// import javax.swing.*;
// import java.sql.*;
// import java.util.*;

// public class practdb extends JFrame implements ActionListener{
    
//     JLabel l1,l2;
//     JTextField t1;
//     JButton b;
    
//     practdb(){
        
//         setTitle("NEW ACCOUNT APPLICATION FORM");
        
//         l1 = new JLabel("Page 1: Personal Details");
//         l1.setFont(new Font("Raleway", Font.BOLD, 22));
        
//         l2 = new JLabel("Name:");
//         l2.setFont(new Font("Raleway", Font.BOLD, 20));
        
        
//         t1 = new JTextField();
//         t1.setFont(new Font("Raleway", Font.BOLD, 14));
              
//         b = new JButton("Next");
//         b.setFont(new Font("Raleway", Font.BOLD, 14));
//         b.setBackground(Color.BLACK);
//         b.setForeground(Color.WHITE);
        
//         setLayout(null);
//         l1.setBounds(140,20,600,40);
//         add(l1);
        
//         l2.setBounds(90,80,300,30);
//         add(l2);
        
//         t1.setBounds(330,80,400,30);
//         add(t1);
       
//         b.setBounds(420,140,80,30);
//         add(b);
        
//         b.addActionListener(this); 
        
//         getContentPane().setBackground(Color.WHITE);
        
//         setSize(850,800);
//         setLocation(500,120);
//         setVisible(true);
//     }
    
//     public void actionPerformed(ActionEvent ae){
        
//         String name = t1.getText();
//         try{
           
//             if(t1.getText().equals("")){
//                 JOptionPane.showMessageDialog(null, "Fill all the required fields");
//             }else{
//                 Conn c1 = new Conn();
//                 String q1 = "insert into name values('"+name+"')";
//                 c1.s.executeUpdate(q1);
                
//                 // new Signup2(first).setVisible(true);
//                 setVisible(false);
//             }
            
//         }catch(Exception e){
//              e.printStackTrace();
//         }
        
//     }
      
//     public static void main(String[] args){
//         new practdb().setVisible(true);
//     }
// }


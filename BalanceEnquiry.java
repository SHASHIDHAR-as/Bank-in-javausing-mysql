
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{

    JLabel l1;
    JButton b1;
    String pin;
    BalanceEnquiry(String pin){
        setLayout(null);
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ICONS/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000 , 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 1000, 800);
        add(l2);
        
        l1 = new JLabel("");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(235,290,700,35);
        l2.add(l1);

        int balance = 0;
        try{
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while (rs.next()) {
                if (rs.getString("Type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){}
        
        l1.setText("Your Current Account Balance is Rs "+balance);
        
        b1 = new JButton("BACK");
        b1.addActionListener(this);
        b1.setBounds(390,390,150,20);
        l2.add(b1);
    
        setSize(1000,1080);
        setLocation(20,0);
        setUndecorated(true);
        setVisible(true);
            
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){ 
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
        
    }
    
    public static void main(String[] args){
        new BalanceEnquiry("").setVisible(true);
    }
}
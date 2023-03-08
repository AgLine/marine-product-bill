package main;
/*
 * gui:¹ÚÁöÇö
 * actionPerformed:±èÀº¼±
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class PWsearch_J extends JFrame implements ActionListener{

   private JPanel contentPane;
   String name,phonenum,id;
   ArrayList<String> namee = new ArrayList<>();
   ArrayList<String> phone = new ArrayList<>();
   ArrayList<String> iid = new ArrayList<>();

   
   public PWsearch_J() {
      setForeground(new Color(255, 255, 255));
      setBackground(new Color(255, 0, 0));
      setTitle("PWÃ£±â");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 800, 600);
      setResizable(false);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(224, 255, 255));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      
      JLabel lblNewLabel = new JLabel("PWÃ£±â");
      lblNewLabel.setBounds(300, 25, 199, 67);
      lblNewLabel.setFont(new Font("ÇÑÄÄ °íµñ", Font.BOLD, 45));
      
      JButton btnNewButton_6 = new JButton("");
      btnNewButton_6.setBounds(50, 50, 80, 60);
      btnNewButton_6.setFocusPainted(false);
      btnNewButton_6.setBorderPainted(false);
      contentPane.add(btnNewButton_6);
      ImageIcon img2 = new ImageIcon("img2/arrow.PNG");
      btnNewButton_6.setIcon(img2);
      btnNewButton_6.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
             login_J join = new login_J();
             join.setVisible(true);
          }
       });

      
      JLabel lblNewLabel_1 = new JLabel("ÀÌ¸§");
      lblNewLabel_1.setBounds(187, 170, 70, 54);
      lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 33));

      
      JTextField textField = new JTextField();
      textField.setFont(new Font("ÇÑÄÄ °íµñ", Font.PLAIN, 30));
      textField.setBounds(299, 179, 208, 52);
      textField.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
        	  name=e.getActionCommand();
           }
        });
      textField.setColumns(10);
      
      JLabel lblNewLabel_2 = new JLabel("ID");
      lblNewLabel_2.setBounds(187, 258, 52, 37);
      lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 33));
      
      JTextField textField_1 = new JTextField();
      textField_1.setFont(new Font("ÇÑÄÄ °íµñ", Font.PLAIN, 30));
      textField_1.setBounds(299, 260, 208, 49);
      textField_1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
        	  id=e.getActionCommand();
          }
       });
      textField_1.setColumns(10);
      
      JLabel lblNewLabel_3 = new JLabel("ÈÞ´ëÆù");
      lblNewLabel_3.setBounds(159, 341, 100, 41);
      lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 33));
      
      JTextField textField_2 = new JTextField();
      textField_2.setFont(new Font("ÇÑÄÄ °íµñ", Font.PLAIN, 30));
      textField_2.setBounds(299, 341, 208, 51);
      textField_2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
        	  phonenum=e.getActionCommand();
          }
       });
      textField_2.setColumns(10);
      
     
      contentPane.setLayout(null);
      contentPane.add(lblNewLabel);
      contentPane.add(lblNewLabel_1);
      contentPane.add(textField);
      contentPane.add(lblNewLabel_2);
      contentPane.add(textField_1);
      contentPane.add(lblNewLabel_3);
      contentPane.add(textField_2);
      
      JButton btnNewButton = new JButton("search");
      btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 30));
      btnNewButton.setBounds(296, 445, 145, 52);
      btnNewButton.addActionListener(this);
      btnNewButton.setFocusPainted(false);
      contentPane.add(btnNewButton);
   }
   @Override
	 public void actionPerformed(ActionEvent e) {
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   ResultSet rs=null;
	   try {
		   String user = "pbl"; 
           String pw = "pbl";
           String url = "jdbc:oracle:thin:@localhost:1521:orcl";
           
           Class.forName("oracle.jdbc.driver.OracleDriver");        
           conn = DriverManager.getConnection(url, user, pw);
           
           System.out.println("Database¿¡ ¿¬°áµÇ¾ú½À´Ï´Ù.\n");
           
           
           String sql="SELECT * FROM CUSTOMER";
           stmt=conn.prepareStatement(sql);
           rs=stmt.executeQuery();
           while(rs.next()) {
        	   namee.add(rs.getString("NAME"));
        	   phone.add(rs.getString("PHONE"));
        	   iid.add(rs.getString("CUSTID"));
           }      
	   }catch(Exception ee) {
		   
	   }
	   String textButton =  e.getActionCommand();
	   if(textButton.equals("search")) {
		   for(int i=0;i<namee.size();i++) {
			   if(name.equals(namee.get(i))&&phonenum.equals(phone.get(i))&&id.equals(iid.get(i))) {
				   checkPW_J join = new checkPW_J(id);
				   join.setVisible(true);
				   dispose();
			   }
		   }
	   }
   }
}
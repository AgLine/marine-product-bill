package main;
/*
 * gui:¼ÛÀ¯ºó
 * actionPerformed,db:±èÀº¼±
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Window.Type;
import javax.swing.ImageIcon;

//È¸¿øÁ¤º¸ º¯°æÇÒ ¼ö ÀÖ´Â Ã¢
@SuppressWarnings({ "unused", "serial" })
public class membercheck extends JFrame implements ActionListener{

   private JPanel contentPane;
   private JPasswordField passwordField;
   static String id;
   String name,pww="",email,address,phone; 
   
   public membercheck(String id) {
	   this.id = id;
      setTitle("È¸¿ø°ü¸®");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1300, 800);
      setResizable(false);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(224, 255, 255));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel label = new JLabel("È¸¿øÁ¤º¸ ¼öÁ¤");
      label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 45));
      label.setBounds(24, 0, 311, 119);
      contentPane.add(label);
      
      JButton btnNewButton = new JButton("");
      btnNewButton.setFocusPainted(false);
      btnNewButton.setBorderPainted(false);
	  ImageIcon img5 = new ImageIcon("img5/home.PNG");
	  btnNewButton.setIcon(img5);
      btnNewButton.setBounds(43, 650, 100, 80);
      btnNewButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
             A1_marineMember join = new A1_marineMember(id);
             join.setVisible(true);
             dispose();
          }
       });
      contentPane.add(btnNewButton);
      

      
      
      JButton btnNewButton1 = new JButton("È®ÀÎ");
      btnNewButton1.setFont(new Font("ÇÑÄÄ °íµñ", Font.BOLD, 40));
      btnNewButton1.setBounds(543, 598, 187, 66);
      btnNewButton1.addActionListener(this);
      btnNewButton1.setFocusPainted(false);
      contentPane.add(btnNewButton1);
      
      JLabel lbname = new JLabel("ÀÌ¸§");
      lbname.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 33));
      lbname.setBounds(158, 193, 97, 66);
      contentPane.add(lbname);
      
      JLabel lblId = new JLabel("ID");
      lblId.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 33));
      lblId.setBounds(158, 312, 108, 66);
      contentPane.add(lblId);

      JLabel lblPassward = new JLabel("PW");
      lblPassward.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 33));
      lblPassward.setBounds(158, 440, 97, 44);
      contentPane.add(lblPassward);

      JLabel lbemail = new JLabel("ÀÌ¸ÞÀÏ");
      lbemail.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 33));
      lbemail.setBounds(704, 201, 108, 51);
      contentPane.add(lbemail);

      JLabel lbadress = new JLabel("ÁÖ¼Ò");
      lbadress.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 33));
      lbadress.setBounds(720, 308, 82, 74);
      contentPane.add(lbadress);
      
      JLabel lbphone = new JLabel("ÈÞ´ëÆù");
      lbphone.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 33));
      lbphone.setBounds(710, 436, 130, 53);
      contentPane.add(lbphone);
      
      JTextField textField = new JTextField();
      textField.setBounds(260, 202, 200, 51);
      textField.setFont(new Font("ÇÑÄÄ °íµñ", Font.PLAIN, 30));
      contentPane.add(textField);
      textField.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              name=e.getActionCommand();
           }
        });
      textField.setColumns(10);
      
      passwordField = new JPasswordField();
      passwordField.setFont(new Font("ÇÑÄÄ °íµñ", Font.BOLD, 25));
      passwordField.setBounds(260, 440, 200, 51);
      passwordField.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			e.getActionCommand();
    		}
    	});
      contentPane.add(passwordField);
      
      JTextField textField_1 = new JTextField();
      textField_1.setFont(new Font("ÇÑÄÄ °íµñ", Font.PLAIN, 30));
      textField_1.setColumns(10);
      textField_1.setBounds(840, 202, 326, 51);
      textField_1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              email=e.getActionCommand();
           }
        });
      contentPane.add(textField_1);
      
      JTextField textField_2 = new JTextField();
      textField_2.setFont(new Font("ÇÑÄÄ °íµñ", Font.PLAIN, 30));
      textField_2.setColumns(10);
      textField_2.setBounds(840, 323, 326, 51);
      textField_2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              address=e.getActionCommand();
           }
        });
      contentPane.add(textField_2);
      
      JTextField textField_3 = new JTextField();
      textField_3.setFont(new Font("ÇÑÄÄ °íµñ", Font.PLAIN, 30));
      textField_3.setColumns(10);
      textField_3.setBounds(840, 440, 326, 51);
      textField_3.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              phone=e.getActionCommand();
           }
        });
      contentPane.add(textField_3);
      
      JLabel lblNewLabel = new JLabel(id);
      lblNewLabel.setFont(new Font("ÇÑÄÄ °íµñ", Font.PLAIN, 30));
      lblNewLabel.setBounds(260, 323, 200, 51);
      contentPane.add(lblNewLabel);
      
   }
   @Override
	public void actionPerformed(ActionEvent e) {
	   String textButton = e.getActionCommand();
	   if(textButton.equals("È®ÀÎ")) {
		   char []aaa = passwordField.getPassword();
		   for(int i=0;i<aaa.length;i++){
		    	  pww+=aaa[i];
		      }
		   db();
		   A1_marineMember join = new A1_marineMember(id);
           join.setVisible(true);
           dispose();
		   
	   }
   }
   void db() {
	   Connection conn = null;
	   PreparedStatement stmt = null;
       try {
           String user = "pbl"; 
           String pw = "pbl";
           String url = "jdbc:oracle:thin:@localhost:1521:orcl";
           
           Class.forName("oracle.jdbc.driver.OracleDriver");        
           conn = DriverManager.getConnection(url, user, pw);
           conn.setAutoCommit(false);
           System.out.println("Database¿¡ ¿¬°áµÇ¾ú½À´Ï´Ù.\n");
           

           String sql="UPDATE CUSTOMER SET name='"+name+"', custpa='"+pww+"', email='"+email+"',phone='"+phone+"',address='"+address+"' WHERE custid='"+id+"'";
           stmt=conn.prepareStatement(sql);
           System.out.println(sql);
           stmt.executeQuery();
           conn.commit();
       } catch (ClassNotFoundException cnfe) {
           System.out.println("DB µå¶óÀÌ¹ö ·Îµù ½ÇÆÐ :"+cnfe.toString());
       } catch (SQLException sqle) {
           System.out.println("DB Á¢¼Ó½ÇÆÐ : "+sqle.toString());
       } catch (Exception ee) {
           System.out.println("Unknown error");
           ee.printStackTrace();
       }
   }
}
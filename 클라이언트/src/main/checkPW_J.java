package main;
import javax.swing.event.*;
import java.util.Random;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.*;

import javax.swing.JTextField;

//임시비밀번호를 받을 수 있는 창
/*
 * gui:박지현
 * rrandom,db:김은선
 */
public class checkPW_J extends JFrame {

   private JPanel contentPane;
   static String id;
   String temppw;

   public checkPW_J(String id) {
	   this.id=id;
      setTitle("PW확인");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 700, 500);
      setResizable(false);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(224, 255, 255));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JButton btnNewButton_3 = new JButton("");
      btnNewButton_3.setFocusPainted(false);
      btnNewButton_3.setBorderPainted(false);
      ImageIcon img5 = new ImageIcon("img5/home2.PNG");
      btnNewButton_3.setIcon(img5);
      btnNewButton_3.setBounds(600, 50, 50, 50);
      btnNewButton_3.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
             A_marine join = new A_marine();
             join.setVisible(true);
             dispose();
          }
       });
      contentPane.add(btnNewButton_3);
      
      JLabel lblPw = new JLabel("귀하의 임시PW 는");	
      lblPw.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
      lblPw.setBounds(89, 97, 400, 52);
      contentPane.add(lblPw);
      
      JLabel lblNewLabel = new JLabel("입니다.");
      lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
      lblNewLabel.setBounds(453, 313, 135, 52);
      contentPane.add(lblNewLabel);
      
      temppw= String.valueOf(rrandom());
      JLabel lblNewLabel_1 = new JLabel(temppw);
      lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
      lblNewLabel_1.setBackground(new Color(255, 255, 255));
      lblNewLabel_1.setBounds(193, 201, 282, 67);
      contentPane.add(lblNewLabel_1);
      
      db();
   }
   int rrandom() {
	   double randomvalue = Math.random();
	   int value = (int)(randomvalue*999999)+100000;
	   return value;
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
           System.out.println("Database에 연결되었습니다.\n");
           

           String sql="UPDATE CUSTOMER SET custpa='"+temppw+"' WHERE custid='"+id+"'";
           stmt=conn.prepareStatement(sql);
           System.out.println(sql);
           stmt.executeQuery();
           conn.commit();
       } catch (ClassNotFoundException cnfe) {
           System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
       } catch (SQLException sqle) {
           System.out.println("DB 접속실패 : "+sqle.toString());
       } catch (Exception ee) {
           System.out.println("Unknown error");
           ee.printStackTrace();
       }
   }
}
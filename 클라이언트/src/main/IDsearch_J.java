package main;

// 회원가입때 적은 정보를 이용해서 ID찾기하는 창
/*
 * gui:박지현
 * actionPerformed():김은선
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

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class IDsearch_J extends JFrame implements ActionListener{

   private JPanel contentPane;
   private JTextField textField;
   private JTextField textField_1;
   String name,phonenum;
   JButton btnNewButton;
	ArrayList<String> namee = new ArrayList<>();
	ArrayList<String> phone = new ArrayList<>();
	ArrayList<String> id = new ArrayList<>();

   
   public IDsearch_J() {
      setTitle("ID찾기");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 800, 600);
      setResizable(false);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(224, 255, 255));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel lblNewLabel = new JLabel("ID찾기 ");
      lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 45));
      lblNewLabel.setBounds(320, 31, 180, 63);
      contentPane.add(lblNewLabel);
      
      JLabel lblNewLabel_1 = new JLabel("이름");
      lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 33));
      lblNewLabel_1.setBounds(184, 165, 72, 60);
      contentPane.add(lblNewLabel_1);
      
      JButton btnNewButton_6 = new JButton("");
      btnNewButton_6.setBounds(50, 50, 80, 60);
      btnNewButton_6.setFocusPainted(false);
      btnNewButton_6.setBorderPainted(false);
      ImageIcon img2 = new ImageIcon("img2/arrow.PNG");
      btnNewButton_6.setIcon(img2);
      contentPane.add(btnNewButton_6);
      btnNewButton_6.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
             login_J join = new login_J();
             join.setVisible(true);
             dispose();
          }
       });
      
      
      textField = new JTextField();
      textField.setBounds(294, 168, 204, 57);
      textField.setFont(new Font("한컴 고딕", Font.PLAIN, 30));
      textField.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              name=e.getActionCommand();
           }
        });
      contentPane.add(textField);
      textField.setColumns(10);
      
      JLabel lblNewLabel_2 = new JLabel("휴대폰");
      lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 33));
      lblNewLabel_2.setBounds(163, 291, 101, 46);
      contentPane.add(lblNewLabel_2);
      
      textField_1 = new JTextField();
      textField_1.setBounds(294, 291, 204, 54);
      textField_1.setFont(new Font("한컴 고딕", Font.PLAIN, 30));
      textField_1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              phonenum=e.getActionCommand();
          }
       });
      contentPane.add(textField_1);
      textField_1.setColumns(10);
      
      btnNewButton = new JButton("search");
      btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
      btnNewButton.setBounds(320, 440, 144, 46);
      btnNewButton.addActionListener(this);
      btnNewButton.setFocusPainted(false);
      contentPane.add(btnNewButton);
   }
   @Override
	 public void actionPerformed(ActionEvent e) {
	   String textButton = e.getActionCommand();
	   if(textButton.equals("search")) {
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   ResultSet rs=null;
		   try {
			   String user = "pbl"; 
	           String pw = "pbl";
	           String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	           
	           Class.forName("oracle.jdbc.driver.OracleDriver");        
	           conn = DriverManager.getConnection(url, user, pw);
	           
	           System.out.println("Database에 연결되었습니다.\n");
	           
	           
	           String sql="SELECT * FROM CUSTOMER";
	           stmt=conn.prepareStatement(sql);
	           rs=stmt.executeQuery();
	           while(rs.next()) {
	        	   namee.add(rs.getString("NAME"));
	        	   phone.add(rs.getString("PHONE"));
	        	   id.add(rs.getString("CUSTID"));
	           }
	           
		   }catch(Exception ee) {
			   
		   }
		   for(int i=0;i<namee.size();i++) {
			   if(name.equals(namee.get(i))&&phonenum.equals(phone.get(i))) {
				   checkID_J join = new checkID_J(id.get(i));
				   join.setVisible(true);
				   dispose();
			   }else {
				   btnNewButton.setText("등록된 회원이 아닙니다.");
			   }
		   }
	   }
   }
}
package main;
/*
 * gui:박지현
 * actionPerformed:김은선
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.*;

public class join_J extends JFrame implements ActionListener{

	public static void main(String[] args) {
	      EventQueue.invokeLater(new Runnable() {
	         public void run() {
	            try {
	            	join_J frame = new join_J();
	               frame.setVisible(true);
	            } catch (Exception e) {
	               e.printStackTrace();
	            }
	         }
	      });
	   }
   private JPanel contentPane;
   private JTextField nametextField;
   private JTextField IDTextField;
   private JTextField PWTextField;
   private JTextField emailtextField;
   private JTextField adresstextField;
   private JTextField phonetextField;
   String name,email,pww,address,phone,id;
   JLabel lblNewLabel;
   JButton btnNewButton1;
   
   int cnt;
   // 회원가입 창 (중복확인전)
   
   public join_J() {
      setTitle("회원가입");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1300, 800);
      setResizable(false);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(224, 255, 255));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel label = new JLabel("회원가입");
      label.setFont(new Font("맑은 고딕", Font.BOLD, 60));
      label.setBounds(503, 0, 481, 135);
      contentPane.add(label);
      
      JLabel lbname = new JLabel("* 이름");
      lbname.setFont(new Font("맑은 고딕", Font.BOLD, 33));
      lbname.setBounds(158, 193, 97, 66);
      contentPane.add(lbname);
      
      nametextField = new JTextField();
      nametextField.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
      nametextField.setBounds(309, 204, 204, 53);
      contentPane.add(nametextField);
      nametextField.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		  name=e.getActionCommand();
    	  }
    	  
      });
      nametextField.setColumns(10);
      
      JLabel lblId = new JLabel("* ID");
      lblId.setFont(new Font("맑은 고딕", Font.BOLD, 33));
      lblId.setBounds(158, 312, 108, 66);
      contentPane.add(lblId);
      
      IDTextField = new JTextField();
      IDTextField.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
      IDTextField.setBounds(309, 313, 204, 53);
      contentPane.add(IDTextField);
      IDTextField.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		  id=e.getActionCommand();
    	  }
    	  
      });
      IDTextField.setColumns(10);
      
      JLabel lblPassward = new JLabel("* PW");
      lblPassward.setFont(new Font("맑은 고딕", Font.BOLD, 33));
      lblPassward.setBounds(158, 440, 97, 44);
      contentPane.add(lblPassward);
      
      PWTextField = new JPasswordField();
      PWTextField.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
      PWTextField.setBounds(309, 436, 204, 53);
      contentPane.add(PWTextField);
      PWTextField.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		  pww=e.getActionCommand();
    	  }
    	  
      });
      PWTextField.setColumns(10);
      
      JLabel lbemail = new JLabel("이메일");
      lbemail.setFont(new Font("맑은 고딕", Font.BOLD, 33));
      lbemail.setBounds(704, 201, 108, 51);
      contentPane.add(lbemail);
      
      JLabel lbadress = new JLabel("주소");
      lbadress.setFont(new Font("맑은 고딕", Font.BOLD, 33));
      lbadress.setBounds(716, 308, 82, 74);
      contentPane.add(lbadress);
      
      JLabel lbphone = new JLabel("* 휴대폰");
      lbphone.setFont(new Font("맑은 고딕", Font.BOLD, 33));
      lbphone.setBounds(688, 427, 130, 53);
      contentPane.add(lbphone);
      
      emailtextField = new JTextField();
      emailtextField.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
      emailtextField.setBounds(839, 206, 365, 53);
      contentPane.add(emailtextField);
      emailtextField.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		  email=e.getActionCommand();
    	  }
    	  
      });
      emailtextField.setColumns(10);
      
      adresstextField = new JTextField();
      adresstextField.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
      adresstextField.setBounds(839, 312, 429, 70);
      contentPane.add(adresstextField);
      adresstextField.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		  address=e.getActionCommand();
    	  }
    	  
      });
      adresstextField.setColumns(10);
      
      phonetextField = new JTextField();
      phonetextField.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
      phonetextField.setBounds(839, 431, 333, 53);
      contentPane.add(phonetextField);
      phonetextField.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e) {
    		  phone=e.getActionCommand();
    	  }
    	  
      });
      phonetextField.setColumns(10);
      
      btnNewButton1 = new JButton("확인");
      btnNewButton1.setFont(new Font("한컴 고딕", Font.BOLD, 40));
      btnNewButton1.setBounds(400, 598, 500, 80);
      btnNewButton1.addActionListener(this);
      btnNewButton1.setFocusPainted(false);
      contentPane.add(btnNewButton1);
      
      JLabel label_5 = new JLabel("* 는 필수 입력사항입니다.");
      label_5.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
      label_5.setBounds(789, 524, 415, 53);
      contentPane.add(label_5);
     
      
      
      JButton button = new JButton("중복확인");
      button.setBounds(543, 323, 105, 34);
      button.addActionListener(this);
      button.setFocusPainted(false);
      contentPane.add(button);
     
      
      JButton btnNewButton_2 = new JButton("");
      btnNewButton_2.setBounds(100, 600, 80, 60);
      btnNewButton_2.setFocusPainted(false);
      btnNewButton_2.setBorderPainted(false);
      ImageIcon img2 = new ImageIcon("img2/arrow.PNG");
      btnNewButton_2.setIcon(img2);
      contentPane.add(btnNewButton_2);
      btnNewButton_2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
             login_J join = new login_J();
             join.setVisible(true);
             dispose();
          }
       });
      
      

      
      lblNewLabel = new JLabel("ID 중복확인을 확인해주세요!");
      lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
      lblNewLabel.setBounds(299, 378, 214, 44);
      contentPane.add(lblNewLabel);
   }
   @Override
	public void actionPerformed(ActionEvent e) {
	   String textButton = e.getActionCommand();
	   btnNewButton1.setText("확인");
	   if(textButton.equals("확인")) {
		   if(cnt==0) {
			  btnNewButton1.setText("중복확인 해주세요");
		   }else {
			   Connection conn = null;
				Statement stmt = null;
		        try {
		            String user = "pbl"; 
		            String pw = "pbl";
		            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		            
		            Class.forName("oracle.jdbc.driver.OracleDriver");        
		            conn = DriverManager.getConnection(url, user, pw);
		            
		            System.out.println("Database에 연결되었습니다.\n");
		            
		            stmt=conn.createStatement();
		            String sql_insert="INSERT INTO CUSTOMER VALUES("+"'"+id+"'"+","+"'"+pww+"'"+","+"'"+email+"'"+","+"'"+phone+"'"+","+"'"+name+"'"+","+"'"+address+"'"+")";//sql쿼리문
		            
		            System.out.println(sql_insert);
		            stmt.executeQuery(sql_insert);
		            login_J join = new login_J();
		             join.setVisible(true);
		             dispose();
		        } catch (ClassNotFoundException cnfe) {
		            System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
		        } catch (SQLException sqle) {
		            System.out.println("DB 접속실패 : "+sqle.toString());
		        } catch (Exception ee) {
		            System.out.println("Unkonwn error");
		            ee.printStackTrace();
		        }
		   }
	   }else if(textButton.equals("중복확인")) {
		   System.out.println("중복확인버튼");
		   Connection conn = null;
		   PreparedStatement stmt = null;
 			ResultSet rs=null;
 	        try {
 	            String user = "pbl"; 
 	            String pw = "pbl";
 	            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
 	            
 	            Class.forName("oracle.jdbc.driver.OracleDriver");        
 	            conn = DriverManager.getConnection(url, user, pw);
 	            
 	            String sql="SELECT CUSTID FROM CUSTOMER";
 	            stmt=conn.prepareStatement(sql);
 	            rs=stmt.executeQuery();
 	            int idcnt=0;
 	            while(rs.next()) {
 	            	if(id.equals(rs.getString("CUSTID"))) {
 	            		idcnt++;
 	            	}
 	            }
 	            if(idcnt>0) {
            		lblNewLabel.setText("중복된 아이디 입니다.");
            		cnt=0;
            	}else {
            		lblNewLabel.setText("사용가능한 아이디 입니다.");
            		cnt=1;
            	}
 	            System.out.println("Database에 연결되었습니다.\n");
 	            
 	        } catch (ClassNotFoundException cnfe) {
 	            System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
 	        } catch (SQLException sqle) {
 	            System.out.println("DB 접속실패 : "+sqle.toString());
 	        } catch (Exception ee) {
 	            System.out.println("Unkonwn error");
 	            ee.printStackTrace();
 	        }
	   }
   }

}
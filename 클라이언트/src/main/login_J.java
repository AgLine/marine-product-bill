package main;
/*
 * gui:박지현
 * actionPerformed:김은선
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.JPasswordField;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.event.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class login_J extends JFrame implements ActionListener{

   private JPanel contentPane;
   private JTextField IDtextField;
   private JPasswordField passwordField;
   private JTextField textField;
   ArrayList<String> id = new ArrayList<>();
   ArrayList<String> pa = new ArrayList<>();
   String textid,textpa="";

   // 메인창에서 로그인 버튼 눌러서 로그인할수 있는 창

   public login_J() {
      setTitle("Login");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1300, 800);
      setResizable(false);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(224, 255, 255));
      contentPane.setForeground(Color.WHITE);
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel lblId = new JLabel("ID");
      lblId.setBounds(371, 192, 123, 87);
      lblId.setFont(new Font("Dialog", Font.BOLD, 53));
      contentPane.add(lblId);
      
      IDtextField = new JTextField();
      IDtextField.setBounds(520, 197, 426, 77);
      IDtextField.setFont(new Font("맑은 고딕", Font.PLAIN, 45));
      IDtextField.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			textid=e.getActionCommand();		
		}
	});
      contentPane.add(IDtextField);
      IDtextField.setColumns(10);
      
      
      JLabel lblPw = new JLabel("PW");
      lblPw.setBounds(354, 338, 143, 66);
      lblPw.setFont(new Font("Dialog", Font.BOLD, 53));
      contentPane.add(lblPw);
      
      JButton btnNewButton = new JButton("회원가입");
      btnNewButton.setForeground(Color.DARK_GRAY);
      btnNewButton.setBounds(401, 501, 116, 45);
      btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
        	 join_J join_J = new join_J();
        	 join_J.setVisible(true);
        	 dispose();
         }
      });
      contentPane.add(btnNewButton);
      
      JButton btnNewButton_6 = new JButton("");
      btnNewButton_6.setFocusPainted(false);
      btnNewButton_6.setBorderPainted(false);
      btnNewButton_6.setBounds(100, 620, 100, 80);
      ImageIcon img5 = new ImageIcon("img5/home.PNG");
      btnNewButton_6.setIcon(img5);
      contentPane.add(btnNewButton_6);
      btnNewButton_6.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
             A_marine join = new A_marine();
             join.setVisible(true);
             dispose();
          }
       });
      
      JButton btnNewButton_1 = new JButton("ID 찾기");
      btnNewButton_1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		 IDsearch_J IDsearch_J = new IDsearch_J();
      	   	 IDsearch_J.setVisible(true);
      	     dispose();
      	}
      });
      btnNewButton_1.setForeground(Color.DARK_GRAY);
      btnNewButton_1.setBounds(612, 501, 116, 45);
      btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      contentPane.add(btnNewButton_1);
      
      JButton btnNewButton_2 = new JButton("PW 찾기");
      btnNewButton_2.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		PWsearch_J PWsearch_J = new PWsearch_J();
      		PWsearch_J.setVisible(true);
      		dispose();
      	}
      });
      btnNewButton_2.setForeground(Color.DARK_GRAY);
      btnNewButton_2.setBounds(830, 501, 116, 45);
      btnNewButton_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      contentPane.add(btnNewButton_2);
      
      JButton login = new JButton("Login");
      login.setForeground(Color.BLACK);
      login.setBackground(Color.WHITE);
      login.setBounds(550, 630, 174, 63);
      login.setFont(new Font("한컴 고딕", Font.BOLD, 30));
      login.addActionListener(this);
      contentPane.add(login);
      
      passwordField = new JPasswordField();
      passwordField.setFont(new Font("맑은 고딕", Font.PLAIN, 45));
      passwordField.setBounds(520, 343, 426, 77);
      passwordField.addActionListener(new ActionListener() {
  		@Override
  		public void actionPerformed(ActionEvent e) {
  			e.getActionCommand();
  		}
  	});
 
  
      contentPane.add(passwordField);
      
      textField = new JTextField();
      textField.setEditable(false);
      textField.setBorder(null);
      textField.setBackground(new Color(224, 255, 255));
      textField.setText("로그인");
      textField.setFont(new Font("한컴 고딕", Font.BOLD, 50));
      textField.setBounds(562, 12, 342, 132);
      contentPane.add(textField);
      textField.setColumns(10);     
   }
   @Override
	public void actionPerformed(ActionEvent e) {
	   String textButton = e.getActionCommand();
	   int cnt=0;//로그인 성공시 1
	   if(textButton.equals("Login")) {
		   char []aaa = passwordField.getPassword();//passwordField의 있는 값을 가져오기 위한 배열
		   for(int i=0;i<aaa.length;i++){//aaa배열에 있는 문자를 붙혀서 문자열로 만든다.
		    	  textpa+=aaa[i];
		      }
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
	           
	           
	           String sql="SELECT CUSTID,CUSTPA FROM CUSTOMER";//디비에서 고객의 아이디와 비밀번호를 가져온다
	           
	           stmt=conn.prepareStatement(sql);
	           rs=stmt.executeQuery();
	           while(rs.next()) {
	        	   id.add(rs.getString("CUSTID"));
	        	   pa.add(rs.getString("CUSTPA"));
	           }
	           for(int i=0;i<id.size();i++) {
	        	   if(textid.equals(id.get(i))&&textpa.equals(pa.get(i))) {//아이디와 비번이 같으면
	        		   try {//소켓을만든다
	                  	 Socket socket = new Socket("localhost",8850);
	                  	 ReceiveThread thread = new ReceiveThread(socket);
	                  	 thread.start();
	                  	 PrintWriter pww = new PrintWriter(socket.getOutputStream());
	               		 pww.println("ID: "+textid);
	               		 pww.flush();
	               		 cnt=1;
	        		   }catch(Exception a) {
	        			   System.out.println("서버 오류");
	        		   }
	        	   }
	           }
	           if(textid.equals("Administer")) {//관리자가 로그인하는경우
	        	   try {
	                  	 Socket socket = new Socket("localhost",8850);
	                  	 ReceiveThread thread = new ReceiveThread(socket);
	                  	 thread.start();
	                  	 PrintWriter pww = new PrintWriter(socket.getOutputStream());
	               		 pww.println("ID: "+textid);
	               		 pww.flush();
	               		 cnt=1;
	        		   }catch(Exception a) {
	        			   System.out.println("서버 오류");
	        		   }
	           }
	       } catch (ClassNotFoundException cnfe) {
	           System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
	       } catch (SQLException sqle) {
	           System.out.println("DB 접속실패 : "+sqle.toString());
	       } catch (Exception ee) {
	           System.out.println("Unkonwn error");
	           ee.printStackTrace();
	       }
		   if(cnt==1) {
			   if(textid.equals("Administer")){//관리자가 로그인한경우
				   A2_marineAdminister join = new A2_marineAdminister();//관리자창을 띄운다
				   join.setVisible(true); 
				   dispose();
			   }else {//관리자가 아닌경우
				   A1_marineMember join = new A1_marineMember(textid);//고객창을 띄운다.
				   join.setVisible(true);
				   dispose();
			   }
		   }
	   }
   }
}

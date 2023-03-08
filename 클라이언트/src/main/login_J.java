package main;
/*
 * gui:������
 * actionPerformed:������
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

   // ����â���� �α��� ��ư ������ �α����Ҽ� �ִ� â

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
      IDtextField.setFont(new Font("���� ���", Font.PLAIN, 45));
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
      
      JButton btnNewButton = new JButton("ȸ������");
      btnNewButton.setForeground(Color.DARK_GRAY);
      btnNewButton.setBounds(401, 501, 116, 45);
      btnNewButton.setFont(new Font("���� ���", Font.BOLD, 20));
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
      
      JButton btnNewButton_1 = new JButton("ID ã��");
      btnNewButton_1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		 IDsearch_J IDsearch_J = new IDsearch_J();
      	   	 IDsearch_J.setVisible(true);
      	     dispose();
      	}
      });
      btnNewButton_1.setForeground(Color.DARK_GRAY);
      btnNewButton_1.setBounds(612, 501, 116, 45);
      btnNewButton_1.setFont(new Font("���� ���", Font.BOLD, 20));
      contentPane.add(btnNewButton_1);
      
      JButton btnNewButton_2 = new JButton("PW ã��");
      btnNewButton_2.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		PWsearch_J PWsearch_J = new PWsearch_J();
      		PWsearch_J.setVisible(true);
      		dispose();
      	}
      });
      btnNewButton_2.setForeground(Color.DARK_GRAY);
      btnNewButton_2.setBounds(830, 501, 116, 45);
      btnNewButton_2.setFont(new Font("���� ���", Font.BOLD, 20));
      contentPane.add(btnNewButton_2);
      
      JButton login = new JButton("Login");
      login.setForeground(Color.BLACK);
      login.setBackground(Color.WHITE);
      login.setBounds(550, 630, 174, 63);
      login.setFont(new Font("���� ���", Font.BOLD, 30));
      login.addActionListener(this);
      contentPane.add(login);
      
      passwordField = new JPasswordField();
      passwordField.setFont(new Font("���� ���", Font.PLAIN, 45));
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
      textField.setText("�α���");
      textField.setFont(new Font("���� ���", Font.BOLD, 50));
      textField.setBounds(562, 12, 342, 132);
      contentPane.add(textField);
      textField.setColumns(10);     
   }
   @Override
	public void actionPerformed(ActionEvent e) {
	   String textButton = e.getActionCommand();
	   int cnt=0;//�α��� ������ 1
	   if(textButton.equals("Login")) {
		   char []aaa = passwordField.getPassword();//passwordField�� �ִ� ���� �������� ���� �迭
		   for(int i=0;i<aaa.length;i++){//aaa�迭�� �ִ� ���ڸ� ������ ���ڿ��� �����.
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
	           
	           System.out.println("Database�� ����Ǿ����ϴ�.\n");
	           
	           
	           String sql="SELECT CUSTID,CUSTPA FROM CUSTOMER";//��񿡼� ���� ���̵�� ��й�ȣ�� �����´�
	           
	           stmt=conn.prepareStatement(sql);
	           rs=stmt.executeQuery();
	           while(rs.next()) {
	        	   id.add(rs.getString("CUSTID"));
	        	   pa.add(rs.getString("CUSTPA"));
	           }
	           for(int i=0;i<id.size();i++) {
	        	   if(textid.equals(id.get(i))&&textpa.equals(pa.get(i))) {//���̵�� ����� ������
	        		   try {//�����������
	                  	 Socket socket = new Socket("localhost",8850);
	                  	 ReceiveThread thread = new ReceiveThread(socket);
	                  	 thread.start();
	                  	 PrintWriter pww = new PrintWriter(socket.getOutputStream());
	               		 pww.println("ID: "+textid);
	               		 pww.flush();
	               		 cnt=1;
	        		   }catch(Exception a) {
	        			   System.out.println("���� ����");
	        		   }
	        	   }
	           }
	           if(textid.equals("Administer")) {//�����ڰ� �α����ϴ°��
	        	   try {
	                  	 Socket socket = new Socket("localhost",8850);
	                  	 ReceiveThread thread = new ReceiveThread(socket);
	                  	 thread.start();
	                  	 PrintWriter pww = new PrintWriter(socket.getOutputStream());
	               		 pww.println("ID: "+textid);
	               		 pww.flush();
	               		 cnt=1;
	        		   }catch(Exception a) {
	        			   System.out.println("���� ����");
	        		   }
	           }
	       } catch (ClassNotFoundException cnfe) {
	           System.out.println("DB ����̹� �ε� ���� :"+cnfe.toString());
	       } catch (SQLException sqle) {
	           System.out.println("DB ���ӽ��� : "+sqle.toString());
	       } catch (Exception ee) {
	           System.out.println("Unkonwn error");
	           ee.printStackTrace();
	       }
		   if(cnt==1) {
			   if(textid.equals("Administer")){//�����ڰ� �α����Ѱ��
				   A2_marineAdminister join = new A2_marineAdminister();//������â�� ����
				   join.setVisible(true); 
				   dispose();
			   }else {//�����ڰ� �ƴѰ��
				   A1_marineMember join = new A1_marineMember(textid);//��â�� ����.
				   join.setVisible(true);
				   dispose();
			   }
		   }
	   }
   }
}

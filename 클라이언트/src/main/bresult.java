package main;
/*
 * gui:송유빈
 * actionPerformed,btnNewButton_2.addActionListener,jsonString:김은선
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.event.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@SuppressWarnings({ "unused", "serial" })
public class bresult extends JFrame implements ActionListener{

   private JPanel contentPane;
   private JTextField textField;
   private JTextField textField_1;
   String fishname;
   static String id;
   JLabel lblNewLabel;
   JLabel label_1;
   JLabel label_2;
   JLabel label_3;
   ArrayList<String> name = new ArrayList<>();
   ArrayList<String> length = new ArrayList<>();
   ArrayList<String> region = new ArrayList<>();
   ArrayList<String> season = new ArrayList<>();
   ArrayList<String> type = new ArrayList<>();
   int cnt=0;
//검색기록 리스트 넣기

   public bresult(String id) {
	   this.id= id;
      setTitle("검색창");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1300, 800);
      setResizable(false);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(224, 255, 255));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      textField = new JTextField();
      textField.setFont(new Font("맑은 고딕", Font.BOLD, 40));
      textField.setBounds(233, 160, 746, 114);
      textField.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              fishname = e.getActionCommand();
           }
        });
      contentPane.add(textField);
      textField.setColumns(10);
      
      JButton btnNewButton = new JButton("검색");
      btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      btnNewButton.setBounds(1025, 160, 109, 106);
      btnNewButton.addActionListener(this);
      btnNewButton.setFocusPainted(false);
      contentPane.add(btnNewButton);
      
     
      
      JButton btnNewButton_2 = new JButton("");
      btnNewButton_2.setFocusPainted(false);
      btnNewButton_2.setBorderPainted(false);
      btnNewButton_2.setBounds(233, 39, 99, 86);
      ImageIcon img5 = new ImageIcon("img5/home.PNG");
      btnNewButton_2.setIcon(img5);
      btnNewButton_2.addActionListener(new ActionListener() {
    		              public void actionPerformed(ActionEvent arg0) {
    		            	  if(id.equals("Administer")) {
    		            		  A2_marineAdminister join = new A2_marineAdminister();
    		            		  join.setVisible(true);
    		            		  dispose();
    		            	  }else {
    		            		  A1_marineMember join = new A1_marineMember(id);
    		            		  join.setVisible(true);
    		            		  dispose();
    		            	  }
    		              }
    		           });
    		        contentPane.add(btnNewButton_2);
      
      JLabel label = new JLabel("해조류");
      label.setFont(new Font("맑은 고딕", Font.BOLD, 50));
      label.setBounds(67, 39, 208, 66);
      contentPane.add(label);
      
      JLabel label3 = new JLabel("");
      ImageIcon img7 = new ImageIcon("img7/seaweed6.png");
		label3.setIcon(img7);
		label3.setBounds(1115, 10, 165, 147);
		contentPane.add(label3);
      
      textField_1 = new JTextField();
      textField_1.setBackground(new Color(224, 255, 255));
      textField_1.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      textField_1.setText("검색결과");
      textField_1.setBounds(119, 300, 139, 52);
      contentPane.add(textField_1);
      textField_1.setColumns(10);
      textField_1.setBorder(null);
      
      lblNewLabel = new JLabel("이름");
      lblNewLabel.setFont(new Font("함초롬돋움", Font.BOLD, 28));
      lblNewLabel.setBounds(192, 364, 862, 73);
      contentPane.add(lblNewLabel);
      
      label_1 = new JLabel("제철");
      label_1.setFont(new Font("함초롬돋움", Font.BOLD, 28));
      label_1.setBounds(192, 449, 862, 73);
      contentPane.add(label_1);
      
      label_2 = new JLabel("서식지");
      label_2.setFont(new Font("함초롬돋움", Font.BOLD, 28));
      label_2.setBounds(192, 534, 862, 73);
      contentPane.add(label_2);
      
      label_3 = new JLabel("가격");
      label_3.setFont(new Font("함초롬돋움", Font.BOLD, 28));
      label_3.setBounds(192, 619, 862, 73);
      contentPane.add(label_3);
      
      JLabel label5 = new JLabel("");
 		ImageIcon img8 = new ImageIcon("img8/arrow.PNG");
 		label5.setIcon(img8);
 		label5.setBounds(144, 377, 46, 44);
 		contentPane.add(label5);

 		JLabel label6 = new JLabel("");
		ImageIcon img9 = new ImageIcon("img9/arrow.PNG");
		label6.setIcon(img9);
		label6.setBounds(144, 463, 46, 44);
		contentPane.add(label6);

		JLabel label7 = new JLabel("");
		ImageIcon img10 = new ImageIcon("img10/arrow.PNG");
		label7.setIcon(img10);
		label7.setBounds(144, 546, 46, 44);
		contentPane.add(label7);

		JLabel label8 = new JLabel("");
		ImageIcon img11 = new ImageIcon("img11/arrow.PNG");
		label8.setIcon(img11);
		label8.setBounds(144, 632, 46, 44);
		contentPane.add(label8);
      
      JLabel label2 = new JLabel("");
      ImageIcon img6 = new ImageIcon("/seaweed5.PNG");
		label2.setIcon(img6);
		label2.setBounds(1098, 12, 165, 147);
		contentPane.add(label2);
   }
   @Override
	 public void actionPerformed(ActionEvent e) {
	   String textButton = e.getActionCommand();
	   String price="";
	   if(textButton.equals("검색")) {
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
	           
	           
	           String sql="SELECT * FROM fish WHERE type='해조류'";
	           stmt=conn.prepareStatement(sql);
	           rs=stmt.executeQuery();
	           while(rs.next()) {
	        	   name.add(rs.getString("NAME"));
	        	   length.add(rs.getString("LENGTH"));
	        	   region.add(rs.getString("REGION"));
	        	   season.add(rs.getString("SEASON"));
	        	   type.add(rs.getString("TYPE"));
	        	   
	           }
	           for(int i=0;i<name.size();i++) {
	        	   if(name.get(i).equals(fishname)) {
	        		   lblNewLabel.setText("이름: "+name.get(i));
	        		   label_1.setText("제철: "+season.get(i));
	        		   label_2.setText("서식지: "+region.get(i));
	    			   price=jsonString();
	    			   label_3.setText(price); 
	    			   cnt=1;
	        	   }
	           }
	           if(cnt==0) {
	        	   warning join = new warning(2,id);
	        	   join.setVisible(true);
	        	   dispose();
	           }

		   }catch(Exception ee) {
			   
		   }
	   }
   }
   public String jsonString() throws Exception{
	   WebConnection wc = new WebConnection(fishname);  
		String json=wc.result;
		String price="";
	      if(json!=null) {
	    	  System.out.println(json);
	      JSONParser parser = new JSONParser();
	      JSONObject obj=(JSONObject)parser.parse(json);
	      JSONObject response=(JSONObject)obj.get("response");
	      JSONObject body=(JSONObject)response.get("body");
	      JSONArray item=(JSONArray)body.get("item");
	      for(int i=0;i<item.size();i++){
	         JSONObject tmp = (JSONObject)item.get(i);
	         String name=((String)tmp.get("mprcStdCodeNm"));
	         String pricee=((String)tmp.get("csmtUntpc"));
	         String place=((String)tmp.get("csmtmktNm"));
	         System.out.println("이름 : "+name);
	         System.out.println("가격: "+pricee+"원");
	         System.out.println("위판장: "+place);
	         price="가격: "+pricee+"원";
	      	}
	      }
	      return price;
   }
}

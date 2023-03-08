package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.event.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import javax.swing.ImageIcon;
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
/*
 * gui:������
 * actionPerformed,btnNewButton_2.addActionListener,jsonString:������
 */
//�˻������ ������ ���â
@SuppressWarnings({ "unused", "serial" })
public class aresult extends JFrame implements ActionListener{

   private JPanel contentPane;
   private JTextField textField;
   private JTextField textField_1;
   String fishname;
   static String id;
   JLabel lblNewLabel;
   JLabel label_1;
   JLabel label_2;
   JLabel label_3; 
   ArrayList<String> name = new ArrayList<>();//��񿡼� ������ �����͵��� ���� ArrayList
   ArrayList<String> length = new ArrayList<>();
   ArrayList<String> region = new ArrayList<>();
   ArrayList<String> season = new ArrayList<>();
   ArrayList<String> type = new ArrayList<>();
   int cnt=0;
//�˻���� ����Ʈ �ֱ�
   
   public aresult(String id) {
	   this.id = id;
      setTitle("�˻�â");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1300, 800);
      setResizable(false);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(224, 255, 255));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      textField = new JTextField();
      textField.setFont(new Font("���� ���", Font.BOLD, 40));
      textField.setBounds(233, 160, 746, 114);
      textField.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              fishname= e.getActionCommand();
           }
        });
      contentPane.add(textField);
      textField.setColumns(10);
      
      JButton btnNewButton = new JButton("�˻�");
      btnNewButton.setFont(new Font("���� ���", Font.BOLD, 30));
      btnNewButton.setBounds(1025, 160, 109, 106);
      btnNewButton.addActionListener(this);
      btnNewButton.setFocusPainted(false);
      contentPane.add(btnNewButton);
      
      lblNewLabel = new JLabel("�̸�");
      lblNewLabel.setFont(new Font("���ʷҵ���", Font.BOLD, 28));
      lblNewLabel.setBounds(192, 364, 862, 73);
      contentPane.add(lblNewLabel);
      
      label_1 = new JLabel("��ö");
      label_1.setFont(new Font("���ʷҵ���", Font.BOLD, 28));
      label_1.setBounds(192, 449, 862, 73);
      contentPane.add(label_1);
      
      label_2 = new JLabel("������");
      label_2.setFont(new Font("���ʷҵ���", Font.BOLD, 28));
      label_2.setBounds(192, 534, 862, 73);
      contentPane.add(label_2);
      
      label_3 = new JLabel("����");
      label_3.setFont(new Font("���ʷҵ���", Font.BOLD, 28));
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
      
      //����â���� ���ư��� ��ư
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
    		       

      
      JLabel label = new JLabel("���");
      label.setFont(new Font("���� ���", Font.BOLD, 50));
      label.setBounds(67, 39, 208, 66);
      contentPane.add(label);
      
      textField_1 = new JTextField();
      textField_1.setBackground(new Color(224, 255, 255));
      textField_1.setFont(new Font("���� ���", Font.BOLD, 30));
      textField_1.setText("�˻����");
      textField_1.setBounds(119, 300, 139, 52);
      contentPane.add(textField_1);
      textField_1.setColumns(10);
      textField_1.setBorder(null);
      
      JLabel label2 = new JLabel("");
		ImageIcon img6 = new ImageIcon("img6/fish2.PNG");
		label2.setIcon(img6);
		label2.setBounds(1130, 12, 130, 147);
		contentPane.add(label2);

   }
   @Override
	 public void actionPerformed(ActionEvent e) {
	   String textButton = e.getActionCommand();
	   String price="";
	   if(textButton.equals("�˻�")) {
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
	           
	           
	           String sql="SELECT * FROM fish WHERE type='���'";
	           stmt=conn.prepareStatement(sql);
	           price=jsonString();
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
	        		   lblNewLabel.setText("�̸�: "+name.get(i));
	        		   label_1.setText("��ö: "+season.get(i));
	        		   label_2.setText("������: "+region.get(i));
	        		   price=jsonString();
	    			   label_3.setText(price);
	        		   cnt=1;
	        	   }
	           }
	           if(cnt==0) {
	        	   warning join = new warning(1,id);
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
	         System.out.println("�̸� : "+name);
	         System.out.println("����: "+pricee+"��");
	         System.out.println("������: "+place);
	         price="����: "+pricee+"��";
	      	}
	      System.out.println(price);
	      }
	      return price;
   }
}

package main;
/*
 * 김은선
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class membersetting extends JFrame {

	private JPanel contentPane;
	private JTable table;
	String name[] = new String[14];
	String id[] = new String[14];
	String email[] = new String[14];
	String address[] = new String[14];
	String phone[] = new String[14];
	String content [][];

	public membersetting() {
		setResizable(false);
		setTitle("회원관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(224, 255, 255));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("회원관리");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 45));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
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
	           int i=0;
	           while(rs.next()) {
	        	   name[i]=rs.getString("NAME");
	        	   id[i]=rs.getString("CUSTID");
	        	   email[i]=rs.getString("EMAIL");
	        	   address[i]=rs.getString("ADDRESS");
	        	   phone[i]=rs.getString("PHONE");
	        	   i++;
	           }
	       } catch (ClassNotFoundException cnfe) {
	           System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
	       } catch (SQLException sqle) {
	           System.out.println("DB 접속실패 : "+sqle.toString());
	       } catch (Exception ee) {
	           System.out.println("Unknown error");
	           ee.printStackTrace();
	       }
			table = new JTable();
			table.setFont(new Font("굴림", Font.PLAIN, 15));
			table.setSurrendersFocusOnKeystroke(true);
			table.setModel(new DefaultTableModel(
		            new Object[][] {
		                {name[0], id[0], address[0], email[0],phone[0]},
		                {name[1], id[1], address[1], email[1],phone[1]},
		                {name[2], id[2], address[2], email[2],phone[2]},
		                {name[3], id[3], address[3], email[3],phone[3]},
		                {name[4], id[4], address[4], email[4],phone[4]},
		                {name[5], id[5], address[5], email[5],phone[5]},
		                {name[6], id[6], address[6], email[6],phone[6]},
		                {name[7], id[7], address[7], email[7],phone[7]},
		                {name[8], id[8], address[8], email[8],phone[8]},
		                {name[9], id[9], address[9], email[9],phone[9]},
		                {name[10], id[10], address[10], email[10],phone[10]},
		                {name[11], id[11], address[11], email[11],phone[11]},
		                {name[12], id[12], address[12], email[12],phone[12]},
		                {name[13], id[13], address[13], email[13],phone[13]},
		            },
		            new String[] {
		                "이름", "ID", "주소", "이메일","핸드폰"
		            }
		        ));
		
			sl_contentPane.putConstraint(SpringLayout.NORTH, table, 82, SpringLayout.SOUTH, lblNewLabel);
			sl_contentPane.putConstraint(SpringLayout.WEST, table, 87, SpringLayout.WEST, contentPane);
			//contentPane.add(table);
			JScrollPane scrollPane = new JScrollPane(table);
			sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 44, SpringLayout.WEST, contentPane);
			sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 35, SpringLayout.SOUTH, lblNewLabel);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, 292, SpringLayout.SOUTH, lblNewLabel);
			sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 1234, SpringLayout.WEST, contentPane);
			contentPane.add(scrollPane);
			
			JButton btnNewButton = new JButton("");
			sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, -110, SpringLayout.SOUTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 33, SpringLayout.WEST, contentPane);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -50, SpringLayout.SOUTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -78, SpringLayout.EAST, lblNewLabel);
			btnNewButton.setBounds(100, 600, 50, 50);
			btnNewButton.setFocusPainted(false);
			btnNewButton.setBorderPainted(false);
		    ImageIcon img2 = new ImageIcon("img2/arrow.PNG");
		    btnNewButton.setIcon(img2);
			btnNewButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent arg0) {
		             administerSetting_S join = new administerSetting_S();
		             join.setVisible(true);
		             dispose();
		          }
		       });
			contentPane.add(btnNewButton);
	}
}

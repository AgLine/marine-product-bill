package main;
/*
 * gui:송유빈
 * actionPerformed:김은선
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.event.*;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// 관리자 메인창
public class A2_marineAdminister extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtAdminister;

	String id ="Administer";
	
	public A2_marineAdminister() {
		//창설정
		setTitle("수산물 위판정보 프로그램_2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 800);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane); 
		contentPane.setLayout(null);
		
		//화면 이름설정
		JLabel label = new JLabel("수산물 위판정보 프로그램");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 45));
		label.setBounds(270, 12, 772, 54);
		contentPane.add(label);
		
		// 어류 ~ 연체동물 버튼설정
		JButton btn1 = new JButton("어류");
	      btn1.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
	      btn1.setBounds(39, 217, 170, 50);
	      btn1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	aresult join = new aresult(id);
	               join.setVisible(true);
	               dispose();
	            }
	         });
	      btn1.setFocusPainted(false);
	      contentPane.add(btn1);
	      
	      JButton btn2 = new JButton("해조류");
	      btn2.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
	      btn2.setBounds(39, 279, 170, 50);
	      btn2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	bresult join = new bresult(id);
	               join.setVisible(true);
	               dispose();
	            }
	         });
	      btn2.setFocusPainted(false);
	      contentPane.add(btn2);
	      
	      JButton btn3 = new JButton("어패류");
	      btn3.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
	      btn3.setBounds(39, 341, 170, 50);
	      btn3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	cresult join = new cresult(id);
	               join.setVisible(true);
	               dispose();
	            }
	         });
	      btn3.setFocusPainted(false);
	      contentPane.add(btn3);
	      
	      JButton btn4 = new JButton("갑각류");
	      btn4.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
	      btn4.setBounds(39, 403, 170, 50);
	      btn4.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	dresult join = new dresult(id);
	               join.setVisible(true);
	               dispose();
	            }
	         });
	      btn4.setFocusPainted(false);
	      contentPane.add(btn4);
	      
	      JButton btn5 = new JButton("연체동물");
	      btn5.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
	      btn5.setBounds(39, 466, 170, 50);
	      btn5.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	            	eresult join = new eresult(id);
	               join.setVisible(true);
	               dispose();
	            }
	         });
	      btn5.setFocusPainted(false);
	      contentPane.add(btn5);
		
	    //메인창 센터아래 주소
		textField = new JTextField();
		textField.setBackground(new Color(224, 255, 255));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setText("우)31460 충남 아산시 탕정면 선문로 221번길 70 선문대학교 인문관 410호");
		textField.setBorder(null);
		textField.setBounds(394, 701, 549, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//관리자계정이름
		txtAdminister = new JTextField();
		txtAdminister.setEditable(false);
		txtAdminister.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdminister.setFont(new Font("맑은 고딕", Font.BOLD, 35));
		txtAdminister.setBackground(new Color(224, 255, 255));
		txtAdminister.setText("Administer");
		txtAdminister.setBorder(null);
		txtAdminister.setBounds(1029, 155, 200, 60);
		contentPane.add(txtAdminister);
		txtAdminister.setColumns(10);
		
		//logout 버튼
		JButton btnLogout = new JButton("LOGOUT");
		  btnLogout.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	               A_marine join = new A_marine();
	               join.setVisible(true);
	               dispose();
	            }
	         });
		btnLogout.setForeground(Color.BLACK);
		btnLogout.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnLogout.setBounds(1051, 223, 110, 40);
		btnLogout.setFocusPainted(false);
		contentPane.add(btnLogout);
		
		//이미지삽입
		JLabel Label = new JLabel("");
	      ImageIcon img = new ImageIcon("img/menu icon3.PNG");
	      Label.setIcon(img);
	      Label.setBounds(25, 155, 70, 50);
	      contentPane.add(Label);
	      
	      JLabel Label1 = new JLabel("");
	      ImageIcon img1 = new ImageIcon("img1/Fish1.PNG");
	      Label1.setIcon(img1);
	      Label1.setBounds(457, 193, 423, 373);
	      contentPane.add(Label1);
	      
	      JLabel Label2 = new JLabel("");
	      ImageIcon img2 = new ImageIcon("img2/seaweed.PNG");
	      Label2.setIcon(img2);
	      Label2.setBounds(923, 585, 359, 168);
	      contentPane.add(Label2);
	      
	      JLabel Label3 = new JLabel("");
	      ImageIcon img4 = new ImageIcon("img4/seaweed.PNG");
	      Label3.setIcon(img4);
	      Label3.setBounds(0, 587, 345, 166);
	      contentPane.add(Label3);

		//관리자 설정창
		JButton btn6 = new JButton("");
		ImageIcon img3 = new ImageIcon("img3/settings.PNG");
		btn6.setIcon(img3);
		btn6.setBorderPainted(false);
		btn6.setBounds(1166, 217, 45, 50);
		btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
               administerSetting_S join = new administerSetting_S();
               join.setVisible(true);
               dispose();
            }
         });
		contentPane.add(btn6);

	}

}

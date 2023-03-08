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

// ������ ����â
public class A2_marineAdminister extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtAdminister;

	String id ="Administer";
	
	public A2_marineAdminister() {
		//â����
		setTitle("���깰 �������� ���α׷�_2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 800);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane); 
		contentPane.setLayout(null);
		
		//ȭ�� �̸�����
		JLabel label = new JLabel("���깰 �������� ���α׷�");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("���� ���", Font.PLAIN, 45));
		label.setBounds(270, 12, 772, 54);
		contentPane.add(label);
		
		// ��� ~ ��ü���� ��ư����
		JButton btn1 = new JButton("���");
	      btn1.setFont(new Font("���� ���", Font.PLAIN, 30));
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
	      
	      JButton btn2 = new JButton("������");
	      btn2.setFont(new Font("���� ���", Font.PLAIN, 30));
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
	      
	      JButton btn3 = new JButton("���з�");
	      btn3.setFont(new Font("���� ���", Font.PLAIN, 30));
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
	      
	      JButton btn4 = new JButton("������");
	      btn4.setFont(new Font("���� ���", Font.PLAIN, 30));
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
	      
	      JButton btn5 = new JButton("��ü����");
	      btn5.setFont(new Font("���� ���", Font.PLAIN, 30));
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
		
	    //����â ���;Ʒ� �ּ�
		textField = new JTextField();
		textField.setBackground(new Color(224, 255, 255));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setText("��)31460 �泲 �ƻ�� ������ ������ 221���� 70 �������б� �ι��� 410ȣ");
		textField.setBorder(null);
		textField.setBounds(394, 701, 549, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//�����ڰ����̸�
		txtAdminister = new JTextField();
		txtAdminister.setEditable(false);
		txtAdminister.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdminister.setFont(new Font("���� ���", Font.BOLD, 35));
		txtAdminister.setBackground(new Color(224, 255, 255));
		txtAdminister.setText("Administer");
		txtAdminister.setBorder(null);
		txtAdminister.setBounds(1029, 155, 200, 60);
		contentPane.add(txtAdminister);
		txtAdminister.setColumns(10);
		
		//logout ��ư
		JButton btnLogout = new JButton("LOGOUT");
		  btnLogout.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	               A_marine join = new A_marine();
	               join.setVisible(true);
	               dispose();
	            }
	         });
		btnLogout.setForeground(Color.BLACK);
		btnLogout.setFont(new Font("���� ���", Font.BOLD, 17));
		btnLogout.setBounds(1051, 223, 110, 40);
		btnLogout.setFocusPainted(false);
		contentPane.add(btnLogout);
		
		//�̹�������
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

		//������ ����â
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

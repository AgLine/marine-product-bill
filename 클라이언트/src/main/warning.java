package main;
/*
 * gui:¼ÛÀ¯ºó
 * actionPerformed:±èÀº¼±
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.*;
import java.net.Socket;

import javax.swing.JLabel;

public class warning extends JFrame implements ActionListener{

	private JPanel contentPane;
	static int num;
	static String id;

	public warning(int num,String id) {
		this.num=num;
		this.id=id;
		setTitle("Warning");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("È®ÀÎ");
		btnNewButton.setFont(new Font("ÇÑÄÄ °íµñ", Font.BOLD, 30));
		btnNewButton.setBounds(280, 384, 115, 53);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);
		btnNewButton.setFocusPainted(false);
		
		JLabel lblNewLabel = new JLabel("°Ë»ö°á°ú°¡");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		lblNewLabel.setBounds(255, 147, 170, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Á¸ÀçÇÏÁö ¾Ê½À´Ï´Ù");
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		lblNewLabel_1.setBounds(211, 223, 260, 64);
		contentPane.add(lblNewLabel_1);
	
		JLabel label1 = new JLabel("");
		ImageIcon img = new ImageIcon("img/warning.PNG");
		label1.setIcon(img);
		label1.setBounds(27, 12, 115, 116);
		contentPane.add(label1);
	}
	@Override
	 public void actionPerformed(ActionEvent e) {
		String textButton=e.getActionCommand();
		if(textButton.equals("È®ÀÎ")) {
			if(num==1) {
				aresult join = new aresult(id);
				join.setVisible(true);
				dispose();
			}else if(num==2) {
				bresult join = new bresult(id);
				join.setVisible(true);
				dispose();
			}else if(num==3) {
				cresult join = new cresult(id);
				join.setVisible(true);
				dispose();
			}else if(num==4) {
				dresult join = new dresult(id);
				join.setVisible(true);
				dispose();
			}else if(num==5) {
				eresult join = new eresult(id);
				join.setVisible(true);
				dispose();
			}
		}
	}
}

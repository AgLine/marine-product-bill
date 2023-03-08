package main;
/*
 * gui:¹ÚÁöÇö
 */
import javax.swing.event.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.Color;

//IDÈ®ÀÎ °¡´ÉÇÑ Ã¢
public class checkID_J extends JFrame {

   private JPanel contentPane;
   private JTextField textField;
   static String id;

   public checkID_J(String id) {
	  this.id=id;
      setTitle("IDÈ®ÀÎ");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 700, 500);
      setResizable(false);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(224, 255, 255));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel lblNewLabel = new JLabel("±ÍÇÏÀÇ ID ´Â");
      lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 30));
      lblNewLabel.setBounds(98, 96, 269, 66);
      contentPane.add(lblNewLabel);
      
      JLabel lblNewLabel_1 = new JLabel("ÀÔ´Ï´Ù.");
      lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 30));
      lblNewLabel_1.setBounds(418, 316, 133, 66);
      contentPane.add(lblNewLabel_1);
      
      JLabel lblNewLabel_2 = new JLabel(id);
      lblNewLabel_2.setForeground(new Color(220, 20, 60));
      lblNewLabel_2.setBackground(Color.WHITE);
      lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 25));
      lblNewLabel_2.setBounds(189, 203, 280, 60);
      contentPane.add(lblNewLabel_2);
      //textField.setColumns(10);
      
      JButton btnNewButton_3 = new JButton("");
      btnNewButton_3.setFocusPainted(false);
      btnNewButton_3.setBorderPainted(false);
      ImageIcon img5 = new ImageIcon("img5/home2.PNG");
      btnNewButton_3.setIcon(img5);
      btnNewButton_3.setBounds(600, 50, 50, 50);
      btnNewButton_3.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
             A_marine join = new A_marine();
             join.setVisible(true);
             dispose();
          }
       });
      contentPane.add(btnNewButton_3);
   }

}
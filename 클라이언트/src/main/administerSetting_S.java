package main;
/*
 * ������
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Image;
import javax.swing.ImageIcon;

//������ ���� â
@SuppressWarnings({ "serial", "unused" })
public class administerSetting_S extends JFrame {

   private JPanel contentPane;
   String id="Administer";
   
   public administerSetting_S() {
      setBackground(new Color(224, 255, 255));
      setForeground(new Color(224, 255, 255));
      setTitle("ȯ�漳��");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1300, 800);
      setResizable(false);
      getContentPane().setLayout(new FlowLayout(1,2,3000));
      contentPane = new JPanel();
      contentPane.setBackground(new Color(224, 255, 255));
      contentPane.setForeground(new Color(224, 255, 255));
      contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      
      //ȸ������ â���� ���� ��ư
      JButton btnNewButton = new JButton("ȸ������");
      btnNewButton.setFont(new Font("���� ���", Font.BOLD, 40));
      btnNewButton.setBounds(461, 270, 344, 203);
      btnNewButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
             membersetting join = new membersetting();
             join.setVisible(true);
             dispose();
          }
       });
      btnNewButton.setFocusPainted(false);
      contentPane.add(btnNewButton);
      
      JLabel lblNewLabel = new JLabel("ȯ�漳��");
      lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 45));
      lblNewLabel.setBounds(36, 0, 249, 133);
      contentPane.add(lblNewLabel);
      
      // Ȩȭ������ ���ư��� ��ư
      JButton btnNewButton_3 = new JButton("");
      btnNewButton_3.setFocusPainted(false);
      btnNewButton_3.setBorderPainted(false);
      ImageIcon img5 = new ImageIcon("img5/home1.PNG");
      btnNewButton_3.setIcon(img5);
      btnNewButton_3.setBounds(37, 585, 136, 148);
      btnNewButton_3.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
             A2_marineAdminister join = new A2_marineAdminister();
             join.setVisible(true);
             dispose();
          }
       });
      contentPane.add(btnNewButton_3);
      
      /*JButton btn3 = new JButton("");
		btn3.setFocusPainted(false);
		btn3.setBorderPainted(false);
		ImageIcon img5 = new ImageIcon("img5/home.PNG");
		btn3.setIcon(img5);
		btn3.setBounds(1081, 593, 136, 148);
		  btn3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	               A_marine join = new A_marine();
	               join.setVisible(true);
	               dispose();
	            }
	         });
		contentPane.add(btn3);*/
   }
}
package main;
//메인창 - 로그인 전
/*
 * 송유빈
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import java.awt.Canvas;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.event.*;

public class A_marine extends JFrame{

   public JPanel contentPane;
   private JTextField textField;
   JButton btnLogin;

   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               A_marine frame = new A_marine();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   public A_marine() {
	   //창설정
      setTitle("수산물 위판정보 프로그램");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100,1300,800);
      setResizable(false);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(224, 255, 255));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      //화면 제목
      JLabel label = new JLabel("수산물 위판정보 프로그램");
      label.setHorizontalAlignment(SwingConstants.CENTER);
      label.setBounds(270, 12, 772, 54);
      label.setFont(new Font("맑은 고딕", Font.PLAIN, 45));
      contentPane.add(label);
      
     
      //메인창 센터아래 주소
      textField = new JTextField();
      textField.setBackground(new Color(224, 255, 255));
      textField.setHorizontalAlignment(SwingConstants.CENTER);
      textField.setEditable(false);
      textField.setText("우)31460 충남 아산시 탕정면 선문로 221번길 70 선문대학교 인문관 410호");
      textField.setBorder(null);
      textField.setBounds(379, 701, 549, 24);
      contentPane.add(textField);
      textField.setColumns(10);
      
      //로그인화면으로 넘어가는 버튼
      btnLogin = new JButton("LOGIN");
      btnLogin.setForeground(new Color(0, 0, 0));
      btnLogin.setFont(new Font("맑은 고딕", Font.BOLD, 35));
      btnLogin.setBounds(1051, 141, 150, 60);
      btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
               login_J join = new login_J();
               join.setVisible(true);
               dispose();
            }
         });
      btnLogin.setFocusPainted(false);
      

      contentPane.add(btnLogin);
      
      //이미지삽입
      JLabel Label = new JLabel("");
      ImageIcon img = new ImageIcon("img/menu icon3.PNG");
      Label.setIcon(img);
      Label.setBounds(25, 155, 70, 50);
      contentPane.add(Label);
      
      //이미지삽입
      JLabel Label1 = new JLabel("");
      ImageIcon img1 = new ImageIcon("img1/Fish1.PNG");
      Label1.setIcon(img1);
      Label1.setBounds(457, 193, 423, 373);
      contentPane.add(Label1);
      
      //이미지삽입
      JLabel Label2 = new JLabel("");
      ImageIcon img2 = new ImageIcon("img2/seaweed.PNG");
      Label2.setIcon(img2);
      Label2.setBounds(923, 585, 359, 168);
      contentPane.add(Label2);
      
      //이미지삽입
      JLabel Label3 = new JLabel("");
      ImageIcon img4 = new ImageIcon("img4/seaweed.PNG");
      Label3.setIcon(img4);
      Label3.setBounds(0, 587, 345, 166);
      contentPane.add(Label3);
      
    
   }
}
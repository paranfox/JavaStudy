package edu.java.booklist;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.*;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class AdminsearchUser extends JFrame { 
 
	private JPanel contentPane;
	private JTextField textUserName;
	private JTextField textUserId;
	private JTextField textUserPassword;
	private JTextField textUserPhone;
	private JTextField textUserEmail;
	private JTextField textUserGander;
	private JTextField textUserBirthdate;

	private static UserDAO userdao;
	private JTextField textSerchUserName;
	
	public AdminsearchUser() {
		
		try {
			userdao = UserDAOImple.getInstance();
		} catch (Exception e) {

		} // 다형성. 싱글톤 인스턴스 생성
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 480, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원정보");
		lblNewLabel.setBounds(184, 10, 57, 15);
		contentPane.add(lblNewLabel);
		
		textUserName = new JTextField();
		textUserName.setBounds(248, 37, 116, 21);
		contentPane.add(textUserName);
		textUserName.setColumns(10);
		
		textUserId = new JTextField();
		textUserId.setColumns(10);
		textUserId.setBounds(248, 68, 116, 21);
		contentPane.add(textUserId);
		
		textUserPassword = new JTextField();
		textUserPassword.setColumns(10);
		textUserPassword.setBounds(248, 98, 116, 21);
		contentPane.add(textUserPassword);
		
		textUserPhone = new JTextField();
		textUserPhone.setColumns(10);
		textUserPhone.setBounds(248, 129, 116, 21);
		contentPane.add(textUserPhone);
		
		textUserEmail = new JTextField();
		textUserEmail.setColumns(10);
		textUserEmail.setBounds(248, 160, 116, 21);
		contentPane.add(textUserEmail);
		
		textUserGander = new JTextField();
		textUserGander.setColumns(10);
		textUserGander.setBounds(248, 194, 116, 21);
		contentPane.add(textUserGander);
		
		JLabel lblUserName = new JLabel("이름");
		lblUserName.setBounds(110, 40, 57, 15);
		contentPane.add(lblUserName);
		
		JLabel lblUserID = new JLabel("아이디");
		lblUserID.setBounds(110, 71, 57, 15);
		contentPane.add(lblUserID);
		
		JLabel lblUserPassword = new JLabel("페스워드");
		lblUserPassword.setBounds(110, 101, 57, 15);
		contentPane.add(lblUserPassword);
		
		JLabel lblUserPhone = new JLabel("전화번호");
		lblUserPhone.setBounds(110, 132, 57, 15);
		contentPane.add(lblUserPhone);
		
		JLabel lblUserEmail = new JLabel("이메일");
		lblUserEmail.setBounds(110, 163, 57, 15);
		contentPane.add(lblUserEmail);
		
		JLabel lblUserGander = new JLabel("성별");
		lblUserGander.setBounds(110, 197, 57, 15);
		contentPane.add(lblUserGander);
		
		JLabel lblUserBirthdate = new JLabel("생일");
		lblUserBirthdate.setBounds(110, 222, 57, 15);
		contentPane.add(lblUserBirthdate);
		
		textUserBirthdate = new JTextField();
		textUserBirthdate.setBounds(248, 225, 116, 21);
		contentPane.add(textUserBirthdate);
		textUserBirthdate.setColumns(10);
		
		JButton btnUserUpdate = new JButton("수정");
		btnUserUpdate.setBounds(344, 266, 97, 23);
		contentPane.add(btnUserUpdate);
		
		textSerchUserName = new JTextField();
		textSerchUserName.setBounds(24, 267, 116, 21);
		contentPane.add(textSerchUserName);
		textSerchUserName.setColumns(10);
		
		JButton btnSerchUserName = new JButton("회원이름 찾기");
		btnSerchUserName.setBounds(173, 266, 121, 23);
		contentPane.add(btnSerchUserName);
	} // end AdminsearchUser()
}

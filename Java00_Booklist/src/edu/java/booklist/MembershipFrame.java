package edu.java.booklist;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MembershipFrame extends JFrame implements USE_FRAME_CODE {

	private static JPanel contentPane;
	private static JTextField textName;
	private static JTextField textId;
	private static JTextField textPassword;
	
	private static UserDAOImple userdao; // UserDAOImple 인스턴스 생성

	
	public MembershipFrame() {
		try {
			userdao = UserDAOImple.getInstance();
		} catch (Exception e) {

		} // 다형성. 싱글톤 인스턴스 생성
		
		setBounds(setBounds_Width, setBounds_Height, 454, 349);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlightText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textName = new JTextField();
		textName.setBounds(244, 34, lbl_Width, lbl_Height);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(244, 100, 137, 42);
		contentPane.add(textId);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(244, 171, 137, 42);
		contentPane.add(textPassword);
		
		JLabel lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("굴림", Font.BOLD, 27));
		lblName.setBackground(Color.CYAN);
		lblName.setOpaque(true);
		lblName.setBounds(46, 34, lbl_Width, lbl_Height);
		contentPane.add(lblName);
		
		JLabel lblId = new JLabel("아이디");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("굴림", Font.BOLD, 27));
		lblId.setBackground(Color.CYAN);
		lblId.setOpaque(true);
		lblId.setBounds(46, 100, lbl_Width, lbl_Height);
		contentPane.add(lblId);
		
		JLabel lblPassword = new JLabel("비밀번호");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("굴림", Font.BOLD, 27));
		lblPassword.setBackground(Color.CYAN);
		lblPassword.setOpaque(true);
		lblPassword.setBounds(46, 171, lbl_Width, lbl_Height);
		contentPane.add(lblPassword);
		
		
		JButton btnNewMembership = new JButton("회원등록");
		btnNewMembership.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check = InsertUser();
//				System.out.println(check);
				if(check == 1) {
					dispose();
//					System.exit(0); 화면 전체 종료
					NewMembership newmembership = new NewMembership();
					newmembership.setVisible(true);
				} else {
					return;
				}
				
			}

		});
		btnNewMembership.setBounds(163, 251, 97, 23);
		contentPane.add(btnNewMembership);
		
	} // end MembershipFrame()
	
	private static int InsertUser() {
		System.out.println("--- 회원 정보 등록 ---");
		System.out.println("이름 입력>");
		String name = textName.getText();
		System.out.println("아이디 입력>");
		String userid = textId.getText();
		System.out.println("비밀번호 입력>");
		String userpassword = textPassword.getText();
		System.out.println("등록");
		if (name.equals("") || userid.equals("") || userpassword.equals("")) {
			return 0;
		}
		
		UserVO uservo = new UserVO(userid, userpassword, name);
		System.out.println("정보 저장");
		int check = userdao.userinsert(uservo);
		
//		int check = 1;
		System.out.println(check); // log
		return check;
		
	} // end InsertUser()

	
} // end MembershipFrame

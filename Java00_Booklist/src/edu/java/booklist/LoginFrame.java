package edu.java.booklist;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LoginFrame extends JFrame implements USE_FRAME_CODE { 

	private JPanel contentPane;
	private static JTextField textId;
	private static JTextField textPassword;
	
	private static UserDAOImple userdao; // UserDAOImple 인스턴스 생성

	public LoginFrame(JFrame frame) {
		try {
			userdao = UserDAOImple.getInstance();
		} catch (Exception e) {

		} // 다형성. 싱글톤 인스턴스 생성

		setBounds(setBounds_Width, setBounds_Height, 454, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(244, 68, 137, 42);
		contentPane.add(textId);

		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(244, 147, 137, 42);
		contentPane.add(textPassword);

		JLabel lblId = new JLabel("아이디");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("굴림", Font.BOLD, 27));
		lblId.setBackground(Color.CYAN);
		lblId.setOpaque(true);
		lblId.setBounds(46, 68, 137, 42);
		contentPane.add(lblId);

		JLabel lblPassword = new JLabel("비밀번호");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("굴림", Font.BOLD, 27));
		lblPassword.setBackground(Color.CYAN);
		lblPassword.setOpaque(true);
		lblPassword.setBounds(46, 147, 137, 42);
		contentPane.add(lblPassword);

		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check = SeleteUser();
//				System.out.println(check);
				if (check == 1) {
					dispose();
//					System.exit(0); 화면 전체 종료
					Welcome welcome = new Welcome(UserId());
					welcome.setVisible(true);
					frame.setVisible(false);
				} else {
					return;
				}

			}


		});
		btnLogin.setBounds(163, 251, 97, 23);
		contentPane.add(btnLogin);

	} // LoginFrame()
	
	private String UserId() {
		String userid = textId.getText();
		
		return userid;
	} // end UserId()

	private int SeleteUser() {
		System.out.println("--- 회원 정보 확인 ---");
		System.out.println("아이디 입력>");
		String userid = textId.getText();
		System.out.println("비밀번호 입력>");
		String userpassword = textPassword.getText();
		if (userid.equals("") || userpassword.equals("")) {
			Usercheck usercheck = new Usercheck();
			usercheck.setVisible(true);
			return 0;
		}
		
		UserVO uservo = new UserVO(userid, userpassword);
		System.out.println("정보 저장");
		int check = userdao.usercheck(uservo);
		
//		int check = 1;
		System.out.println(check); // log
		return check;
	} // end SeleteUser()
} // LoginFrame
package edu.java.booklist;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookslistMain { 

	private JFrame frame;

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookslistMain window = new BookslistMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookslistMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(850, 500, 263, 114);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 일반적으로 새로운 프레임이나, 다이얼로그를 생성할 때는
				// 각 클래스들을 상속받는 자식 클래스를 만들어서 사용하는 것이
				// 편의성 면에서 더 좋음
				LoginFrame loginframe = new LoginFrame(frame); // Myframe작업이 다끝나고 출력
				loginframe.setVisible(true);
//				frame.setVisible(false); // 메인 프레임을 안보이게
				
			}
		});
		btnLogin.setBounds(135, 21, 97, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnmembership = new JButton("회원가입");
		btnmembership.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MembershipFrame membershipframe = new MembershipFrame();
				membershipframe.setVisible(true);
				
			}
		});
		btnmembership.setBounds(26, 21, 97, 23);
		frame.getContentPane().add(btnmembership);
		        
	}
}

package edu.java.booklist;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewMembership extends JFrame implements USE_FRAME_CODE { 

	private JPanel contentPane;
	
	public NewMembership() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(setBounds_Width, setBounds_Height, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		 
		JButton btnmain = new JButton("회원가입을 축하합니다.");
		btnmain.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnmain.setFont(new Font("굴림", Font.BOLD, 30));
		contentPane.add(btnmain, BorderLayout.CENTER);
		
	} // end NewMembership

}

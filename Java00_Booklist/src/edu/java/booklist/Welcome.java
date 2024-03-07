package edu.java.booklist;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Welcome extends JFrame implements USE_FRAME_CODE {

	private JPanel contentPane;

	
	public Welcome(String user_id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(setBounds_Width, setBounds_Height, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnmain = new JButton("로그인 되셨습니다!");
		btnmain.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				AdminFrame adminframe = new AdminFrame(user_id);
				adminframe.setVisible(true);
				dispose();
			}
		});
		btnmain.setFont(new Font("굴림", Font.BOLD, 30));
		contentPane.add(btnmain, BorderLayout.CENTER);
		
	} // end Welcome

}

package edu.java.gui12;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class MyFrame extends JFrame { // main 지울 것!

	private JPanel contentPane; // getcontentpane과 같은 말이 된다.

	
	public MyFrame(String text) {
		
		// JFrame.EXIT_ON_CLOSE : 프로그램 전체 종료
		// JFrame.DISPOSE_ON_CLOSE : 현재 창만 종료
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		contentPane = new JPanel(); // frame.getContentPane() 동일
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton(text);
		contentPane.add(btnNewButton, BorderLayout.CENTER);
		
	}

}

package edu.java.gui11;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiMain11 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain11 window = new GuiMain11();
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
	public GuiMain11() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btn1 = new JButton("New Frame");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				JFrame myFrame = new JFrame();
//				myFrame.setBounds(10, 10, 400, 400);
//				myFrame.setVisible(true);
				
				// 일반적으로 새로운 프레임이나, 다이얼로그를 생성할 때는
				// 각 클래스들을 상속받는 자식 클래스를 만들어서 사용하는 것이
				// 편의성 면에서 더 좋음
				MyFrame myframe = new MyFrame(); // Myframe작업이 다끝나고 출력
				myframe.setVisible(true);
//				frame.setVisible(false); // 메인 프레임을 안보이게
			}
		});
		btn1.setFont(new Font("굴림", Font.PLAIN, 30));
		btn1.setBounds(12, 10, 410, 107);
		frame.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("New Dialog");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyDialog myDialog = new MyDialog();
				myDialog.setVisible(true);
			}
		});
		btn2.setFont(new Font("굴림", Font.PLAIN, 30));
		btn2.setBounds(12, 127, 410, 107);
		frame.getContentPane().add(btn2);
	}

}

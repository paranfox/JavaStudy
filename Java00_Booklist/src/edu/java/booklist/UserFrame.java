package edu.java.booklist;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class UserFrame extends JFrame { 

	private JPanel contentPane;
	
	private static UserDAOImple userdao; // UserDAOImple 인스턴스 생성
	private JTextField textbookname;
	private JTextField textbookserch;

	
	public UserFrame(String user_id) {
		try {
			userdao = UserDAOImple.getInstance();
		} catch (Exception e) {

		} // 다형성. 싱글톤 인스턴스 생성
		
		
		setBounds(100, 100, 769, 536);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("환영합니다!");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(192, 9, 204, 58);
		contentPane.add(lblNewLabel);
		
		JLabel lbl_user_name = new JLabel(userdao.username(user_id) + "님");
		lbl_user_name.setFont(new Font("굴림", Font.PLAIN, 28));
		lbl_user_name.setBounds(392, 22, 237, 33);
		contentPane.add(lbl_user_name);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 100, 500, 364);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblbook = new JLabel("도서 정보");
		lblbook.setFont(new Font("나눔고딕", Font.BOLD, 15));
		lblbook.setBounds(551, 78, 78, 18);
		contentPane.add(lblbook);
		
		JLabel lblNewLabel_1 = new JLabel("제목으로 검색");
		lblNewLabel_1.setBounds(515, 100, 84, 15);
		contentPane.add(lblNewLabel_1);
		
		textbookname = new JTextField();
		textbookname.setBounds(601, 97, 116, 21);
		contentPane.add(textbookname);
		textbookname.setColumns(10);
		
		JButton btnFindBook = new JButton("찾기");
		btnFindBook.setBounds(620, 128, 97, 23);
		contentPane.add(btnFindBook);
		
		JButton btnexit = new JButton("종료");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnexit.setBounds(644, 9, 97, 23);
		contentPane.add(btnexit);
		
		JLabel lblbookserch = new JLabel("검색");
		lblbookserch.setHorizontalAlignment(SwingConstants.CENTER);
		lblbookserch.setFont(new Font("굴림", Font.BOLD, 16));
		lblbookserch.setBounds(12, 69, 57, 21);
		contentPane.add(lblbookserch);
		
		textbookserch = new JTextField();
		textbookserch.setFont(new Font("굴림", Font.PLAIN, 16));
		textbookserch.setBounds(70, 69, 204, 21);
		contentPane.add(textbookserch);
		textbookserch.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("도서제목");
		chckbxNewCheckBox.setBounds(282, 61, 115, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("대출상태");
		chckbxNewCheckBox_1.setBounds(401, 69, 115, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
	} // end UserFrame()
} // end UserFrame

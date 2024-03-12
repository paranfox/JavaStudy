package edu.java.booklist;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class UserFrame extends JFrame { 

	private JPanel contentPane;
	
	private static UserDAO userdao; // UserDAOImple 인스턴스 생성
	private static BookserviceDAO bookservicedao; // BookserviceDAO 인스턴스 생성
	private static BooklistDAO booklistdao; // BooklistDAO 인스턴스 생성
	
	private static JTextField textbookname;
	private static JTextField textbookserch;
	private static JTextField textfindbookname;
	private static JTextField textbookwriter;
	private static JTextField textbookprice;

	private static String[] header = { "도서제목", "회원명", "대출일자", "상태", "반납날짜" };
	private static Object[] records = new Object[header.length];
	private static DefaultTableModel model; // 테이블 형태를 만들 변수
	private static JTable table;

	
	public UserFrame(String user_id) {

		try {
			userdao = UserDAOImple.getInstance();
			bookservicedao = BookserviceDAOImple.getInstance();
			booklistdao = BooklistDAOImple.getInstance();
		} catch (Exception e) {

		} // 다형성. 싱글톤 인스턴스 생성

		setBounds(700, 250, 785, 625);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmuserinterface = new JMenuItem("회원 정보 수정");
		mnNewMenu.add(mntmuserinterface);
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
		scrollPane.setBounds(12, 100, 437, 418);
		contentPane.add(scrollPane);

		JLabel lblbook = new JLabel("도서 정보");
		lblbook.setFont(new Font("나눔고딕", Font.BOLD, 15));
		lblbook.setBounds(461, 80, 78, 18);
		contentPane.add(lblbook);

		JLabel lblbooklook = new JLabel("제목으로 검색");
		lblbooklook.setBounds(461, 108, 84, 15);
		contentPane.add(lblbooklook);

		JButton btnfindbook = new JButton("검색");
		btnfindbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}

		});
		btnfindbook.setBounds(660, 104, 97, 23);
		contentPane.add(btnfindbook);

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

		JCheckBox chckbxbookname = new JCheckBox("도서제목");
		chckbxbookname.setBounds(282, 68, 78, 25);
		contentPane.add(chckbxbookname);

		JCheckBox chckbxwritername = new JCheckBox("저자명");
		chckbxwritername.setBounds(359, 69, 90, 23);
		contentPane.add(chckbxwritername);

		textbookserch = new JTextField();

		textbookserch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxbookname.isSelected() && chckbxwritername.isSelected()) { // 도서제목과 회원명 찾기
					
				} else if (chckbxwritername.isSelected()) { // 회원명 찾기
					
				} else if (chckbxbookname.isSelected()) { // 도서제목 찾기
					
				} else {
					textbookserch.setText("도서제목이나 회원명을 눌러주세요~");
				}

			}

		});
		textbookserch.setFont(new Font("굴림", Font.PLAIN, 16));
		textbookserch.setBounds(70, 69, 204, 21);
		contentPane.add(textbookserch);
		textbookserch.setColumns(10);

		JLabel lblBookPicture = new JLabel("사진");
		lblBookPicture.setBounds(461, 136, 133, 165);
		contentPane.add(lblBookPicture);

		JLabel lblbookname = new JLabel("제목");
		lblbookname.setBounds(606, 133, 57, 15);
		contentPane.add(lblbookname);

		JLabel lblbookwriter = new JLabel("저자");
		lblbookwriter.setBounds(606, 194, 57, 15);
		contentPane.add(lblbookwriter);

		JLabel lblbookprice = new JLabel("대출 상태");
		lblbookprice.setBounds(606, 260, 57, 15);
		contentPane.add(lblbookprice);

		textfindbookname = new JTextField();
		textfindbookname.setEditable(false);
		textfindbookname.setColumns(10);
		textfindbookname.setBounds(606, 158, 143, 21);
		contentPane.add(textfindbookname);

		textbookwriter = new JTextField();
		textbookwriter.setEditable(false);
		textbookwriter.setColumns(10);
		textbookwriter.setBounds(606, 219, 143, 21);
		contentPane.add(textbookwriter);

		textbookprice = new JTextField();
		textbookprice.setEditable(false);
		textbookprice.setColumns(10);
		textbookprice.setBounds(606, 291, 143, 21);
		contentPane.add(textbookprice);

		textbookname = new JTextField();
		textbookname.setBounds(549, 105, 106, 21);
		contentPane.add(textbookname);
		textbookname.setColumns(10);

		// 테이블 초기화
		model = new DefaultTableModel(header, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				Object value = table.getValueAt(row, col);
				System.out.println(value);
			}
		});
		table.setFont(new Font("굴림", Font.PLAIN, 15));

		scrollPane.setViewportView(table);
		selectAllContactTable();
		
	} // end UserFrame()
	
	
	// 전체 태이블 찾기
		private static void selectAllContactTable() {
			ArrayList<BookTableVO> list = bookservicedao.bookallselect();

			System.out.println(list);
			model.setRowCount(0);
			System.out.println(list.size());
			for (int i = 0; i < list.size(); i++) {
				records[0] = list.get(i).getBookname().isBlank();
				records[1] = list.get(i).getUserid();
				records[2] = list.get(i).getBookserviceouttime();
				if (list.get(i).getBookserviceinout().equals("대여")) {
					records[3] = "대여중";
				} else if ((list.get(i).getBookserviceinout().equals("반납"))) {
					records[3] = "반납";
				} else {
					records[3] = "보관중";
				}
				records[4] = list.get(i).getBookserviceintime();
				model.addRow(records);
			}

		} // end selectAllContactTable()
} // end UserFrame

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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Choice;
import java.awt.Button;
import javax.swing.JPasswordField;

public class UserFrame extends JFrame {

	private JPanel contentPane;

	private static UserDAO userdao; // UserDAOImple 인스턴스 생성
	private static BookserviceDAO bookservicedao; // BookserviceDAO 인스턴스 생성
	private static BooklistDAO booklistdao; // BooklistDAO 인스턴스 생성

	private static JTextField textbookname;
	private static JTextField textbookserch;
	private static JTextField textfindbookname;
	private static JTextField textbookwriter;
	private static JTextField textbookinout;
	private static String selectchoice = null;

	private static String[] header = { "도서제목", "저자명", "대출일자", "상태", "반납날짜" };
	private static Object[] records = new Object[header.length];
	private static DefaultTableModel model; // 테이블 형태를 만들 변수
	private static JTable table;

	private static String[] allheader = { "도서명", "저자명", "카테고리" };
	private static Object[] allrecords = new Object[header.length];
	private static DefaultTableModel allmodel; // 테이블 형태를 만들 변수
	private static JTable alltable;

	public UserFrame(String user_id, JFrame frame) {

		try {
			userdao = UserDAOImple.getInstance();
			bookservicedao = BookserviceDAOImple.getInstance();
			booklistdao = BooklistDAOImple.getInstance();
		} catch (Exception e) {

		} // 다형성. 싱글톤 인스턴스 생성

		setBounds(700, 250, 895, 625);

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

		Choice choice = new Choice();
		choice.addItem("검색");
		choice.addItem("도서제목");
		choice.addItem("저자명");
		choice.addItem("카테고리");
		choice.setBounds(437, 104, 78, 21);
		contentPane.add(choice);

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
		scrollPane.setBounds(447, 363, 419, 160);
		contentPane.add(scrollPane);

		JLabel lblbook = new JLabel("도서 정보");
		lblbook.setFont(new Font("나눔고딕", Font.BOLD, 15));
		lblbook.setBounds(461, 80, 78, 18);
		contentPane.add(lblbook);

		JButton btnfindbook = new JButton("검색");
		btnfindbook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (choice.getSelectedIndex()) {
				case 1:
					selectchoice = "도서제목";
					break;
				case 2:
					selectchoice = "저자명";
					break;
				case 3:
					selectchoice = "카테고리";
					break;
				default:
					selectchoice = "검색할 내용을 정해주세요";
					textbookname.setText(selectchoice);
					return;
				}
				booknameserch(selectchoice);

			}

		});
		btnfindbook.setBounds(667, 104, 97, 23);
		contentPane.add(btnfindbook);

		JButton btnexit = new JButton("종료");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnexit.setBounds(769, 9, 97, 23);
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
					textbookserch.setText("도서제목이나 저자명을 눌러주세요~");
				}

			}

		});
		textbookserch.setFont(new Font("굴림", Font.PLAIN, 16));
		textbookserch.setBounds(70, 69, 204, 21);
		contentPane.add(textbookserch);
		textbookserch.setColumns(10);

		JLabel lblBookPicture = new JLabel("사진");
		lblBookPicture.setBounds(443, 136, 151, 165);
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

		textbookinout = new JTextField();
		textbookinout.setEditable(false);
		textbookinout.setColumns(10);
		textbookinout.setBounds(606, 291, 143, 21);
		contentPane.add(textbookinout);

		textbookname = new JTextField();
		textbookname.setBounds(521, 105, 134, 21);
		contentPane.add(textbookname);
		textbookname.setColumns(10);

		JButton btnBookOut = new JButton("대여");
		btnBookOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check = bookseleterentar(textfindbookname.getText());
				if (check > 0) {
					System.out.println("대여가능");
					BOOK_RENTAL_COUNT_DOWN(textfindbookname.getText(), user_id);
				} else {
					System.out.println("대여불가능");
					return;
				}
			}



		});
		btnBookOut.setBounds(769, 104, 97, 23);
		contentPane.add(btnBookOut);

		JButton btnLogOut = new JButton("로그아웃");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				dispose();
			}
		});
		btnLogOut.setBounds(667, 9, 97, 23);
		contentPane.add(btnLogOut);

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
				System.out.println(row);
				int col = table.getSelectedColumn();
				System.out.println(col);
				Object value = table.getValueAt(row, 0); // row = 행(세로), col = 열
				System.out.println(value);
				selectbookname(value.toString());
				
			}
		});
		table.setFont(new Font("굴림", Font.PLAIN, 15));

		scrollPane.setViewportView(table);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 104, 419, 419);
		contentPane.add(scrollPane_1);

		// 테이블 초기화
		allmodel = new DefaultTableModel(allheader, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		alltable = new JTable(allmodel);
		alltable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = alltable.getSelectedRow();
				System.out.println(row);
				int col = alltable.getSelectedColumn();
				System.out.println(col);
				Object value = alltable.getValueAt(row, 0); // row = 행(세로), col = 열
				System.out.println(value);
				selectbookname(value.toString());
				
			}

		});
		alltable.setFont(new Font("굴림", Font.PLAIN, 15));

		scrollPane_1.setViewportView(alltable);

		JButton btnBookIn = new JButton("반납");
		btnBookIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BOOK_RENTAL_COUNT_UP(textfindbookname.getText(), user_id);
				selectAllContactTable(user_id);
			}
		});
		btnBookIn.setBounds(769, 137, 97, 23);
		contentPane.add(btnBookIn);

		selectAllContactTable(user_id);
//		selectAllBookListTable();		
	} // end UserFrame()

	// 전체 태이블 찾기
	private static void selectAllContactTable(String userid) {
		ArrayList<BookTableVO> list = bookservicedao.bookallselectwriter(userid);

		System.out.println(list);
		model.setRowCount(0);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			records[0] = list.get(i).getBookname();
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

	// 전체 책리스트 태이블 찾기
//		private static void selectAllBookListTable() {
//			ArrayList<BookTableVO> list = bookservicedao.bookallselectwriter();
//
//			System.out.println(list);
//			allmodel.setRowCount(0);
//			System.out.println(list.size());
//			for (int i = 0; i < list.size(); i++) {
//				allrecords[0] = list.get(i).getBookname();
//				allrecords[1] = list.get(i).getUserid();
//				allrecords[2] = list.get(i).getBookserviceouttime();
//				allrecords[3] = list.get(i).getBookserviceintime();
//				allmodel.addRow(allrecords);
//			}
//
//		} // end selectAllBookListTable()
//	
//	// 책 대여하기
//	private void bookseleterentar(String bookname) {
//		bookservicedao.bookinoutselect(bookname);

//	} // end bookseleterentar()
	// 책 대여가능한지 불가능한지 확인 메소드
	private int bookseleterentar(String bookname) {
		int bookrentalcount = bookservicedao.bookinoutselect(bookname);
		return bookrentalcount;
	} // end bookseleterentar()

	// choice으로 선택한 것을 기준으로 검색
	private void booknameserch(String selectchoice) {
		switch (selectchoice) {
		case "도서제목":
			selectchoice = "BOOK_NAME";
			break;
		case "저자명":
			selectchoice = "BOOK_WRITER";
			break;
		case "카테고리":
			selectchoice = "BOOK_CATEGORY";
			break;
		default:
			break;
		}
		ArrayList<BookTableVO> list = bookservicedao.searchbookchoice(selectchoice, textbookname.getText());
		
		System.out.println(list);
		allmodel.setRowCount(0);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			allrecords[0] = list.get(i).getBookname();
			allrecords[1] = list.get(i).getBookwriter();
			allrecords[2] = list.get(i).getBookcategory();
			allmodel.addRow(allrecords);
		}
	
	} // end booknameserch()

	private void selectbookname(String bookname) {
		BookTableVO vo = bookservicedao.searchallbookname(bookname);
		textfindbookname.setText(vo.getBookname());
		textbookwriter.setText(vo.getBookwriter());
		int check = bookseleterentar(textfindbookname.getText());
		if (check > 0) {
			textbookinout.setText("대여가능");
		} else {
			textbookinout.setText("대여불가능");
		}
	
	} // end selectbookname()
	

	private void BOOK_RENTAL_COUNT_DOWN(String bookname, String user_id) {
		int check = bookservicedao.bookinoutcheck(bookname, user_id);
		if(check == 1) {
			System.out.println("대여중");
			return;
		} else if (check == 2) {
			System.out.println("반납");
		}
		bookservicedao.bookouttimeuser(bookname, user_id);
		ArrayList<BookTableVO> list = bookservicedao.bookouttime(bookname, user_id);

		System.out.println(list);
		model.setRowCount(0);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			records[0] = list.get(i).getBookname();
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
	} // end BOOK_RENTAL_COUNT_DOWN

	private void BOOK_RENTAL_COUNT_UP(String bookname, String user_id) {
		bookservicedao.bookintime(bookname, user_id);
		
		
	}  // end BOOK_RENTAL_COUNT_UP()
	
}
// end UserFrame

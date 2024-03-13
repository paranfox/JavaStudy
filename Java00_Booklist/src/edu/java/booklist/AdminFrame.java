package edu.java.booklist;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

public class AdminFrame extends JFrame {

	private JPanel contentPane;

	private static UserDAO userdao; // UserDAO 인스턴스 생성
	private static BookserviceDAO bookservicedao; // BookserviceDAO 인스턴스 생성
	private static BooklistDAO booklistdao; // BooklistDAO 인스턴스 생성

	private static JTextField textbookname;
	private static JTextField textbookserch;
	private static JTextField textuaername;
	private static JTextField textusername;
	private static JTextField textuserbirth;
	private static JTextField textuserphone;
	private static JTextField textfindbookname;
	private static JTextField textbookwriter;
	private static JTextField textbookinout;

	private static String[] header = { "도서제목", "회원명", "대출일자", "상태", "반납날짜" };
	private static Object[] records = new Object[header.length];
	private static DefaultTableModel model; // 테이블 형태를 만들 변수
	private static JTable table;

	// 이건 이클립스 경고 메세지를 없애기 위한 버전
	private static final long serialVersionUID = 1L;
	// 이미지를 저장할 apple과 가로 길이의 w, 세로 길이의 h
	private Image apple;
	private int w;
	private int h;

	public AdminFrame(String user_id) {

		try {
			userdao = UserDAOImple.getInstance();
			bookservicedao = BookserviceDAOImple.getInstance();
			booklistdao = BooklistDAOImple.getInstance();
		} catch (Exception e) {

		} // 다형성. 싱글톤 인스턴스 생성

		setBounds(700, 250, 769, 625);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("menu");
		menuBar.add(mnNewMenu);

		JMenuItem mntmbook = new JMenuItem("책관리");
		mnNewMenu.add(mntmbook);

		JMenuItem mntmuser = new JMenuItem("유저관리");
		mntmuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminsearchUser adminsearchUser = new AdminsearchUser();
				adminsearchUser.setVisible(true);
			}
		});
		mnNewMenu.add(mntmuser);
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
		lblbook.setBounds(461, 300, 78, 18);
		contentPane.add(lblbook);

		JLabel lblbooklook = new JLabel("제목으로 검색");
		lblbooklook.setBounds(455, 328, 84, 15);
		contentPane.add(lblbooklook);

		JButton btnfindbook = new JButton("검색");
		btnfindbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findbook();
			}

		});
		btnfindbook.setBounds(658, 324, 97, 23);
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

		JCheckBox chckbxusername = new JCheckBox("회원명");
		chckbxusername.setBounds(359, 69, 90, 23);
		contentPane.add(chckbxusername);

		textbookserch = new JTextField();

		textbookserch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxbookname.isSelected() && chckbxusername.isSelected()) { // 도서제목과 회원명 찾기
					searchbookusername();
				} else if (chckbxusername.isSelected()) { // 회원명 찾기
					searchusername();
				} else if (chckbxbookname.isSelected()) { // 도서제목 찾기
					searchbookname();
				} else {
					textbookserch.setText("도서제목이나 회원명을 눌러주세요~");
				}

			}

		});
		textbookserch.setFont(new Font("굴림", Font.PLAIN, 16));
		textbookserch.setBounds(70, 69, 204, 21);
		contentPane.add(textbookserch);
		textbookserch.setColumns(10);

		JLabel lbluser = new JLabel("회원 정보");
		lbluser.setFont(new Font("나눔고딕", Font.BOLD, 15));
		lbluser.setBounds(461, 73, 78, 18);
		contentPane.add(lbluser);

		JLabel lblusernamesearch = new JLabel("이름으로 검색");
		lblusernamesearch.setBounds(455, 101, 84, 15);
		contentPane.add(lblusernamesearch);

		textuaername = new JTextField();
		textuaername.setColumns(10);
		textuaername.setBounds(540, 97, 106, 21);
		contentPane.add(textuaername);

		JLabel lblUserPicture = new JLabel("사진");
		lblUserPicture.setBounds(461, 125, 133, 165);
		contentPane.add(lblUserPicture);

		JLabel lblBookPicture = new JLabel("사진");
		lblBookPicture.setBounds(461, 353, 133, 165);
		contentPane.add(lblBookPicture);

		JButton btnfinduser = new JButton("찾기");
		btnfinduser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon IMAGE_ICONS = new ImageIcon("img/book1.jpg");
				lblUserPicture.setIcon(IMAGE_ICONS);
				selectUser();
			}
		});
		btnfinduser.setBounds(656, 96, 97, 23);
		contentPane.add(btnfinduser);

		JLabel lblusername = new JLabel("이름");
		lblusername.setBounds(598, 128, 57, 15);
		contentPane.add(lblusername);

		textusername = new JTextField();
		textusername.setEditable(false);
		textusername.setBounds(598, 153, 143, 21);
		contentPane.add(textusername);
		textusername.setColumns(10);

		JLabel lbluserbirth = new JLabel("생년월일");
		lbluserbirth.setBounds(598, 184, 57, 15);
		contentPane.add(lbluserbirth);

		textuserbirth = new JTextField();
		textuserbirth.setEditable(false);
		textuserbirth.setColumns(10);
		textuserbirth.setBounds(598, 209, 143, 21);
		contentPane.add(textuserbirth);

		JLabel lbluserphone = new JLabel("전화번호");
		lbluserphone.setBounds(598, 240, 57, 15);
		contentPane.add(lbluserphone);

		textuserphone = new JTextField();
		textuserphone.setEditable(false);
		textuserphone.setColumns(10);
		textuserphone.setBounds(598, 258, 143, 21);
		contentPane.add(textuserphone);

		JLabel lblbookname = new JLabel("제목");
		lblbookname.setBounds(598, 357, 57, 15);
		contentPane.add(lblbookname);

		JLabel lblbookwriter = new JLabel("저자");
		lblbookwriter.setBounds(598, 405, 57, 15);
		contentPane.add(lblbookwriter);

		JLabel lblbookinout = new JLabel("대여상태");
		lblbookinout.setBounds(598, 456, 57, 15);
		contentPane.add(lblbookinout);

		textfindbookname = new JTextField();
		textfindbookname.setEditable(false);
		textfindbookname.setColumns(10);
		textfindbookname.setBounds(598, 374, 143, 21);
		contentPane.add(textfindbookname);

		textbookwriter = new JTextField();
		textbookwriter.setEditable(false);
		textbookwriter.setColumns(10);
		textbookwriter.setBounds(598, 425, 143, 21);
		contentPane.add(textbookwriter);

		textbookinout = new JTextField();
		textbookinout.setEditable(false);
		textbookinout.setColumns(10);
		textbookinout.setBounds(598, 478, 143, 21);
		contentPane.add(textbookinout);

		textbookname = new JTextField();
		textbookname.setBounds(540, 325, 106, 21);
		contentPane.add(textbookname);
		textbookname.setColumns(10);

		
//		JLabel lblUserPicture = new JLabel("사진");
//		lblUserPicture.setBounds(461, 125, 133, 165);
//		contentPane.add(lblUserPicture);
//		
//		JLabel imgLabel = new JLabel();
//		
//		ImageIcon icon = new ImageIcon(AdminFrame.class.getResource("img/book1.jpg"));
//		
//		// ImageIcon 객체에서 Image 추출
//		Image img = icon.getImage();
//		
//		// 추출된 Image의 크기 조절하여 새로운 Image 객체 생성
//		Image updateImg = img.getScaledInstance(165, 100, Image.SCALE_SMOOTH);
//		
//		// 새로운 Image 객체로 ImageIcon 객체 생성
//		ImageIcon updateIcon = new ImageIcon(updateImg);
//
//		imgLabel.setIcon(updateIcon);
//		
//		// 프레임 설정
//		imgLabel.setBounds(210, 30, 165, 150);
//		imgLabel.setHorizontalAlignment(JLabel.CENTER);
//
//		getContentPane().add(imgLabel);
//
//		setVisible(true);


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
	} // end AdminFrame()

	// 책이름으로 정보 찾기
	private void searchbookname() {
		String serch = textbookserch.getText();
		ArrayList<BookTableVO> list = bookservicedao.searchbookname(serch);

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

	} // end searchbookname()

	// 회원명으로 정보 찾기
	private void searchusername() {
		String serch = textbookserch.getText();
		ArrayList<BookTableVO> list = bookservicedao.searchusername(serch);

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

	} // end searchusername()

	// 책이름과 회원명으로 정보 찾기
	private void searchbookusername() {
		String serch = textbookserch.getText();
		ArrayList<BookTableVO> list = bookservicedao.searchbookusername(serch);

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

	} // end searchbookusername()

	// 전체 태이블 찾기
	private static void selectAllContactTable() {
		ArrayList<BookTableVO> list = bookservicedao.bookallselect();

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

	// 유저 정보 찾기
	private static void selectUser() {
		String username = textuaername.getText();
		UserVO uservo = userdao.userselect(username);
		textusername.setText(uservo.getUsername());
		if (uservo.getUserbirthdate() == null) {
			textuserbirth.setText("아직 생일을 입력하지 않았습니다");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String str = format.format(uservo.getUserbirthdate());
			textuserbirth.setText(str);
		}
		textuserphone.setText(uservo.getUserphone());

	} // end selectUser()

	// 책 정보 찾기(책이름으로)
	private void findbook() {
		String bookname = textbookname.getText();
		BooklistVO booklistvo = booklistdao.bookselect(bookname);
		String inout = null; 
		int check = booklistvo.getBookInOut();
		textfindbookname.setText(booklistvo.getBookName());

		textbookwriter.setText(booklistvo.getBookWriter());

		if(check >= 1) {
			inout = "대여 가능";
			textbookinout.setText(inout);
//			textbookinout.setText(String.valueOf(booklistvo.getBookInOut()));
		} else {
			inout = "대여 불가능";
			textbookinout.setText(inout);
		}

	} // findbook()
} // end AdminFrame

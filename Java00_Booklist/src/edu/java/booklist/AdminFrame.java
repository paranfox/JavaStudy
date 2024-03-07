package edu.java.booklist;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

public class AdminFrame extends JFrame {

	private JPanel contentPane;

	private static UserDAOImple userdao; // UserDAOImple 인스턴스 생성
	private static BookserviceDAOImple bookservicedao; // BookserviceDAOImple 인스턴스 생성
	
	private static JTextField textbookname;
	private static JTextField textbookserch;
	private static JTextField textuaername;
	private static JTextField textusername;
	private static JTextField textuserbirth;
	private static JTextField textuserphone;
	private static JTextField textfindbookname;
	private static JTextField textbookwriter;
	private static JTextField textbookprice;
	

	private static String[] header = { "도서제목", "회원명", "대출일자", "상태", "반납날짜" };
	private static Object[] records = new Object[header.length];
	private static DefaultTableModel model; // 테이블 형태를 만들 변수
	private static JTable table;

	public AdminFrame(String user_id) {
		try {
			userdao = UserDAOImple.getInstance();
		} catch (Exception e) {

		} // 다형성. 싱글톤 인스턴스 생성

		setBounds(700, 250, 769, 625);

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
					textbookserch.setText("도서제목과 회원명");
					selectAllContactTable();
					searchbookusername();
				} else if (chckbxusername.isSelected()) { // 회원명 찾기
					textbookserch.setText("회원명");
					searchusername();
				} else if (chckbxbookname.isSelected()) { // 도서제목 찾기
					textbookserch.setText("도서제목");
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

		JButton btnfinduser = new JButton("찾기");
		btnfinduser.setBounds(656, 96, 97, 23);
		contentPane.add(btnfinduser);

		JLabel lblNewLabel_2 = new JLabel("사진");
		lblNewLabel_2.setBounds(461, 125, 133, 165);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("사진");
		lblNewLabel_2_1.setBounds(461, 353, 133, 165);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblusername = new JLabel("이름");
		lblusername.setBounds(598, 128, 57, 15);
		contentPane.add(lblusername);

		textusername = new JTextField();
		textusername.setBounds(598, 153, 143, 21);
		contentPane.add(textusername);
		textusername.setColumns(10);

		JLabel lbluserbirth = new JLabel("생년월일");
		lbluserbirth.setBounds(598, 184, 57, 15);
		contentPane.add(lbluserbirth);

		textuserbirth = new JTextField();
		textuserbirth.setColumns(10);
		textuserbirth.setBounds(598, 209, 143, 21);
		contentPane.add(textuserbirth);

		JLabel lbluserphone = new JLabel("전화번호");
		lbluserphone.setBounds(598, 240, 57, 15);
		contentPane.add(lbluserphone);

		textuserphone = new JTextField();
		textuserphone.setColumns(10);
		textuserphone.setBounds(598, 258, 143, 21);
		contentPane.add(textuserphone);

		JLabel lblbookname = new JLabel("제목");
		lblbookname.setBounds(598, 357, 57, 15);
		contentPane.add(lblbookname);

		JLabel lblbookwriter = new JLabel("저자");
		lblbookwriter.setBounds(598, 405, 57, 15);
		contentPane.add(lblbookwriter);

		JLabel lblbookprice = new JLabel("가격");
		lblbookprice.setBounds(598, 456, 57, 15);
		contentPane.add(lblbookprice);

		textfindbookname = new JTextField();
		textfindbookname.setColumns(10);
		textfindbookname.setBounds(598, 374, 143, 21);
		contentPane.add(textfindbookname);

		textbookwriter = new JTextField();
		textbookwriter.setColumns(10);
		textbookwriter.setBounds(598, 425, 143, 21);
		contentPane.add(textbookwriter);

		textbookprice = new JTextField();
		textbookprice.setColumns(10);
		textbookprice.setBounds(598, 478, 143, 21);
		contentPane.add(textbookprice);

		textbookname = new JTextField();
		textbookname.setBounds(540, 325, 106, 21);
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
		
	} // end AdminFrame()

	private void searchbookname() {

	} // end searchbookname()

	private void searchusername() {
		// TODO Auto-generated method stub

	} // end searchusername()

	private void searchbookusername() {
		// TODO Auto-generated method stub

	} // end searchbookusername()
	
	private static void selectAllContactTable() {
		ArrayList<BooklistVO> list = bookservicedao.bookallselect();
		System.out.println(list);
		model.setRowCount(0);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {

			records[0] = i + 1;
			records[1] = list.get(i);
			records[2] = list.get(i);
			records[3] = list.get(i);
			records[4] = list.get(i);
			model.addRow(records);
		}

	} // end selectAllContactTable()
	

} // end AdminFrame

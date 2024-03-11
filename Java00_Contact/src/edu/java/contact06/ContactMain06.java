package edu.java.contact06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JTextPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ContactMain06 {

	private JFrame frame;
	private static JTextField textName;
	private static JTextField textPhone;
	private static JTextField textEmail;
	private static JTextField txtIndex;
	private static ContactDAOImple dao; // ContactDAOImple 인스턴스를 저장할 변수
	private static JLabel lblName;
	private static JLabel lblPhone;
	private static JLabel lblEmail;
	private static JTextArea txtAreaInfo;
	private static JTextArea txtAreaLog;

	private static String[] header = { "NO", "이름", "전화번호", "이메일" };
	private static Object[] records = new Object[header.length];
	private static DefaultTableModel model; // 테이블 형태를 만들 변수
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			dao = ContactDAOImple.getInstance();
		} catch (Exception e) {

		} // 다형성. 싱글톤 인스턴스 생성

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactMain06 window = new ContactMain06();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} // end main()
	/**
	 * Create the application.
	 */
	public ContactMain06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 680, 703);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("연락처 프로그램 Version 0.6");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 34));
		lblNewLabel.setBounds(12, 10, 461, 72);
		frame.getContentPane().add(lblNewLabel);

		lblName = new JLabel("이름");
		lblName.setFont(new Font("굴림", Font.PLAIN, 34));
		lblName.setBounds(12, 72, 139, 72);
		frame.getContentPane().add(lblName);

		lblPhone = new JLabel("전화번호");
		lblPhone.setFont(new Font("굴림", Font.PLAIN, 34));
		lblPhone.setBounds(12, 149, 139, 72);
		frame.getContentPane().add(lblPhone);

		lblEmail = new JLabel("이메일");
		lblEmail.setFont(new Font("굴림", Font.PLAIN, 34));
		lblEmail.setBounds(12, 227, 139, 72);
		frame.getContentPane().add(lblEmail);

		textName = new JTextField();
		textName.setBounds(163, 89, 283, 52);
		frame.getContentPane().add(textName);
		textName.setColumns(10);

		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(163, 156, 283, 52);
		frame.getContentPane().add(textPhone);

		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(163, 228, 283, 52);
		frame.getContentPane().add(textEmail);

		JButton btnInsert = new JButton("등록");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertMember();
			}
		});
		btnInsert.setFont(new Font("굴림", Font.BOLD, 24));
		btnInsert.setBounds(12, 294, 103, 52);
		frame.getContentPane().add(btnInsert);

		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateMember();
				VTxtAreaLog();
			}
		});
		btnUpdate.setFont(new Font("굴림", Font.BOLD, 24));
		btnUpdate.setBounds(12, 356, 103, 52);
		frame.getContentPane().add(btnUpdate);

		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteMamber();
				selectAllContactTable();
				VTxtAreaLog();
			}
		});
		btnDelete.setFont(new Font("굴림", Font.BOLD, 24));
		btnDelete.setBounds(127, 356, 103, 52);
		frame.getContentPane().add(btnDelete);

		JButton btnAllSearch = new JButton("전체검색");
		btnAllSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VTxtAreaLog();
				selectAllContactTable();
				selectAll();
			}

		});
		btnAllSearch.setFont(new Font("굴림", Font.BOLD, 24));
		btnAllSearch.setBounds(245, 356, 201, 52);
		frame.getContentPane().add(btnAllSearch);

		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectByIndax();
				selectContactTable();
				VTxtAreaLog();
			}

		});
		btnSearch.setFont(new Font("굴림", Font.BOLD, 24));
		btnSearch.setBounds(245, 290, 103, 52);
		frame.getContentPane().add(btnSearch);

		txtIndex = new JTextField();
		txtIndex.setText("번호입력");
		txtIndex.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtIndex.setText("");
			}
		});
		txtIndex.setToolTipText("");
		txtIndex.setBounds(127, 294, 103, 52);
		frame.getContentPane().add(txtIndex);
		txtIndex.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 418, 434, 99);
		frame.getContentPane().add(scrollPane);

		txtAreaInfo = new JTextArea();
		scrollPane.setViewportView(txtAreaInfo);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 527, 434, 104);
		frame.getContentPane().add(scrollPane_1);

		txtAreaLog = new JTextArea();
		scrollPane_1.setViewportView(txtAreaLog);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(458, 372, 194, 259);
		frame.getContentPane().add(scrollPane_2);

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

		scrollPane_2.setViewportView(table);

	} // end initialize();

	private static void deleteMamber() {
		try {
			System.out.println("검색할 인덱스 입력>");
			String indexst = txtIndex.getText();

			// 문자열을 숫자로 변환
			int index = Integer.parseInt(indexst);

			int count = ((ContactDAOImple) dao).getSize();
			if (index >= 0 && index < count) {
				int result = dao.delete(index);
				if (result == 1) {
					txtAreaLog.setText("연락처 정보 삭제 완료");
					selectAllContactTable();
				}
			} else {
				txtAreaLog.setText("0부터 " + (count - 1) + "까지만 입력하세요.");
			}
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			txtAreaLog.setText("0 이상의 정수를 입력하세요.");
		}
	} // end deleteMamber()

	private static void updateMember() {
		try {
			System.out.println("인덱스 입력>");
			String indexst = txtIndex.getText();

			// 문자열을 숫자로 변환
			int index = Integer.parseInt(indexst);

			int count = ((ContactDAOImple) dao).getSize();
			if (index >= 0 && index < count) {
				System.out.println("전화번호 입력>");
				String phone = textPhone.getText();

				System.out.println("이메일 입력>");
				String email = textEmail.getText();
				if (phone.equals("") || email.equals("")) {
					txtAreaLog.setText("이름, 전화번호, 이메일을 입력해 주세요." + "\n");
					return; // InsertMember() 종료
				}
				ContactDTO dto = new ContactDTO(index, "", phone, email);
				int result = dao.update(index, dto);
				if (result == 1) {
					txtAreaLog.setText("연락처 정보 수정 완료");
					clearTextFields();
					selectAllContactTable();
				} else {
					txtAreaLog.setText("수정에 실패했습니다." + "\n");

					txtAreaLog.setText("0부터 " + (count - 1) + "까지만 입력하세요.");
				}
			}
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			txtAreaLog.setText("0 이상의 정수를 입력하세요.");

		}
	} // end updateMember()

	private static void selectByIndax() {

		try {
			System.out.println("검색할 인덱스 입력>");
			String indexst = txtIndex.getText();
			System.out.println(indexst);
			// 문자열을 숫자로 변환
			int index = Integer.parseInt(indexst);
			int count = dao.select().size();

			System.out.println(count);
			if (index >= 0 && index < count) {
				ContactDTO dto = dao.select(index);
				String result = "--- 연락처 " + index + " ---" + "\n" + dto + "\n";
				txtAreaInfo.append(result);

			} else {
				txtAreaLog.setText("0부터 " + (count) + "까지만 입력하세요.");
			}
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			txtAreaLog.setText("0 이상의 정수를 입력하세요.");
		}
	} // end selectByIndax()

	private static void selectAll() {
//		try {
//			ArrayList<ContactDTO> list = dao.select();
//
//			int count = dao.getCount();
//			for (int i = 0; i < count; i++) {
//				String result = "--- 연락처 " + i + " ---" + "\n" + list.get(i) + "\n";
//				txtAreaInfo.append(result);
//				System.out.println("연락처 정보 [" + i + "]");
//				System.out.println(list.get(i));
//								
//			}
		int size = ((ContactDAOImple) dao).getSize();
		ArrayList<ContactDTO> list = dao.select();
		StringBuffer buffer = new StringBuffer();
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			buffer.append("연락처[" + i + "] \n" + list.get(i) + "\n");
		}
		txtAreaInfo.setText(buffer.toString());
		long endTime = System.currentTimeMillis();
		System.out.println("걸린 시간 : " + (endTime - startTime));

//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	} // end selectAll()

	private static void InsertMember() {
		System.out.println("--- 연락처 정보 등록 ---");
		System.out.println("이름 입력>");
		String name = textName.getText();
		System.out.println("전화번호 입력>");
		String phone = textPhone.getText();
		System.out.println("이메일 입력>");
		String email = textEmail.getText();
		System.out.println("등록");
		if (name.equals("") || phone.equals("") || email.equals("")) {
			txtAreaLog.setText("저장할 연락처 정보를 입력하세요.");
			return; // InsertMember() 종료
		}
		ContactDTO dto = new ContactDTO(0, name, phone, email);
		int check = dao.insert(dto);

		if (check == 1) {
			txtAreaLog.setText("연락처를 등록했습니다." + "\n");
			clearTextFields();
		} else {
			txtAreaLog.setText("등록에 실패했습니다." + "\n");
		}
		int count = dao.getSize();
		String result = "등록된 연락처 개수 : " + count + "\n" + "연락처 등록 완료" + "\n";
		txtAreaLog.append(result);
	} // end InsertMember()

	private static void clearTextFields() {
		textName.setText("");
		textPhone.setText("");
		textEmail.setText("");
	}

	private static void VTxtAreaLog() {
		int count = dao.getSize();
		String result = "등록된 연락처 개수 : " + count + "\n";
		txtAreaLog.append(result);
	} // end VTxtAreaLog()

	private static void selectAllContactTable() {
		ArrayList<ContactDTO> list = dao.select();
		System.out.println(list);
		model.setRowCount(0);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {

			records[0] = i + 1;
			records[1] = list.get(i).getName();
			records[2] = list.get(i).getPhone();
			records[3] = list.get(i).getEmail();
			model.addRow(records);
		}

	} // end selectAllContactTable()
	
	private void selectContactTable() {
		model.setRowCount(0);
		try {
			System.out.println("검색할 인덱스 입력>");
			String indexst = txtIndex.getText();
			System.out.println(indexst);
			// 문자열을 숫자로 변환
			int index = Integer.parseInt(indexst);
			int count = ((ContactDAOImple) dao).getSize();
			
			System.out.println(count);
			if (index >= 0 && index < count) {
				ContactDTO dto = dao.select(index);
				records[0] = dto.getIndex();
				records[1] = dto.getName();
				records[2] = dto.getPhone();
				records[3] = dto.getEmail();
				model.addRow(records);
				
			} else {
				txtAreaLog.setText("0부터 " + (count - 1) + "까지만 입력하세요.");
			}
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			txtAreaLog.setText("0 이상의 정수를 입력하세요.");
		}

	} // end selectContactTable()

}// end ContactMain05

package edu.java.gui10;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class GuiMain10 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain10 window = new GuiMain10();
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
	public GuiMain10() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JFileChooser : 파일을 선택할 수 있는 팝업창
				System.out.println("클릭!"); // 이해가 안되면 로그!
				JFileChooser chooser = new JFileChooser();
				int result = chooser.showOpenDialog(null);
				System.out.println(result);
				if(result == JFileChooser.APPROVE_OPTION) { // 확인 버튼 클릭시
					System.out.println("파일 선택");
					File seleced = chooser.getSelectedFile();
					System.out.println(seleced.getAbsolutePath());
				} else { // 취소 버튼 클릭시
					System.out.println("취소");
				}

			}
		});
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnFile.add(mntmSave);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ConfirmDialog :
				// Yes(확인) - No(아니요) - Cancel(취소) 버튼을 갖는 다이얼로그
				int result = JOptionPane.showConfirmDialog(frame.getContentPane(), "종료하시겠습니까?"); // 컴퍼넌트의 자식들이다. (즉 다형성)
				// parantComponent : 부모 컴퍼넌트를 설정.
				// 현재 컴퍼넌트를 보여줄 위치 설정
				System.out.println("선택 결과 : " + result);
				if(result == JOptionPane.YES_OPTION) {
					// 프로그램 동료 :
					// System.exit(0); 정상 종료
					// System.exit(0 이외의 숫자); 비정상 종료
					System.exit(0);
				} else {
					System.out.println("취소");
				}
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 메시지와 Ok 버튼만 있는 다이얼로그 : MessageDialog
				JOptionPane.showMessageDialog(frame, "버전 1.0");
			}
		});
		mnHelp.add(mntmAbout);
		frame.getContentPane().setLayout(null);
	} // end initialize() 
} // 

package edu.java.booklist;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Usercheck extends JDialog implements USE_FRAME_CODE {

	private final JPanel contentPanel = new JPanel();
 
	
	public Usercheck() {
		setModal(true);
		setBounds(setBounds_Width, setBounds_Height, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 228);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		{
			JLabel lblNewLabel = new JLabel("아이디와 페스워드를 입력해 주세요.");
			contentPanel.add(lblNewLabel);
		} 
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 228, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}

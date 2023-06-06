package com.hejiaman.view;

import java.awt.EventQueue;
import com.hejiaman.view.loginFrm;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hejiaman.dao.CustomerDao;
import com.hejiaman.model.user_identify;
import com.hejiaman.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class changecus extends JFrame {

	private JPanel contentPane;
	private JTextField changenametextField;
	private JTextField changeteltextField;
//	private user_identify user_identify;
//	private Object userObject;
	public static String id = loginFrm.user_id;
	private JLabel currentuserLabel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					changecus frame = new changecus();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public changecus() {
		setTitle("个人信息修改");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("个人信息修改");
		lblNewLabel.setIcon(new ImageIcon(changecus.class.getResource("/pic/修改.png")));
		lblNewLabel.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 25));
		
		JLabel lblNewLabel_1 = new JLabel("当前账号：");
		lblNewLabel_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1_1 = new JLabel("修改姓名：");
		lblNewLabel_1_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("修改联系方式：");
		lblNewLabel_1_1_1_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 16));
		
		JButton submitButton = new JButton("提交");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit(e);
			}
		});
		submitButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		JButton resetButton = new JButton("重置");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset(e);
			}
		});
		resetButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		changenametextField = new JTextField();
		changenametextField.setColumns(10);
		
		changeteltextField = new JTextField();
		changeteltextField.setColumns(10);
		
		currentuserLabel = new JLabel("New label");
		currentuserLabel.setEnabled(false);
		currentuserLabel.setText("");
		currentuserLabel.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(64)
									.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
									.addGap(51)
									.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(changenametextField, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(currentuserLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(changeteltextField, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(107)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNewLabel)
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(currentuserLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(changenametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(changeteltextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		currentuserLabel.setText(id);
	}
	
	protected void submit(ActionEvent e) {
		// TODO Auto-generated method stub
		String changename = changenametextField.getText().toString();
		String changetel = changeteltextField.getText().toString();
		String id = currentuserLabel.getText();
		CustomerDao customerdao = new CustomerDao();
		if(!changename.equals(""))
		{
			JOptionPane.showMessageDialog(this, customerdao.changename(changename, id));
		}
		if(!changetel.equals("")) {
			JOptionPane.showMessageDialog(this, customerdao.changetel(changetel, id));
		}

	}
	
	
	
	protected void reset(ActionEvent e) {
		// TODO Auto-generated method stub
		changenametextField.setText("");
		changeteltextField.setText("");
	}

}

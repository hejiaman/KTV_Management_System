package com.hejiaman.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hejiaman.dao.CustomerDao;
import com.hejiaman.model.Customer;
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
import com.hejiaman.view.loginFrm;

public class changecuspsw extends JFrame {

	private JPanel contentPane;
	private JTextField oldpasswordtextField;
	private JTextField newpasswordtextField;
	private JTextField confirmpasswordtextField;
	private JLabel currentuserLabel;
	public static String id = loginFrm.user_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					changecuspsw frame = new changecuspsw();
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
	public changecuspsw() {
		setTitle("密码修改");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("密码修改");
		lblNewLabel.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 20));
		lblNewLabel.setIcon(new ImageIcon(changecuspsw.class.getResource("/pic/password.jpg")));
		
		JLabel lblNewLabel_1 = new JLabel("当前账号：");
		lblNewLabel_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1_1 = new JLabel("原密码：");
		lblNewLabel_1_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("新密码：");
		lblNewLabel_1_1_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("确认密码：");
		lblNewLabel_1_1_1_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		JButton changepswNewButton = new JButton("确认修改");
		changepswNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit(e);
			}
		});
		changepswNewButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		JButton resetButton = new JButton("重置");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset(e);
			}
		});
		resetButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		oldpasswordtextField = new JTextField();
		oldpasswordtextField.setColumns(10);
		
		newpasswordtextField = new JTextField();
		newpasswordtextField.setColumns(10);
		
		confirmpasswordtextField = new JTextField();
		confirmpasswordtextField.setColumns(10);
		
		currentuserLabel = new JLabel("New label");
//		currentuserLabel.setEnabled(false);
		currentuserLabel.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(currentuserLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(oldpasswordtextField))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(confirmpasswordtextField, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(newpasswordtextField))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(changepswNewButton)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))))
					.addGap(92))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(68)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(currentuserLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(oldpasswordtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(newpasswordtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(confirmpasswordtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(changepswNewButton)
						.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(37))
		);
		contentPane.setLayout(gl_contentPane);
		currentuserLabel.setText(id);

	}

	protected void submit(ActionEvent e) {
		// TODO Auto-generated method stub
		String oldPassword = oldpasswordtextField.getText().toString();
		String newPassword = newpasswordtextField.getText().toString();
		String confrmPassword = confirmpasswordtextField.getText().toString();
		String id = currentuserLabel.getText();
		if(StringUtil.isEmpty(oldPassword)) {
			JOptionPane.showMessageDialog(this, "请输入旧密码");
			return;
		}
		if(StringUtil.isEmpty(newPassword)) {
			JOptionPane.showMessageDialog(this, "请输入新密码");
			return;
		}
		if(StringUtil.isEmpty(confrmPassword)) {
			JOptionPane.showMessageDialog(this, "请再次确认新密码");
			return;
		}
		if(!newPassword.equals(confrmPassword)) {
			JOptionPane.showMessageDialog(this, "两次密码输入不一致！");
			return;
		}
		CustomerDao customerdao = new CustomerDao();
		JOptionPane.showMessageDialog(this, customerdao.editpassword(oldPassword, newPassword, id));
	}

	protected void reset(ActionEvent e) {
		// TODO Auto-generated method stub
		oldpasswordtextField.setText("");
		newpasswordtextField.setText("");
		confirmpasswordtextField.setText("");
	}

}

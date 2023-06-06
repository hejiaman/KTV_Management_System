package com.hejiaman.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hejiaman.dao.CustomerDao;
import com.hejiaman.model.Customer;
import com.hejiaman.model.customer_sex;
import com.hejiaman.model.user_identify;
import com.hejiaman.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import java.awt.Checkbox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ZhuceFrm extends JFrame {

	private JPanel contentPane;
	private JTextField customer_idtextField;
	private JLabel lblNewLabel_2;
	private JTextField customer_nametextField;
	private JLabel lblNewLabel_3;
	private JTextField customer_idcardtextField;
	private JTextField customer_teltextField;
	private JTextField customer_passwordtextField;
	private JTextField confirmpasswordtextField;
	private JTextField customer_sextextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZhuceFrm frame = new ZhuceFrm();
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
	public ZhuceFrm() {
		setTitle("注册界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("欢迎注册！");
		lblNewLabel.setForeground(new Color(0, 128, 192));
		lblNewLabel.setIcon(new ImageIcon(ZhuceFrm.class.getResource("/pic/音乐.png")));
		lblNewLabel.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 25));
		
		JLabel lblNewLabel_1 = new JLabel("账号：");
		lblNewLabel_1.setForeground(new Color(0, 128, 192));
		lblNewLabel_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 18));
		lblNewLabel_1.setIcon(new ImageIcon(ZhuceFrm.class.getResource("/pic/账号.png")));
		
		customer_idtextField = new JTextField();
		customer_idtextField.setColumns(10);
		
		lblNewLabel_2 = new JLabel("姓名：");
		lblNewLabel_2.setIcon(new ImageIcon(ZhuceFrm.class.getResource("/pic/姓名.png")));
		lblNewLabel_2.setForeground(new Color(0, 128, 192));
		lblNewLabel_2.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 18));
		
		customer_nametextField = new JTextField();
		customer_nametextField.setColumns(10);
		
		lblNewLabel_3 = new JLabel("性别：");
		lblNewLabel_3.setIcon(new ImageIcon(ZhuceFrm.class.getResource("/pic/性别.png")));
		lblNewLabel_3.setForeground(new Color(0, 128, 192));
		lblNewLabel_3.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3_1 = new JLabel("身份证号：");
		lblNewLabel_3_1.setForeground(new Color(0, 128, 192));
		lblNewLabel_3_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 18));
		
		customer_idcardtextField = new JTextField();
		customer_idcardtextField.setColumns(10);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("联系电话：");
		lblNewLabel_3_1_1.setForeground(new Color(0, 128, 192));
		lblNewLabel_3_1_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 18));
		
		customer_teltextField = new JTextField();
		customer_teltextField.setColumns(10);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("密码：");
		lblNewLabel_3_1_1_1.setIcon(new ImageIcon(ZhuceFrm.class.getResource("/pic/密码123123.png")));
		lblNewLabel_3_1_1_1.setForeground(new Color(0, 128, 192));
		lblNewLabel_3_1_1_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 18));
		
		customer_passwordtextField = new JTextField();
		customer_passwordtextField.setColumns(10);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("确认密码：");
		lblNewLabel_3_1_1_1_1.setForeground(new Color(0, 128, 192));
		lblNewLabel_3_1_1_1_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 18));
		
		confirmpasswordtextField = new JTextField();
		confirmpasswordtextField.setColumns(10);
		
		JButton submitButton = new JButton("确认");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit(e);
			}
		});
		submitButton.setForeground(new Color(0, 128, 192));
		submitButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 18));
		
		JButton resetButton = new JButton("重置");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer_idtextField.setText("");
				customer_nametextField.setText("");
				customer_idcardtextField.setText("");
				customer_teltextField.setText("");
				customer_passwordtextField.setText("");
				confirmpasswordtextField.setText("");
				customer_sextextField.setText("");
			}
		});
		resetButton.setForeground(new Color(0, 128, 192));
		resetButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 18));
		
		customer_sextextField = new JTextField();
		customer_sextextField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(160)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(66)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(customer_nametextField, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(customer_idtextField, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(customer_sextextField, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(customer_idcardtextField, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_3_1_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(customer_teltextField, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_3_1_1_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(customer_passwordtextField, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_3_1_1_1_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
												.addComponent(confirmpasswordtextField, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))))))))
					.addContainerGap(85, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(41)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(customer_idtextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(customer_nametextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(customer_sextextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(customer_idcardtextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3_1_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(customer_teltextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3_1_1_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(customer_passwordtextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3_1_1_1_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(confirmpasswordtextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(submitButton)
						.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void submit(ActionEvent e) {
		// TODO Auto-generated method stub
		String customer_id = customer_idtextField.getText().toString();
		String customer_name = customer_nametextField.getText().toString();
		String customer_sex = customer_sextextField.getText().toString();
		String customer_idcard = customer_idcardtextField.getText().toString();
		String customer_tel = customer_teltextField.getText().toString();
		String customer_password = customer_passwordtextField.getText().toString();
		String confirmpassword = confirmpasswordtextField.getText().toString();
		if(StringUtil.isEmpty(customer_id)) {
			JOptionPane.showMessageDialog(this, "账号不能为空");
			return;
		}
		if(StringUtil.isEmpty(customer_name)) {
			JOptionPane.showMessageDialog(this, "姓名不能为空");
			return;
		}
		if(StringUtil.isEmpty(customer_sex)) {
			JOptionPane.showMessageDialog(this, "性别不能为空，请填写男或女");
			return;
		}
		if(StringUtil.isEmpty(customer_idcard)) {
			JOptionPane.showMessageDialog(this, "身份证号不能为空");
			return;
		}
		if(StringUtil.isEmpty(customer_tel)) {
			JOptionPane.showMessageDialog(this, "联系方式不能为空");
			return;
		}
		if(StringUtil.isEmpty(customer_password)) {
			JOptionPane.showMessageDialog(this, "密码不能为空");
			return;
		}
		if(StringUtil.isEmpty(confirmpassword)) {
			JOptionPane.showMessageDialog(this, "请再次确认您的密码");
			return;
		}
		if(!customer_password.equals(confirmpassword)) {
			JOptionPane.showMessageDialog(this, "两次密码输入不一致");
			return;
		}
		
		CustomerDao customerdao = new CustomerDao();
		Customer customertmp = new Customer();
		customertmp.setCustomer_id(customer_id);
		customertmp.setCustomer_name(customer_name);
		customertmp.setCustomer_sex(customer_sex);
		customertmp.setCustomer_idcard(customer_idcard);
		customertmp.setCustomer_tel(customer_tel);
		customertmp.setCustomer_password(customer_password);
		JOptionPane.showMessageDialog(this, customerdao.Zhuce(customertmp));
		
		return;
//		String customer2 = customerdao.Insert(customertmp);
	}
	
	protected void resetvalue(ActionEvent ae) {
		// TODO Auto-generated method stub
		customer_idtextField.setText("");
		customer_nametextField.setText("");
		customer_sextextField.setText("");
		customer_idcardtextField.setText("");
		customer_teltextField.setText("");
		customer_passwordtextField.setText("");
		confirmpasswordtextField.setText("");
	}
	
	
	
	
	
}

package com.hejiaman.view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.hejiaman.dao.AdminDao;
import com.hejiaman.dao.CustomerDao;
import com.hejiaman.dao.WaiterDao;
import com.hejiaman.model.Admin;
import com.hejiaman.model.Customer;
import com.hejiaman.model.user_identify;
import com.hejiaman.model.waiter;
import com.hejiaman.util.StringUtil;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class loginFrm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField user_passwordtextField;
	private static JTextField user_idtextField;
	private JComboBox user_identifycomboBox; 
	static String user_id;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrm frame = new loginFrm();
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
	@SuppressWarnings("rawtypes")
	public loginFrm() {
		setTitle("KTV预约管理登陆界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("KTV预约管理登陆界面");
		lblNewLabel.setForeground(new Color(83, 169, 255));
		lblNewLabel.setFont(new Font("华光黑变_CNKI", Font.BOLD | Font.ITALIC, 32));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(loginFrm.class.getResource("/pic/KTV音乐麦克风(1)(1)(1).png")));
		
		JLabel lblNewLabel_2 = new JLabel("身份：");
		lblNewLabel_2.setForeground(new Color(83, 169, 255));
		lblNewLabel_2.setIcon(new ImageIcon(loginFrm.class.getResource("/pic/identify.jpg")));
		lblNewLabel_2.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_1 = new JLabel("账号：");
		lblNewLabel_2_1.setForeground(new Color(83, 169, 255));
		lblNewLabel_2_1.setIcon(new ImageIcon(loginFrm.class.getResource("/pic/user.jpg")));
		lblNewLabel_2_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_1_1 = new JLabel("密码：");
		lblNewLabel_2_1_1.setForeground(new Color(83, 169, 255));
		lblNewLabel_2_1_1.setIcon(new ImageIcon(loginFrm.class.getResource("/pic/password.jpg")));
		lblNewLabel_2_1_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3 = new JLabel("");
		
		user_passwordtextField = new JTextField();
		user_passwordtextField.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 16));
		user_passwordtextField.setColumns(10);
		
		user_idtextField = new JTextField();
		user_idtextField.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 16));
		user_idtextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		user_idtextField.setColumns(10);
		
		JButton loginButton = new JButton("登录");
		loginButton.setBackground(new Color(153, 204, 255));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				user_id = user_idtextField.getText();
				loginAct(ae);
			}
		});
		loginButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 20));
		
		JButton signupButton = new JButton("注册");
		signupButton.setBackground(new Color(153, 204, 255));
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				zhuce(ae);
			}
		});
		signupButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 20));
		
		user_identifycomboBox = new JComboBox();
		user_identifycomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		user_identifycomboBox.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 16));
		user_identifycomboBox.setModel(new DefaultComboBoxModel(new user_identify[] {user_identify.ADMIN,user_identify.CUSTOMER,user_identify.WAITER}));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_2_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(lblNewLabel_2_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(user_identifycomboBox, 0, 258, Short.MAX_VALUE)
								.addComponent(user_passwordtextField, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(loginButton, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
									.addGap(44)
									.addComponent(signupButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
								.addComponent(user_idtextField, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)))
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3)
					.addGap(32))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(user_identifycomboBox, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
							.addGap(23)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(user_idtextField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_3))
							.addGap(25)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2_1_1)
								.addComponent(user_passwordtextField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(signupButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(loginButton)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
	}



	protected void zhuce(ActionEvent ae) {
		// TODO Auto-generated method stub
		user_identify selectedItem = (user_identify)user_identifycomboBox.getSelectedItem();
		//顾客注册界面显示
		if("顾客".equals(selectedItem.getName())) {
		new ZhuceFrm().setVisible(true);
		}
	}

	protected void loginAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String user_id = user_idtextField.getText().toString();
		String user_password = user_passwordtextField.getText().toString();
		user_identify selectedItem = (user_identify)user_identifycomboBox.getSelectedItem();
		if(StringUtil.isEmpty(user_id)) {
			JOptionPane.showMessageDialog(this, "账号不能为空");
			return;
		}
		if(StringUtil.isEmpty(user_password)) {
			JOptionPane.showMessageDialog(this, "密码不能为空！");
			return;
		}
		Customer customer = null;
		waiter waiter = null;
		if("管理员".equals(selectedItem.getName())) {
			//管理员登录
			AdminDao admindao = new AdminDao();
			Admin adminTmp = new Admin();
			adminTmp.setId(user_id);
			adminTmp.setPassword(user_password);
			Admin admin = admindao.login(adminTmp);
			if(admin == null) {
				JOptionPane.showMessageDialog(this, "密码或账号错误！");
				return;
			}
			else {
				JOptionPane.showMessageDialog(this, "欢迎管理员登录本系统");
				this.dispose();
				new AdminFrm().setVisible(true);
				return;
			}
		}
		else if("服务员".equals(selectedItem.getName())){
			//服务员登录
			WaiterDao waiterdao = new WaiterDao();
			waiter waitertmp = new waiter();
			waitertmp.setWaiter_id(user_id);
			waitertmp.setWaiter_password(user_password);
			waiter = waiterdao.login(waitertmp);
			if(waiter == null) {
				JOptionPane.showMessageDialog(this, "密码或账号错误！");
				return;
			}
			else {
				JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.getName()+"】:"+waiter.getWaiter_name()+"登录本系统");
				this.dispose();
				new WaiterFrm().setVisible(true);
				return;
			}
			
		}
		else {
			//顾客登录
			CustomerDao customerdao = new CustomerDao();
			Customer customerTmp = new Customer();
			customerTmp.setCustomer_id(user_id);
			customerTmp.setCustomer_password(user_password);
			customer = customerdao.login(customerTmp);
			if(customer == null) {
				JOptionPane.showMessageDialog(this, "密码或账号错误！");
				return;
			}
			else {
				JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.getName()+"】:"+customer.getCustomer_name()+"登录本系统");
				this.dispose();
				new UserFrm().setVisible(true);
				return;
			}

		}


	}

	protected void resetvalue(ActionEvent ae) {
		// TODO Auto-generated method stub
		user_idtextField.setText("");
		user_passwordtextField.setText("");
		user_identifycomboBox.setSelectedItem(0);
	}
}

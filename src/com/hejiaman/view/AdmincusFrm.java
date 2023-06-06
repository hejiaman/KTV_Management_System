package com.hejiaman.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hejiaman.dao.CustomerDao;
import com.hejiaman.dao.OrderDao;
import com.hejiaman.model.Customer;
import com.hejiaman.model.Reserve;
import com.hejiaman.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class AdmincusFrm extends JFrame {

	private JPanel contentPane;
	private JTable customerlisttable;
	private JTextField searchtextField;
	private JTextField customer_changenametextField;
	private JTextField customer_changeteltextField;
	private JTextField customer_changepswtextField;
	private JRadioButton manRadioButton;
	private JRadioButton womanRadioButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdmincusFrm frame = new AdmincusFrm();
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
	public AdmincusFrm() {
//		setClosable(true);
//		setIconifiable(true);我的set这俩就报错不知道为啥
		setTitle("顾客信息管理");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("顾客姓名：");
		lblNewLabel.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		lblNewLabel.setIcon(new ImageIcon(AdmincusFrm.class.getResource("/pic/顾客画像 base_setting_customerPortrait .png")));
		
		searchtextField = new JTextField();
		searchtextField.setColumns(10);
		
		JButton searchcusButton = new JButton("查询");
		searchcusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer cus = new Customer();
				setTable(cus);
			}
		});
		searchcusButton.setIcon(new ImageIcon(AdmincusFrm.class.getResource("/pic/发现.png")));
		searchcusButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u987E\u5BA2\u4FE1\u606F\u4FEE\u6539", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(88)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchtextField, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(searchcusButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 544, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE))))
					.addGap(23))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(searchtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(searchcusButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("顾客姓名：");
		lblNewLabel_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 13));
		
		customer_changenametextField = new JTextField();
		customer_changenametextField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("顾客电话：");
		lblNewLabel_1_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 13));
		
		customer_changeteltextField = new JTextField();
		customer_changeteltextField.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("顾客性别：");
		lblNewLabel_1_2.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 13));
		
		ButtonGroup buttongroup = new ButtonGroup();
		manRadioButton = new JRadioButton("男");
		manRadioButton.setSelected(true);
		
		womanRadioButton = new JRadioButton("女");
		buttongroup.add(manRadioButton);
		buttongroup.add(womanRadioButton);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("登录密码：");
		lblNewLabel_1_1_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 13));
		
		customer_changepswtextField = new JTextField();
		customer_changepswtextField.setColumns(10);
		
		JButton submitButton = new JButton("确认修改");
		submitButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editcustomer(e);
			}
		});
		submitButton.setIcon(new ImageIcon(AdmincusFrm.class.getResource("/pic/ok.png")));
		
		JButton deleteButton = new JButton("删除信息");
		deleteButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete(e);
			}
		});
		deleteButton.setIcon(new ImageIcon(AdmincusFrm.class.getResource("/pic/删除.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(customer_changenametextField, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(customer_changeteltextField, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(manRadioButton)
									.addGap(18)
									.addComponent(womanRadioButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(customer_changepswtextField, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
							.addGap(113))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(submitButton)
							.addGap(31)
							.addComponent(deleteButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(51))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(customer_changenametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(manRadioButton)
								.addComponent(womanRadioButton))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(customer_changeteltextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(61)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(customer_changepswtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(deleteButton))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		customerlisttable = new JTable();
		customerlisttable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedTableRow(e);
			}
		});
		
		customerlisttable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8D26\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u8EAB\u4EFD\u8BC1\u53F7", "\u8054\u7CFB\u65B9\u5F0F", "\u767B\u9646\u5BC6\u7801"
			}
		));
		customerlisttable.getColumnModel().getColumn(0).setPreferredWidth(57);
		customerlisttable.getColumnModel().getColumn(1).setPreferredWidth(62);
		customerlisttable.getColumnModel().getColumn(2).setPreferredWidth(43);
		customerlisttable.getColumnModel().getColumn(3).setPreferredWidth(89);
		customerlisttable.getColumnModel().getColumn(4).setPreferredWidth(81);
		scrollPane.setViewportView(customerlisttable);
		contentPane.setLayout(gl_contentPane);

		setTable(new Customer());
	}
	
	protected void editcustomer(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = customerlisttable.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "请选择要修改的数据");
			return;
		}
		String customer_name= customer_changenametextField.getText().toString();
		String customer_tel = customer_changeteltextField.getText().toString();
		String customer_sex = manRadioButton.isSelected() ? manRadioButton.getText().toString() : womanRadioButton.getText().toString();
		String customer_password = customer_changepswtextField.getText().toString();
		if(StringUtil.isEmpty(customer_name)) {
			JOptionPane.showMessageDialog(this, "姓名不能为空");
			return;
		}
		if(StringUtil.isEmpty(customer_tel)) {
			JOptionPane.showMessageDialog(this, "联系方式不能为空");
			return;
		}
		if(StringUtil.isEmpty(customer_sex)) {
			JOptionPane.showMessageDialog(this, "性别不能为空");
			return;
		}
		if(StringUtil.isEmpty(customer_password)) {
			JOptionPane.showMessageDialog(this, "密码不能为空");
			return;
		}
		Customer customertmp = new Customer();
		customertmp.setCustomer_id(customerlisttable.getValueAt(row, 0).toString());
		customertmp.setCustomer_name(customer_name);
		customertmp.setCustomer_sex(customer_sex);
		customertmp.setCustomer_tel(customer_tel);
		customertmp.setCustomer_password(customer_password);
		CustomerDao customerdao = new CustomerDao();
		if(customerdao.update(customertmp)) {
			JOptionPane.showMessageDialog(this, "修改成功！");
		}
		else {
			JOptionPane.showMessageDialog(this, "修改失败！");
		}
		setTable(new Customer());
	}
		


	protected void delete(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = customerlisttable.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "请选择要删除的数据");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "确定删除吗？")!= JOptionPane.OK_OPTION )return;
		String id = customerlisttable.getValueAt(row, 0).toString();
		CustomerDao customerdao = new CustomerDao();
		if(customerdao.delete(id)) {
			JOptionPane.showMessageDialog(this, "删除成功！");
		}
		else {
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		setTable(new Customer());
	}

	private void setTable(Customer customer) {
		String name = searchtextField.getText().toString();
		DefaultTableModel dft = (DefaultTableModel) customerlisttable.getModel();
		dft.setRowCount(0);
		CustomerDao customerdao = new CustomerDao();
		customer.setCustomer_name(name);
		List<Customer> customer1 = customerdao.getcustomerList(customer);
		for(Customer cus : customer1) {
			Vector v = new Vector();
			v.add(cus.getCustomer_id());
			v.add(cus.getCustomer_name());
			v.add(cus.getCustomer_sex());
			v.add(cus.getCustomer_idcard());
			v.add(cus.getCustomer_tel());
			v.add(cus.getCustomer_password());
			dft.addRow(v);
		}	
	}
	
	protected void selectedTableRow(MouseEvent e) {
		DefaultTableModel dft = (DefaultTableModel) customerlisttable.getModel();
		customer_changenametextField.setText(dft.getValueAt(customerlisttable.getSelectedRow(),1).toString());
		customer_changeteltextField.setText(dft.getValueAt(customerlisttable.getSelectedRow(),4).toString());
		customer_changepswtextField.setText(dft.getValueAt(customerlisttable.getSelectedRow(),5).toString());
		String id = dft.getValueAt(customerlisttable.getSelectedRow(),0).toString();
		String sex = dft.getValueAt(customerlisttable.getSelectedRow(),2).toString();
		if(sex.equals(manRadioButton.getText()))manRadioButton.setSelected(true);
		if(sex.equals(womanRadioButton.getText()))womanRadioButton.setSelected(true);
		
	}
	
	
	
	
	
}

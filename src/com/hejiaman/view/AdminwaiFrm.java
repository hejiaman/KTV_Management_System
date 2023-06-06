package com.hejiaman.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hejiaman.dao.CustomerDao;
import com.hejiaman.dao.WaiterDao;
import com.hejiaman.model.Customer;
import com.hejiaman.model.waiter;
import com.hejiaman.util.StringUtil;

import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class AdminwaiFrm extends JFrame {

	private JPanel contentPane;
	private JTextField searchtextField;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTable waiterlisttable;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JTextField changenametextField;
	private JLabel lblNewLabel_2;
	private JTextField changepswtextField;
	private JLabel lblNewLabel_3;
	private JTextField changeteltextField;
	private JLabel lblNewLabel_4;
	private JRadioButton manRadioButton;
	private JRadioButton womanRadioButton;
	private JButton submitNewButton;
//	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminwaiFrm frame = new AdminwaiFrm();
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
	public AdminwaiFrm() {
		setTitle("服务员信息管理");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("服务员姓名：");
		lblNewLabel.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		lblNewLabel.setIcon(new ImageIcon(AdminwaiFrm.class.getResource("/pic/个人.png")));
		
		searchtextField = new JTextField();
		searchtextField.setColumns(10);
		
		btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				waiter waiter1 = new waiter();
				setTable(waiter1);
			}
		});
		btnNewButton.setIcon(new ImageIcon(AdminwaiFrm.class.getResource("/pic/发现.png")));
		btnNewButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		scrollPane = new JScrollPane();
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u670D\u52A1\u5458\u4FE1\u606F\u4FEE\u6539", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		lblNewLabel_1 = new JLabel("姓名：");
		lblNewLabel_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		changenametextField = new JTextField();
		changenametextField.setColumns(10);
		
		lblNewLabel_2 = new JLabel("密码：");
		lblNewLabel_2.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		changepswtextField = new JTextField();
		changepswtextField.setColumns(10);
		
		lblNewLabel_3 = new JLabel("电话：");
		lblNewLabel_3.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		changeteltextField = new JTextField();
		changeteltextField.setColumns(10);
		
		lblNewLabel_4 = new JLabel("性别：");
		lblNewLabel_4.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		ButtonGroup buttongroup = new ButtonGroup();
		manRadioButton = new JRadioButton("男");
		manRadioButton.setSelected(true);
		manRadioButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		womanRadioButton = new JRadioButton("女");
		womanRadioButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		buttongroup.add(manRadioButton);
		buttongroup.add(womanRadioButton);
		
		submitNewButton = new JButton("提交修改");
		submitNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editwaiter(e);
			}
		});
		submitNewButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		submitNewButton.setIcon(new ImageIcon(AdminwaiFrm.class.getResource("/pic/ok.png")));
		
		JButton submitNewButton_1 = new JButton("删除信息");
		submitNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete(e);
			}
		});
		submitNewButton_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		submitNewButton_1.setIcon(new ImageIcon(AdminwaiFrm.class.getResource("/pic/删除.png")));
		

//		customerlisttable.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				selectedTableRow(e);
//			}
//		});
		
		waiterlisttable = new JTable();
		waiterlisttable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedTableRow(e);
			}
		});
		waiterlisttable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u8D26\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u8054\u7cfb\u7535\u8bdd", "\u767B\u9646\u5BC6\u7801"
				}
			));
		waiterlisttable.getColumnModel().getColumn(0).setPreferredWidth(57);
		waiterlisttable.getColumnModel().getColumn(1).setPreferredWidth(62);
		waiterlisttable.getColumnModel().getColumn(2).setPreferredWidth(43);
		waiterlisttable.getColumnModel().getColumn(3).setPreferredWidth(89);
		waiterlisttable.getColumnModel().getColumn(4).setPreferredWidth(81);
			scrollPane.setViewportView(waiterlisttable);
			GroupLayout gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(81)
								.addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(searchtextField, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addGap(30)
								.addComponent(btnNewButton))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(47)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addContainerGap(48, Short.MAX_VALUE))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(7)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(searchtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel)
							.addComponent(btnNewButton))
						.addGap(7)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
						.addGap(26))
			);
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(10)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblNewLabel_1)
								.addGap(4)
								.addComponent(changenametextField, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
								.addGap(68)
								.addComponent(lblNewLabel_4)
								.addGap(6)
								.addComponent(manRadioButton)
								.addGap(2)
								.addComponent(womanRadioButton))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblNewLabel_2)
								.addGap(4)
								.addComponent(changepswtextField, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
								.addGap(68)
								.addComponent(submitNewButton, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblNewLabel_3)
								.addGap(4)
								.addComponent(changeteltextField, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
								.addGap(68)
								.addComponent(submitNewButton_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(30)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(4)
								.addComponent(lblNewLabel_1))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(3)
								.addComponent(changenametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(4)
								.addComponent(lblNewLabel_4))
							.addComponent(manRadioButton)
							.addComponent(womanRadioButton))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(4)
								.addComponent(lblNewLabel_2))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(3)
								.addComponent(changepswtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addComponent(submitNewButton))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(8)
								.addComponent(lblNewLabel_3))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(3)
								.addComponent(changeteltextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addComponent(submitNewButton_1)))
			);
			panel.setLayout(gl_panel);
			contentPane.setLayout(gl_contentPane);
			

			setTable(new waiter());
		
	}
	
	protected void delete(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = waiterlisttable.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "请选择要删除的数据");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "确定删除吗？")!= JOptionPane.OK_OPTION )return;
		String id = waiterlisttable.getValueAt(row, 0).toString();
		WaiterDao waiterdao = new WaiterDao();
		if(waiterdao.delete(id)) {
			JOptionPane.showMessageDialog(this, "删除成功！");
		}
		else {
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		setTable(new waiter());
	}
	
	protected void selectedTableRow(MouseEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) waiterlisttable.getModel();
		changenametextField.setText(dft.getValueAt(waiterlisttable.getSelectedRow(),1).toString());
		changeteltextField.setText(dft.getValueAt(waiterlisttable.getSelectedRow(),3).toString());
		changepswtextField.setText(dft.getValueAt(waiterlisttable.getSelectedRow(),4).toString());
		String id = dft.getValueAt(waiterlisttable.getSelectedRow(),0).toString();
		String sex = dft.getValueAt(waiterlisttable.getSelectedRow(),2).toString();
		if(sex.equals(manRadioButton.getText()))manRadioButton.setSelected(true);
		if(sex.equals(womanRadioButton.getText()))womanRadioButton.setSelected(true);
	}

	private void setTable(waiter waiter1) {
		String name = searchtextField.getText().toString();
		DefaultTableModel dft = (DefaultTableModel)waiterlisttable.getModel();
		dft.setRowCount(0);
		WaiterDao waiterdao = new WaiterDao();
		waiter1.setWaiter_name(name);
		List<waiter> waiter11 = waiterdao.getwaiterList(waiter1);
		for(waiter wai : waiter11) {
			Vector v = new Vector();
			v.add(wai.getWaiter_id());
			v.add(wai.getWaiter_name());
			v.add(wai.getWaiter_sex());
			v.add(wai.getWaiter_tel());
			v.add(wai.getWaiter_password());
			dft.addRow(v);
		}	
	}
	
	protected void editwaiter(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = waiterlisttable.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "请选择要修改的数据");
			return;
		}
		String waiter_name= changenametextField.getText().toString();
		String waiter_tel = changeteltextField.getText().toString();
		String waiter_sex = manRadioButton.isSelected() ? manRadioButton.getText().toString() : womanRadioButton.getText().toString();
		String waiter_password = changepswtextField.getText().toString();
		if(StringUtil.isEmpty(waiter_name)) {
			JOptionPane.showMessageDialog(this, "姓名不能为空");
			return;
		}
		if(StringUtil.isEmpty(waiter_tel)) {
			JOptionPane.showMessageDialog(this, "联系方式不能为空");
			return;
		}
		if(StringUtil.isEmpty(waiter_sex)) {
			JOptionPane.showMessageDialog(this, "性别不能为空");
			return;
		}
		if(StringUtil.isEmpty(waiter_password)) {
			JOptionPane.showMessageDialog(this, "密码不能为空");
			return;
		}
		waiter waitertmp = new waiter();
		waitertmp.setWaiter_id(waiterlisttable.getValueAt(row, 0).toString());
		waitertmp.setWaiter_name(waiter_name);
		waitertmp.setWaiter_sex(waiter_sex);
		waitertmp.setWaiter_tel(waiter_tel);
		waitertmp.setWaiter_password(waiter_password);
		WaiterDao waiterdao = new WaiterDao();
		if(waiterdao.update(waitertmp)) {
			JOptionPane.showMessageDialog(this, "修改成功！");
		}
		else {
			JOptionPane.showMessageDialog(this, "修改失败！");
		}
		setTable(new waiter());
	}
}

package com.hejiaman.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.hejiaman.dao.BillDao;
import com.hejiaman.dao.OrderDao;
import com.hejiaman.dao.RoomDao;
import com.hejiaman.model.Reserve;
import com.hejiaman.util.StringUtil;

public class WaiterFrm extends JFrame {

	private JPanel contentPane;
	private JTextField searchtextField;
	private JTable ordertable;
	private JTextField room_idtextField;
	private JTextField bill_pricetextField;
	private JTextField customer_idtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WaiterFrm frame = new WaiterFrm();
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
	public WaiterFrm() {
		setTitle("服务员操作界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 492);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnNewButton = new JButton("安排房间");
		btnNewButton.setIcon(new ImageIcon(WaiterFrm.class.getResource("/pic/ico_前台接待_安排入住.png")));
		btnNewButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("退出系统");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(WaiterFrm.this, "确定退出吗？") == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(WaiterFrm.class.getResource("/pic/退出.png")));
		btnNewButton_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		menuBar.add(btnNewButton_1);
		
		JMenu mnNewMenu = new JMenu("信息查看");
		mnNewMenu.setIcon(new ImageIcon(WaiterFrm.class.getResource("/pic/查看.png")));
		mnNewMenu.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("顾客信息查看");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerinfo(e);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(WaiterFrm.class.getResource("/pic/顾客画像 base_setting_customerPortrait .png")));
		mntmNewMenuItem.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("房间信息查看");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				roominfo(e);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(WaiterFrm.class.getResource("/pic/预约reserve.png")));
		mntmNewMenuItem_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("个人中心");
		mnNewMenu_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		mnNewMenu_1.setIcon(new ImageIcon(WaiterFrm.class.getResource("/pic/个人.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("个人信息修改");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new changewaiter().setVisible(true);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(WaiterFrm.class.getResource("/pic/信息空心.png")));
		mntmNewMenuItem_2.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("密码修改");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editpassword(e);
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(WaiterFrm.class.getResource("/pic/密码（关）.png")));
		mntmNewMenuItem_3.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("顾客姓名:");
		lblNewLabel.setIcon(new ImageIcon(WaiterFrm.class.getResource("/pic/查找 (2).png")));
		lblNewLabel.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		searchtextField = new JTextField();
		searchtextField.setColumns(10);
		
		JButton searchButton = new JButton("查询");
		searchButton.setIcon(new ImageIcon(WaiterFrm.class.getResource("/pic/发现.png")));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Reserve res = new Reserve();
				String customer_name = searchtextField.getText().toString();
				setTable(res);
			}
		});
		searchButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("安排房间");
		lblNewLabel_1.setIcon(new ImageIcon(WaiterFrm.class.getResource("/pic/天使.png")));
		lblNewLabel_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("确认房号：");
		lblNewLabel_2.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		room_idtextField = new JTextField();
		room_idtextField.setColumns(10);
		JLabel lblNewLabel_2_1 = new JLabel("确认金额：");
		lblNewLabel_2_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		bill_pricetextField = new JTextField();
		bill_pricetextField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("确认安排");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changecondition(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(WaiterFrm.class.getResource("/pic/驯鹿.png")));
		btnNewButton_2.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 18));
		
		JButton btnNewButton_2_1 = new JButton("确认退房");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkout(e);
			}
		});
		btnNewButton_2_1.setIcon(new ImageIcon(WaiterFrm.class.getResource("/pic/铃铛.png")));
		btnNewButton_2_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2_1_1 = new JLabel("顾客账号：");
		lblNewLabel_2_1_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		customer_idtextField = new JTextField();
		customer_idtextField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("结算消费");
		lblNewLabel_1_1.setIcon(new ImageIcon(WaiterFrm.class.getResource("/pic/蝴蝶结.png")));
		lblNewLabel_1_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 20));
		
		JButton cancelButton = new JButton("取消预约");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel(e);
			}
		});
		cancelButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(93)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(searchtextField, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(168, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(bill_pricetextField, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(customer_idtextField, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(40)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_2)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(room_idtextField, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))))
							.addGap(34)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_2_1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(searchtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(searchButton, 0, 0, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(room_idtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_2))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(36)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(bill_pricetextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
										.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(btnNewButton_2_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(62)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(customer_idtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		
		ordertable = new JTable();
		ordertable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u987E\u5BA2\u8D26\u53F7", "\u9884\u5B9A\u623F\u95F4", "\u5F00\u59CB\u4F7F\u7528\u65F6\u95F4", "\u7ED3\u675F\u4F7F\u7528\u65F6\u95F4"
			}
		));
		ordertable.getColumnModel().getColumn(2).setPreferredWidth(105);
		ordertable.getColumnModel().getColumn(3).setPreferredWidth(124);
		scrollPane.setViewportView(ordertable);
		contentPane.setLayout(gl_contentPane);
		setTable(new Reserve());
	}
	
	protected void cancel(ActionEvent e) {
		// TODO Auto-generated method stub
		String order_user = customer_idtextField.getText().toString();
		OrderDao orderdao = new OrderDao();
		Reserve reservetmp = new Reserve();
		reservetmp.setOrder_user(order_user);
		JOptionPane.showMessageDialog(this, orderdao.cancle(reservetmp));
		
		return;
		
	}

	protected void roominfo(ActionEvent e) {
		// TODO Auto-generated method stub
		showroominfo(e);
	}

	private void showroominfo(ActionEvent e) {
		// TODO Auto-generated method stub
		new RoominfoFrm().setVisible(true);
	}

	protected void customerinfo(ActionEvent e) {
		// TODO Auto-generated method stub
		new CusinfoFrm().setVisible(true);
	}

	protected void checkout(ActionEvent e) {
		// TODO Auto-generated method stub
		String room_id = room_idtextField.getText().toString();
		String customer_id = customer_idtextField.getText().toString();
		String bill_price = bill_pricetextField.getText().toString();
		if(StringUtil.isEmpty(room_id)) {
			JOptionPane.showMessageDialog(this, "请输入房间号");
			return;
		}
		if(StringUtil.isEmpty(customer_id)) {
			JOptionPane.showMessageDialog(this, "顾客账号");
			return;
		}
		if(StringUtil.isEmpty(bill_price)) {
			JOptionPane.showMessageDialog(this, "请输入消费金额");
			return;
		}
		BillDao billdao = new BillDao();
		RoomDao roomdao = new RoomDao();
		JOptionPane.showMessageDialog(this,billdao.checkout(customer_id, room_id, bill_price));
		JOptionPane.showMessageDialog(this,roomdao.changecondition1(room_id));
	}

	protected void changecondition(ActionEvent e) {
		// TODO Auto-generated method stub
		String room_id = room_idtextField.getText().toString();
		if(StringUtil.isEmpty(room_id)) {
			JOptionPane.showMessageDialog(this, "请输入房间号");
			return;
		}
		RoomDao roomdao = new RoomDao();
		JOptionPane.showMessageDialog(this,roomdao.changecondition(room_id));
		
	}

	protected void editpassword(ActionEvent e) {
		// TODO Auto-generated method stub
		new changewaipsw().setVisible(true);
	}

	private void setTable(Reserve reserve) {
		DefaultTableModel dft = (DefaultTableModel) ordertable.getModel();
		dft.setRowCount(0);
		OrderDao orderdao = new OrderDao();
		String customer_name = searchtextField.getText().toString();
		List<Reserve> reserve1 = orderdao.getClassList(reserve,customer_name) ;
		for(Reserve res : reserve1) {
			Vector v = new Vector();
			v.add(res.getOrder_user());
			v.add(res.getOrder_room());
			v.add(res.getOrder_begintime());
			v.add(res.getOrder_endtime());
			dft.addRow(v);
		}
		
	}
}

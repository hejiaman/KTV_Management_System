package com.hejiaman.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.hejiaman.dao.CustomerDao;
import com.hejiaman.dao.OrderDao;
import com.hejiaman.dao.RoomDao;
import com.hejiaman.model.Customer;
import com.hejiaman.model.Reserve;
import com.hejiaman.model.Room;
import com.hejiaman.model.user_identify;
import com.hejiaman.util.PutinStorage;
import com.hejiaman.util.StringUtil;

import javax.swing.event.AncestorEvent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JSeparator;
import javax.swing.JDesktopPane;

public class UserFrm extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel tableModel;
	private JTextField order_roomtextField;
	private JTextField order_usertextField;
	private JTextField order_begintimetextField;
	private JTextField order_endtimetextField;
	private JTable table;
	private String head[]=null;
    private Object [][]data=null;
    private RoomDao roomdao=new RoomDao();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFrm frame = new UserFrm();
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
	public UserFrm() {
		setTitle("顾客主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 489);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnNewButton = new JButton("房间预约");
		btnNewButton.setIcon(new ImageIcon(UserFrm.class.getResource("/pic/房间.png")));
		btnNewButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("退出系统");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(JOptionPane.showConfirmDialog(UserFrm.this, "确定退出吗？") == JOptionPane.OK_OPTION) {
				System.exit(0);
			}
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(UserFrm.class.getResource("/pic/退出.png")));
		btnNewButton_2.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		menuBar.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("关于我们");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				aboutUs(ae);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(UserFrm.class.getResource("/pic/帮助.png")));
		btnNewButton_3.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		menuBar.add(btnNewButton_3);
		
		JMenu mnNewMenu = new JMenu("个人信息修改");
		mnNewMenu.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		mnNewMenu.setIcon(new ImageIcon(UserFrm.class.getResource("/pic/个人.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("基础信息修改");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeinfo(e);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(UserFrm.class.getResource("/pic/个人.png")));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("密码修改");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editpassword(e);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(UserFrm.class.getResource("/pic/使用概况统计.png")));
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("KTV房间情况");
		lblNewLabel.setIcon(new ImageIcon(UserFrm.class.getResource("/pic/唱歌123.png")));
		lblNewLabel.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 20));
		
		
		 head=new String[] {
		            "房间号", "房间单价", "房间容纳人数"
		        };

		        DefaultTableModel tableModel=new DefaultTableModel(queryData(),head){
		            public boolean isCellEditable(int row, int column)
		            {
		                return false;
		            }
		        };

		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_1 = new JLabel("预约房间");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setIcon(new ImageIcon(UserFrm.class.getResource("/pic/home.jpg")));
		lblNewLabel_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("预定房间号：");
		lblNewLabel_2.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		order_roomtextField = new JTextField();
		order_roomtextField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("顾客账号：");
		lblNewLabel_2_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		order_usertextField = new JTextField();
		order_usertextField.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("结束时间：");
		lblNewLabel_2_1_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2_2 = new JLabel("开始时间");
		lblNewLabel_2_2.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		order_begintimetextField = new JTextField();
		order_begintimetextField.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("预约");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reserve(e);
			}
		});
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(UserFrm.class.getResource("/pic/预定.png")));
		
		order_endtimetextField = new JTextField();
		order_endtimetextField.setColumns(10);
		
		JDesktopPane desktopPane = new JDesktopPane();
		setLocationRelativeTo(null);
		
		JButton cancelButton = new JButton("取消预约");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancle(e);
			}
		});
		cancelButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 20));
		cancelButton.setBackground(Color.WHITE);
		   
        
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(297)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
							.addGap(311))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblNewLabel_2_2)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(order_begintimetextField, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblNewLabel_2)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(order_roomtextField, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
											.addGap(56)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblNewLabel_2_1)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(order_usertextField, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(order_endtimetextField, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(244)
											.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)))
									.addGap(33)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNewLabel_3, 0, 0, Short.MAX_VALUE)
										.addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(cancelButton, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(436))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(268)
					.addComponent(lblNewLabel)
					.addContainerGap(759, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(8)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_2)
										.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
										.addComponent(order_usertextField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(16)
									.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
									.addGap(53)
									.addComponent(order_roomtextField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(order_begintimetextField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(order_endtimetextField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_4)
								.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))))
					.addGap(14))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(tableModel);
		contentPane.setLayout(gl_contentPane);
		
	}

	protected void cancle(ActionEvent e) {
		// TODO Auto-generated method stub
		String order_user =order_usertextField.getText().toString();
		String order_room =order_roomtextField.getText().toString();
		OrderDao orderdao = new OrderDao();
		Reserve reservetmp = new Reserve();
		reservetmp.setOrder_user(order_user);
		reservetmp.setOrder_room(order_room);
		JOptionPane.showMessageDialog(this, orderdao.cancle(reservetmp));
		return;
		
	}

	private Object[][] queryData() {
		// TODO Auto-generated method stub
		 List<Room> list= roomdao.queryAllRoom();//这里参考的写的：customer.queryAllCustomer();
	        data=new Object[list.size()][head.length];

	        for(int i=0;i<list.size();i++){
	            for(int j=0;j<head.length;j++){
	                data[i][0]=list.get(i).getRoom_id();
	                data[i][1]=list.get(i).getRoom_price();
	                data[i][2]=list.get(i).getRoom_capacity();
//	                data[i][3]=list.get(i).getRoom_condition();
	            }
	        }
	        return data;
	}

	protected void editpassword(ActionEvent e) {
		// TODO Auto-generated method stub
		new changecuspsw().setVisible(true);
	}

	protected void changeinfo(ActionEvent e) {
		// TODO Auto-generated method stub
		new changecus().setVisible(true);
	}

	protected void reserve(ActionEvent e) {
		// TODO Auto-generated method stub
		String order_room = order_roomtextField.getText().toString();
		String order_user = order_usertextField.getText().toString();
		String order_begintime = order_begintimetextField.getText().toString();
		String order_endtime = order_endtimetextField.getText().toString();
		if(StringUtil.isEmpty(order_room)) {
			JOptionPane.showMessageDialog(this, "房间号不能为空");
			return;
		}
		if(StringUtil.isEmpty(order_user)) {
			JOptionPane.showMessageDialog(this, "账号不能为空");
			return;
		}
		if(StringUtil.isEmpty(order_begintime)) {
			JOptionPane.showMessageDialog(this, "开始时间不能为空");
			return;
		}
		if(StringUtil.isEmpty(order_endtime)) {
			JOptionPane.showMessageDialog(this, "结束时间不能为空");
			return;
		}
		if(order_begintime.equals(order_endtime)) {
			JOptionPane.showMessageDialog(this, "开始时间和结束时间不能一样");
			return;
		}
	
		OrderDao orderdao = new OrderDao();
		Reserve reservetmp = new Reserve();
		reservetmp.setOrder_user(order_user);
		reservetmp.setOrder_room(order_room);
		reservetmp.setOrder_begintime(order_begintime);
		reservetmp.setOrder_endtime(order_endtime);
		JOptionPane.showMessageDialog(this, orderdao.Order(reservetmp));
		
		return;
		

	}

	protected void aboutUs(ActionEvent ae) {
		// TODO Auto-generated method stub
		String info = "Barbara 出品\n";
		info += "欢迎沟通交流！\n";
		info += "联系邮箱：1348864196@qq.com";
		JOptionPane.showMessageDialog(this, info);
	}
}

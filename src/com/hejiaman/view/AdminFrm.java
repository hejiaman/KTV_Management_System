package com.hejiaman.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrm frame = new AdminFrm();
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
	public AdminFrm() {
		setTitle("管理员操作界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 513);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("顾客相关信息");
		mnNewMenu.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		mnNewMenu.setIcon(new ImageIcon(AdminFrm.class.getResource("/pic/个人.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("信息维护");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admincusinfo();
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(AdminFrm.class.getResource("/pic/信息.png")));
		mntmNewMenuItem.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 13));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("统计信息");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TJ(e);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(AdminFrm.class.getResource("/pic/统计分析-常规统计.png")));
		mntmNewMenuItem_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 13));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("服务员相关信息");
		mnNewMenu_1.setIcon(new ImageIcon(AdminFrm.class.getResource("/pic/员工.png")));
		mnNewMenu_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("信息维护");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminwaiinfo(e);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 13));
		mntmNewMenuItem_2.setIcon(new ImageIcon(AdminFrm.class.getResource("/pic/信息.png")));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("出勤情况");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chuqin(e);
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(AdminFrm.class.getResource("/pic/考勤打卡.png")));
		mntmNewMenuItem_3.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 13));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("房间相关信息");
		mnNewMenu_2.setIcon(new ImageIcon(AdminFrm.class.getResource("/pic/房间 (1).png")));
		mnNewMenu_2.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("信息维护");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminroominfo(e);
			}
		});
		mntmNewMenuItem_4.setIcon(new ImageIcon(AdminFrm.class.getResource("/pic/信息.png")));
		mntmNewMenuItem_4.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 13));
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("收入情况");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				income(e);
			}
		});
		mntmNewMenuItem_5.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 13));
		mntmNewMenuItem_5.setIcon(new ImageIcon(AdminFrm.class.getResource("/pic/收入.png")));
		mnNewMenu_2.add(mntmNewMenuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(157, 205, 227));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("都会时尚，尽在欢唱！");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("华光综艺_CNKI", Font.PLAIN, 30));
		lblNewLabel.setBounds(163, 306, 300, 62);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("欢迎来到管理员操作界面！");
		lblNewLabel_1.setFont(new Font("华光综艺_CNKI", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(163, 356, 300, 75);
		desktopPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(AdminFrm.class.getResource("/pic/唱歌.png")));
		lblNewLabel_2.setBounds(150, 42, 363, 255);
		desktopPane.add(lblNewLabel_2);
	}

	protected void TJ(ActionEvent e) {
		// TODO Auto-generated method stub
		TJFrm tjfrm = new TJFrm();
		tjfrm.setVisible(true);
	}

	protected void income(ActionEvent e) {
		// TODO Auto-generated method stub
		IncomeFrm incomefrm = new IncomeFrm();
		incomefrm.setVisible(true);
	}

	protected void chuqin(ActionEvent e) {
		// TODO Auto-generated method stub
		ChuqinFrm chuqin = new ChuqinFrm();
		chuqin.setVisible(true);
	}

	protected void adminroominfo(ActionEvent e) {
		// TODO Auto-generated method stub
		AdminroomFrm roominfo = new AdminroomFrm();
		roominfo.setVisible(true);
	}

	protected void adminwaiinfo(ActionEvent e) {
		// TODO Auto-generated method stub
		AdminwaiFrm adminwaifrm = new AdminwaiFrm();
		adminwaifrm.setVisible(true);
	}

	protected void admincusinfo() {
		// TODO Auto-generated method stub
		AdmincusFrm admincusfrm = new AdmincusFrm();
		admincusfrm.setVisible(true);
		
				
	}
}

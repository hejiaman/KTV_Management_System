package com.hejiaman.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.hejiaman.dao.CustomerDao;
import com.hejiaman.dao.RoomDao;
import com.hejiaman.model.Customer;
import com.hejiaman.model.Room;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;

public class RoominfoFrm extends JFrame {

	private JPanel contentPane;
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
					RoominfoFrm frame = new RoominfoFrm();
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
	public RoominfoFrm() {
		setTitle("房间信息查看");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("KTV房间使用情况");
		lblNewLabel.setIcon(new ImageIcon(RoominfoFrm.class.getResource("/pic/植物icon-荷花.png")));
		lblNewLabel.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 20));
		 head=new String[] {
		            "房间号", "房间单价", "房间容纳人数", "房间状态"
		        };

		        DefaultTableModel tableModel=new DefaultTableModel(queryData(),head){
		            public boolean isCellEditable(int row, int column)
		            {
		                return false;
		            }
		        };
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(204)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 617, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		table = new JTable();
		
		scrollPane.setViewportView(table);
		table.setModel(tableModel);
		contentPane.setLayout(gl_contentPane);
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
	                data[i][3]=list.get(i).getRoom_condition();
	            }
	        }
	        return data;
	}
}

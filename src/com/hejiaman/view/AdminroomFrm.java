package com.hejiaman.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Panel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.hejiaman.dao.RoomDao;
import com.hejiaman.dao.WaiterDao;
import com.hejiaman.model.Room;
import com.hejiaman.model.waiter;
import com.hejiaman.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class AdminroomFrm extends JFrame {

	private JPanel contentPane;
	private JTextField searchtextField;
	private JTable roomlisttable;
	private JTextField idtextField;
	private JTextField pricetextField;
	private JTextField capacitytextField;
	private JTextField conditiontextField;
	private JScrollPane scrollPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminroomFrm frame = new AdminroomFrm();
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
	public AdminroomFrm() {
		setTitle("房间信息管理");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("房间号：");
		lblNewLabel.setIcon(new ImageIcon(AdminroomFrm.class.getResource("/pic/ico_酒店管理_房间预约.png")));
		lblNewLabel.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		searchtextField = new JTextField();
		searchtextField.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Room room = new Room();
					setTable(room);
			}
		});
		btnNewButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		btnNewButton.setIcon(new ImageIcon(AdminroomFrm.class.getResource("/pic/发现.png")));
		
		scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u623F\u95F4\u4FE1\u606F\u4FEE\u6539", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(123)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchtextField, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(searchtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton))
						.addComponent(lblNewLabel))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(26))
		);
		
		JLabel lblNewLabel_1 = new JLabel("房间号：");
		lblNewLabel_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1_1 = new JLabel("房间价格：");
		lblNewLabel_1_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("容纳人数：");
		lblNewLabel_1_1_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("房间状态：");
		lblNewLabel_1_1_1_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		idtextField = new JTextField();
		idtextField.setColumns(10);
		
		pricetextField = new JTextField();
		pricetextField.setColumns(10);
		
		capacitytextField = new JTextField();
		capacitytextField.setColumns(10);
		
		conditiontextField = new JTextField();
		conditiontextField.setColumns(10);
		
		JButton deleteButton = new JButton("删除信息");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete(e);
			}
		});
		deleteButton.setIcon(new ImageIcon(AdminroomFrm.class.getResource("/pic/删除.png")));
		deleteButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		roomlisttable = new JTable();
		roomlisttable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedTableRow(e);
			}
		});
		roomlisttable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u623F\u95F4\u53F7", "\u623F\u95F4\u4EF7\u683C", "\u623F\u95F4\u5BB9\u7EB3\u4EBA\u6570", "\u623F\u95F4\u72B6\u6001"
			}
		));
		roomlisttable.getColumnModel().getColumn(2).setPreferredWidth(96);
		scrollPane.setViewportView(roomlisttable);
		JButton submitButton = new JButton("确认修改");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editroom(e);
			}
		});
		submitButton.setIcon(new ImageIcon(AdminroomFrm.class.getResource("/pic/ok.png")));
		submitButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(idtextField, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(capacitytextField, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
					.addGap(43)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
							.addComponent(deleteButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_1_1_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(pricetextField, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(conditiontextField, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(idtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pricetextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(capacitytextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(conditiontextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		
		scrollPane.setViewportView(roomlisttable);
		contentPane.setLayout(gl_contentPane);
		
		setTable(new Room());
	}
	
	protected void delete(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = roomlisttable.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "请选择要删除的数据");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "确定删除吗？")!= JOptionPane.OK_OPTION )return;
		String id = roomlisttable.getValueAt(row, 0).toString();
		RoomDao roomdao = new RoomDao();
		if(roomdao.delete(id)) {
			JOptionPane.showMessageDialog(this, "删除成功！");
		}
		else {
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		setTable(new Room());
	}
	
	protected void selectedTableRow(MouseEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) roomlisttable.getModel();
		idtextField.setText(dft.getValueAt(roomlisttable.getSelectedRow(),0).toString());
		pricetextField.setText(dft.getValueAt(roomlisttable.getSelectedRow(),1).toString());
		capacitytextField.setText(dft.getValueAt(roomlisttable.getSelectedRow(),2).toString());
		conditiontextField.setText(dft.getValueAt(roomlisttable.getSelectedRow(),3).toString());

	}

	protected void setTable(Room room) {
		// TODO Auto-generated method stub
		String id = searchtextField.getText().toString();
		DefaultTableModel dft = (DefaultTableModel)roomlisttable.getModel();
		dft.setRowCount(0);
		RoomDao roomdao = new RoomDao();
		room.setRoom_id(id);
		List<Room> room1 = roomdao.getroomList(room);
		for(Room wai : room1) {
			Vector v = new Vector();
			v.add(wai.getRoom_id());
			v.add(wai.getRoom_price());
			v.add(wai.getRoom_capacity());
			v.add(wai.getRoom_condition());
			dft.addRow(v);
		}	
	}
	
	protected void editroom(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = roomlisttable.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "请选择要修改的数据");
			return;
		}
		String room_id= idtextField.getText().toString();
		String room_price= pricetextField.getText().toString();
		String room_capacity= capacitytextField.getText().toString();
		String room_condition= conditiontextField.getText().toString();
		if(StringUtil.isEmpty(room_id)) {
			JOptionPane.showMessageDialog(this, "房间号不能为空");
			return;
		}
		if(StringUtil.isEmpty(room_price)) {
			JOptionPane.showMessageDialog(this, "房间价格不能为空");
			return;
		}
		if(StringUtil.isEmpty(room_capacity)) {
			JOptionPane.showMessageDialog(this, "容纳人数不能为空");
			return;
		}
		if(StringUtil.isEmpty(room_condition)) {
			JOptionPane.showMessageDialog(this, "房间状态不能为空");
			return;
		}
		Room roomtmp = new Room();
		roomtmp.setRoom_id(roomlisttable.getValueAt(row, 0).toString());
		roomtmp.setRoom_price(room_price);
		roomtmp.setRoom_capacity(room_capacity);
		roomtmp.setRoom_condition(room_condition);
		RoomDao roomdao = new RoomDao();
		if(roomdao.update(roomtmp)) {
			JOptionPane.showMessageDialog(this, "修改成功！");
		}
		else {
			JOptionPane.showMessageDialog(this, "修改失败！");
		}
		setTable(new Room());
	}
}

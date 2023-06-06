package com.hejiaman.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.hejiaman.dao.WaiterDao;
import com.hejiaman.model.waiter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChuqinFrm extends JFrame {

	private JPanel contentPane;
	private JTextField searchtextField;
	private JTable waiterlisttable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChuqinFrm frame = new ChuqinFrm();
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
	public ChuqinFrm() {
		setTitle("员工考勤页面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("服务员姓名：");
		lblNewLabel.setIcon(new ImageIcon(ChuqinFrm.class.getResource("/pic/员工.png")));
		lblNewLabel.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		searchtextField = new JTextField();
		searchtextField.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				waiter waiter1 = new waiter();
				setTable(waiter1);
			}
		});
		btnNewButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton_1 = new JButton("迟到记录");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chidao();
			}
		});
		btnNewButton_1.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(searchtextField, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNewButton))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(133)
							.addComponent(btnNewButton_1)))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(searchtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton))
						.addComponent(lblNewLabel))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addContainerGap(117, Short.MAX_VALUE))
		);
		
		waiterlisttable = new JTable();

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
		
		contentPane.setLayout(gl_contentPane);
		setTable(new waiter());
	}
	
	protected void chidao() {
		// TODO Auto-generated method stub
		int row = waiterlisttable.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "请选择要记录的员工");
			return;
		}
		String id = waiterlisttable.getValueAt(row, 0).toString();
		WaiterDao waiterdao = new WaiterDao();
		if(waiterdao.late(id)) {
			JOptionPane.showMessageDialog(this, "记录成功！");
		}
		else {
			JOptionPane.showMessageDialog(this, "记录失败！");
		}
		setTable(new waiter());
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
}

package com.hejiaman.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hejiaman.dao.BillDao;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IncomeFrm extends JFrame {

	private JPanel contentPane;
	private JTextField sumtextField;
	private JTextField avgtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IncomeFrm frame = new IncomeFrm();
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
	public IncomeFrm() {
		setTitle("收入查询界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 387, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("收入查询");
		lblNewLabel.setIcon(new ImageIcon(IncomeFrm.class.getResource("/pic/钱袋.png")));
		lblNewLabel.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 20));
		
		JButton sumButton = new JButton("总收入");
		sumButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sum(e);
			}
		});
		sumButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		sumtextField = new JTextField();
		sumtextField.setEditable(false);
		sumtextField.setColumns(10);
		
		JButton avgButton = new JButton("人均消费");
		avgButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				avg(e);
			}
		});
		avgButton.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 15));
		
		avgtextField = new JTextField();
		avgtextField.setEditable(false);
		avgtextField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(avgButton)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(avgtextField))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(sumButton)
									.addGap(18)
									.addComponent(sumtextField, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(114)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(sumButton)
						.addComponent(sumtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(avgButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(avgtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(95))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void avg(ActionEvent e) {
		// TODO Auto-generated method stub
		BillDao billdao = new BillDao();
		avgtextField.setText(billdao.avg().toString());
	}

	protected void sum(ActionEvent e) {
		// TODO Auto-generated method stub
		BillDao billdao = new BillDao();
		sumtextField.setText(billdao.sum().toString());
	}

}

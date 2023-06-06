package com.hejiaman.view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.hejiaman.dao.CustomerDao;
import com.hejiaman.model.Customer;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;

public class CusinfoFrm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String head[]=null;
    private Object [][]data=null;
    private CustomerDao customerdao=new CustomerDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CusinfoFrm frame = new CusinfoFrm();
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
	public CusinfoFrm() {
		setTitle("顾客个人信息查看");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("顾客相关信息");
		lblNewLabel.setIcon(new ImageIcon(CusinfoFrm.class.getResource("/pic/2.jpg")));
		lblNewLabel.setFont(new Font("华光黑变_CNKI", Font.PLAIN, 20));
		
//		table.setBorder(new LineBorder(new Color(0, 0, 0)));
        head=new String[] {
            "顾客账号", "顾客姓名", "顾客性别", "顾客联系方式", "顾客身份证号码",
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
							.addGap(26)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(270)
							.addComponent(lblNewLabel)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(tableModel);
		contentPane.setLayout(gl_contentPane);
		
	}

	private Object[][] queryData() {
		// TODO Auto-generated method stub
		 List<Customer> list= customerdao.queryAllCustomer();//这里参考的写的：customer.queryAllCustomer();
	        data=new Object[list.size()][head.length];

	        for(int i=0;i<list.size();i++){
	            for(int j=0;j<head.length;j++){
	                data[i][0]=list.get(i).getCustomer_id();
	                data[i][1]=list.get(i).getCustomer_idcard();
	                data[i][2]=list.get(i).getCustomer_name();
	                data[i][3]=list.get(i).getCustomer_sex();
	                data[i][4]=list.get(i).getCustomer_tel();
	            }
	        }
	        return data;
	}
}

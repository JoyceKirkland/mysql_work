package Enterprise_power;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Enterprise_power extends JFrame {
		
	JLabel label1_wel;//��¼���滶ӭ���ǩ
	JLabel label2_name;//��¼���桰�û�������ǩ
	JLabel label3_password;//��¼���桰���롱��ǩ
//	JLabel label4_class;//��¼���桰�༶����ǩ
	JTextField jtf2_name;//��¼���桰�û��������ı���
	JTextField jtf3_password;//��¼���桰���롱�����ı���
//	JTextField jtf4_class;//��¼���桰�༶�������ı���
	JButton jbt1_login;//��½��ť
	JButton jbt2_exit;//�˳���ť
	
	Container con=this.getContentPane();//��������
	
public String getName()
{
	return jtf2_name.getText();
}
public String getGrade()
{
	return label3_password.getText();
}


public Enterprise_power()
{
	this.setSize(500,400);//���õ�½�����С
	this.setTitle("��ҵ�õ����ϵͳ");
	this.setLocation(800, 200);//���ÿ������������λ��
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�˳�
	
	con.setLayout(null);//����һ������
	
	label1_wel=new JLabel("�����������Ϣ");//�������뿼����Ϣ����ǩ
	label1_wel.setFont(new Font("΢���ź�", Font.BOLD, 20));
	label1_wel.setBounds(110, 30, 150, 40);
	con.add(label1_wel);
		
	label2_name=new JLabel("�û�����");//����������ǩ
	label2_name.setFont(new Font("΢���ź�", Font.BOLD, 20));
	label2_name.setBounds(50, 90, 80, 40);	
	con.add(label2_name);
	
	label3_password=new JLabel("���룺");//���꼶��ǩ��
	label3_password.setFont(new Font("΢���ź�", Font.BOLD, 20));
	label3_password.setBounds(50, 140, 67, 40);
	con.add(label3_password);
	
//	label4_class=new JLabel("�༶��");//���༶��ǩ��
//	label4_class.setFont(new Font("΢���ź�", Font.BOLD, 20));
//	label4_class.setBounds(60, 190, 105, 40);
//	con.add(label4_class);
	
	jbt1_login=new JButton("��½");//����½����ť
	jbt1_login.setFont(new Font("΢���ź�", Font.BOLD, 20));
	jbt1_login.setBounds(130, 270, 80, 30);

	jbt2_exit=new JButton("�˳�");//���˳���ť��
	jbt2_exit.setFont(new Font("΢���ź�", Font.BOLD, 20));
	jbt2_exit.setBounds(290, 270, 80, 30);
	
	
	jtf2_name=new JTextField();//����¼���桱�ı���
	jtf2_name.setBounds(130, 97, 240, 30);
	con.add(jtf2_name);
	jtf3_password=new JTextField();//���������ı���
	jtf3_password.setBounds(130, 147, 240, 30);
	con.add(jtf3_password);
//	jtf4_class=new JTextField();//���꼶"�ı���
//	jtf4_class.setBounds(130, 197, 240, 30);
//	con.add(jtf4_class);
			
	this.setVisible(true);	

	//��½
	jbt1_login.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)//����������¼� 
		{
			BufferedWriter buf;
			String l2_name  = jtf2_name.getText();
			String l3_password = jtf3_password.getText();
//			String l4_class = jtf4_class.getText();
			if(l2_name.equals("")||l3_password.equals(""))
			{
				JOptionPane.showMessageDialog(null,"��������������Ϣ\n");				
			}else//�жϵ�½��Ա�Ƿ�Ϊ����Ա
			{					
				if(l2_name.equals("����")&&l3_password.equals("����")) 
				{
					admin tea = new admin();
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"�û�������\n");	
				}
			}
		}
	});
	con.add(jbt1_login);//�����������ʵ�������������
	
	//�˳�
	jbt2_exit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) 
		{
			JOptionPane.showMessageDialog(null,"��лʹ�ñ�ϵͳ�� \n");
			System.exit(0);
		}
	});
	con.add(jbt2_exit);
	

}

}
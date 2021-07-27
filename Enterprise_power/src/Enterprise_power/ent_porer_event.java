package Enterprise_power;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.text.DecimalFormat;
import java.util.*;
import javax.swing.Timer;
import java.io.*;
import java.awt.Dialog;

class ent_porer_event extends JFrame{
	JPanel cardpanel;//������ʽ����
	JPanel con_cardpanel;//��ſ�ʽ���������������Ŀ�밴ť��
	JPanel[] panel=new JPanel[10];
	JLabel input_name;//������ҵ��
	JLabel ent_num;//��ҵ���
	JLabel ent_name;//��ҵ��
	JLabel ent_address;//��ҵ��ַ
	JLabel ent_tel;//��ҵ�绰
	JLabel ent_present;//��ҵ��ϵ��
	JLabel month_pow;//���õ���
	JLabel month_pow_cost;//�µ��
	JLabel year_low_pow;//��ȵ���
	JLabel year_high_pow;//������
	JLabel year_total_pow;//���ܵ���
	JLabel year_total_pow_cost;//���ܵ��
	
	JTextField jtf0_input_name;//������ҵ����
	JTextField jtf1_ent_num;//��ҵ��ſ�
	JTextField jtf2_ent_name;//��ҵ����
	JTextField jtf3_ent_address;//��ҵ��ַ��
	JTextField jtf4_ent_tel;//��ҵ�绰��
	JTextField jtf5_ent_present;//��ҵ��ϵ�˿�
	JTextField jtf6_month_pow;//���õ�����
	JTextField jtf7_month_pow_cost;//�µ�ѿ�
	JTextField jtf8_year_low_pow;//��ȵ�����
	JTextField jtf9_year_high_pow;//��������
	JTextField jtf10_year_total_pow;//���ܵ�����
	JTextField jtf11_year_total_pow_cost;//���ܵ�ѿ�
	
	String[] answer_student=new String[50];//�û��𰸴������
	String[] answer_correct=new String[50];//��ȷ�𰸴������                 	
    JButton information;//�鿴��Ϣ
    JButton confirm_del;//ȷ��ɾ��
    JButton confirm_add;//ȷ�����
    JButton confirm_change;//ȷ���޸�
    JButton back;//����
	
	ArrayList<String> student_scores = new ArrayList<String>();//����ѧ���ɼ�
	BufferedReader in;//����һ�������ַ�������
	BufferedWriter fos;//����һ���ַ����������
	int score=0;//�ɼ���ʼ��
	Container con_event = this.getContentPane();//����
	int target=0;//���ģʽ
	
public ent_porer_event(int target)//����ѯҳ�棬����Ա����ͨ�û�ͨ��
{ 
	//���������
	this.setBounds(100,100,870,700);//��������С
	this.setTitle("��ѯ��ҵ��Ϣ");//���ÿ��Խ������
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);//������������Ļ����
	con_event.setLayout(null);//�����ֹ�������ʼ��

	//����JPanel���������������cardlayout�Ĳ��֣��������Ŀ�Ĳ���
//	cardpanel = new JPanel();//ʵ����������	
//	cardpanel.setBounds(30, 40, 760, 400);//���ô�С
//	cardpanel.setLayout(new CardLayout(0,0));//�����ֹ�������ʼ��
//	con_event.add(cardpanel);//
	
	//��ҳ���֣����������ť�Ĳ��֣�
//	con_cardpanel = new JPanel();		
//	con_cardpanel.setBounds(30, 520, 760, 50);
//	con_event.add(con_cardpanel);
	
	input_name=new JLabel("��������ҵ��:");//������ҵ����ǩ
	input_name.setFont(new Font("΢���ź�", Font.BOLD, 20));
	input_name.setBounds(80, 30, 130, 30);
	con_event.add(input_name);
		
	ent_num=new JLabel("       ��ҵ���:");//����ҵ��š���ǩ
	ent_num.setFont(new Font("΢���ź�", Font.BOLD, 20));
	ent_num.setBounds(80, 90, 150, 30);
	con_event.add(ent_num);
	
	ent_name=new JLabel("          ��ҵ��:");//����ҵ������ǩ
	ent_name.setFont(new Font("΢���ź�", Font.BOLD, 20));
	ent_name.setBounds(80, 130, 150, 30);
	con_event.add(ent_name);
	
	ent_address=new JLabel("       ��ҵ��ַ:");//����ҵ��ַ����ǩ
	ent_address.setFont(new Font("΢���ź�", Font.BOLD, 20));
	ent_address.setBounds(80, 170, 150, 30);
	con_event.add(ent_address);
	
	ent_tel=new JLabel("       ��ҵ�绰:");//����ҵ�绰����ǩ
	ent_tel.setFont(new Font("΢���ź�", Font.BOLD, 20));
	ent_tel.setBounds(80, 210, 150, 30);
	con_event.add(ent_tel);
	
	ent_present=new JLabel("    ��ҵ��ϵ��:");//����ҵ��ϵ�ˡ���ǩ
	ent_present.setFont(new Font("΢���ź�", Font.BOLD, 20));
	ent_present.setBounds(80, 250, 150, 30);
	con_event.add(ent_present);
	
	month_pow=new JLabel("       ���õ���:");//�����õ�������ǩ
	month_pow.setFont(new Font("΢���ź�", Font.BOLD, 20));
	month_pow.setBounds(80, 290, 150, 30);
	con_event.add(month_pow);
	
	month_pow_cost=new JLabel("          �µ��:");//���µ�ѡ���ǩ
	month_pow_cost.setFont(new Font("΢���ź�", Font.BOLD, 20));
	month_pow_cost.setBounds(80, 330, 150, 30);
	con_event.add(month_pow_cost);
	
	year_low_pow=new JLabel("       ��ȵ���:");//����ȵ�������ǩ
	year_low_pow.setFont(new Font("΢���ź�", Font.BOLD, 20));
	year_low_pow.setBounds(80, 370, 150, 30);
	con_event.add(year_low_pow);
	
	year_high_pow=new JLabel("       ������:");//������������ǩ
	year_high_pow.setFont(new Font("΢���ź�", Font.BOLD, 20));
	year_high_pow.setBounds(80, 410, 150, 30);
	con_event.add(year_high_pow);
	
	year_total_pow=new JLabel("       ���ܵ���:");//�����ܵ�������ǩ
	year_total_pow.setFont(new Font("΢���ź�", Font.BOLD, 20));
	year_total_pow.setBounds(80, 450, 150, 30);
	con_event.add(year_total_pow);
	
	year_total_pow_cost=new JLabel("       ���ܵ��:");//�����ܵ�ѡ���ǩ
	year_total_pow_cost.setFont(new Font("΢���ź�", Font.BOLD, 20));
	year_total_pow_cost.setBounds(80, 490, 150, 30);
	con_event.add(year_total_pow_cost);
	//____________________________________________________
	jtf0_input_name=new JTextField();//����¼���桱�ı���
	jtf0_input_name.setBounds(220, 30, 240, 30);
	con_event.add(jtf0_input_name);
	
	jtf1_ent_num=new JTextField();//����¼���桱�ı���
	jtf1_ent_num.setBounds(220, 90, 240, 30);
	con_event.add(jtf1_ent_num);
	
	jtf2_ent_name=new JTextField();//����¼���桱�ı���
	jtf2_ent_name.setBounds(220, 130, 240, 30);
	con_event.add(jtf2_ent_name);
	
	jtf3_ent_address=new JTextField();//����¼���桱�ı���
	jtf3_ent_address.setBounds(220, 170, 240, 30);
	con_event.add(jtf3_ent_address);
	
	jtf4_ent_tel=new JTextField();//����¼���桱�ı���
	jtf4_ent_tel.setBounds(220, 210, 240, 30);
	con_event.add(jtf4_ent_tel);
	
	jtf5_ent_present=new JTextField();//����¼���桱�ı���
	jtf5_ent_present.setBounds(220, 250, 240, 30);
	con_event.add(jtf5_ent_present);
	
	jtf6_month_pow=new JTextField();//����¼���桱�ı���
	jtf6_month_pow.setBounds(220, 290, 240, 30);
	con_event.add(jtf6_month_pow);
	
	jtf7_month_pow_cost=new JTextField();//����¼���桱�ı���
	jtf7_month_pow_cost.setBounds(220, 330, 240, 30);
	con_event.add(jtf7_month_pow_cost);
	
	jtf8_year_low_pow=new JTextField();//����¼���桱�ı���
	jtf8_year_low_pow.setBounds(220, 370, 240, 30);
	con_event.add(jtf8_year_low_pow);
	
	jtf9_year_high_pow=new JTextField();//����¼���桱�ı���
	jtf9_year_high_pow.setBounds(220, 410, 240, 30);
	con_event.add(jtf9_year_high_pow);
	
	jtf10_year_total_pow=new JTextField();//����¼���桱�ı���
	jtf10_year_total_pow.setBounds(220, 450, 240, 30);
	con_event.add(jtf10_year_total_pow);
	
	jtf11_year_total_pow_cost=new JTextField();//����¼���桱�ı���
	jtf11_year_total_pow_cost.setBounds(220, 490, 240, 30);
	con_event.add(jtf11_year_total_pow_cost);
	
	//�����ť
	if(target==1)
	{
		confirm_add = new JButton("ȷ�����");
		confirm_add.setFont(new Font("΢���ź�", Font.BOLD, 20));
		confirm_add.setBounds(220, 530, 150, 40);
		confirm_add.addActionListener(new ActionListener()//����������¼�����ͬ 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null,"��ӳɹ�\n");
				admin admin=new admin();
				dispose();
		}
	});
	con_event.add(confirm_add);	
	}else if(target==2)
	{
		confirm_del = new JButton("ȷ��ɾ��");
		confirm_del.setFont(new Font("΢���ź�", Font.BOLD, 20));
		confirm_del.setBounds(220, 530, 150, 40);
		confirm_del.addActionListener(new ActionListener()//����������¼�����ͬ 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null,"ɾ���ɹ�\n");
				admin admin=new admin();
				dispose();
			}
		});
		con_event.add(confirm_del);
	}else if(target==3)
	{
		confirm_change = new JButton("ȷ���޸�");
		confirm_change.setFont(new Font("΢���ź�", Font.BOLD, 20));
		confirm_change.setBounds(220, 530, 150, 40);
		confirm_change.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null,"�޸ĳɹ�\n");
				admin admin=new admin();
				dispose();
			}
		});
		con_event.add(confirm_change);
	}

	
    //������������������������������������������������������������������������������������������������	
	information = new JButton("�鿴��Ϣ");
	information.setFont(new Font("΢���ź�", Font.BOLD, 20));
	information.setBounds(530, 30, 120, 40);
	information.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
//			JOptionPane.showMessageDialog(null,"��ӳɹ�\n");
//			dispose();
		}
	});
	con_event.add(information);
	
	//���ذ�ť
	back = new JButton("����");
	back.setFont(new Font("΢���ź�", Font.BOLD, 20));
	back.setBounds(530, 530, 90, 40);
	back.addActionListener (new ActionListener() 
	{	
		public void actionPerformed (ActionEvent e)
		{
			admin admin=new admin();
			dispose();
		}
	}) ;
	con_event.add(back);
//	
//	//���������Ŀ
//	

	this.setVisible(true);//���������������ʾ
	
}
	
		
}

class admin extends JFrame //����Ա���
{
	BufferedReader buf_r;
	//��ť
	JButton qucery_aver;//�鿴ƽ����
	JButton admin_exit;//�˳�ϵͳ
	JButton manage_ent;//������ҵ��Ϣ
	DecimalFormat dec = new DecimalFormat(" .00");//������λС��
	JTextField enter_name;
	ArrayList<String> student_score_writer = new ArrayList<String>();//д���ļ���ѧ���ɼ�����
public admin() 
{
	//�����
	this.setBounds(100,100,700,400);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("��ҵ�õ�����ѯ");
	this.setLocationRelativeTo(null);
	Container con_teacher = this.getContentPane();
	con_teacher.setLayout(null);
	
	//�����ѯ���ı���
//	enter_name=new JTextField();
//	enter_name.setBounds(130, 97, 240, 30);
//	con_teacher.add(enter_name);
	
	//��ť
//	JButton qucery_aver;//�鿴ƽ����
//	JButton teacher_exit;//�˳�ϵͳ
	
	
	qucery_aver = new JButton("��ѯ");
	qucery_aver.setFont(new Font("΢���ź�", Font.BOLD, 25));
	qucery_aver.setBounds(200, 70, 300, 50);
	qucery_aver.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			ent_porer_event pow=new ent_porer_event(0);
			dispose();
//			JOptionPane.showConfirmDialog(null, "����ƽ����Ϊ��"+dec.format(average()));
		}
	});
	con_teacher.add(qucery_aver);
	
	manage_ent = new JButton("������ҵ��Ϣ");
	manage_ent.setFont(new Font("΢���ź�", Font.BOLD, 25));
	manage_ent.setBounds(200, 170, 300, 50);
	manage_ent.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			Manager_enterprise manger=new Manager_enterprise();
			dispose();
//			JOptionPane.showConfirmDialog(null, "����ƽ����Ϊ��"+dec.format(average()));
		}
	});
	con_teacher.add(manage_ent);
	
	admin_exit = new JButton("�˳�ϵͳ");
	admin_exit.setFont(new Font("΢���ź�", Font.BOLD, 25));
	admin_exit.setBounds(255, 280, 190, 50);
	admin_exit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "��ӭ�´�ʹ�ã�");
			System.exit(0);
		}
	});
	con_teacher.add(admin_exit);
	
	this.setVisible(true);
}
		
	
public double average()//����ƽ����
{
		ArrayList<Integer> student_aver = new ArrayList<Integer>();//���ļ���ȡѧ���ɼ�������
		
		try {
			buf_r = new BufferedReader(new FileReader("�ɼ�.txt"));
			String str=null;
			while((str=buf_r.readLine())!=null)//���ļ��ж�ȡһ���ַ�����ֵ��str
			{
				student_score_writer.add(str+"\n");
				String aver[] = str.split("\t");//��\t����
				student_aver.add(Integer.valueOf(aver[3]).intValue());
			}
			buf_r.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		double average=0,sum=0;
		for(int i=0;i<student_aver.size();i++) 
		{
			sum+=student_aver.get(i);
		}
		average = sum/student_aver.size();
		return average;
	}
}

//������ҵ��Ϣ���
class Manager_enterprise extends JFrame{
	
	JButton add_ent;//������ҵ��Ϣ
	JButton del_ent;//ɾ����ҵ��Ϣ
	JButton change_ent;//�޸���ҵ��Ϣ
	JButton manager_back;//����
	
public Manager_enterprise()
{
	this.setBounds(100,100,700,500);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("������ҵ��Ϣ");
	this.setLocationRelativeTo(null);
	Container con_manger = this.getContentPane();
	con_manger.setLayout(null);
	
	add_ent = new JButton("������ҵ��Ϣ");
	add_ent.setFont(new Font("΢���ź�", Font.BOLD, 25));
	add_ent.setBounds(200, 50, 300, 40);
	add_ent.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			ent_porer_event pow=new ent_porer_event(1);
			dispose();
//			JOptionPane.showConfirmDialog(null, "����ƽ����Ϊ��"+dec.format(average()));
		}
	});
	con_manger.add(add_ent);
	
	del_ent = new JButton("ɾ����ҵ��Ϣ");
	del_ent.setFont(new Font("΢���ź�", Font.BOLD, 25));
	del_ent.setBounds(200, 150, 300, 40);
	del_ent.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			ent_porer_event pow=new ent_porer_event(2);
			dispose();
//			JOptionPane.showConfirmDialog(null, "����ƽ����Ϊ��"+dec.format(average()));
		}
	});
	con_manger.add(del_ent);
	
	change_ent = new JButton("�޸���ҵ��Ϣ");
	change_ent.setFont(new Font("΢���ź�", Font.BOLD, 25));
	change_ent.setBounds(200, 250, 300, 40);
	change_ent.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			ent_porer_event pow=new ent_porer_event(3);
			dispose();
//			JOptionPane.showConfirmDialog(null, "����ƽ����Ϊ��"+dec.format(average()));
		}
	});
	con_manger.add(change_ent);
	
	manager_back = new JButton("�� ��");
	manager_back.setFont(new Font("΢���ź�", Font.BOLD, 25));
	manager_back.setBounds(250, 350, 200, 40);
	manager_back.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			admin admin = new admin();
			dispose();
		}
	});
	con_manger.add(manager_back);
	
	this.setVisible(true);
}
	
}
	
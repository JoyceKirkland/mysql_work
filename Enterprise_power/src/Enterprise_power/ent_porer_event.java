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
	JPanel cardpanel;//创建卡式布局
	JPanel con_cardpanel;//存放卡式布局组件，包括题目与按钮等
	JPanel[] panel=new JPanel[10];
	JLabel input_name;//输入企业名
	JLabel ent_num;//企业编号
	JLabel ent_name;//企业名
	JLabel ent_address;//企业地址
	JLabel ent_tel;//企业电话
	JLabel ent_present;//企业联系人
	JLabel month_pow;//月用电量
	JLabel month_pow_cost;//月电费
	JLabel year_low_pow;//年谷电量
	JLabel year_high_pow;//年峰电量
	JLabel year_total_pow;//年总电量
	JLabel year_total_pow_cost;//年总电费
	
	JTextField jtf0_input_name;//输入企业名框
	JTextField jtf1_ent_num;//企业编号框
	JTextField jtf2_ent_name;//企业名框
	JTextField jtf3_ent_address;//企业地址框
	JTextField jtf4_ent_tel;//企业电话框
	JTextField jtf5_ent_present;//企业联系人框
	JTextField jtf6_month_pow;//月用电量框
	JTextField jtf7_month_pow_cost;//月电费框
	JTextField jtf8_year_low_pow;//年谷电量框
	JTextField jtf9_year_high_pow;//年峰电量框
	JTextField jtf10_year_total_pow;//年总电量框
	JTextField jtf11_year_total_pow_cost;//年总电费框
	
	String[] answer_student=new String[50];//用户答案存放数组
	String[] answer_correct=new String[50];//正确答案存放数组                 	
    JButton information;//查看信息
    JButton confirm_del;//确认删除
    JButton confirm_add;//确认添加
    JButton confirm_change;//确认修改
    JButton back;//返回
	
	ArrayList<String> student_scores = new ArrayList<String>();//储存学生成绩
	BufferedReader in;//创建一个缓冲字符输入流
	BufferedWriter fos;//创建一个字符缓冲输出流
	int score=0;//成绩初始化
	Container con_event = this.getContentPane();//容器
	int target=0;//面板模式
	
public ent_porer_event(int target)//被查询页面，管理员和普通用户通用
{ 
	//设置主面板
	this.setBounds(100,100,870,700);//设置面板大小
	this.setTitle("查询企业信息");//设置考试界面标题
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);//将窗口置于屏幕中央
	con_event.setLayout(null);//流布局管理器初始化

	//设置JPanel（面板组件），存放cardlayout的部分，即存放题目的部分
//	cardpanel = new JPanel();//实例化面板组件	
//	cardpanel.setBounds(30, 40, 760, 400);//设置大小
//	cardpanel.setLayout(new CardLayout(0,0));//流布局管理器初始化
//	con_event.add(cardpanel);//
	
	//翻页部分（放置五个按钮的部分）
//	con_cardpanel = new JPanel();		
//	con_cardpanel.setBounds(30, 520, 760, 50);
//	con_event.add(con_cardpanel);
	
	input_name=new JLabel("请输入企业名:");//输入企业名标签
	input_name.setFont(new Font("微软雅黑", Font.BOLD, 20));
	input_name.setBounds(80, 30, 130, 30);
	con_event.add(input_name);
		
	ent_num=new JLabel("       企业编号:");//“企业编号”标签
	ent_num.setFont(new Font("微软雅黑", Font.BOLD, 20));
	ent_num.setBounds(80, 90, 150, 30);
	con_event.add(ent_num);
	
	ent_name=new JLabel("          企业名:");//“企业名”标签
	ent_name.setFont(new Font("微软雅黑", Font.BOLD, 20));
	ent_name.setBounds(80, 130, 150, 30);
	con_event.add(ent_name);
	
	ent_address=new JLabel("       企业地址:");//“企业地址”标签
	ent_address.setFont(new Font("微软雅黑", Font.BOLD, 20));
	ent_address.setBounds(80, 170, 150, 30);
	con_event.add(ent_address);
	
	ent_tel=new JLabel("       企业电话:");//“企业电话”标签
	ent_tel.setFont(new Font("微软雅黑", Font.BOLD, 20));
	ent_tel.setBounds(80, 210, 150, 30);
	con_event.add(ent_tel);
	
	ent_present=new JLabel("    企业联系人:");//“企业联系人”标签
	ent_present.setFont(new Font("微软雅黑", Font.BOLD, 20));
	ent_present.setBounds(80, 250, 150, 30);
	con_event.add(ent_present);
	
	month_pow=new JLabel("       月用电量:");//“月用电量”标签
	month_pow.setFont(new Font("微软雅黑", Font.BOLD, 20));
	month_pow.setBounds(80, 290, 150, 30);
	con_event.add(month_pow);
	
	month_pow_cost=new JLabel("          月电费:");//“月电费”标签
	month_pow_cost.setFont(new Font("微软雅黑", Font.BOLD, 20));
	month_pow_cost.setBounds(80, 330, 150, 30);
	con_event.add(month_pow_cost);
	
	year_low_pow=new JLabel("       年谷电量:");//“年谷电量”标签
	year_low_pow.setFont(new Font("微软雅黑", Font.BOLD, 20));
	year_low_pow.setBounds(80, 370, 150, 30);
	con_event.add(year_low_pow);
	
	year_high_pow=new JLabel("       年峰电量:");//“年峰电量”标签
	year_high_pow.setFont(new Font("微软雅黑", Font.BOLD, 20));
	year_high_pow.setBounds(80, 410, 150, 30);
	con_event.add(year_high_pow);
	
	year_total_pow=new JLabel("       年总电量:");//“年总电量”标签
	year_total_pow.setFont(new Font("微软雅黑", Font.BOLD, 20));
	year_total_pow.setBounds(80, 450, 150, 30);
	con_event.add(year_total_pow);
	
	year_total_pow_cost=new JLabel("       年总电费:");//“年总电费”标签
	year_total_pow_cost.setFont(new Font("微软雅黑", Font.BOLD, 20));
	year_total_pow_cost.setBounds(80, 490, 150, 30);
	con_event.add(year_total_pow_cost);
	//____________________________________________________
	jtf0_input_name=new JTextField();//“登录界面”文本框
	jtf0_input_name.setBounds(220, 30, 240, 30);
	con_event.add(jtf0_input_name);
	
	jtf1_ent_num=new JTextField();//“登录界面”文本框
	jtf1_ent_num.setBounds(220, 90, 240, 30);
	con_event.add(jtf1_ent_num);
	
	jtf2_ent_name=new JTextField();//“登录界面”文本框
	jtf2_ent_name.setBounds(220, 130, 240, 30);
	con_event.add(jtf2_ent_name);
	
	jtf3_ent_address=new JTextField();//“登录界面”文本框
	jtf3_ent_address.setBounds(220, 170, 240, 30);
	con_event.add(jtf3_ent_address);
	
	jtf4_ent_tel=new JTextField();//“登录界面”文本框
	jtf4_ent_tel.setBounds(220, 210, 240, 30);
	con_event.add(jtf4_ent_tel);
	
	jtf5_ent_present=new JTextField();//“登录界面”文本框
	jtf5_ent_present.setBounds(220, 250, 240, 30);
	con_event.add(jtf5_ent_present);
	
	jtf6_month_pow=new JTextField();//“登录界面”文本框
	jtf6_month_pow.setBounds(220, 290, 240, 30);
	con_event.add(jtf6_month_pow);
	
	jtf7_month_pow_cost=new JTextField();//“登录界面”文本框
	jtf7_month_pow_cost.setBounds(220, 330, 240, 30);
	con_event.add(jtf7_month_pow_cost);
	
	jtf8_year_low_pow=new JTextField();//“登录界面”文本框
	jtf8_year_low_pow.setBounds(220, 370, 240, 30);
	con_event.add(jtf8_year_low_pow);
	
	jtf9_year_high_pow=new JTextField();//“登录界面”文本框
	jtf9_year_high_pow.setBounds(220, 410, 240, 30);
	con_event.add(jtf9_year_high_pow);
	
	jtf10_year_total_pow=new JTextField();//“登录界面”文本框
	jtf10_year_total_pow.setBounds(220, 450, 240, 30);
	con_event.add(jtf10_year_total_pow);
	
	jtf11_year_total_pow_cost=new JTextField();//“登录界面”文本框
	jtf11_year_total_pow_cost.setBounds(220, 490, 240, 30);
	con_event.add(jtf11_year_total_pow_cost);
	
	//五个按钮
	if(target==1)
	{
		confirm_add = new JButton("确认添加");
		confirm_add.setFont(new Font("微软雅黑", Font.BOLD, 20));
		confirm_add.setBounds(220, 530, 150, 40);
		confirm_add.addActionListener(new ActionListener()//匿名类监听事件，下同 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null,"添加成功\n");
				admin admin=new admin();
				dispose();
		}
	});
	con_event.add(confirm_add);	
	}else if(target==2)
	{
		confirm_del = new JButton("确认删除");
		confirm_del.setFont(new Font("微软雅黑", Font.BOLD, 20));
		confirm_del.setBounds(220, 530, 150, 40);
		confirm_del.addActionListener(new ActionListener()//匿名类监听事件，下同 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null,"删除成功\n");
				admin admin=new admin();
				dispose();
			}
		});
		con_event.add(confirm_del);
	}else if(target==3)
	{
		confirm_change = new JButton("确认修改");
		confirm_change.setFont(new Font("微软雅黑", Font.BOLD, 20));
		confirm_change.setBounds(220, 530, 150, 40);
		confirm_change.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null,"修改成功\n");
				admin admin=new admin();
				dispose();
			}
		});
		con_event.add(confirm_change);
	}

	
    //————————————————————————————————————————————————	
	information = new JButton("查看信息");
	information.setFont(new Font("微软雅黑", Font.BOLD, 20));
	information.setBounds(530, 30, 120, 40);
	information.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
//			JOptionPane.showMessageDialog(null,"添加成功\n");
//			dispose();
		}
	});
	con_event.add(information);
	
	//返回按钮
	back = new JButton("返回");
	back.setFont(new Font("微软雅黑", Font.BOLD, 20));
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
//	//随机生成题目
//	

	this.setVisible(true);//组件设置完后进行显示
	
}
	
		
}

class admin extends JFrame //管理员面板
{
	BufferedReader buf_r;
	//按钮
	JButton qucery_aver;//查看平均分
	JButton admin_exit;//退出系统
	JButton manage_ent;//管理企业信息
	DecimalFormat dec = new DecimalFormat(" .00");//保留两位小数
	JTextField enter_name;
	ArrayList<String> student_score_writer = new ArrayList<String>();//写入文件的学生成绩数组
public admin() 
{
	//主面板
	this.setBounds(100,100,700,400);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("企业用电量查询");
	this.setLocationRelativeTo(null);
	Container con_teacher = this.getContentPane();
	con_teacher.setLayout(null);
	
	//输入查询的文本框
//	enter_name=new JTextField();
//	enter_name.setBounds(130, 97, 240, 30);
//	con_teacher.add(enter_name);
	
	//按钮
//	JButton qucery_aver;//查看平均分
//	JButton teacher_exit;//退出系统
	
	
	qucery_aver = new JButton("查询");
	qucery_aver.setFont(new Font("微软雅黑", Font.BOLD, 25));
	qucery_aver.setBounds(200, 70, 300, 50);
	qucery_aver.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			ent_porer_event pow=new ent_porer_event(0);
			dispose();
//			JOptionPane.showConfirmDialog(null, "考试平均分为："+dec.format(average()));
		}
	});
	con_teacher.add(qucery_aver);
	
	manage_ent = new JButton("管理企业信息");
	manage_ent.setFont(new Font("微软雅黑", Font.BOLD, 25));
	manage_ent.setBounds(200, 170, 300, 50);
	manage_ent.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			Manager_enterprise manger=new Manager_enterprise();
			dispose();
//			JOptionPane.showConfirmDialog(null, "考试平均分为："+dec.format(average()));
		}
	});
	con_teacher.add(manage_ent);
	
	admin_exit = new JButton("退出系统");
	admin_exit.setFont(new Font("微软雅黑", Font.BOLD, 25));
	admin_exit.setBounds(255, 280, 190, 50);
	admin_exit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "欢迎下次使用！");
			System.exit(0);
		}
	});
	con_teacher.add(admin_exit);
	
	this.setVisible(true);
}
		
	
public double average()//计算平均分
{
		ArrayList<Integer> student_aver = new ArrayList<Integer>();//从文件读取学生成绩的数组
		
		try {
			buf_r = new BufferedReader(new FileReader("成绩.txt"));
			String str=null;
			while((str=buf_r.readLine())!=null)//从文件中读取一行字符串赋值给str
			{
				student_score_writer.add(str+"\n");
				String aver[] = str.split("\t");//以\t隔开
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

//管理企业信息面板
class Manager_enterprise extends JFrame{
	
	JButton add_ent;//增加企业信息
	JButton del_ent;//删除企业信息
	JButton change_ent;//修改企业信息
	JButton manager_back;//返回
	
public Manager_enterprise()
{
	this.setBounds(100,100,700,500);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("管理企业信息");
	this.setLocationRelativeTo(null);
	Container con_manger = this.getContentPane();
	con_manger.setLayout(null);
	
	add_ent = new JButton("增加企业信息");
	add_ent.setFont(new Font("微软雅黑", Font.BOLD, 25));
	add_ent.setBounds(200, 50, 300, 40);
	add_ent.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			ent_porer_event pow=new ent_porer_event(1);
			dispose();
//			JOptionPane.showConfirmDialog(null, "考试平均分为："+dec.format(average()));
		}
	});
	con_manger.add(add_ent);
	
	del_ent = new JButton("删除企业信息");
	del_ent.setFont(new Font("微软雅黑", Font.BOLD, 25));
	del_ent.setBounds(200, 150, 300, 40);
	del_ent.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			ent_porer_event pow=new ent_porer_event(2);
			dispose();
//			JOptionPane.showConfirmDialog(null, "考试平均分为："+dec.format(average()));
		}
	});
	con_manger.add(del_ent);
	
	change_ent = new JButton("修改企业信息");
	change_ent.setFont(new Font("微软雅黑", Font.BOLD, 25));
	change_ent.setBounds(200, 250, 300, 40);
	change_ent.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			ent_porer_event pow=new ent_porer_event(3);
			dispose();
//			JOptionPane.showConfirmDialog(null, "考试平均分为："+dec.format(average()));
		}
	});
	con_manger.add(change_ent);
	
	manager_back = new JButton("返 回");
	manager_back.setFont(new Font("微软雅黑", Font.BOLD, 25));
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
	
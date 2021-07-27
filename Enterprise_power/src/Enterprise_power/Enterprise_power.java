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
		
	JLabel label1_wel;//登录界面欢迎语标签
	JLabel label2_name;//登录界面“用户名”标签
	JLabel label3_password;//登录界面“密码”标签
//	JLabel label4_class;//登录界面“班级”标签
	JTextField jtf2_name;//登录界面“用户”输入文本框
	JTextField jtf3_password;//登录界面“密码”输入文本框
//	JTextField jtf4_class;//登录界面“班级”输入文本框
	JButton jbt1_login;//登陆按钮
	JButton jbt2_exit;//退出按钮
	
	Container con=this.getContentPane();//创建容器
	
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
	this.setSize(500,400);//设置登陆界面大小
	this.setTitle("企业用电管理系统");
	this.setLocation(800, 200);//设置框口相对于组件的位置
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出
	
	con.setLayout(null);//生成一个容器
	
	label1_wel=new JLabel("请输入个人信息");//“请输入考生信息”标签
	label1_wel.setFont(new Font("微软雅黑", Font.BOLD, 20));
	label1_wel.setBounds(110, 30, 150, 40);
	con.add(label1_wel);
		
	label2_name=new JLabel("用户名：");//“姓名”标签
	label2_name.setFont(new Font("微软雅黑", Font.BOLD, 20));
	label2_name.setBounds(50, 90, 80, 40);	
	con.add(label2_name);
	
	label3_password=new JLabel("密码：");//“年级标签”
	label3_password.setFont(new Font("微软雅黑", Font.BOLD, 20));
	label3_password.setBounds(50, 140, 67, 40);
	con.add(label3_password);
	
//	label4_class=new JLabel("班级：");//“班级标签”
//	label4_class.setFont(new Font("微软雅黑", Font.BOLD, 20));
//	label4_class.setBounds(60, 190, 105, 40);
//	con.add(label4_class);
	
	jbt1_login=new JButton("登陆");//“登陆“按钮
	jbt1_login.setFont(new Font("微软雅黑", Font.BOLD, 20));
	jbt1_login.setBounds(130, 270, 80, 30);

	jbt2_exit=new JButton("退出");//”退出按钮“
	jbt2_exit.setFont(new Font("微软雅黑", Font.BOLD, 20));
	jbt2_exit.setBounds(290, 270, 80, 30);
	
	
	jtf2_name=new JTextField();//“登录界面”文本框
	jtf2_name.setBounds(130, 97, 240, 30);
	con.add(jtf2_name);
	jtf3_password=new JTextField();//“姓名”文本框
	jtf3_password.setBounds(130, 147, 240, 30);
	con.add(jtf3_password);
//	jtf4_class=new JTextField();//“年级"文本框
//	jtf4_class.setBounds(130, 197, 240, 30);
//	con.add(jtf4_class);
			
	this.setVisible(true);	

	//登陆
	jbt1_login.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)//匿名类监听事件 
		{
			BufferedWriter buf;
			String l2_name  = jtf2_name.getText();
			String l3_password = jtf3_password.getText();
//			String l4_class = jtf4_class.getText();
			if(l2_name.equals("")||l3_password.equals(""))
			{
				JOptionPane.showMessageDialog(null,"请输入完整的信息\n");				
			}else//判断登陆人员是否为管理员
			{					
				if(l2_name.equals("张三")&&l3_password.equals("教务处")) 
				{
					admin tea = new admin();
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"用户不存在\n");	
				}
			}
		}
	});
	con.add(jbt1_login);//在容器中添加实例化后的面板组件
	
	//退出
	jbt2_exit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) 
		{
			JOptionPane.showMessageDialog(null,"感谢使用本系统！ \n");
			System.exit(0);
		}
	});
	con.add(jbt2_exit);
	

}

}
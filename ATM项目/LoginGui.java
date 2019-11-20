package Atm;

//import Intenet.Calculator;
//import mybank.Account;
//import mybank.Test;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;




public  class LoginGui implements ActionListener{//实现监听器的接口
	String username,password;

     JFrame frame;
    private JPanel p0,p1,p2,p3,p4;//p4包括确认密码时的输入框；点击register按钮出现
 
     JTextField userName;
    public  JTextField passWord,passwordCheck;
    public  JButton login;
     JButton change;
     JButton concel;
     JButton register;
//    private Reader fw;gtre
 Boolean regirsterable=true;//控制是否能注册的变量
    public static void main(String[] args) {
    	String u="123456";
    	String p="123456";
 	   LoginGui a = new LoginGui(u,p);
  }
//    public LoginGui()
//	{
//		login = new JButton("登录");
//		this.add(login);
//		userName = new JTextField();
//		this.add(userName);
//		this.setLayout(new FlowLayout());
//		this.setBounds(200, 100, 300, 150);
//		this.setVisible(true);
//		login.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e)
//			{
//				String s = JOptionPane.showInputDialog("请输入： ");
//						userName.setText(s);
//				
//			}
//			
//			
//		});
//		  
//	}
    void change(String u,String p) {
    	username =u;
    	password=p;
    	}
	public LoginGui( String username,String password) {
    	this.username=username;
    	this.password=password;
    	
    	
    	frame=new JFrame("登录ATM");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置窗口的点击右上角的x的处理方式，这里设置的是退出程序
        p0=new JPanel();
 
        p0.add(new JLabel("中国邮政储蓄银行ATM"));
        frame.add(p0);
 
        p1=new JPanel();
        p1.add(new JLabel("\tUserName:"));
        userName=new JTextField(20);
        p1.add(userName);
 
        p2=new JPanel();
        p2.add(new JLabel("\tPassword:"));
        passWord=new JTextField(20);
        p2.add(passWord);
 
 
        p3=new JPanel();
 
        login=new JButton("     Login    ");
        change=new JButton("   change   ");
        register=new JButton("   Register   ");
        p3.add(login);
        p3.add(change);
        p3.add(register);
 
        p4=new JPanel();
        p4.add(new JLabel("PasswordCheck:"));
        passwordCheck=new JTextField(20);
        p4.add(passwordCheck);
 
 
        frame.add(p1);
        frame.add(p2);
        frame.add(p4);//确认密码框
        frame.add(p3);
 
 
        frame.pack();
        frame.setVisible(true);
        p4.setVisible(false);
        show();
        /*****************************Login****************************/
    }
 
 
 
    public void show(){
 
       login.addActionListener(this);//添加监视器
       change.addActionListener(this);
       register.addActionListener(this);
        frame.setBounds(500,500,350,250);//设置大小
        frame.setLayout(new FlowLayout());//设置流式布局
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		//*********************************************************************************************//
		 if(e.getActionCommand().equals("     Login    ")){
			 
			 if(userName.getText().equals(username)&&passWord.getText().equals(password)) {
			 JOptionPane.showMessageDialog(frame, "登录成功");
			 WindowMenu a =new WindowMenu();
			 frame.setVisible(false);//隐藏登陆窗口
			 }
			 else {
				 JOptionPane.showMessageDialog(frame, "密码账户有问题");
			 }
		 }
		//*********************************************************************************************//
							 if(e.getActionCommand().equals("   change   ")){
					//			 String s=JOptionPane.showMessageDialog(frame, "该用户已被注册");
					//
								 String u = JOptionPane.showInputDialog("请输入旧用户名 ");
								 String  p= JOptionPane.showInputDialog("请输入旧密码 ");
								 if(u.equals(username)&&p.equals(password))
								 { String u2 = JOptionPane.showInputDialog("请输入新用户名 ");
								 String  p2= JOptionPane.showInputDialog("请输入新密码 ");
								 if(u2.length()>=6&&p2.length()>=6)
									 {if(u2.equals(p2)) {{JOptionPane.showMessageDialog(frame, "账户密码不能相同");}}
									 else { change(u2,p2);}}
								 else {JOptionPane.showMessageDialog(frame, "密码账户不能少于六为数");}
								 
								 }
								 else {JOptionPane.showMessageDialog(frame, "密码账户有问题");}
								
							 }
		 //*********************************************************************************************//
				 if(e.getActionCommand().equals("   Register   ")) {//注册，如果监听器获得的按钮文本是这个，也就是点击的按钮文本是这个的话，执行下面的语句
						            if(p4.isVisible()==false)
						            {
						                p4.setVisible(true);//检查密码输入栏
						                login.setText("     Cancel    ");//将ｌｏｇｉｎ文本改为ｃａｎｃｅｌ，同时也能触发作为Ｃａｎｃｅｌ的监听器
						                regirsterable=true;
						                return;
						            }
						            if(regirsterable==true) {
						                if (userName.getText().equals(""))//如果userName的文本是空
						                {
						                    JOptionPane.showMessageDialog(frame, "用户名不能为空");//弹窗
						                    return;
						                }
						 
						 
						              
						                    if (userName.getText().equals("123456")) {
						                        JOptionPane.showMessageDialog(frame, "该用户已被注册");
						                        userName.setText("");//清空输入框
						                        passWord.setText("");
						                        passwordCheck.setText("");
						                        return;/*如果同名，结束方法，不在运行下面的语句*/  }
						 
						                    if (passWord.getText().equals("")) {
						                        JOptionPane.showMessageDialog(frame, "密码不能为空，请重新输入");
						                        return;
						     
						                    }
						                    else {
						                        if (passwordCheck.getText().equals(passWord.getText())) {
//						                            Account registeraccount = new Account(userName.getText(), passWord.getText(), "0");//实例化此账号
						                            JOptionPane.showMessageDialog(frame, "注册成功，请登录");
						                           
						                            return;
						                        } else {
						                            JOptionPane.showMessageDialog(frame, "两次输入的密码不一致，请重新输入");
						                            return;
						                        }
						     
						     
						                    }
						                }
						     }
				 //*********************************************************************************************//
		 
				  if(e.getActionCommand().equals("     Cancel    "))
			        {
			            p4.setVisible(false);
			            login.setText("     Login    ");
			            regirsterable=false;//不可注册
			        }
			 //*********************************************************************************************//
	}

	
	

}
package Atm;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class WindowMenu implements ActionListener{
	String input; 
	int sleeptime;//一个判断其
	public JFrame frame;
	public JTextArea feedback;
	public JPanel p0,p1,p2,p3,p4;
	JButton b,c,d,e,f,g,h,i,k,withdraw,quit,qiury,confirm;
	JButton j,deposit;
	JTextField textField; 
	boolean back=true;
	String Account;
	int setsleeptime() {
		return sleeptime;
	}
	double outmoney,inmoney,allmoney;
	private CheckingAccount account;
	void setmoney(double outmoney,double inmoney) {
		this.outmoney=outmoney;
		this.inmoney=inmoney;
		
	}
	void outmoney(double money) {
		this.outmoney=money;
	}
	void inmoney(double money) {
		this.inmoney=money;
	}
	void setAccount(String account) {
		this.Account=account;
	}
//	public static void main(String[] args) {
//		while(true) {
//		try{int a;
//		System.out.println("你的卡号:");
//		Scanner act = new Scanner(System.in);
//		a=act.nextInt();
//		
//		CheckingAccount account = new CheckingAccount(a);
//		System.out.println("请输入存款金额:");
//		Scanner in = new Scanner(System.in);
//		int add = in.nextInt();
//		account.deposit(add);
//			System.out.println("请输入取款金额:");
//			Scanner qu = new Scanner (System.in);
//			int withdraw =qu.nextInt();
//			account.withdraw(withdraw);
//			}
//		catch(InsufficientFundsException e) {
//			System.out.println(e.getAmount());
//		}
//		finally {}
//		}
//	}
//	public WindowMenu() {}
//	public WindowMenu(String s,int x ,int y,int w,int h) {
//		init(s);
//		setLocation(x,y);
//		setSize(w,h);
//		setVisible(true);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		
//	}
//	JButton[] in ;
//	int a[] = {1,2,3,4,5,6,7,8,9,0};
//
//	void init(String s) {
//		setTitle(s);
//		setLayout(new FlowLayout());
//		in = new JButton[10];
//		in[0] = new JButton("1");
//		in[1] = new JButton("2");
//		in[2] = new JButton("3");
//		in[3] = new JButton("4");
//		in[4] = new JButton("5");
//		in[5] = new JButton("6");
//		in[6] = new JButton("7");
//		in[7] = new JButton("8");
//		in[8] = new JButton("9");
//		in[9] = new JButton("0");
//	}
	public static void main(String[] args) {
		
		WindowMenu a =new WindowMenu();
	}
	
	 WindowMenu() {
		   
		   
		 	sleeptime=66;
	    	frame=new JFrame("ATM系统");
	        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置窗口的点击右上角的x的处理方式，这里设置的是退出程序
	        p0=new JPanel();
	        feedback= new JTextArea(2,20);
	        feedback.setEditable(false);//设置为不可编辑
	        p0.add(feedback);
	        frame.add(p0);
	 
	        p1=new JPanel();
	        b=new JButton("1");
	        c=new JButton("2");
	        d=new JButton("3");
	        qiury=new JButton("查询");
	        p1.add(b);
	        p1.add(c);
	        p1.add(d);
	        p1.add(qiury);
	 
	        p2=new JPanel();
//	        p2.add(new JLabel("\tPassword:"));
	        e= new JButton("4");
	        f=new JButton("5");
	        g=new JButton("6");
	        withdraw=new JButton("取款");  
	        p2.add(e);
	        p2.add(f);
	        p2.add(g);
	        p2.add(withdraw);
	 
	 
	        p3=new JPanel();
	 
	        h= new JButton("7");
	        i=new JButton("8");
	        j= new JButton("9");
	        
	        deposit= new JButton("存款");
	        
	        p3.add(h);
	        p3.add(i);
	        p3.add(j);
	       p3.add(deposit);
	 
	        p4=new JPanel();
	       k= new JButton("0");
	       confirm = new JButton("    确定     ");
	        quit = new JButton("退出");
	        p4.add(k);
	        p4.add(confirm);
	        p4.add(quit);
	        
	 
	 
	        frame.add(p1);
	        frame.add(p2);  
	        frame.add(p3);
	        frame.add(p4);
	        
	 
	        frame.pack();
	        frame.setVisible(true);
	        p0.setVisible(true);
	        show();
	       
	        /*****************************Login****************************/
	    }
	  public void show(){
		
		  
		  b.addActionListener(this);
		  c.addActionListener(this);
		 d. addActionListener(this);
		  e.addActionListener(this);
		  f.addActionListener(this);
		  g.addActionListener(this);
		  h.addActionListener(this);
		  i.addActionListener(this);
		  j.addActionListener(this);
		  k.addActionListener(this);
		  deposit.addActionListener(this);
	       qiury.addActionListener(this);//添加监视器
	       confirm.addActionListener(this);
	       withdraw.addActionListener(this);
	       quit.addActionListener(this);
	        frame.setBounds(400,400,250,300);//设置大小
	        frame.setLayout(new FlowLayout());//设置流式布局
	        frame.setResizable(false);
	        input="";
	        feedback.append("欢迎登录ATM取款平台"+"\n"+"取存款请先输入金额：");
	    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//*********************************************************************************************//
		 
		String num=e.getActionCommand() ;
		if(num.length()==1) {
				input +=num;
//		feedback.append(input);
				 feedback.setText(input);
				
				
		System.out.println(input);
//		String s= feedback.getText();
		}	
		String s= input;
//		System.out.println(s);
		//*********************************************************************************************//
		if(sleeptime==66)
		{
			 account=new CheckingAccount(Account);
		  account.setBalance(10000);
		  sleeptime=0;
		}
	    	
		
		//*********************************************************************************************//
		  if(e.getActionCommand().equals("查询")) {
			
			  
			  feedback.setText("你的账号余额:"+ account.getBalance()+"\n");
			  System.out.println(account.getBalance());
			  return;
		  }
		//*********************************************************************************************//
		  if(sleeptime==9) {
			  if(e.getActionCommand().equals("    确定     ")) {
				  if(inmoney==0) {
					  System.out.println("输入的存款金额有误");
					  feedback.setText("请输入你要取款的金额\n");
					  return;
				  }
				  else {
					 account.deposit(inmoney);
					
					 inmoney=0;
				  }
				 
				  back=false;
				sleeptime=0;
				
			  }
		  }
		
		  if(sleeptime==3) {  
			  if(e.getActionCommand().equals("    确定     ")) {  
				 sleeptime=4;
			  }  
		  }
		  if(sleeptime ==5) {
			 
			  if(e.getActionCommand().equals("    确定     ")) {
				  
					 sleeptime=4;
				  }  
		  }
		  if(sleeptime ==7) {
				 
			  if(e.getActionCommand().equals("    确定     ")) {
				  
					 sleeptime=6;
				  }  
		  }
		  if(sleeptime==1) {
			  if(e.getActionCommand().equals("    确定     ")) {
				  
					 sleeptime=2;
				  }  
		  }
		  
		  if(sleeptime==0)
			  
		  { 
			  if(e.getActionCommand().equals("    确定     ")) {
//				  if(inmoney==0) {
//					  System.out.println("存款为零");
//				  }
				   
				  if(input=="") {
					  feedback.setText("请输入你取款的金额");
					  sleeptime=5;
					  return;
				  }
			   if(outmoney==0) {//修改过
				System.out.println("没有进行任何操作");//测试语句
				
			  }

			  else try {
				  
				account.withdraw(outmoney);
				sleeptime=1;
				outmoney=0;
//				account.deposit(inmoney);
				}catch(InsufficientFundsException e1) {
				System.out.println(e1.getAmount());
				 feedback.setText(e1.getAmount());
				 sleeptime=3;
				 return;
				}  
			finally {}
			  back=false;
//			  sleeptime++;
			  
//			  inmoney=0;  
		  }
		  }
		//*********************************************************************************************//
		  if(this.setsleeptime()==8) {LoginGui gui=new LoginGui("admin","admin");//这句话好像没有
		  	gui.frame.setVisible(true);//实现又打开login界面
		  }
	 
		  if(e.getActionCommand().equals("取款")) {
			 if(input=="") {
				 feedback.setText("请先输入你要取款的金额");
				 sleeptime=7;
				 return;
			 }
//			 Scanner in= new Scanner(System.in);
			  outmoney(Double.parseDouble(s));
	  feedback.setText("你需要取款的金额:"+s+"\n"+"(单击确定进行取款)");//
			  
//			  outmoney(Double.parseDouble(feedback.getText()));
		  }
		//*********************************************************************************************//
		  if(e.getActionCommand().equals("退出")) {
			  sleeptime=8;//8为退出系统
			  frame.setVisible(false);
			  //设置一个返回参数，用方法体实现
		  }//实现跳转到登录界面
		//*********************************************************************************************//
		  if(e.getActionCommand().equals("存款")) {
			  if(input=="") {
					 feedback.setText("请先输入你要存款的金额");
					 sleeptime=7;//7是输入为空时的缓冲语句代号
					 return;
				 }
			  feedback.setText("你需要存款的金额:"+s+"\n"+"(单击确定进行存款)");
			  sleeptime=9;//将此存款的操作设为9
			  inmoney(Double.parseDouble(s));
			  System.out.println(inmoney);//测试语句
			  
			  
		  }
		//*********************************************************************************************//
		  if(back==false) {
			  feedback.setText(""+"\n");
		  feedback.setText("操作成功,请按确定返回主界面"+"\n");
		  input="";
		  back=true;
		  }
		  if(sleeptime%2==0&&sleeptime!=0) {
			  if(sleeptime==2)
			  feedback.setText("请选择你的操作"+"\n"+"取存款请先输入金额：");
			  if(sleeptime==4) {
				  feedback.setText("请重新输入你金额：");  
				  input="";
				  }
			 if(sleeptime==6) {
				 feedback.setText(null);
			 }
			  sleeptime=0;
			  }
		  
		  
		  
	}
	
}

 class CheckingAccount
{
  //balance为余额，number为账号
   public  double balance;
   public String number;
   public CheckingAccount(String number)
   {
      this.number = number;
   }
  //方法：存钱
   public void deposit(double amount)
   {
     this.balance += amount;
      System.out.println("存款成功，你的账户余额为:"+balance);
   }
  //方法：取钱
   public void withdraw(double amount)  throws InsufficientFundsException
   {
      if(amount <= balance)
      {
         balance -= amount;
      }
      else
      {
         double needs = amount - balance;
         throw new InsufficientFundsException(needs);
      }
      
   }
  //方法：返回余额
   public void setBalance(double balance) {
	   this.balance=balance;
   }
   public double getBalance()
   {
	   
      return balance;
      
   }
  //方法：返回卡号
   public String getNumber()
   {
      return number;
   }
}
 class InsufficientFundsException extends Exception{
		String message;
		public InsufficientFundsException(double amount){
			message="你的余额不足 .缺乏:"+amount;//amount为所缺乏的钱
			
		}
		public String getAmount(){
			return message;
		}
		
	}

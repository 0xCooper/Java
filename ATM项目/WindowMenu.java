package Atm;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class WindowMenu implements ActionListener{
	String input; 
	int sleeptime;//һ���ж���
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
//		System.out.println("��Ŀ���:");
//		Scanner act = new Scanner(System.in);
//		a=act.nextInt();
//		
//		CheckingAccount account = new CheckingAccount(a);
//		System.out.println("����������:");
//		Scanner in = new Scanner(System.in);
//		int add = in.nextInt();
//		account.deposit(add);
//			System.out.println("������ȡ����:");
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
	    	frame=new JFrame("ATMϵͳ");
	        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//���ô��ڵĵ�����Ͻǵ�x�Ĵ���ʽ���������õ����˳�����
	        p0=new JPanel();
	        feedback= new JTextArea(2,20);
	        feedback.setEditable(false);//����Ϊ���ɱ༭
	        p0.add(feedback);
	        frame.add(p0);
	 
	        p1=new JPanel();
	        b=new JButton("1");
	        c=new JButton("2");
	        d=new JButton("3");
	        qiury=new JButton("��ѯ");
	        p1.add(b);
	        p1.add(c);
	        p1.add(d);
	        p1.add(qiury);
	 
	        p2=new JPanel();
//	        p2.add(new JLabel("\tPassword:"));
	        e= new JButton("4");
	        f=new JButton("5");
	        g=new JButton("6");
	        withdraw=new JButton("ȡ��");  
	        p2.add(e);
	        p2.add(f);
	        p2.add(g);
	        p2.add(withdraw);
	 
	 
	        p3=new JPanel();
	 
	        h= new JButton("7");
	        i=new JButton("8");
	        j= new JButton("9");
	        
	        deposit= new JButton("���");
	        
	        p3.add(h);
	        p3.add(i);
	        p3.add(j);
	       p3.add(deposit);
	 
	        p4=new JPanel();
	       k= new JButton("0");
	       confirm = new JButton("    ȷ��     ");
	        quit = new JButton("�˳�");
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
	       qiury.addActionListener(this);//��Ӽ�����
	       confirm.addActionListener(this);
	       withdraw.addActionListener(this);
	       quit.addActionListener(this);
	        frame.setBounds(400,400,250,300);//���ô�С
	        frame.setLayout(new FlowLayout());//������ʽ����
	        frame.setResizable(false);
	        input="";
	        feedback.append("��ӭ��¼ATMȡ��ƽ̨"+"\n"+"ȡ������������");
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
		  if(e.getActionCommand().equals("��ѯ")) {
			
			  
			  feedback.setText("����˺����:"+ account.getBalance()+"\n");
			  System.out.println(account.getBalance());
			  return;
		  }
		//*********************************************************************************************//
		  if(sleeptime==9) {
			  if(e.getActionCommand().equals("    ȷ��     ")) {
				  if(inmoney==0) {
					  System.out.println("����Ĵ��������");
					  feedback.setText("��������Ҫȡ��Ľ��\n");
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
			  if(e.getActionCommand().equals("    ȷ��     ")) {  
				 sleeptime=4;
			  }  
		  }
		  if(sleeptime ==5) {
			 
			  if(e.getActionCommand().equals("    ȷ��     ")) {
				  
					 sleeptime=4;
				  }  
		  }
		  if(sleeptime ==7) {
				 
			  if(e.getActionCommand().equals("    ȷ��     ")) {
				  
					 sleeptime=6;
				  }  
		  }
		  if(sleeptime==1) {
			  if(e.getActionCommand().equals("    ȷ��     ")) {
				  
					 sleeptime=2;
				  }  
		  }
		  
		  if(sleeptime==0)
			  
		  { 
			  if(e.getActionCommand().equals("    ȷ��     ")) {
//				  if(inmoney==0) {
//					  System.out.println("���Ϊ��");
//				  }
				   
				  if(input=="") {
					  feedback.setText("��������ȡ��Ľ��");
					  sleeptime=5;
					  return;
				  }
			   if(outmoney==0) {//�޸Ĺ�
				System.out.println("û�н����κβ���");//�������
				
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
		  if(this.setsleeptime()==8) {LoginGui gui=new LoginGui("admin","admin");//��仰����û��
		  	gui.frame.setVisible(true);//ʵ���ִ�login����
		  }
	 
		  if(e.getActionCommand().equals("ȡ��")) {
			 if(input=="") {
				 feedback.setText("����������Ҫȡ��Ľ��");
				 sleeptime=7;
				 return;
			 }
//			 Scanner in= new Scanner(System.in);
			  outmoney(Double.parseDouble(s));
	  feedback.setText("����Ҫȡ��Ľ��:"+s+"\n"+"(����ȷ������ȡ��)");//
			  
//			  outmoney(Double.parseDouble(feedback.getText()));
		  }
		//*********************************************************************************************//
		  if(e.getActionCommand().equals("�˳�")) {
			  sleeptime=8;//8Ϊ�˳�ϵͳ
			  frame.setVisible(false);
			  //����һ�����ز������÷�����ʵ��
		  }//ʵ����ת����¼����
		//*********************************************************************************************//
		  if(e.getActionCommand().equals("���")) {
			  if(input=="") {
					 feedback.setText("����������Ҫ���Ľ��");
					 sleeptime=7;//7������Ϊ��ʱ�Ļ���������
					 return;
				 }
			  feedback.setText("����Ҫ���Ľ��:"+s+"\n"+"(����ȷ�����д��)");
			  sleeptime=9;//���˴��Ĳ�����Ϊ9
			  inmoney(Double.parseDouble(s));
			  System.out.println(inmoney);//�������
			  
			  
		  }
		//*********************************************************************************************//
		  if(back==false) {
			  feedback.setText(""+"\n");
		  feedback.setText("�����ɹ�,�밴ȷ������������"+"\n");
		  input="";
		  back=true;
		  }
		  if(sleeptime%2==0&&sleeptime!=0) {
			  if(sleeptime==2)
			  feedback.setText("��ѡ����Ĳ���"+"\n"+"ȡ������������");
			  if(sleeptime==4) {
				  feedback.setText("�������������");  
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
  //balanceΪ��numberΪ�˺�
   public  double balance;
   public String number;
   public CheckingAccount(String number)
   {
      this.number = number;
   }
  //��������Ǯ
   public void deposit(double amount)
   {
     this.balance += amount;
      System.out.println("���ɹ�������˻����Ϊ:"+balance);
   }
  //������ȡǮ
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
  //�������������
   public void setBalance(double balance) {
	   this.balance=balance;
   }
   public double getBalance()
   {
	   
      return balance;
      
   }
  //���������ؿ���
   public String getNumber()
   {
      return number;
   }
}
 class InsufficientFundsException extends Exception{
		String message;
		public InsufficientFundsException(double amount){
			message="������� .ȱ��:"+amount;//amountΪ��ȱ����Ǯ
			
		}
		public String getAmount(){
			return message;
		}
		
	}

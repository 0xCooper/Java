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




public  class LoginGui implements ActionListener{//ʵ�ּ������Ľӿ�
	String username,password;

     JFrame frame;
    private JPanel p0,p1,p2,p3,p4;//p4����ȷ������ʱ������򣻵��register��ť����
 
     JTextField userName;
    public  JTextField passWord,passwordCheck;
    public  JButton login;
     JButton change;
     JButton concel;
     JButton register;
//    private Reader fw;gtre
 Boolean regirsterable=true;//�����Ƿ���ע��ı���
    public static void main(String[] args) {
    	String u="123456";
    	String p="123456";
 	   LoginGui a = new LoginGui(u,p);
  }
//    public LoginGui()
//	{
//		login = new JButton("��¼");
//		this.add(login);
//		userName = new JTextField();
//		this.add(userName);
//		this.setLayout(new FlowLayout());
//		this.setBounds(200, 100, 300, 150);
//		this.setVisible(true);
//		login.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e)
//			{
//				String s = JOptionPane.showInputDialog("�����룺 ");
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
    	
    	
    	frame=new JFrame("��¼ATM");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//���ô��ڵĵ�����Ͻǵ�x�Ĵ���ʽ���������õ����˳�����
        p0=new JPanel();
 
        p0.add(new JLabel("�й�������������ATM"));
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
        frame.add(p4);//ȷ�������
        frame.add(p3);
 
 
        frame.pack();
        frame.setVisible(true);
        p4.setVisible(false);
        show();
        /*****************************Login****************************/
    }
 
 
 
    public void show(){
 
       login.addActionListener(this);//��Ӽ�����
       change.addActionListener(this);
       register.addActionListener(this);
        frame.setBounds(500,500,350,250);//���ô�С
        frame.setLayout(new FlowLayout());//������ʽ����
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		//*********************************************************************************************//
		 if(e.getActionCommand().equals("     Login    ")){
			 
			 if(userName.getText().equals(username)&&passWord.getText().equals(password)) {
			 JOptionPane.showMessageDialog(frame, "��¼�ɹ�");
			 WindowMenu a =new WindowMenu();
			 frame.setVisible(false);//���ص�½����
			 }
			 else {
				 JOptionPane.showMessageDialog(frame, "�����˻�������");
			 }
		 }
		//*********************************************************************************************//
							 if(e.getActionCommand().equals("   change   ")){
					//			 String s=JOptionPane.showMessageDialog(frame, "���û��ѱ�ע��");
					//
								 String u = JOptionPane.showInputDialog("��������û��� ");
								 String  p= JOptionPane.showInputDialog("����������� ");
								 if(u.equals(username)&&p.equals(password))
								 { String u2 = JOptionPane.showInputDialog("���������û��� ");
								 String  p2= JOptionPane.showInputDialog("������������ ");
								 if(u2.length()>=6&&p2.length()>=6)
									 {if(u2.equals(p2)) {{JOptionPane.showMessageDialog(frame, "�˻����벻����ͬ");}}
									 else { change(u2,p2);}}
								 else {JOptionPane.showMessageDialog(frame, "�����˻�����������Ϊ��");}
								 
								 }
								 else {JOptionPane.showMessageDialog(frame, "�����˻�������");}
								
							 }
		 //*********************************************************************************************//
				 if(e.getActionCommand().equals("   Register   ")) {//ע�ᣬ�����������õİ�ť�ı��������Ҳ���ǵ���İ�ť�ı�������Ļ���ִ����������
						            if(p4.isVisible()==false)
						            {
						                p4.setVisible(true);//�������������
						                login.setText("     Cancel    ");//���������ı���Ϊ������죬ͬʱҲ�ܴ�����Ϊ�ã�����ļ�����
						                regirsterable=true;
						                return;
						            }
						            if(regirsterable==true) {
						                if (userName.getText().equals(""))//���userName���ı��ǿ�
						                {
						                    JOptionPane.showMessageDialog(frame, "�û�������Ϊ��");//����
						                    return;
						                }
						 
						 
						              
						                    if (userName.getText().equals("123456")) {
						                        JOptionPane.showMessageDialog(frame, "���û��ѱ�ע��");
						                        userName.setText("");//��������
						                        passWord.setText("");
						                        passwordCheck.setText("");
						                        return;/*���ͬ������������������������������*/  }
						 
						                    if (passWord.getText().equals("")) {
						                        JOptionPane.showMessageDialog(frame, "���벻��Ϊ�գ�����������");
						                        return;
						     
						                    }
						                    else {
						                        if (passwordCheck.getText().equals(passWord.getText())) {
//						                            Account registeraccount = new Account(userName.getText(), passWord.getText(), "0");//ʵ�������˺�
						                            JOptionPane.showMessageDialog(frame, "ע��ɹ������¼");
						                           
						                            return;
						                        } else {
						                            JOptionPane.showMessageDialog(frame, "������������벻һ�£�����������");
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
			            regirsterable=false;//����ע��
			        }
			 //*********************************************************************************************//
	}

	
	

}
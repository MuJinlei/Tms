package com.briup.Tmss;
import java.util.Scanner;
public class Tms
{
	public int index=0;
	public Teacher[] teacher=new Teacher[3];
    /**�˵�*/
	public void Menu(){
		System.out.println("**********��ʦ��Ϣ����ϵͳ**********");
		System.out.println("*1.��ѯ���н�ʦ��Ϣ");
		System.out.println("*2.��ӽ�ʦ��Ϣ");
		System.out.println("*3.ɾ����ʦ��Ϣ");
		System.out.println("*4.�޸Ľ�ʦ��Ϣ");
		System.out.println("*5.��ѯ��ʦ��Ϣ");
		System.out.println("*exit.�˳���ʦ��Ϣ����ϵͳ");
		System.out.println("*help.�����б�");
		System.out.println("************************************");
	}
	/**���뿪ʼ���*/
	public static void main(String[] args){
		Tms tms=new Tms();
		Scanner sc=new Scanner(System.in);
		tms.Menu();
		while(true){
			System.out.print("�����빦�ܱ��:");
			String option=sc.nextLine();
			switch(option){
				case "1":
					System.out.println("���������н�ʦ��Ϣ��");
				    Teacher[] tcs=tms.findAll();
					for(Teacher tc:tcs){
						System.out.println(tc);
					}
					System.out.println("������Ϊ��"+tms.index+"��");
					break;
				case "2":
				 while(true){
					System.out.println("�������ʦ��Ϣ����ʽΪ��id#����#���䡿�����롾break��������һ��");
				    String tcstr=sc.nextLine();
					if(tcstr.equals("break")) break;
					String[] arr=tcstr.split("#");
					long id=Long.parseLong(arr[0]);
					String name=arr[1];
					int age=Integer.parseInt(arr[2]);
					Teacher tc=new Teacher(id,name,age);
					tms.add(tc);
					System.out.println("��ӳɹ���");
				 }
					break;
				case "3":
					while(true){
					System.out.println("��������Ҫɾ����Ϣ�Ľ�ʦid�����롾break��������һ��");
				    String tcstr=sc.nextLine();
					if(tcstr.equals("break")) break;
					long id=Long.parseLong(tcstr);
					int num=tms.getIndexById(id);
					if(num==-1){
						System.out.println("ɾ���Ľ�ʦ��Ϣ�����ڣ�");
						break;
					}
					tms.deleteById(id);
					System.out.println("ɾ���ɹ���");


				}
					break;
				case "4":
					while(true){
				       System.out.println("��������Ҫ�޸���Ϣ�Ľ�ʦid�����롾break��������һ��");
				       String tcstr=sc.nextLine();
					   if(tcstr.equals("break")) break;
					   long id=Long.parseLong(tcstr);
					   int num=tms.getIndexById(id);
					   if(num==-1){
						System.out.println("��Ҫ�޸ĵĽ�ʦ��Ϣ�����ڣ�");
						continue;
					   }
					   System.out.print("ԭ��ʦ��ϢΪ��"+tms.teacher[num]);
					   System.out.println("�������޸���Ϣ����ʽΪ������#���䡿�����롾break���˳��޸ģ�");
					   String tcstrnew=sc.nextLine();
					   if(tcstrnew.equals("break")) break;
					   String[] arr=tcstrnew.split("#");
					   String name=arr[0];
					   int age=Integer.parseInt(arr[1]);
					   Teacher tc=new Teacher(id,name,age);
					   tms.update(tc);
					   System.out.println("�޸ĳɹ���");
				    }
					break;
				case "5":					
					while(true){
				       System.out.println("��������Ҫ��ѯ��Ϣ�Ľ�ʦid�����롾break��������һ��");
				       String tcstr=sc.nextLine();
					   if(tcstr.equals("break")) break;
					   long id=Long.parseLong(tcstr);
					   int num=tms.getIndexById(id);
					   if(num==-1){
						System.out.println("��Ҫ��ѯ�Ľ�ʦ��Ϣ�����ڣ�");
						continue;
					   }
					   Teacher tc=tms.findById(id);
					   System.out.println(tc);
				    }
					break;
				case "exit":
					System.out.println("��ӭ�ٴ�ʹ�ã�");
					System.exit(0);
					break;
				case "help":
					tms.Menu();
					break;
				default:
					System.out.println("��������밴��ʾ���룡");
					break;
					
			}
		}
	}
	/**ÿ����ʦ������*/
	public int getIndexById(long id){
		int num=-1;
		for(int i=0;i<index;i++){
	       if(teacher[i].getid()==id){
			   num=i;
		   }
		}
		return num; 
	}
	/**�������н�ʦ*/
	public Teacher[] findAll(){
		Teacher[] demo=new Teacher[index];
		System.arraycopy(teacher,0,demo,0,index);
		return demo;
	}
	/**��ӽ�ʦ��Ϣ*/
	public void add(Teacher tc){
		if(index>=teacher.length){
			Teacher[] demo=new Teacher[index+3];
			System.arraycopy(teacher,0,demo,0,index);
			teacher=demo;
		}
		teacher[index]=tc;
		index++;
		
	}
	/**ɾ��*/
	public void deleteById(long id){
		int num=getIndexById(id);
		for(int i=num;i<index-1;i++){
			teacher[i]=teacher[i+1];
		}
		teacher[index-1]=null;
		index--;
	}
	/**������Ϣ����*/
	public void update(Teacher tc){
		int num=getIndexById(tc.getid());
		teacher[num]=tc;
	}
	/**��ѯ����*/
	public Teacher findById(long id){
		int num=getIndexById(id);
		return teacher[num];
	}


}
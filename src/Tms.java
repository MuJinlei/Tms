package com.briup.Tmss;
import java.util.Scanner;
public class Tms
{
	public int index=0;
	public Teacher[] teacher=new Teacher[3];
    /**菜单*/
	public void Menu(){
		System.out.println("**********教师信息管理系统**********");
		System.out.println("*1.查询所有教师信息");
		System.out.println("*2.添加教师信息");
		System.out.println("*3.删除教师信息");
		System.out.println("*4.修改教师信息");
		System.out.println("*5.查询教师信息");
		System.out.println("*exit.退出教师信息管理系统");
		System.out.println("*help.帮助列表");
		System.out.println("************************************");
	}
	/**代码开始入口*/
	public static void main(String[] args){
		Tms tms=new Tms();
		Scanner sc=new Scanner(System.in);
		tms.Menu();
		while(true){
			System.out.print("请输入功能编号:");
			String option=sc.nextLine();
			switch(option){
				case "1":
					System.out.println("以下是所有教师信息：");
				    Teacher[] tcs=tms.findAll();
					for(Teacher tc:tcs){
						System.out.println(tc);
					}
					System.out.println("总人数为："+tms.index+"人");
					break;
				case "2":
				 while(true){
					System.out.println("请输入教师信息，格式为【id#姓名#年龄】或输入【break】返回上一级");
				    String tcstr=sc.nextLine();
					if(tcstr.equals("break")) break;
					String[] arr=tcstr.split("#");
					long id=Long.parseLong(arr[0]);
					String name=arr[1];
					int age=Integer.parseInt(arr[2]);
					Teacher tc=new Teacher(id,name,age);
					tms.add(tc);
					System.out.println("添加成功！");
				 }
					break;
				case "3":
					while(true){
					System.out.println("请输入需要删除信息的教师id或输入【break】返回上一级");
				    String tcstr=sc.nextLine();
					if(tcstr.equals("break")) break;
					long id=Long.parseLong(tcstr);
					int num=tms.getIndexById(id);
					if(num==-1){
						System.out.println("删除的教师信息不存在！");
						break;
					}
					tms.deleteById(id);
					System.out.println("删除成功！");


				}
					break;
				case "4":
					while(true){
				       System.out.println("请输入需要修改信息的教师id或输入【break】返回上一级");
				       String tcstr=sc.nextLine();
					   if(tcstr.equals("break")) break;
					   long id=Long.parseLong(tcstr);
					   int num=tms.getIndexById(id);
					   if(num==-1){
						System.out.println("需要修改的教师信息不存在！");
						continue;
					   }
					   System.out.print("原教师信息为："+tms.teacher[num]);
					   System.out.println("请输入修改信息，格式为【姓名#年龄】或输入【break】退出修改！");
					   String tcstrnew=sc.nextLine();
					   if(tcstrnew.equals("break")) break;
					   String[] arr=tcstrnew.split("#");
					   String name=arr[0];
					   int age=Integer.parseInt(arr[1]);
					   Teacher tc=new Teacher(id,name,age);
					   tms.update(tc);
					   System.out.println("修改成功！");
				    }
					break;
				case "5":					
					while(true){
				       System.out.println("请输入需要查询信息的教师id或输入【break】返回上一级");
				       String tcstr=sc.nextLine();
					   if(tcstr.equals("break")) break;
					   long id=Long.parseLong(tcstr);
					   int num=tms.getIndexById(id);
					   if(num==-1){
						System.out.println("需要查询的教师信息不存在！");
						continue;
					   }
					   Teacher tc=tms.findById(id);
					   System.out.println(tc);
				    }
					break;
				case "exit":
					System.out.println("欢迎再次使用！");
					System.exit(0);
					break;
				case "help":
					tms.Menu();
					break;
				default:
					System.out.println("输入错误！请按提示输入！");
					break;
					
			}
		}
	}
	/**每个教师的索引*/
	public int getIndexById(long id){
		int num=-1;
		for(int i=0;i<index;i++){
	       if(teacher[i].getid()==id){
			   num=i;
		   }
		}
		return num; 
	}
	/**查找所有教师*/
	public Teacher[] findAll(){
		Teacher[] demo=new Teacher[index];
		System.arraycopy(teacher,0,demo,0,index);
		return demo;
	}
	/**添加教师信息*/
	public void add(Teacher tc){
		if(index>=teacher.length){
			Teacher[] demo=new Teacher[index+3];
			System.arraycopy(teacher,0,demo,0,index);
			teacher=demo;
		}
		teacher[index]=tc;
		index++;
		
	}
	/**删除*/
	public void deleteById(long id){
		int num=getIndexById(id);
		for(int i=num;i<index-1;i++){
			teacher[i]=teacher[i+1];
		}
		teacher[index-1]=null;
		index--;
	}
	/**更新信息操作*/
	public void update(Teacher tc){
		int num=getIndexById(tc.getid());
		teacher[num]=tc;
	}
	/**查询操作*/
	public Teacher findById(long id){
		int num=getIndexById(id);
		return teacher[num];
	}


}
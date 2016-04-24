package com.briup.Tmss;

public class Teacher
{
	private long Id;
	private String Name;
	private int Age;
	public Teacher(){}
	public Teacher(long id,String name,int age){
		this.Id=id;
		this.Name=name;
		this.Age=age;
	}
	public String toString(){
		return "¡¾id:"+this.Id+",ĞÕÃû£º"+this.Name+",ÄêÁä£º"+this.Age+"¡¿";
	}
	public void setid(long id){
		this.Id=id;
	}
	public void setname(String name){
		this.Name=name;
	}
	public void setage(int age){
		this.Age=age;
	}
	public long getid(){
		return this.Id;
	}
	public String getname(){
		return this.Name;
	}
	public int getage(){
		return this.Age;
	}


}
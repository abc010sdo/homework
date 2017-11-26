package com.exam.pojo;

/**
 * 
 * @author abc010sdo
 *
 */
//学生实体类
public class Student {
	private int id; // 学号
	private String name; // 姓名

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "[学号:" + id + ", 姓名:" + name + "]";
	}
}

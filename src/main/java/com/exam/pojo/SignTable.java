package com.exam.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author abc010sdo
 *
 */
// 签到表实体类
public class SignTable {
	private int id; // 编号
	private Date date; // 签到时间
	private Student student; // 签到学生

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student s) {
		this.student = s;
	}

	public SignTable(int id, Date date, Student s) {
		super();
		this.id = id;
		this.date = date;
		this.student = s;
	}

	public SignTable() {
		super();
	}

	@Override
	public String toString() {
		String date = new SimpleDateFormat("yyyy年MM月dd日-HH:mm").format(this.date);
		return "[序号:" + id + ", 签到时间:" + date + ", 签到学生:" + student + "]";
	}

}

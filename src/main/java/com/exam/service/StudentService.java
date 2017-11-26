package com.exam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exam.pojo.Student;

@Service
public class StudentService {
	private static List<Student> students;
	static {
		students = new ArrayList<>();
		String[] names = {"张三", "李四", "王五", "陈六", "田七", "郭九", "冬十", "王六"};
		for (int i = 0; i < names.length; i++) {
			students.add(new Student(i, names[i]));
		}
	}
	
	// 显示所有学生
	public static List<Student> getStudents() {
		return students;
	}
	
	// 查看指定学生
	public Student getStudent(int sid) {
		return students.get(sid);
	}
	
}

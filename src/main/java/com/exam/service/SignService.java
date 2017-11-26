package com.exam.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.exam.pojo.SignTable;
import com.exam.pojo.Student;

@Component
public class SignService {
	private List<Student> students = StudentService.getStudents();
	private List<SignTable> table = new ArrayList<> (
			Arrays.asList(new SignTable(1, new Date(), students.get(3)),
					new SignTable(2, new Date(), students.get(2)),
					new SignTable(3, new Date(), students.get(1)),
					new SignTable(4, new Date(), students.get(0)),
					new SignTable(5, new Date(), students.get(6)),
					new SignTable(6, new Date(), students.get(5)),
					new SignTable(7, new Date(), students.get(7))));
	// 学生签到
	public void sign(int sid) {
		 SignTable t = new SignTable(table.size()+1, new Date(), students.get(sid));
		 boolean f = table.add(t);
		 if(f) {
			 System.out.println("签到成功!");
		 }
	}
	
	// 查询签到情况
	public Stream<SignTable> getSignTable(long start, long size) {
		return table.stream().filter(t -> t.getId() > start*size).limit(size);
	}
	
	// 统计签到次数
	public int count(int sid) {
		return (int) table.stream()
				.filter(t -> t.getStudent()
				.getId() == sid)
				.count();
	}
	
	// 查看指定学生的签到情况
	public Stream<SignTable> findBySid(int sid) {
		return table.stream()
				.filter(t -> t.getStudent()
				.getId() == sid);
	}
	
	// 签到总人数
	public int totalCount() {
		return table.size();
	}
	
}

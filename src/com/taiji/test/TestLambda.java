package com.taiji.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.taiji.entity.Student;
import com.taiji.function.RandScore;
import com.taiji.function.StudentFactory;

public class TestLambda {
	// 学生成绩
	private static int[] scores = { 100, 95, 90, 85, 80, 75, 70, 65, 60 };

	public static void main(String[] args) {
		List<Student> list = createStudent(Student::new);
		Arrays.stream(scores).forEach(score -> {
			System.out.println("成绩为" + score + "的学生:");
			list.stream().filter(s -> s.getScore() == score).forEach(System.out::println);
		});
	}

	// 产生50个学生对象
	public static List<Student> createStudent(StudentFactory funct) {
		List<Student> list = new LinkedList<>();
		for (int i = 0; i < 50; i++) {
			list.add(funct.build(i, "student" + (i + 1), scores[createRandom(new Random()::nextInt)]));
		}
		return list;
	}

	// 产生成绩的随机数
	public static int createRandom(RandScore funct) {
		return funct.getRandom(scores.length);
	}
}

package com.taiji.test;

import java.util.*;

import com.taiji.entity.Student;
import com.taiji.function.*;

public class TestLambda {
	// 学生成绩
	private static int[] scores = {100, 95, 90, 85, 80, 75, 70, 65, 60};

	public static void main(String[] args) {
		List<Student> list = createStudent(Student::new);
		Arrays.stream(scores).forEach(score -> {
			System.out.println("成绩为" + score + "的学生:");
			list.stream().filter(s -> s.getScore() == score).forEach(System.out::println);
		});
	}

	// 产生20个学生对象
	public static List<Student> createStudent(StudentFactory funct) {
		List<Student> list = new LinkedList<>();
		for (int i = 0; i < 50; i++) {
			list.add(funct.build(i, "student" + (i + 1), scores[createRandom(Random::nextInt)]));
		}
		return list;
	}
	
	// 产生成绩的随机数
	public static int createRandom(RandScore funct) {
		return funct.getRandom(new Random(), scores.length);
	}
}

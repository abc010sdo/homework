package com.exam;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.exam.service.SignService;
import com.exam.service.StudentService;

@SpringBootApplication
public class WebDemoApplication {
	
	@Autowired
	private SignService signService;
	
	public static void main(String[] args) {
		SpringApplication.run(WebDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner() {
		return arg -> {
			System.out.println("所有学生:");
			StudentService.getStudents().forEach(System.out::println);
			Scanner sc = new Scanner(System.in);
			try {
				do {
					System.out.println("\n==========主菜单==========");
					System.out.print("1.学生签到\t\t2.查询签到情况\t3.退出\n请选择[1~3]:");
					switch(sc.nextInt()) {
					case 1: 
						System.out.println("\n==========学生签到系统==========");
						System.out.print("请输入学号:");
						signService.sign(sc.nextInt());
						break;
					case 2: 
						sc.nextLine();
						seek(sc, 0);
						break;
					case 3: return ;
					default: throw new Exception();
					}
					System.out.println();
				}while(true);
			} catch (Exception e) {
				e.printStackTrace();
				return ;
			} finally {
				sc.close();
			}
		};
	}
	 
	public void seek(Scanner sc, int start) throws Exception {
		System.out.println("\n==========签到情况==========");
		signService.getSignTable(start, 5).forEach(System.out::println);
		int totalCount = signService.totalCount();
		System.out.println("当前是第" + (start + 1) + "页,共计" + totalCount + "条记录(空格后回车进入上一页||回车进入下一页)");
		System.out.print("a.查看学生签到情况\t\tb.统计签到次数\tc.返回主菜单\n请选择[a~c]:");
		switch(sc.nextLine().replaceAll("\\s\\s*", " ")) {
		case "": 
			seek(sc, start > totalCount/5-1 ? start : start + 1); 
			break;
		case " ": 
			seek(sc, start < 1 ? 0 : start - 1);
			break;
		case "a": 
			System.out.print("请输入学号:");
			signService.findBySid(sc.nextInt()).forEach(System.out::println);
			break;
		case "b": 
			System.out.print("请输入学号:");
			int count = signService.count(sc.nextInt());
			System.out.println("签到次数:" + count);
			break;
		case "c": return ;
		default : throw new Exception();
		}
	}
	
}

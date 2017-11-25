package com.taiji.function;

import com.taiji.entity.Student;

/**
 * 
 * @author abc010sdo
 *
 */
public interface StudentFactory {

	/**
	 * 学生构建者
	 * 
	 * @param id
	 *            学生编号
	 * @param name
	 *            学生姓名
	 * @param score
	 *            成绩
	 * @return 学生
	 */
	Student build(int id, String name, int score);

}

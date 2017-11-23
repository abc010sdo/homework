package com.taiji.function;

import com.taiji.entity.Student;

public interface StudentFactory {
	Student build(int id, String name, int score);
}

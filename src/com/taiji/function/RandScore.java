package com.taiji.function;

import java.util.Random;

/**
 * 
 * @author abc010sdo
 *
 */
public interface RandScore {
	
	/**
	 * 获取随机数
	 * 
	 * @param r
	 *            新的随机数
	 * @param max
	 *            随机数范围(从0到max)
	 * @return
	 */
	int getRandom(Random r, int max);

}

/**
 * Copyright(C) 2018 Zhejiang Fline Technology Co., Ltd. All rights reserved.
 *
 */
package teaop.core;

import teaop.annotation.Component;

/**
 * @since 2018年7月19日 上午10:22:53
 * @version 1.0.0
 * @author 
 *
 */
@Component
public class MyServiceImpl implements MyService {

	@Override
	public int sayHello() {

		System.out.println("hello world");
		return 1;
	}

}

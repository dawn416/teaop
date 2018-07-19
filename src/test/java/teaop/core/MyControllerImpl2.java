package teaop.core;

import teaop.annotation.Component;

/**
 * @since 2018年7月19日 下午5:25:33
 * @version 1.0.0
 * @author 黎明
 *
 */
@Component
public class MyControllerImpl2 implements MyController {

	@Override
	public void returnData() {
		System.out.println("hi");

	}

}

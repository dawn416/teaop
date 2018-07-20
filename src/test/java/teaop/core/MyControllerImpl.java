package teaop.core;

import teaop.annotation.Autowired;
import teaop.annotation.Component;

/**
 * @since 2018年7月19日 上午10:44:22
 * @version 1.0.0
 * @author 
 *
 */
@Component
public class MyControllerImpl implements MyController {

	@Autowired
	private MyService myService;

	@Override
	public void returnData() {
		System.out.println("hi world");
		myService.sayHello();
		System.out.println("bye world");
	}

}

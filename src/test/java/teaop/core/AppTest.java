package teaop.core;

import org.junit.Test;

import teaop.annotation.Component;

/**
 * @since 2018年7月19日 上午10:21:19
 * @version 1.0.0
 * @author 
 *
 */
public class AppTest {

	@Test
	public void test() {
		BeanBuilder beanBuilder = new BeanBuilder("teaop");
		// MyService myService = beanBuilder.getBean(MyService.class);
		// myService.sayHello();
		MyController myController = beanBuilder.getBean(MyController.class);
		myController.sayWhy();
	}

	@Test
	public void reflectTest() {
		// Component.class
		Class<MyController> clzs = MyController.class;
		Class<MyControllerImpl> clz = MyControllerImpl.class;
		System.out.println(clzs.getDeclaredAnnotation(Component.class));
		System.out.println(clz.getDeclaredAnnotation(Component.class));
	}
}

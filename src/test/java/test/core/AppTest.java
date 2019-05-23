package test.core;

import org.junit.Test;

import teaop.annotation.Component;
import teaop.core.BeanBuilder;

/**
 * @since 2018年7月19日 上午10:21:19
 * @version 1.0.0
 * @author 
 *
 */
public class AppTest {

	@Test
	public void test() {
		BeanBuilder beanBuilder = new BeanBuilder("test");
		// MyService myService = beanBuilder.getBean(MyService.class);
		// myService.sayHello();
		MyController myController = beanBuilder.getBean(MyController.class);
		myController.returnData();
		// myController.sayWhy();
		// myService.sayHello();
	}

	@Test
	public void reflectTest() {
		// Component.class
		Class<MyController> clzs = MyController.class;
		Class<MyControllerImpl> clz = MyControllerImpl.class;
		System.out.println(clz.getAnnotations().length);
		System.out.println(clz.getAnnotation(Component.class));
	}
}

package test.aop;

import teaop.annotation.Component;
import teaop.aop.AbstractAspect;

/**
 * @since 2018年7月19日 下午7:23:30
 * @version 1.0.0
 * @author 黎明
 *
 */
@Component
public class LogAspect extends AbstractAspect {

	@Override
	public void beforeMethod() {
		System.out.println("before method1");
	}

	@Override
	public void afterMethod() {
		System.out.println("after method1");
	}

	@Override
	public String execution() {
		return "sayHello";
	}

	@Override
	public int orderBy() {
		return 0;
	}

	@Override
	public void afterThrowing() {
		System.out.println("exception");

	}

	@Override
	public void afterReturning() {
		System.out.println("finally");

	}
}

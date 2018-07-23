package teaop.aop;

import teaop.annotation.Component;

/**
 * @since 2018年7月19日 下午7:23:30
 * @version 1.0.0
 * @author 黎明
 *
 */
@Component
public class LogAspect2 extends AbstractAspect {

	@Override
	public void beforeMethod() {
		System.out.println("before method2");
	}

	@Override
	public void afterMethod() {
		System.out.println("after method2");
	}

	@Override
	public String execution() {
		return "sayWhy";
	}

	@Override
	public int orderBy() {
		return 1;
	}

	@Override
	public void afterThrowing() {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterReturning() {
		// TODO Auto-generated method stub

	}
}

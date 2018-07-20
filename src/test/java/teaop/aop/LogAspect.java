package teaop.aop;

import teaop.annotation.Component;

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
		System.out.println("before method");
	}

	@Override
	public void afterMethod() {
		System.out.println("after method");
	}

	@Override
	public String execution() {
		return "returnData";
	}

	@Override
	public int orderBy() {
		return 0;
	}
}

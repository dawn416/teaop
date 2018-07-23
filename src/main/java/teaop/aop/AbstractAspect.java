package teaop.aop;

import java.lang.reflect.Method;

/**
 * @since 2018年7月19日 下午8:47:58
 * @version 1.0.0
 * @author 黎明
 *
 */
public abstract class AbstractAspect implements MethodInterceptor {

	@Override
	public abstract void beforeMethod();

	@Override
	public abstract void afterMethod();

	@Override
	public abstract String execution();

	@Override
	public abstract int orderBy();

	public Object process(InvokeChain chain, Method method) throws Throwable {
		if (method.getName().equals(execution())) {
			beforeMethod();
		}
		Object process = chain.process(method);
		if (method.getName().equals(execution())) {
			afterMethod();
		}
		return process;
	}
}

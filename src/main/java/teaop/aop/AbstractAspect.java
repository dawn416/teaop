package teaop.aop;

import java.lang.reflect.Method;

/**
 * @since 2018年7月19日 下午8:47:58
 * @version 1.0.0
 * @author 黎明
 *
 */
public abstract class AbstractAspect implements MethodInterceptor {



	public Object process(InvokeChain chain, Method method) throws Throwable {

		try {
			if (method.getName().equals(execution())) {
				beforeMethod();
			}
			Object process = chain.process(method);
			if (method.getName().equals(execution())) {
				afterMethod();
			}
			return process;
		} catch (Exception e) {
			if (method.getName().equals(execution())) {
				afterThrowing();
			}
			throw e;
		} finally {
			if (method.getName().equals(execution())) {
				afterReturning();
			}
		}

	}
}

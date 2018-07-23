package teaop.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import teaop.aop.InvokeChain;

/**
 * @since 2018年7月19日 上午10:03:26
 * @version 1.0.0
 * @author 
 *
 */
public class MethodHandler implements InvocationHandler {

	private Object target;

	/**
	 * @param target
	 */
	public MethodHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, final Method method, final Object[] args) throws Throwable {

		InvokeChain chain = new InvokeChain(BeanFactory.methodInterceptor) {
			@Override
			public Object indeedMethod() throws Throwable {
				try {
					return method.invoke(target, args);
				} catch (InvocationTargetException e) {
					// 抛出的异常会被代理类包装，需要拿到原始异常抛出
					throw e.getCause();
				}
				// return method.invoke(target, args);
			}
		};
		Object process = chain.process(method);
		return process;
	}


}

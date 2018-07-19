package teaop.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

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
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before");
		Object invoke = method.invoke(target, args);
		System.out.println("after");
		return invoke;
	}

}

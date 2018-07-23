package teaop.core;

import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Vector;

import teaop.aop.AbstractAspect;

/**
 * @since 2018年7月19日 上午10:30:49
 * @version 1.0.0
 * @author 
 *
 */
public class ProxyFactory {

	public static final List<Object> objList = new Vector<>();

	@SuppressWarnings("unchecked")
	public static <T> T newInstance(Class<T> clz) {
		Class<?>[] interfaces = clz.getInterfaces();
		T newInstance = null;
		try {
			newInstance = clz.newInstance();
			objList.add(newInstance);
			if (AbstractAspect.class.isAssignableFrom(clz)) {
				BeanFactory.methodInterceptor.add((AbstractAspect) newInstance);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return (T) Proxy.newProxyInstance(clz.getClassLoader(), interfaces, new MethodHandler(newInstance));
	}
}

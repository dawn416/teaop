package teaop.core;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @since 2018年7月19日 上午10:30:49
 * @version 1.0.0
 * @author 
 *
 */
public class ProxyFactory {

	public static final List<Object> objList = new ArrayList<>();

	@SuppressWarnings("unchecked")
	public static <T> T newInstance(Class<T> clz) {
		Class<?>[] interfaces = clz.getInterfaces();
		T newInstance = null;
		try {
			newInstance = clz.newInstance();
			objList.add(newInstance);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return (T) Proxy.newProxyInstance(clz.getClassLoader(), interfaces, new MethodHandler(newInstance));
	}
}

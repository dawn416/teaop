package teaop.core;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import teaop.annotation.Autowired;
import teaop.exception.BeanException;

/**
 * @since 2018年7月19日 上午10:46:24
 * @version 1.0.0
 * @author 
 *
 */
public class BeanFactory {
	private static final ConcurrentHashMap<Class<?>, List<Object>> beanMap = new ConcurrentHashMap<>();

	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clz) {
		List<Object> list = beanMap.get(clz);
		if (list == null) {
			throw new BeanException("没有对应的bean");
		}
		if (list.size() > 1) {
			throw new BeanException("对应的bean个数大于1");
		}
		return (T) list.get(0);
	}

	public static void postCreate() {
		// KeySetView<Class<?>, List<Object>> keySet = beanMap.keySet();
		for (Object obj : ProxyFactory.objList) {
			Class<? extends Object> class1 = obj.getClass();
			Field[] declaredFields = class1.getDeclaredFields();
			for (Field field : declaredFields) {
				if (field.getDeclaredAnnotationsByType(Autowired.class) != null) {
					Class<?> type = field.getType();
					Object bean2 = getBean(type);
					try {
						field.setAccessible(true);
						field.set(obj, bean2);
					} catch (Exception e) {
						e.printStackTrace();
						throw new BeanException(
								"加载bean:" + class1.getSimpleName() + "的" + type.getSimpleName() + "属性失败");
					}
				}
			}
		}
	}

	public static void createBean(Class<?> clz) {
		Class<?>[] interfaces = clz.getInterfaces();
		Object newInstance = ProxyFactory.newInstance(clz);
		for (Class<?> class1 : interfaces) {
			List<Object> beanList = beanMap.get(class1);
			if (beanList == null) {
				beanList = new ArrayList<>();
			}
			beanList.add(newInstance);
			beanMap.put(class1, beanList);
		}
	}
}

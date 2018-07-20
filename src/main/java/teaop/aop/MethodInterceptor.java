package teaop.aop;

/**
 * @since 2018年7月19日 下午8:13:48
 * @version 1.0.0
 * @author 黎明
 *
 */
public interface MethodInterceptor {
	void beforeMethod();

	void afterMethod();

	String execution();

	int orderBy();
}

# teaop
类似spring的小型aop和ioc框架

使用jdk动态代理实现

**测试代码在AppTest.java中**

#使用方法：
IOC容器：
new一个BeanBuilder，参数为要扫描的包名（包内所有类均会被扫描到）

    BeanBuilder beanBuilder = new BeanBuilder("teaop");

写一个接口，一个接口实现类，加上@Component注解,放在要扫描的包下

直接从beanBuilder对象中使用getBean取得接口的代理对象

    MyController myController = beanBuilder.getBean(MyController.class);

调用接口的方法即可调用实现类的方法实体

自动注入代理对象使用

    @Autowired
    private MyService myService;

AOP：
写个实体类继承AbstractAspect抽象类，加上@Component注解，实现以下方法，并能被BeanBuilder扫描到

前置方法

    public abstract void beforeMethod();
    
后置方法

    public abstract void afterMethod();

切入点表达式（只支持方法名）

    public abstract String execution();

多个切面的顺序（从小到大排列）

    public abstract int orderBy();

// simple example

@interface IA{
	
}

@interface IB{
	String name() default "ha";
}

@interface IC{
	IA a();
	IB[] b();
	String name() default "hh";
	int age() default 32;
}

public class Annotations{
	
	@IA
	@IB(name = "ha")
	@IC(name = "ok", a = @IA, b = { @IB(name = "a"), @IB(name = "b"), @IB()})
	@SuppressWarnings("hahaha")
	public void haha () {
		
	}
}

// simple example

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Inherited;
import javax.lang.model.element.*;
import java.util.*;
import javax.management.*;

@Retention(RetentionPolicy.RUNTIME)
@interface IA{
	
}

@interface IB{
	String name() default "ha";
}

@interface IC{
	IA a();
	IB[] b();
	String name() default "hh";			// 单独查看 IC 的反汇编，可以看到 AnnotationDefault.
	int age() default 32;
}


@Target(ElementType.PARAMETER)			// 可以修饰参数的 annotation。(参数必须明确类型)
@interface ID{
	
}
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@interface IE{
	
}


@Target(ElementType.TYPE_USE)			// 可以修饰 泛型(或者类型) 的 annotation。	// 可以用于 instanceof
@interface IF{
	
}
@Target(ElementType.TYPE_USE)
@Retention(RetentionPolicy.RUNTIME)
@interface IG{
	
}


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)		// 可以修饰类的 annotation。
@interface IH{
	
}
@Target(ElementType.TYPE)
@interface II{
	
}

@Target(ElementType.TYPE_PARAMETER)		// 只能修饰[泛型参数]，在泛型声明那里。
@interface IJ{
	
}

@Inherited
@IL
@Target(ElementType.LOCAL_VARIABLE)
@interface IK{
}

@Target(ElementType.ANNOTATION_TYPE)
@interface IL{}

@Target(ElementType.CONSTRUCTOR)
@interface IM{}

@Target(ElementType.PACKAGE)		// package-info.class 所用。详见：http://www.cnblogs.com/ycoe/archive/2009/09/26/1574565.html
@interface IN{}


class Enum{}
interface Interface{}


@II
@IH
public class Annotations <@IG T> extends @IG Enum implements @IG Interface{		// CLASS_EXTENDS
	
	@IM
	Annotations() {}
	
	@IA
	@IB(name = "ha")
	@IC(name = "ok", a = @IA, b = { @IB(name = "a"), @IB(name = "b"), @IB()})
	int i;
	
	@IA
	@IB(name = "ha")
	@IC(name = "ok", a = @IA, b = { @IB(name = "a"), @IB(name = "b"), @IB()})
	@SuppressWarnings("hahaha")
	<@IF @IG @IJ T extends @IG ArrayList<@IG T>> 	// 注意参数不可以放 @ID !! 因为 T 不确定。
	@IF @IG T check(@ID @IE @IF @IG T in) throws @IG RuntimeException { 
		try{
			@IA @IK String i = "haha";		// 这里的 IA 也消失了...
			System.out.println(i instanceof @IF String);
			int j = 0;
			System.out.println((@IF char)j);
			String @IG [] ss = new String[3];
			@IG String[] sss = new String[3];
			@IG ArrayList<@IG String> a = new ArrayList<>();
			throw new @IG ClassNotFoundException();
		} catch (@IG /*@IE*/ RuntimeException | @IG ClassNotFoundException g) {		// 这个 IE 消失掉了？？在字节码中？？
				
		}
		return in;
	}
	
	
//	void print() {
//		try{
//			throw new RuntimeException();
//		} catch (/*@IE @ID*/ RuntimeException g) {		// 就是这个 IE 和 ID，都消失掉了！！	// 卧槽，真有意思......在 eclipse 下测试，虽然都报错，但是编译运行却可以过？！欧摩西裸衣......
//				
//		}
//	}
	
}

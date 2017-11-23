# My .class file parser tool `javap`

Imitate java command tool `javap -p -verbose`.

# Example
1. download this repo
2. compile `Annotations.java` or other `.java` file: `javac -parameters Annotations.java`(`-parameters` is to open the switch of `MethodParameters` Attribute of `java8`). if U want to `javap` other `.java` file, please modify `class_main.cc` file to the right `.class` file.
3. compile the javap tool: `g++ -c class_parser.cpp -o class_parser.o && g++ class_main.cc -o myjavap class_parser.o`
4. run. `./myjavap` is okay.

# Display

* Example: `Annotations.java`
	```java
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
		String name() default "hh";
		int age() default 32;
	}


	@Target(ElementType.PARAMETER)
	@interface ID{
		
	}
	@Target(ElementType.PARAMETER)
	@Retention(RetentionPolicy.RUNTIME)
	@interface IE{
		
	}


	@Target(ElementType.TYPE_USE)
	@interface IF{
		
	}
	@Target(ElementType.TYPE_USE)
	@Retention(RetentionPolicy.RUNTIME)
	@interface IG{
		
	}


	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@interface IH{
		
	}
	@Target(ElementType.TYPE)
	@interface II{
		
	}

	@Target(ElementType.TYPE_PARAMETER)
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
		<@IF @IG @IJ T extends @IG ArrayList<@IG T>>
		@IF @IG T check(@ID @IE @IF @IG T in) throws @IG RuntimeException { 
			try{
				@IA @IK String i = "haha";
				System.out.println(i instanceof @IF String);
				int j = 0;
				System.out.println((@IF char)j);
				String @IG [] ss = new String[3];
				@IG String[] sss = new String[3];
				@IG ArrayList<@IG String> a = new ArrayList<>();
				throw new @IG ClassNotFoundException();
			} catch (@IG RuntimeException | @IG ClassNotFoundException g) {
					
			}
			return in;
		}
	}
	```
* Result: `./myjavap`
	```
	(DEBUG) cafebabe 0 52 80
	(DEBUG) constpool_size: 80
	(DEBUG) #   1 = Methodref             #15.#58
	(DEBUG) #   2 = String                #59
	(DEBUG) #   3 = Fieldref              #60.#61
	(DEBUG) #   4 = Class                 #62
	(DEBUG) #   5 = Methodref             #63.#64
	(DEBUG) #   6 = Methodref             #63.#65
	(DEBUG) #   7 = Class                 #62
	(DEBUG) #   8 = Class                 #66
	(DEBUG) #   9 = Methodref             #8.#58
	(DEBUG) #  10 = Class                 #67
	(DEBUG) #  11 = Methodref             #10.#58
	(DEBUG) #  12 = Class                 #68
	(DEBUG) #  13 = Class                 #67
	(DEBUG) #  14 = Class                 #69
	(DEBUG) #  15 = Class                 #70
	(DEBUG) #  16 = Class                 #71
	(DEBUG) #  17 = Utf8                  i
	(DEBUG) #  18 = Utf8                  I
	(DEBUG) #  19 = Utf8                  RuntimeVisibleAnnotations
	(DEBUG) #  20 = Utf8                  LIA;
	(DEBUG) #  21 = Utf8                  RuntimeInvisibleAnnotations
	(DEBUG) #  22 = Utf8                  LIB;
	(DEBUG) #  23 = Utf8                  name
	(DEBUG) #  24 = Utf8                  ha
	(DEBUG) #  25 = Utf8                  LIC;
	(DEBUG) #  26 = Utf8                  ok
	(DEBUG) #  27 = Utf8                  a
	(DEBUG) #  28 = Utf8                  b
	(DEBUG) #  29 = Utf8                  <init>
	(DEBUG) #  30 = Utf8                  ()V
	(DEBUG) #  31 = Utf8                  Code
	(DEBUG) #  32 = Utf8                  LineNumberTable
	(DEBUG) #  33 = Utf8                  LIM;
	(DEBUG) #  34 = Utf8                  check
	(DEBUG) #  35 = Utf8                  (Ljava/util/ArrayList;)Ljava/util/ArrayList;
	(DEBUG) #  36 = Utf8                  StackMapTable
	(DEBUG) #  37 = Class                 #72
	(DEBUG) #  38 = Utf8                  RuntimeVisibleTypeAnnotations
	(DEBUG) #  39 = Utf8                  LIG;
	(DEBUG) #  40 = Utf8                  RuntimeInvisibleTypeAnnotations
	(DEBUG) #  41 = Utf8                  LIF;
	(DEBUG) #  42 = Utf8                  Exceptions
	(DEBUG) #  43 = Class                 #68
	(DEBUG) #  44 = Utf8                  MethodParameters
	(DEBUG) #  45 = Utf8                  in
	(DEBUG) #  46 = Utf8                  Signature
	(DEBUG) #  47 = Utf8                  <T:Ljava/util/ArrayList<TT;>;>(TT;)TT;
	(DEBUG) #  48 = Utf8                  LIJ;
	(DEBUG) #  49 = Utf8                  RuntimeVisibleParameterAnnotations
	(DEBUG) #  50 = Utf8                  LIE;
	(DEBUG) #  51 = Utf8                  RuntimeInvisibleParameterAnnotations
	(DEBUG) #  52 = Utf8                  LID;
	(DEBUG) #  53 = Utf8                  <T:Ljava/lang/Object;>LEnum;LInterface;
	(DEBUG) #  54 = Utf8                  SourceFile
	(DEBUG) #  55 = Utf8                  Annotations.java
	(DEBUG) #  56 = Utf8                  LIH;
	(DEBUG) #  57 = Utf8                  LII;
	(DEBUG) #  58 = NameAndType           #29.#30
	(DEBUG) #  59 = Utf8                  haha
	(DEBUG) #  60 = Class                 #73
	(DEBUG) #  61 = NameAndType           #74.#75
	(DEBUG) #  62 = Utf8                  java/lang/String
	(DEBUG) #  63 = Class                 #76
	(DEBUG) #  64 = NameAndType           #77.#78
	(DEBUG) #  65 = NameAndType           #77.#79
	(DEBUG) #  66 = Utf8                  java/util/ArrayList
	(DEBUG) #  67 = Utf8                  java/lang/ClassNotFoundException
	(DEBUG) #  68 = Utf8                  java/lang/RuntimeException
	(DEBUG) #  69 = Utf8                  Annotations
	(DEBUG) #  70 = Utf8                  Enum
	(DEBUG) #  71 = Utf8                  Interface
	(DEBUG) #  72 = Utf8                  java/lang/Exception
	(DEBUG) #  73 = Utf8                  java/lang/System
	(DEBUG) #  74 = Utf8                  out
	(DEBUG) #  75 = Utf8                  Ljava/io/PrintStream;
	(DEBUG) #  76 = Utf8                  java/io/PrintStream
	(DEBUG) #  77 = Utf8                  println
	(DEBUG) #  78 = Utf8                  (Z)V
	(DEBUG) #  79 = Utf8                  (C)V
	(DEBUG) ----------------- (Annotations) static constant_pool over --------------------
	(DEBUG) access_flags: 33  this_class: #14  super_class: #15
	(DEBUG) Interfaces: 16 
	(DEBUG) field_info_size: 1
	(DEBUG) i;
	(DEBUG)   descriptor: I
	(DEBUG)   flags: 
	(DEBUG)   RuntimeVisibleAnnotations:
	(DEBUG)     0: #20()
	(DEBUG)   RuntimeInisibleAnnotations:
	(DEBUG)     0: #22(#23=s#24)
	(DEBUG)     1: #25(#23=s#26,#27=@#20(),#28=[@#22(#23=s#27),@#22(#23=s#28),@#22()])
	(DEBUG) method_number: 2
	(DEBUG)
	(DEBUG) <init>;
	(DEBUG)   descriptor: ()V
	(DEBUG)   flags: 
	(DEBUG)   Code: 
	(DEBUG)     stack=1, locals=1
	(DEBUG)       0: aload_0        
	(DEBUG)       1: invokespecial  
	(DEBUG)       4: return         
	(DEBUG)     LineNumberTable:
	(DEBUG)       line:   91, start_pc: 0   
	(DEBUG)   RuntimeInisibleAnnotations:
	(DEBUG)     0: #33()
	(DEBUG)
	(DEBUG)  throws java/lang/RuntimeException check;
	(DEBUG)   descriptor: (Ljava/util/ArrayList;)Ljava/util/ArrayList;
	(DEBUG)   flags: 
	(DEBUG)   Code: 
	(DEBUG)     stack=2, locals=7
	(DEBUG)       0: ldc            
	(DEBUG)       2: astore_2       
	(DEBUG)       3: getstatic       #3
	(DEBUG)       6: aload_2        
	(DEBUG)       7: instanceof     
	(DEBUG)      10: invokevirtual  
	(DEBUG)      13: iconst_0       
	(DEBUG)      14: istore_3       
	(DEBUG)      15: getstatic       #3
	(DEBUG)      18: iload_3        
	(DEBUG)      19: i2c            
	(DEBUG)      20: invokevirtual  
	(DEBUG)      23: iconst_3       
	(DEBUG)      24: anewarray      
	(DEBUG)      27: astore         
	(DEBUG)      29: iconst_3       
	(DEBUG)      30: anewarray      
	(DEBUG)      33: astore         
	(DEBUG)      35: new            
	(DEBUG)      38: dup            
	(DEBUG)      39: invokespecial  
	(DEBUG)      42: astore         
	(DEBUG)      44: new            
	(DEBUG)      47: dup            
	(DEBUG)      48: invokespecial  
	(DEBUG)      51: athrow         
	(DEBUG)      52: astore_2       
	(DEBUG)      53: aload_1        
	(DEBUG)      54: areturn        
	(DEBUG)     Exception Table:
	(DEBUG)        from      to  target    type
	(DEBUG)           0      52      52      12
	(DEBUG)           0      52      52      13
	(DEBUG)     LineNumberTable:
	(DEBUG)       line:  105, start_pc: 0   
	(DEBUG)       line:  106, start_pc: 3   
	(DEBUG)       line:  107, start_pc: 13  
	(DEBUG)       line:  108, start_pc: 15  
	(DEBUG)       line:  109, start_pc: 23  
	(DEBUG)       line:  110, start_pc: 29  
	(DEBUG)       line:  111, start_pc: 35  
	(DEBUG)       line:  112, start_pc: 44  
	(DEBUG)       line:  113, start_pc: 52  
	(DEBUG)       line:  116, start_pc: 53  
	(DEBUG)     StackMapTable: number_of_entries = 1
	(DEBUG)       frame_type = 116  /* stack_item */
	(DEBUG)         locals = [java/lang/Exception]
	(DEBUG)   RuntimeVisibleTypeAnnotations:
	(DEBUG)     #39()
	(DEBUG)     tag == 44 0: [offset_target] #2c
	(DEBUG)     #39()
	(DEBUG)     tag == 40 1: [localvar_target] 
	(DEBUG)       index: 4, start_pc: 1d, length: 17
	(DEBUG)     #39()
	(DEBUG)     tag == 40 2: [localvar_target] 
	(DEBUG)       index: 5, start_pc: 23, length: 11
	(DEBUG)     type_path_kind: 0; type_argument_index: 0
	(DEBUG)     #39()
	(DEBUG)     tag == 40 3: [localvar_target] 
	(DEBUG)       index: 6, start_pc: 2c, length: 8
	(DEBUG)     type_path_kind: 3; type_argument_index: 0
	(DEBUG)     #39()
	(DEBUG)     tag == 40 4: [localvar_target] 
	(DEBUG)       index: 6, start_pc: 2c, length: 8
	(DEBUG)     #39()
	(DEBUG)     tag == 42 5: [catch_target] #0
	(DEBUG)     #39()
	(DEBUG)     tag == 42 6: [catch_target] #0
	(DEBUG)   RuntimeInisibleTypeAnnotations:
	(DEBUG)     #41()
	(DEBUG)     tag == 43 0: [offset_target] #6
	(DEBUG)     #41()
	(DEBUG)     tag == 47 1: [type_argument_target] #12 #0
	(DEBUG)   Exceptions: 
	(DEBUG)     throws java/lang/RuntimeException 
	(DEBUG)
	(DEBUG)  MethodParameters:
	(DEBUG)    in 
	(DEBUG)   Signature: #47 <T:Ljava/util/ArrayList<TT;>;>(TT;)TT;
	(DEBUG)   RuntimeVisibleAnnotations:
	(DEBUG)     0: #20()
	(DEBUG)   RuntimeInisibleAnnotations:
	(DEBUG)     0: #22(#23=s#24)
	(DEBUG)     1: #25(#23=s#26,#27=@#20(),#28=[@#22(#23=s#27),@#22(#23=s#28),@#22()])
	(DEBUG)   RuntimeVisibleTypeAnnotations:
	(DEBUG)     #39()
	(DEBUG)     tag == 1 0: [type_parameter_target] #0
	(DEBUG)     #39()
	(DEBUG)     tag == 12 1: [type_parameter_bound_target] #0 #0
	(DEBUG)     #39()
	(DEBUG)     tag == 12 2: [type_parameter_bound_target] #0 #0
	(DEBUG)     type_path_kind: 3; type_argument_index: 0
	(DEBUG)     #39()
	(DEBUG)     tag == 17 3: [throws_target] #0
	(DEBUG)     #39()
	(DEBUG)     tag == 14 4: [empty_target]
	(DEBUG)     #39()
	(DEBUG)     tag == 16 5: [formal_parameter_target] #0
	(DEBUG)   RuntimeInisibleTypeAnnotations:
	(DEBUG)     #41()
	(DEBUG)     tag == 1 0: [type_parameter_target] #0
	(DEBUG)     #48()
	(DEBUG)     tag == 1 1: [type_parameter_target] #0
	(DEBUG)     #41()
	(DEBUG)     tag == 14 2: [empty_target]
	(DEBUG)     #41()
	(DEBUG)     tag == 16 3: [formal_parameter_target] #0
	(DEBUG)   RuntimeVisibleParameterAnnotations:
	(DEBUG)     0: #50()
	(DEBUG)   RuntimeInisibleParameterAnnotations:
	(DEBUG)     0: #52()
	(DEBUG)
	(DEBUG) attribute_number: 5
	(DEBUG)   Signature: #53 <T:Ljava/lang/Object;>LEnum;LInterface;
	(DEBUG) SourceFile: "Annotations.java"
	(DEBUG)   RuntimeVisibleAnnotations:
	(DEBUG)     0: #56()
	(DEBUG)   RuntimeInisibleAnnotations:
	(DEBUG)     0: #57()
	(DEBUG)   RuntimeVisibleTypeAnnotations:
	(DEBUG)     #39()
	(DEBUG)     tag == 10 0: [supertype_target] #ffff
	(DEBUG)     #39()
	(DEBUG)     tag == 10 1: [supertype_target] #0
	(DEBUG)     #39()
	(DEBUG)     tag == 0 2: [type_parameter_target] #0
	```

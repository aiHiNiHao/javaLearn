package annotation;

import jdk.jfr.Description;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 这个之前，我要先说这个注解的定义
 * 写法是不是和类的定义很相似啊， @interface 就说明他是一个注解啦，
 * 再看第一行，@Target 这个就是要告诉用注解的人，我这个的作用范围，
 * 就这个例子来说 ElementType.TYPE 意思就是我这个注解你只能用来作用于类，而不能作用于变量或者方法上面
 * 他的取值我们可以看一下 ElementType 这个enum里面的说明，一看就明白，不多说
 *
 * 第二行这个 @Retention 是用来规定这个注解要作用的时机，RetentionPolicy.RUNTIME 就是说我要在运行时
 * 让他起作用，这也不难理解，你想啊，咱们的javabean 要存到数据库肯定是动态执行时的，所以选择 RetentionPolicy.RUNTIME
 * 关于这个选项，可参见文档说明， 一看就明白，不多说了
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {

    //关于这个value方法，如果你只有一个属性，当我们value()时，使用的时候就不需要指明是哪个属性了，直接填值就可以了
    String value();
}

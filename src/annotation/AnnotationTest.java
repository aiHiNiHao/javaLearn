package annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class AnnotationTest {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setName("xiaoli");

        Person person2 = new Person();
        person2.setAddress("北京");

        Person person3 = new Person();
        person3.setEmail("5555@qq.com, 163333@163.com");

        String query1 = query(person1);
        String query2 = query(person2);
        String query3 = query(person3);

        System.out.println(query1);
        System.out.println(query2);
        System.out.println(query3);
    }


    /**
     * 根据Person 这个对象里面的字段名和字段值来生成sql语句
     * @param person
     * @return
     */
    public static String query(Person person) {
        StringBuffer sql = new StringBuffer();

        //这里用到了反射，不会反射的朋友也不要惊慌，在这我大致概括一下反射的使用过程
        //1,先获取类对象 Class
        //2,根据Class对象来获取Class里面的字段和方法
        //3,在通过某个方法获取Object对象的字段的值或者调用Object的方法

        //第一步，
        Class clazz = person.getClass();
        // 这里就是检测一下传进来的对象的类对象有没有用到我们定义的注解，没什么好说，记住这些方法
        boolean exist = clazz.isAnnotationPresent(Table.class);

        if (!exist) return null;

        //获取注解的值，这里就是数据库表名
        Table table = (Table) clazz.getAnnotation(Table.class);
        String tableName = table.value();

        //这里的" where 1 = 1"就是防止没有判断语句而导致sql语句不完整
        sql.append("select * from ").append(tableName).append(" where 1 = 1");

        //第二步 获取所有的字段，不管是public还是private，统统的拿到
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {

            //还是判断一下这个字段有没有用到注解
            boolean existColunm = field.isAnnotationPresent(Column.class);
            if (existColunm){
                //数据库里面的字段
                Column column = field.getAnnotation(Column.class);
                String columnalue = column.value();

                //到底看看这是javabean哪个属性
                String fieldName = field.getName();

                //根据属性名来找到get方法，下面的写法不是固定的，随机应变
                String methodName = "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);

                try {
                    //看到了没，这就是第三步
                    Object invoke = clazz.getMethod(methodName).invoke(person);

                    if (invoke != null){
                        sql.append(" and ").append(columnalue).append("=").append(invoke);
                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }

        return sql.toString();
    }
}

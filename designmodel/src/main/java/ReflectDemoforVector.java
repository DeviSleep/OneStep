import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射技术 解析向量类java.util.Vector 有哪些属性和方法
 */
public class ReflectDemoforVector {

    public static void main(String[] args) throws ClassNotFoundException {
        Class vector = Class.forName("java.util.Vector");

        Constructor[] cons = vector.getDeclaredConstructors();
        int i = 1, j = 1;
        for (Constructor con : cons) {
            System.out.print("第-" + i + "个constructor ：" + con.getName().toString());
            System.out.println("-----------"+ con.toGenericString());
            i++;
        }

        Method[] methods = vector.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(" method 第 " + j + "个" + method.getName());
            j++;
        }

        int m = 1;
        Field[] fields = vector.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field 第" + m + "个 " + field.getName());
            m++;
        }
    }


}

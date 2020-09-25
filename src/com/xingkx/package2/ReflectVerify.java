package com.xingkx.package2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

class FatherClass{
    public String FatherName;
    public int FatherAge;

    public void printFatherMsg(){

    }
}

class SonClass extends FatherClass{
    private String SonName;
    protected int SonAge;
    public String SonBirthday;

    private String getSonName() {
        return SonName;
    }

    private void setSonName(String sonName) {
        SonName = sonName;
    }

    private int getSonAge() {
        return SonAge;
    }

    private void setSonAge(int sonAge) {
        SonAge = sonAge;
    }

    public void printSonMsg(){
        System.out.println("Son Msg - name : " + SonName + "; age : " + SonAge);
    }

}

class TestClass{
    private String MSG = "Original";

    private void privateMethod(String head, int tail){
        System.out.println(head + tail);
    }

    public String getMsg(){
        return MSG;
    }
}
public class ReflectVerify {
    public static void printFields() {
        //1.获取并输出类的名称
        Class clz = SonClass.class;
        System.out.println("类的名称： " + clz.getName());

        //2.1获取所有public访问权限的变量，包括从父类继承
        //Field[] fields = clz.getFields();

        //2.2获取所有本类声明的变量（不问访问权限,没有继承过来的变量）
        Field[] fields = clz.getDeclaredFields();

        //3.遍历输出变量信息
        for(Field field : fields){
            //获取访问权限并输出
            int modifiers = field.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");

            //输出变量的类型及变量名
            System.out.println(field.getType().getName() + " " + field.getName());

        }
    }
    public static void printMethods() {
        Class clz = SonClass.class;
        System.out.println(clz.getName());//全限定路径类名

        //2.1获取所有public访问权限的自己声明以及继承父类的方法
        //Method[] methods = clz.getMethods();
        //2.2获取所有本类的方法
        Method[] methods = clz.getDeclaredMethods();

        for(Method method : methods) {
            int modifiers = method.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");
            //获取并输出方法的返回值类型
            Class returnType = method.getReturnType();
            System.out.print(returnType.getName() + " " + method.getName() + "( ");

            //获取并输出方法的所有参数
            Parameter[] parameters = method.getParameters();
            for(Parameter parameter : parameters){
                System.out.print(parameter.getType() + " " + parameter.getName() + ",");
            }

            //获取并输出方法抛出的异常
            Class[] exceptionType = method.getExceptionTypes();
            if(exceptionType.length == 0){
                System.out.println(" )");
            }
            else {
                for(Class c : exceptionType){
                    System.out.println(" ) throws " + c.getName());
                }
            }

        }
    }
    public static void main(String[] args) throws Exception {
        //1.获取Class类实例
        TestClass testClass = new TestClass();
        Class clz = testClass.getClass();

        //2.获取私有方法，第一个参数为要获取私有方法的名称，第二个为要获取方法的参数的类型，参数为Class，没有参数就是null
        Method privateMethod = clz.getDeclaredMethod("privateMethod", String.class, int.class);

        if(privateMethod != null) {
            //获取私有方法的访问权，并不会修改实际权限
            privateMethod.setAccessible(true);

            //使用invoke反射调用私有方法
            privateMethod.invoke(testClass, "Java Reflect ", 666);

        }


    }
}

package com.xingkx.package1;

import java.io.*;

/**
 * 利用序列化实现对象的拷贝
 * 在内存中通过字节流的拷贝：把母对象写入到一个字节流中，再从字节流中将其读出来，这样就可以创建一个新的对象了
 *                      并且该新对象与母对象之间并不存在引用共享的问题，真正实现对象的深拷贝。
 */
class CloneUtils{

    public static <T extends Serializable> T clone(T obj){
        T cloneObj = null;

        try {
            //写入字节流
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(obj);

            //分配内存，写入原始对象，生成新对象
            ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(in);
            //返回生成的新对象
            cloneObj = (T) ois.readObject();

            ois.close();
            obs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cloneObj;
    }
}

class Employee implements Serializable{
    private static final long serialVersionUID = 2631590509760908280L;
    private String name;
    private Email email;

    public Employee(String name, Email email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}

class Email implements Serializable{
    private static final long serialVersionUID = 1267293988171991494L;
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Email(String title, String content){
        this.title = title;
        this.content = content;
    }
}

public class SerializableVerify {

    public static void main(String[] args) {
        Email email = new Email("请参加会议","12:30开始");

        Employee p1 = new Employee("张三",email);
        Employee p2 = CloneUtils.clone(p1);
        p2.setName("李四");
        Employee p3 = CloneUtils.clone(p1);
        p3.setName("王五");

        p1.getEmail().setContent("12:00开始");

        System.out.println(p1.getName() + "的邮件内容是：" + p1.getEmail().getContent());
        System.out.println(p2.getName() + "的邮件内容是：" + p2.getEmail().getContent());
        System.out.println(p3.getName() + "的邮件内容是：" + p3.getEmail().getContent());
    }
}

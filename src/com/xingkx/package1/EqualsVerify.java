package com.xingkx.package1;

/**
 * 所有的对象都拥有标识（内存地址）和状态（数据）
 * "=="比较两个对象的内存地址，使用Object的equals()方法是比较两个对象的内存地址是否相等
 * equals()方法在非空对象引用上实现相等关系：
 * 1自反性 x.equals(x) == true
 * 2对称性 if and only if y.equals(x)==true,x.equals(y)==true
 * 3传递性 if x.equals(y)==true,y.equals(z)==true x.equals(z)==true
 * 4一致性 多次equals保持相同结果
 * 5对于任何非空引用值x,x.equals(null)==false
 *
 * 覆写equals时推荐使用getClass进行类型判断。而不是使用instanceof.
 */
public class EqualsVerify {

    public boolean equals(Object obj){
        return (this == obj);
    }

    public static void main(String[] args) {


    }
}

package com.xingkx.package2;

class New{
    int a;
    String b;
}
public class TestClone implements Cloneable{
    String a;
    String b;
    New n;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        TestClone tc = null;

        tc = (TestClone) super.clone();
        return tc;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        TestClone t = new TestClone();
        t.setA("haha");
        t.setB("nothaha");
        t.n = new New();
        t.n.a = 1;
        t.n.b = "1";
        TestClone tt= (TestClone)t.clone();
        tt.setA("oo");
        tt.setB("notoo");
        tt.n.a = 2;
        tt.n.b = "2";
        System.out.println(t.getA() + " " + t.getB() + " " + t.n.a + " " + t.n.b);
        System.out.println(tt.getA() + " " + tt.getB());
    }
}

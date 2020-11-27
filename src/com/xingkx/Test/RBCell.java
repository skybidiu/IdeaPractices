package com.xingkx.Test;

import java.util.Comparator;

public class RBCell<E> {
    static final boolean RED = false;
    static final boolean BLACK = true;

    private E element;
    private boolean color = BLACK;
    private RBCell left = null;
    private RBCell right = null;
    private RBCell parent = null;

    public RBCell(E element){
        this.element = element;
    }
    public final E element(){
        return element;
    }
    public final void element(E e){
        this.element = e;
    }
    public final RBCell left(){
        return left;
    }
    public final RBCell right(){
        return right;
    }
    public final RBCell parent(){
        return parent;
    }
    static boolean colorOf(RBCell p){
        return (p == null) ? BLACK : p.color;
    }
    static RBCell parentOf(RBCell p){
        return (p == null) ? null : p.parent;
    }
    static void setColor(RBCell p, boolean color){
        if(p != null){
            p.color = color;
        }
    }
    static RBCell leftOf(RBCell p){
        return (p == null) ? null : p.left;
    }
    static RBCell rightOf(RBCell p){
        return (p == null) ? null : p.right;
    }
    protected void copyContents(RBCell<E>t){
        element = t.element;
    }

    public final RBCell leftmost(){
        RBCell p = this;
        while(p.left != null){
            p = p.left;
        }
        return p;
    }
    public final RBCell rightmost(){
        RBCell p = this;
        while(p.right != null){
            p = p.right;
        }
        return p;
    }
    public final RBCell root(){
        RBCell p = this;
        while(p.parent != null){
            p = p.parent;
        }
        return p;
    }
    public final boolean isRoot(){
        return parent == null;
    }
    public final RBCell successor(){ //寻找中序遍历的后继
        if(right != null){
            return right.leftmost();
        } else {
            RBCell p = parent;
            RBCell ch = this;
            while(p != null && ch == p.right){
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }
    public final RBCell predecessor(){ //寻找中序遍历的前驱
        if(left != null){
            return left.rightmost();
        } else {
            RBCell p = parent;
            RBCell ch = this;
            while(p != null && ch == p.left){
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }
    public final int size(){
        int c = 1;
        if(left != null) c += left.size();
        if(right != null) c += right.size();
        return c;
    }

    public RBCell find(E e, Comparator cmp){
        RBCell t = this;
        for(;;) {
            int diff = cmp.compare(element, t.element);
            if(diff == 0) return t;
            else if(diff < 0) t = t.left;
            else t = t.right;
            if(t == null) return null;
        }
    }
}

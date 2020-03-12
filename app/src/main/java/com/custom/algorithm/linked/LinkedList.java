package com.custom.algorithm.linked;

/**
 * Created by: Ysw on 2020/3/12.
 */
public class LinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    int size;

    public LinkedList() {
    }

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        public Node(Node<T> prev, T item, Node<T> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    public synchronized void add(T t) {
        linkLast(t);
    }

    /**
     * 添加至末尾
     *
     * @author Ysw created at 2020/3/12 12:46
     */
    private void linkLast(T t) {
        Node<T> newNode = new Node<>(last, t, null);
        Node<T> l = last;
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public synchronized T get(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        return node(index).item;

    }


    /**
     * 获取某个位置的值，采用了一级2分法
     *
     * @author Ysw created at 2020/3/12 12:51
     */
    private Node<T> node(int index) {
        if (index < (size >> 1)) {
            Node<T> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<T> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    /**
     * 添加到链表中间的某一个位置
     *
     * @author Ysw created at 2020/3/12 12:56
     */
    public synchronized void add(int index, T t) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == size) {
            linkLast(t);
        } else {
            Node<T> target = node(index);
            Node<T> pre = target.prev;
            Node<T> newNode = new Node<>(pre, t, target);
            if (pre == null) {
                first = newNode;
            } else {
                pre.next = newNode;
            }
            pre = newNode;
            size++;
        }
    }

    public synchronized void remove(int index) {
        Node<T> target = node(index);
        unlinkNode(target);
    }

    /**
     * 移除链表中某个位置的元素
     *
     * @author Ysw created at 2020/3/12 12:57
     */
    private void unlinkNode(Node<T> target) {
        Node<T> pre = target.prev;
        Node<T> next = target.next;
        if (pre == null) {
            first = target.next;
        } else {
            pre.next = target.next;
        }
        if (next == null) {
            last = target.prev;
        } else {
            next.prev = target.prev;
        }
        size--;
    }


    /**
     * 获取链表的长度
     *
     * @author Ysw created at 2020/3/12 13:06
     */
    public synchronized int size() {
        return size;
    }
}

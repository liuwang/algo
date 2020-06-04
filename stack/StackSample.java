interface Stack {
    boolean push(String element);

    String pop();
}

// 数组实现方式
class ArrayStack implements Stack {
    private String[] items; // 容器
    private int size; // 容器大小
    private int count; // 容器中元素数量

    public ArrayStack(int n) {
        this.items = new String[n];
        this.size = n;
        this.count = 0;
    }

    @Override
    public boolean push(String element) {
        if (size == count) return false;
        items[count] = element;
        ++count;
        return true;
    }

    @Override
    public String pop() {
        if (count == 0) {
            return null;
        }
        --count;
        return items[count];
    }
}

class LinkedStack implements Stack {
    private Node head;

    @Override
    public boolean push(String element) {
        Node node = new Node();
        node.content = element;
        if (head == null) {
            node.next = null;
        } else {
            node.next = head;
        }
        head = node;
        return true;
    }

    @Override
    public String pop() {
        if (head == null) return null;
        Node el = head;
        head = head.next;
        return el.content;
    }

    private class Node {
        String content;
        Node next;
    }
}

public class StackSample {
    public static void main(String[] args) {
        Stack stack = new LinkedStack();
        stack.push("hello");
        stack.push("world");
        stack.push("baby");
        stack.push("girl");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

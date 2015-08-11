package DoubleNodePackage;

/**
 * Created by ù on 11.08.2015.
 */
public class SingleLLUtils_2 {
    public static void main(String[] args) {
        int size = 5;
        DoubleNode doubleNode = generateDoubleNodeIter(size);
        System.out.println(nodeToStringIter(doubleNode));
        int value = 999;
        int value1 = 333;
        add(doubleNode, value);
        add(doubleNode, value);
        add(doubleNode, value1);
        add(doubleNode, value1);
        System.out.println(nodeToStringIter(doubleNode));
        removeIter(doubleNode);
        System.out.println(nodeToStringIter(doubleNode));
        System.out.println(doubleNode.nodeToStringRecurs());  //!!!non-static method!!!
        int index = 2;
        int value2 = 777;
        add(doubleNode, index, value2);
        System.out.println(doubleNode.nodeToStringRecurs());
        DoubleNode doubleNode1 = remove(doubleNode, 1);
        System.out.print("null-");
        System.out.println(doubleNode1.nodeToStringRecurs());
    }

    private static DoubleNode remove(DoubleNode tail, int index) {
        DoubleNode result = tail;
        if (index < 1) {
            tail.prev.next = null;
            result = tail.prev;
        } else {
            for (int i = 0; i < index; i++) {
                if (tail.prev != null) {
                    tail = tail.prev;
                }
            }
            tail.next.prev = tail.prev;
            if (tail.prev != null) {
                tail.prev.next = tail.next;
            }
        }
        return result;
    }

    private static DoubleNode add(DoubleNode tail, int index, int value) {
        DoubleNode result = tail;
        if (index < 1) {
            DoubleNode newDoubleNode = new DoubleNode(value, tail, null);
            tail.next = newDoubleNode;
            result = result.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                tail = tail.prev;
            }
            DoubleNode newDoubleNode = new DoubleNode(value, tail.prev, tail);
            tail.prev.next = newDoubleNode;
            tail.prev = newDoubleNode;
        }
        return result;
    }

    private static DoubleNode removeIter(DoubleNode tail) {
        DoubleNode result = tail;
        while (tail.prev.prev != null) {
            tail = tail.prev;
        }
        tail.prev = null;
        return result;
    }

    private static String remove(DoubleNode tail) {
        if (tail != null) {
            return tail.value + "-" + remove(tail.prev);
        } else {
            return "null";
        }
    }

    private static String nodeToStringIter(DoubleNode tail) {
        String result = "null-";
        while (tail != null) {
            result += tail.value + "-";
            tail = tail.prev;
        }
        result += "null";
        return result;
    }

    private static DoubleNode add(DoubleNode tail, int value) {
        DoubleNode result = tail;
        DoubleNode newDoubleNode = new DoubleNode(value, null, null);
        while (tail.prev != null) {
            tail = tail.prev;
        }
        tail.prev = newDoubleNode;
        newDoubleNode.next = tail;
        return result;
    }

    private static DoubleNode generateDoubleNodeIter(int size) {
        DoubleNode result = new DoubleNode(size, null, null);
        for (int index = size - 1; index >= 0; index--) {
            result.next = new DoubleNode(index, result, null);
            result = result.next;
        }
        result.next = null;
        return result;
    }

    private static DoubleNode generateDoubleNodeRecurs(int size) {//Can't solve
        int maxSize;
        DoubleNode result;
        if (size > 0) {
            result = new DoubleNode(size, generateDoubleNodeRecurs(size - 2), generateDoubleNodeRecurs(size - 1));
        } else {
            result = null;
        }
        return result;
    }
}

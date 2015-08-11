package DoubleNodePackage;

/**
 * Created by ù on 11.08.2015.
 */
public class DoubleNode {
    int value;
    DoubleNode prev;
    DoubleNode next;

    public DoubleNode(int value, DoubleNode prev, DoubleNode next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    public String nodeToStringRecurs() {
        if (this.prev != null) {
            return this.value + "-" + this.prev.nodeToStringRecurs();
        } else {
            return this.value + "-null";
        }
    }
}

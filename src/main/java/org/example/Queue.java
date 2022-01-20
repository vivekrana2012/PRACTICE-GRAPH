package org.example;

public class Queue<T> implements BasicStructure<T> {

    private Node<T> head;

    @Override
    public void push(T t) {

        if (this.head == null) {
            this.head = new Node<>(t);

            return;
        }

        pushNow(this.head, t);
    }

    private void pushNow(Node<T> node, T t) {

        if (node.hasNext()) {
            pushNow(node.getNext(), t);
        } else {
            node.setNext(new Node<>(t));
        }
    }

    @Override
    public T pop() {

        if (this.head == null) {
            return null;
        }

        Node<T> node = this.head;

        if (this.head.hasNext()) {
            this.head = this.head.getNext();
        } else {
            this.head = null;
        }

        return node.getData();
    }
}

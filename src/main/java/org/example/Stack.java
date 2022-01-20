package org.example;

public class Stack<T> implements BasicStructure<T> {

    private Node<T> head;

    @Override
    public T pop() {

        if (this.head == null) {
            return null;
        }

        if (!this.head.hasNext()) {
            Node<T> node = this.head;
            this.head = null;

            return node.getData();
        }

        return popNow(this.head);
    }

    private T popNow(Node<T> node) {

        if (node.getNext().hasNext()) {
            return popNow(node.getNext());
        } else {
            Node<T> removedNode = node.getNext();
            node.setNext(null);

            return removedNode.getData();
        }
    }

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
}

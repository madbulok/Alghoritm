package lesson3;

public class DoubleVectorList<E>{
    private Node<E> front = null;
    private Node<E> back = null;
    private int size = 0;
    private Node<E> current;
    private boolean isFirst = true;     // первый узел надо обработать отдельно

    public DoubleVectorList(){
        front = new Node<>();
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }

    public void add(E element){
        if (isEmpty()){    // первый узел надо обработать отдельно, иначе в первом узле элемент будет балластом
            front.set(element);
        }
        else{
            front.add(element);
        }
        size++;             // увеличим счетчик элементов
    }

    public void addPrevious(E element){
        if (isEmpty()){
            current.set(element);
        } else {
            back.set(element);
        }
    }

    public void remove(Node<E> element){

    }

    public Node<E> get(){
        return front;
    }

    // Узел с элементом, сделан внутренним, чтобы не светить его наружу
    protected class Node<E>{
        private E element;
        private Node<E> next = null;
        private Node<E> previous = null;

        Node(){}
        Node(E element){
            set(element);
        }
        void set(E element){
            this.element = element;
        }
        void add(E element){
            if (isNext()){                      // если существует следующий узел, передадим ему эстафету
                next.add(element);
            }
            else{                               // иначе создадим следующий узел
                next = new Node<>(element);
            }
        }
        E get(){
            return element;
        }
        boolean isNext(){
            return next != null;
        }
        boolean isPrevious(){
            return previous != null;
        }

        public boolean hasNext() {
            if (size == 1 && isFirst) return true;   // отдельно обработать один элемент (потому как у него нет next)
            return isNext();
        }
        public boolean hasPrevious() {
            if (size == 1 && isFirst) return true;   // отдельно обработать один элемент (потому как у него нет next)
            return isPrevious();
        }

        public E next() {
            if (isFirst) isFirst = false;
            else current = current.next;
            if (hasNext()) return next.get();
            return null;
        }

        public E previous() {
            if (!isFirst) isFirst = true;
            else current = current.previous;
            if (hasPrevious()) return previous.get();
            return null;
        }
    }
}
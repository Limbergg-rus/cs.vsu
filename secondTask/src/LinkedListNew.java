public class LinkedListNew {
    Node head;
    int size;
    Node tail;

    public class Node {
        Node next;
        Node previous;
        final int value;

        public Node(int value) {
            this.value = value;
        }

    }

    public void addFirst(int value) {
        Node firstNode = new Node(value);
        if (head == null) {
            tail = firstNode;
        } else {
            head.previous = firstNode;
        }
        firstNode.next = head;
        head = firstNode;
        size++;
    }

    public void addLast(int value) {
        Node lastNode = new Node(value);
        if (tail == null) {
            head = lastNode;
        } else {
            tail.next = lastNode;
        }
        lastNode.previous = tail;
        tail = lastNode;
        size++;
    }

    public void add(int index, int value) {
        if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            int i = 0;
            Node currentNode = head;
            while (i != index) {
                currentNode = currentNode.next;
                i++;
            }

            Node temp = new Node(value);

            currentNode.previous.next = temp;
            temp.previous = currentNode.previous;
            currentNode.previous = temp;
            temp.next = currentNode;
            size++;
        }
    }

    public int get(int k) {
        Node currentNode;
        if ((size + 1) / 2 > k) {
            currentNode = head;
            for (int i = 0; i < k; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = tail;
            for (int i = 0; i < size - 1 - k; i++) {
                currentNode = currentNode.previous;
            }
        }
        return currentNode.value;
    }


    public void remove(int index) {
        if (index == 0) {
            head = head.next;
        } else if (index == size - 1) {
            tail = tail.previous;
        } else {
            int i = 0;
            Node currentNode = head;
            while (i != index) {
                currentNode = currentNode.next;
                i++;
            }
            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
        }
        size--;
    }

    public static void print(LinkedListNew arr) {
        Node head = arr.head;
        for (int i = 0; i < arr.size; i++) {
            if (i == arr.size - 1) {
                System.out.println(head.value);
            } else {
                System.out.print(head.value + ", ");
            }
            head = head.next;

        }
    }

    public static int[] LinkedListToIntArray(LinkedListNew arr){
        int[] arr1 = new int[arr.size];
        Node head = arr.head;
        for (int i = 0;i < arr.size; i++){
            arr1[i] = head.value;
            head = head.next;
        }
        return arr1;
    }

    public static LinkedListNew fillLinkedList(int[] arr){
        LinkedListNew arr1 = new LinkedListNew();
        for(int i: arr){
            arr1.addLast(i);
        }
        return arr1;
    }



}

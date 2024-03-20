public class Stack {
    Node head;


    public class Node {
        Node prev;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    //    Возвращает объект, находящийся в начале Stack<T>, без его удаления
    public int peek() {
        if (head != null) {
            return head.val;
        }
        return 0;

    }

    //    Удаляет и возвращает объект, находящийся в начале Stack<T>

    public int pop() {
        if (head != null) {
            int ans = head.val;
            head = head.prev;
            return ans;
        }
        return 0;
    }

    //    Вставляет объект как верхний элемент стека Stack<T>
    public void push(int val) {
        Node cur = new Node(val);
        cur.prev = head;
        head = cur;
    }

}

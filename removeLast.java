public class LinkedList{
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void Addfirst(int data){
        //1 - Create new node
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }
        //2 - newNode next = Head
        newNode.next = head; //link
        //3 - head = newNode
        head = newNode;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode; //link
        tail = newNode;
    }
    public void print(){
        if(head == null){
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+">");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public int removeLast(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        //prev: i=size-2
        Node prev = head;
        for(int i = 0; i<size-2; i++){
            prev = prev.next;
        }

        int val = prev.next.data; //tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.Addfirst(2);
        ll.Addfirst(1);
        ll.addLast(4);

        ll.print(); 
        ll.removeLast();
        ll.print();
        System.out.println(ll.size);
    }
}
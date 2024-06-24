public class DoublyLL{
    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
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
        newNode.next = head; //link
        head.prev = newNode;
        head = newNode;
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

    //remove - removeLast
    public int removeFirst(){
        if(head == null){
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }
    public static void main(String args[]){
        DoublyLL dll = new DoublyLL();
        dll.Addfirst(1);
        dll.Addfirst(2);
        dll.Addfirst(3);
        dll.Addfirst(4);
        dll.Addfirst(5);

        dll.print();
        System.out.println(dll.size); 

        dll.removeFirst();
        dll.print();
        System.out.println(dll.size); 
    }
}
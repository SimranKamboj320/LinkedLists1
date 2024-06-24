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
    public void reverse(){
        Node curr = head;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }
        head = prev;
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

        dll.reverse();
        dll.print(); 
    }
}
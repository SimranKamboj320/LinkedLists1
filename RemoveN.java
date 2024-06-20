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
    public void RemoveN(int n){
        //calculate size
        int size = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        if(n == size){
            head = head.next; //remove first
            return;
        }

        //size - n
        int i = 1;
        int iToFind = size-n;
        Node prev = head;
        while(i < iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.Addfirst(2);
        ll.Addfirst(1);
        ll.Addfirst(4);
        ll.Addfirst(5);
        ll.Addfirst(7);
        ll.Addfirst(8);

        ll.print();
        ll.RemoveN(4); 
        ll.print();
    }
}
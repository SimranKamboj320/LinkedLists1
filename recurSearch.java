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
    public int helper(Node head, int key){//recursive func
        if(head == null){//base case
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }
        return idx+1;
    }
    public int recurSearch(int key){
        return helper(head, key);
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
        System.out.println(ll.recurSearch(3));
        System.out.println(ll.recurSearch(7));
    }
}
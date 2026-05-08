class ListNode {
    int value;
    ListNode next;

    // Constructor that sets 'next' to null by default
    public ListNode(int value) {
        this(value, null);
    }

    // Constructor that accepts both value and next node
    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}

class LinkedList {
    ListNode head;
    int size;

    // Constructor: Initialize with a -1 node and 0 size
    public LinkedList() {
        this.head = new ListNode(-1);
        this.size = 0;
    }

    public int get(int index) {
        ListNode target = this.head.next;
        if (target == null){return -1;}

        for (int i = 0; i<index; i++){
            if (target.next == null){return -1;}
            target = target.next;
        }

        return target.value;
    }

    public void insertHead(int val) {
        ListNode newHead = new ListNode(val, this.head.next);
        this.head.next = newHead;
        this.size += 1;
    }

    public void insertTail(int val) {
        ListNode newTail = new ListNode(val);
        ListNode current = this.head;
        
        while(current.next != null) {current = current.next;}
        current.next = newTail;
        
        this.size += 1;
    }

    public boolean remove(int index) {
        ListNode target = this.head.next;
        ListNode previous = this.head;

        if (target == null){return false;}

        for (int i = 0; i<index; i++){
            if (target.next == null){return false;}
            previous = target;
            target = target.next;
        }

        previous.next = target.next;
        this.size -= 1;

        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> valueList = new ArrayList<Integer>();
        ListNode current = this.head.next;

        for (int i = 0; i<this.size; i++){
            valueList.add(current.value);
            current = current.next;
        }

        return valueList;
    }
}

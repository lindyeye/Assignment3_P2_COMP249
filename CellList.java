/**
 * Assignment 3 - Part 2
 * For COMP  249 Section D - Fall 2022
 * @author Linden Wheeler 40195748 and Matej Pederson 40209550
 */
import java.util.NoSuchElementException;

//this is my magnum opus and i will take no complaints. im probably out this bitch after the semester is over so this is my last code for a failed degree :D
public class CellList{
    
    public class CellNode 
    {
        private CellPhone c;
        private CellNode next;
        /**
         * Default constructor.
        */
        public CellNode()
        {
            c = null;
            next = null;
            size++;
        }
        /**
         * Constructor that takes parameters.
         * @param cr cellphone to store in the node
         * @param xt new CellNode
         */
        public CellNode(CellPhone cr, CellNode xt)
        {
            c = cr;
            next = xt;
            size++;
        }
        /** 
         * clone method. calls the copy constructor to create a new node with a duplicate cellphone
         * @return CellNode new CellNode that is created
         */
        public CellNode clone()
        {
            size++;
            return new CellNode(this);
        }
        /** 
         * copy constructor
         * @param cn cellNode that is the copy reference
         */
        public CellNode(CellNode cn)
        {
            c = cn.c;
            next = cn.next;
            size++;
        }
        /** 
         * sets new cellphone to node
         * @param cr new cellphone to set to
         */
        public void setCellPhone(CellPhone cr)
        {
            c = cr;
        }
        /** 
         * sets new node to next
         * @param xt new node to set to
         */
        public void setNext(CellNode xt)
        {
            next = xt;
        }
        /** 
         * returns cellphone object
         * @return cellphone
         */
        public CellPhone getCellPhone(){
            return c;
        }

        
    } //end of CellNode

    private CellNode head;
    int size;
    /**
     * Default constructor.
    */
    public CellList()
    {
        head = null;
        size = 0;
    }

    /** 
     * copy constructor
     * @param lt CellList that is reference for the copy
     */
    public CellList(CellList lt)
    {
        if(lt.head == null)
            head = null;
        else
        {
            head = null;
            CellNode t1,t2,t3;

            t1 = lt.head;
            t2 = t3 = null;
            while(t1 != null)
            {
                if (head == null)
                {
                    t2 = new CellNode(t1);
                    head = t2;
                }
                else
                {
                    t3 = new CellNode(t1);
                    t2.next = t3;
                    t2 = t3;
                }
                t1 = t1.next;
            }
            t2 = t3 = null;
        }
    }
    
    
    /** 
     * adds the node to the start of the list
     * @param c cellphone that is used to create the new node
     */
    public void addToStart(CellPhone c)
    {
        head = new CellNode(c,head);
    }
    
    /** 
     * inserts a new node at a certain index in the CellList
     * @param c cellphone that's in the new node
     * @param i index to be inserted at
     */
    public void insertAtIndex(CellPhone c, int i)
    {
        CellNode node = new CellNode();
        node.c = c;
        node.next = null;
        try{
            if(i < 0 || i > size - 1)
            {
                throw new NoSuchElementException("ERROR, index " + i + " is out of bounds. Cellphone not added.");
            }
        }
        catch(NoSuchElementException e){
            System.out.println(e.getMessage());
            System.out.println("Terminating program.\n");
            System.exit(0);
        }
        if (head == null)
        {
            if(i != 0)
            {
                return;
            }
            else
            {
                head = node;
            }
        }
        if(head != null && i == 0)
        {
            node.next = head;
            head = node;
            return;
        }
        CellNode current = head;
        CellNode prev = null;
        int j = 0;
        while(j < i)
        {
            prev = current;
            current = current.next;

            if(current == null)
            {
                break;
            }
            j++;
        }
        node.next = current;
        prev.next = node;
    }
    
    /** 
     * deletes a node from a certain index in the list
     * @param i index
     */
    public void deleteFromIndex(int i)
    {
        CellNode temp = head;
        if(i < 0 || i > size)
        {
            throw new NoSuchElementException("That index does not exist");
        }
        if(head == null)
        {
            System.out.println("Nothing to delete");
            return;
        }

        if(i == 0)
        {
            head = temp.next;
            return;
        }

        for(int j = 0; temp != null && j < i-1; j++)
        {
            temp = temp.next;
        }
        CellNode next = temp.next.next;
        temp.next = next;
        size--;

    }
    
    /** 
     * deletes the first element of the CellList
     * @return boolean true if there was something to delte false if there isnt
     */
    public boolean deleteFromStart()
    {
        if(head != null)
        {
            head = head.next;
            size--;
            return true;
        }
        else{
            System.out.println("List is empty, cannot delete from start.");
            return false; 
        }
         
    }
    
    /** 
     * replaces the node at the index with a new one
     * @param x CellPhone that will be in the new node
     * @param i index to be replaced
     */
    public void replaceAtIndex(CellPhone x, int i) 
    {
        if(i < 0 || i > size)
        {
            System.out.println("ERROR: Given index is out of range! Program will terminate. \n");
            throw new NoSuchElementException();
        }
        int j = 0;
		CellNode temp = head;
		while(j != i)
		{
			temp = temp.next;
			j++;
		}
		System.out.println("Replacing value at index # " + i + " from " + temp.c + " to " + x + ". \n");
		temp.c = x;

    }
    
    /** 
     * finds the cellnode that has the cellphone with the SN entered by the user
     * @param SN serial number to search for
     * @return CellNode node that has the matching SN
     */
    public CellNode find(long SN)   // PRIVACY LEAK
    {
        /*
         * This is the method where the privacy leak occurs. Since the method returns a cellNode, that cellNode can
         * be used to nullify all the nodes that come after it in the linked list. This would partly destroy the linked
         * list. A solution to this would be to either return a copy of the node, or just to just not return a node at all.
         */
        int counter = 1;
        CellNode temp = head;
        while(temp != null)
        {
            if(temp.c.getSerialNum() == SN)
            {
                System.out.println("Found cellphone with serial number " + SN + ". Number of iterations: " + counter);
                return temp;
            }
            temp = temp.next;
            counter++;
        }
        System.out.println("No cellphone found matching serial number: " + SN + ". Number of iterations: " + counter);
        return null;
    }
    
    /** 
     * checks if the list contains an entered serial number
     * @param SN serial number to search for
     * @return boolean true if it contains the SN and false if not
     */
    public boolean contains(long SN)
    {
        CellNode temp = head;
        while(temp != null)
        {
            if(temp.c.getSerialNum() == SN)
            {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /** 
     * prints the contents of a CellList
     */
    public void showContents()
    {
        
        CellNode temp = head;
        if(temp == null)
        {
            System.out.println("The list is empty, there is nothing to print.");
        }
        else
        {
            System.out.println("The current size of the list is " + size + ". Here are the contents of the list");
            System.out.println("===========================================================================");
        }
        while(temp != null)
        {
            System.out.print(" [" + temp.c + "] --->");
            temp = temp.next;
        }
        System.out.println(" X");
    }

    
    /** 
     * checks if two CellLists have similar objects
     * @param cell the second list to check
     * @return boolean return true if equal and false if not
     */
    public boolean equals(CellList cell)
    {
        CellNode temp = head;
        CellNode temp1 = cell.head;

        if (cell.size != size){
            return false;
        }

        while (temp != null){
            if (!temp.c.equals(temp1.c)){
                return false;
            }
            temp = temp.next;
            temp1 = temp1.next;
        }
        return true;
    }

    
}

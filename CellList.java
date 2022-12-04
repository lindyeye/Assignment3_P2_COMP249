import java.util.NoSuchElementException;
import java.util.Scanner;

//this is my magnum opus and i will take no complaints. im probably out this bitch after the semester is over so this is my last code for a failed degree :D
public class CellList implements Cloneable{
    
    public class CellNode 
    {
        Scanner sc = new Scanner(System.in);
        private CellPhone c;
        private CellNode next;
        
        public CellNode()
        {
            c = null;
            next = null;
            size++;
        }
        public CellNode(CellPhone cr, CellNode xt)
        {
            c = cr;
            next = xt;
            size++;
        }
        
        public CellNode clone()
        {
            size++;
            return new CellNode(this);
        }
        
        public CellNode(CellNode cn)
        {
            c = cn.c.clone(sc);
            next = cn.next;
            size++;
        }
        public void setCellPhone(CellPhone cr)
        {
            c = cr;
        }
        public void setNext(CellNode xt)
        {
            next = xt;
        }
        
    } //end of CellNode

    private CellNode head;
    int size;

    public CellList()
    {
        head = null;
        size = 0;
    }

    public int getSize()
    {
        return size;
    }
    //copy constructor
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
    
    public void addToStart(CellPhone c)
    {
        head = new CellNode(c,head);
    }
    //the exception is for invalid integer, check if it works later
    public void insertAtIndex(CellPhone c, int i) //throws NoSuchElementException
    {
        CellNode node = new CellNode();
        node.c = c;
        node.next = null;
        if(i < 0 || i > size - 1)
        {
            throw new NoSuchElementException();
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
        size++;
    }
    //i think this works? it should unlink the node from the list so it'll be deleted
    public void deleteFromIndex(int i) //throws NoSuchElementException
    {
        CellNode temp = head;
        if(i < 0 || i > size)
        {
            throw new NoSuchElementException("That index does not exist");
        }
        else if(head == null)
        {
            System.out.println("Nothing to delete");
            return;
        }
        else if(i == 0)
        {
            head = temp.next;
        }
        for(int j = 0; temp != null && j < i - 1; j++)
        {
            temp = temp.next;
        }
        CellNode next = temp.next;
        temp.next = next;
        size--;

    }
    public boolean deleteFromStart()
    {
        if(head != null)
        {
            head = head.next;
            size--;
            return true;
        }
        else
            return false;  
    }
    public void replaceAtIndex(CellPhone x, int i)
    {
        if(i > size -1)
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
    public CellNode find(long SN)
    {
        CellNode temp = head;
        while(temp != null)
        {
            if(temp.c.getSerialNum() == SN)
            {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    public boolean contains(long SN)
    {
        if(find(SN) != null)
            return true;
        else
            return false;
    }

    public void showContents() //honestly i kind of slayed this(I "borrowed" it from Aiman)
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

    //im too fuckin tired to create this method i just want to be done
    public boolean equals(CellList cell)
    {
        CellNode temp = head;
        CellNode temp1 = cell.head;

        for(int j = 0; j < size; j++)
        {
            for(int k = 0; k < cell.size; k++)
            {
                
            }
        }
        return true;
    }

    
}

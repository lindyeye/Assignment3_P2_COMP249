/**
 * Assignment 3 - Part 2
 * For COMP  249 Section D - Fall 2022
 * @author Linden Wheeler 40195748 and Matej Pederson 40209550
 */
import java.util.Scanner;
public class CellPhone{
    private long serialNum;
    private String brand;
    private int year;
    private double price;
    static int SNCtr = 100000;

    /**
     * Default constructor.
     */
    public CellPhone()
    {

        serialNum = SNCtr;
        SNCtr++;
    }
    /**
     * Constructor that takes parameters.
     * 
     * @param serialNum serial number of the cellphone
     * @param brand brand of the cellphone
     * @param year year tthe cellphone is from
     * @param price price of the cellphone
     * 
     */
    public CellPhone(long serialNum, String brand, int year, double price)
    {
        this.serialNum = serialNum;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }
    
    /** 
     * returns the serial number
     * @return long serial number of the cellphone
     */
    public long getSerialNum()
    {
        return serialNum;
    }
    
    /** 
     * sets the serial number of the phone
     * @param serialNum new serial number to change to
     */
    public void setSerialNum(long serialNum)
    {
        this.serialNum = serialNum;
    }

    
    /** 
     * returns brand of the phone
     * @return String brand of the phone
     */
    public String getBrand()
    {
        return brand;
    }
    
    /** 
     * sets new brand of the phone
     * @param brand new brand to set to
     */
    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    
    /** 
     * returns year of the phone
     * @return int year of the phone
     */
    public int getYear()
    {
        return year;
    }
    
    /** 
     * sets  new year of the phone
     * @param year year of the phone
     */
    public void setYear(int year)
    {
        this.year = year;
    }

    
    /** 
     * returns price of the phone
     * @return double price of the phone
     */
    public double getPrice()
    {
        return price;
    }
    
    /** 
     * sets new phone price
     * @param price new price
     */
    public void setPrice(double price)
    {
        this.price = price;
    }

    
    /** 
     * displays all the information(attributes) of the phone
     * @return String the info that is output
     */
    public String toString()
    {
        return serialNum + ": " + brand +" " + price +" " + year;
        //return "Serial Number: " + this.serialNum + "\nBrand: " + this.brand + "\nYear: " + this.year + "\nPrice: " + this.price;
    }

    
    /** 
     * equals method, compares everything except serial number which should always be different
     * @param x cellphone that is being compared
     * @return boolean true if equal false if not
     */
    public boolean equals(CellPhone x)
    {
        return(this.brand.equals(x.brand) && this.price == x.price && this.year == x.year);
    }
    
    /** 
     * copy constructor. copies the passed object onto the called object. gives the called object a different serial number
     * @param x cellphone that is the copy reference
     * @param serialNum new serial number for the called cellphone
     */
    CellPhone(CellPhone c, long serialNum)
    {
        this.serialNum = serialNum;
        this.brand = c.brand;
        this.year = c.year;
        this.price = c.price;
    }

    
    /** 
     * clone method. asks for a new SN, uses the copy constructor and creates a new cellphone
     * @param sc scanner to read the new serial number
     * @return CellPhone new cellphone that is a clone of the one the method is called with
     */
    public CellPhone clone(Scanner sc)
    {
        System.out.println("Please enter a new serial number: ");
        long enteredSN = sc.nextLong();
        return new CellPhone(this, enteredSN);
    }
}

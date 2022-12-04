import java.util.Scanner;
public class CellPhone{
    private long serialNum;
    private String brand;
    private int year;
    private double price;
    static int SNCtr = 100000;

    public CellPhone()
    {

        serialNum = SNCtr;
        SNCtr++;
    }
    public CellPhone(long serialNum, String brand, int year, double price)
    {
        this.serialNum = serialNum;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }
    public long getSerialNum()
    {
        return serialNum;
    }
    public void setSerialNum(long serialNum)
    {
        this.serialNum = serialNum;
    }

    public String getBrand()
    {
        return brand;
    }
    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public int getYear()
    {
        return year;
    }
    public void setYear(int year)
    {
        this.year = year;
    }

    public double getPrice()
    {
        return price;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }

    public String toString()
    {
        return serialNum + ": " + brand +" " + price +" " + year;
        //return "Serial Number: " + this.serialNum + "\nBrand: " + this.brand + "\nYear: " + this.year + "\nPrice: " + this.price;
    }

    public boolean equals(CellPhone x)
    {
        return(this.brand.equals(x.brand) && this.price == x.price && this.year == x.year);
    }
    public boolean duplicate(CellPhone x)
    {
        return(this.brand.equals(x.brand) && this.price == x.price && this.year == x.year && serialNum == x.serialNum);
    }
    //that's a copy
    CellPhone(CellPhone c, long serialNum)
    {
        this.serialNum = serialNum;
        this.brand = c.brand;
        this.year = c.year;
        this.price = c.price;
    }

    public CellPhone clone(Scanner sc)
    {
        System.out.println("Please enter a new serial number: ");
        long enteredSN = sc.nextLong();
        return new CellPhone(this, enteredSN);
    }
}

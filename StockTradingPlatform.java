import java.util.*;
class Stock 
{
    String name;
    double price;
    int quantity;
    Stock(String name, double price, int quantity)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    void display() 
    {
        System.out.println(name + " - ₹" + price + " (" + quantity + " available)");
    }
}

class SimpleStockTrading
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Stock tcs = new Stock("TCS", 3500, 100);
        Stock infosys = new Stock("Infosys", 1600, 150);
        double balance = 10000;
        int tcsOwned = 0;
        int infosysOwned = 0;
        int choice;
        do
        {
            System.out.println("\n------ Stock Trading Menu ------");
            System.out.println("1. View Stocks");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) 
            {
                case 1:
                    System.out.println("Available Stocks:");
                    tcs.display();
                    infosys.display();
                    break;
                case 2:
                    System.out.println("Enter stock name (TCS or Infosys): ");
                    String buyName = sc.next();
                    System.out.println("Enter quantity: ");
                    int buyQty = sc.nextInt();
                    if(buyName.equalsIgnoreCase("TCS") && tcs.quantity >= buyQty) 
                    {
                        double cost = buyQty * tcs.price;
                        if (balance >= cost) 
                        {
                            tcs.quantity -= buyQty;
                            tcsOwned += buyQty;
                            balance -= cost;
                            System.out.println("Bought " + buyQty + " TCS shares.");
                        } 
                        else 
                        {
                            System.out.println("Not enough balance.");
                        }
                    } 
                    else if (buyName.equalsIgnoreCase("Infosys") && infosys.quantity >= buyQty)
                    {
                        double cost = buyQty * infosys.price;
                        if (balance >= cost)
                         {
                            infosys.quantity -= buyQty;
                            infosysOwned += buyQty;
                            balance -= cost;
                            System.out.println("Bought " + buyQty + " Infosys shares.");
                        } 
                        else 
                        {
                            System.out.println("Not enough balance.");
                        }
                    } 
                    else 
                    {
                        System.out.println("Invalid stock name or insufficient stock.");
                    }
                    break;

                case 3:
                    System.out.print("Enter stock name to sell (TCS or Infosys): ");
                    String sellName = sc.next();
                    System.out.print("Enter quantity: ");
                    int sellQty = sc.nextInt();
                    if (sellName.equalsIgnoreCase("TCS") && tcsOwned >= sellQty)
                     {
                        tcs.quantity += sellQty;
                        tcsOwned -= sellQty;
                        balance += sellQty * tcs.price;
                        System.out.println("Sold " + sellQty + " TCS shares.");
                    } 
                    else if (sellName.equalsIgnoreCase("Infosys") && infosysOwned >= sellQty)
                    {
                        infosys.quantity += sellQty;
                        infosysOwned -= sellQty;
                        balance += sellQty * infosys.price;
                        System.out.println("Sold " + sellQty + " Infosys shares.");
                    } 
                    else 
                    {
                        System.out.println("Not enough shares to sell or wrong name.");
                    }
                    break;
                case 4:
                    System.out.println("----- Your Portfolio -----");
                    System.out.println("TCS Shares: " + tcsOwned);
                    System.out.println("Infosys Shares: " + infosysOwned);
                    System.out.println("Available Balance:" + balance);
                    break;
                case 5:
                    System.out.println("Thank you for using the trading system!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } 
        while (choice != 5);
        sc.close();
    }
}

import java.util.*;
class Bank
{
    Scanner xy=new Scanner(System.in);
    BankAccount[]accounts;
    int numOfAccounts;
    //double bm=0.0;
     Bank()
    {
        accounts=new BankAccount[100];
        numOfAccounts=0;
    }
     int totalAccounts()
    {
        return numOfAccounts;
    }
     int openNewAccount(String cfname,String cmname,String clname,double openingBalance)
    {
        BankAccount b=new BankAccount(cfname,cmname,clname,openingBalance);
        accounts[numOfAccounts]=b;
        numOfAccounts++;
        return b.getAccountNum();
    }
     void withdrawFrom(int accountNum)
    {
        for(int i=0;i<numOfAccounts;i++)
        {
            if(accountNum==accounts[i].getAccountNum())
            {
                System.out.println("Enter amount to be withdrawn");
                double amount=xy.nextDouble();
                if(compare(amount)==true)
                {
                    accounts[i].withdraw(amount);
                    return;
                }
                else
                {
                    System.out.println("Amount to be withdrawn should be in whole number");
                    return;
                }
            }
        }
        System.out.println("Account Number not found");
    }
     void depositTo(int accountNum)
    {
        for(int i=0;i<numOfAccounts;i++)
        {
            if(accountNum==accounts[i].getAccountNum())
            {
                System.out.println("Enter amount to be deposited");
                double amount=xy.nextDouble();
                if(compare(amount)==true)
                {
                    accounts[i].deposit(amount);
                    return;
                }
                else
                {
                    System.out.println("Amount to be deposited should be in whole number");
                    return;
                }
            }
        }
        System.out.println("Account Number not found");
    }
     void printAccountInfo(int accountNum)
    {
        for(int i=0;i<numOfAccounts;i++)
        {
            if(accountNum==accounts[i].getAccountNum())
            {
                System.out.println(accounts[i].getAccountInfo());
                return;
            }
        }
        System.out.println("Account Number not found");
    }
     void printAllAccounts()
    {
        for(int i=0;i<numOfAccounts;i++)
        {
            System.out.println(accounts[i].getAccountInfo());
        }
    }
    void lastTransactions(int accountNum)
    {
        for(int i=0;i<numOfAccounts;i++)
        {
            if(accountNum==accounts[i].getAccountNum())
            {
                System.out.println("Last Transactions Made are:");
                accounts[i].printhist();
                return;
            }
        }
        System.out.println("Account Number not found");
    }
     void printTransactionInfo(int accountNum)
    {
        for(int i=0;i<numOfAccounts;i++)
        {
            if(accountNum==accounts[i].getAccountNum())
            {
                System.out.println(accounts[i].getAccountInfo());
                System.out.println("Number of transactions:"+accounts[i].getTransactionInfo());
                if(accounts[i].getTransactionInfo()>0)
                {
                    System.out.println("Last Transaction made was of: Rs."+accounts[i].getlastTransaction());
                    accounts[i].date();
                }
                else
                {
                    System.out.println("No Transactions Yet Made");
                    accounts[i].date();
                }
                return;
            }
        }
        System.out.println("Account Number not found");
    }
     void update(int number)
    {
        for(int i=0;i<numOfAccounts;i++)
        {
            if(number==accounts[i].getAccountNum())
            {
                System.out.println("Enter New Name:-");
                System.out.println("Enter First name-");
                String fname=xy.next();
                System.out.println("Enter Middle name-");
                System.out.println("(If there is no middle name enter '@')");
                String mname=xy.next();
                System.out.println("Enter Last name-");
                String lname=xy.next();
                accounts[i].updating(fname,mname,lname);
                System.out.println("!!ACCOUNT UPDATED!!");
                System.out.println(accounts[i].getAccountInfo());
                return;
            }
        }
        System.out.println("Account Number not found");
    }
     void close(int accnum)
    {
        for(int i=0;i<numOfAccounts;i++)
        {
            if(accnum==accounts[i].getAccountNum())
            {
                System.out.println("Re-enter your account number");
                int racnum=xy.nextInt();
                if(accnum==racnum)
                {
                    System.out.println("!!ACCOUNT CLOSED!!");
                    accounts[i].closeaccount();
                    numOfAccounts--;
                    return;
                }
                else
                {
                    System.out.println("Account Number did not match");
                    return;
                }
            }
        }
        System.out.println("Account Number not found");
    }
     boolean compare(double sum)
    {
        double s2=Math.floor(sum);
        if(s2==sum)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    double getBm()
    {
        double bm=0.0;
        for(int i=0;i<numOfAccounts;i++)
        {
            double m=accounts[i].getbankmoney();
            bm=bm+m;
        }
        return bm;
    }
    void withbm(double amt)
    {
        double bm=getBm();
        bm=bm-amt;
        accounts[0].notes(amt);
        System.out.println("AMOUNT WITHDRAWN.");
        System.out.println("Current Bank's Money= Rs."+bm);
        redbm(amt);
    }
    void redbm(double a)
    {
        for(int i=0;i<numOfAccounts;i++)
        {
            double m=accounts[i].getbankmoney();
            if(m>=a)
            {
                accounts[i].cbm(a);
            }
            else
            {
                a=a-m;
                accounts[i].cbm(m);
            }
        }
    }
}
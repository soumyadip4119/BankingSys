import java.util.*;
class BankAccount
{
    getdate gt=new getdate();
    boolean bm=false;
    int accountNum;
    int ex=1801800000-1;
    String name1;
    String name2;
    String name3;
    double bal;
    double bmoney=0;
    String[] balance;
    static int noOfAccounts=0;
    int numOfTransactions=0;
    String last="";
    final String made=gt.made();
    BankAccount(String abc,String uio,String qwe,double xyz)
    {
        name1=abc;
        name2=uio;
        name3=qwe;
        bal=xyz;
        accountNum=1801800000+noOfAccounts;
        balance=new String[1000];
        balance[0]="b"+Double.toString(bal);
        noOfAccounts++;
    }
    String getAccountInfo()
    {
        if(name2.equals("@"))
        {
            return ("Account Number: "+accountNum+"\nCustomer Name: "+name1+" "+name3+"\nBalance: Rs."+bal+"\n");
        }
        else
        {
            return ("Account Number: "+accountNum+"\nCustomer Name: "+name1+" "+name2+" "+name3+"\nBalance: Rs."+bal+"\n");
        }
    }
    int getTransactionInfo()
    {
        return numOfTransactions;
    }
    void printhist()
    {
        int i=numOfTransactions;
        if(i>0)
        {
            for(int j=0;j<=i;j++)
            {
                String b=balance[j];
                char c=b.charAt(0);
                int l=b.length();
                if(c=='b')
                {
                    System.out.println("Account's starting balance= Rs."+b.substring(1,l));
                }
                if(c=='d')
                {
                    System.out.println("Amount deposited= Rs."+b.substring(1,l));
                }
                if(c=='w')
                {
                    System.out.println("Amount withdrawn= Rs."+b.substring(1,l));
                }
                b="";
                c=' ';
                l=0;
            }
            System.out.println("Account's current balance= Rs."+bal);
        }
        else
        {
            System.out.println("No Transactions yet made");
        }
    }
    void updating(String nname1,String nname2,String nname3)
    {
        name1=nname1;
        name2=nname2;
        name3=nname3;
    }
    double getBalance()
    {
        return bal;
    }
    int getAccountNum()
    {
        return accountNum;
    }
    void deposit(double amount)
    {
        if(amount<=0)
        {
            System.out.println("Amount to be deposited should be positive");
        }
        else
        {
            bal=bal+amount;
            balance[numOfTransactions+1]="d"+Double.toString(amount);
            numOfTransactions++;
            System.out.println("Amount deposited successfully");
            System.out.println("Your current balance is: Rs."+bal);
            last=gt.dat();
        }
    }
    void withdraw(double amount)
    {
        Scanner xy=new Scanner(System.in);
        if(amount<=0)
        {
            System.out.println("Amount to be withdrawn should be positive");
        }
        else
        {
            if(bal<amount)
            {
                System.out.println("Insufficient balance");
            }
            else if((bal-amount)<1000)
            {
                System.out.println("After withdrawal your balance will be less than Rs.1000.");
                System.out.println("Due to this 10% fine will be charged!");
                System.out.println("Do you want to continue? Enter Y to contine and N to discontinue.");
                String ch1=xy.next();
                String ch=ch1.toUpperCase();
                switch(ch)
                {
                    case"Y":
                    bm=true;
                    double b2=bal;
                    b2=b2-amount;
                    double b3=b2/10;
                    bmoney=bmoney+b3;
                    bal=b2-b3;
                    balance[numOfTransactions+1]="w"+Double.toString(amount);
                    numOfTransactions++;
                    System.out.println("Amount withdrawn successfully");
                    notes(amount);
                    System.out.println("Fine Charged: Rs."+b3);
                    System.out.println("Your current balance is: Rs."+bal);
                    last=gt.dat();
                    break;
                    case"N":
                    System.out.println("Amount not withdrawn");
                    break;
                    default:
                    System.out.println("Invalid choice");
                }
            }
            else
            {
                bal=bal-amount;
                balance[numOfTransactions+1]="w"+Double.toString(amount);
                numOfTransactions++;
                System.out.println("Amount withdrawn successfully");
                notes(amount);
                System.out.println("Your current balance is: Rs."+bal);
                last=gt.dat();
            }
        }
    }
    void notes(double amt)
    {
        System.out.println("Number of types of notes provided");
        double amt2=amt;
        int tot=(int)Math.floor(amt);
        int tth=tot/2000;
        int ntth=(tot%2000);
        System.out.println("Rs.2000: "+tth);
        int fh=ntth/500;
        System.out.println("Rs.500: "+fh);
        int nfh=(ntth%500);
        int th=nfh/200;
        System.out.println("Rs.200: "+th);
        int nth=(nfh%200);
        int h=nth/100;
        System.out.println("Rs.100: "+h);
        int nh=nfh%100;
        int fif=nh/50;
        System.out.println("Rs.50: "+fif);
        int nfif=nh%50;
        int tw=nfif/20;
        System.out.println("Rs.20: "+tw);
        int ntw=nfif%20;
        int tn=ntw/10;
        System.out.println("Rs.10: "+tn);
        int ntn=ntw%10;
        int fv=ntn/5;
        System.out.println("Rs.5: "+fv);
        int nfv=ntn%5;
        int t=nfv/2;
        System.out.println("Rs.2: "+t);
        int nt=nfv%2;
        int o=nt/1;
        System.out.println("Rs.1: "+o);
        System.out.println("Total amount withdrawn: Rs."+amt2);
    }
    void closeaccount()
    {
        System.out.println("Please collect your leftover balance: Rs."+bal);
        notes(bal);
        bal=0;
        name1="null";
        name2="null";
        name3="null";
        accountNum=ex;
        noOfAccounts--;
    }
    double getbankmoney()
    {
        if(bm==true)
        return bmoney;
        else
        return 0;
    }
    void cbm(double a)
    {
        bmoney=bmoney-a;
    }
    double getlastTransaction()
    {
        String t=balance[numOfTransactions];
        int l=t.length();
        return Double.parseDouble(t.substring(1,l));
    }
    void date()
    {
        System.out.println("Last Transaction at:"+last);
        System.out.println("Account Created at:"+made);
    }
}
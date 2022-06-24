import java.util.*;
class Banking
{
    public static void main (String args[])
    {
        System.out.println("  *WELCOME*  ");
        Scanner Sd=new Scanner(System.in);
        Bank myBank=new Bank();
        Input var=new Input();
        String i="scan";
        int c=0;
        int choice,choice1,choice2;
        /*choice=0;
        choice1=0;
        choice2=0;*/
        int numOfTransactions=1;
        do
        {
            System.out.println();
            System.out.println("SELECT YOUR CHOICE");
            System.out.println("1:ADMINISTRATIVE FUNCTIONS");
            System.out.println("2:CUSTOMER'S FUNCTIONS");
            System.out.println("3:EXIT");
            System.out.println();
            System.out.println("ENTER YOUR CHOICE");
            choice1=var.getInput();
            switch(choice1)
            {
                case 1:
                System.out.println("Enter Managing Password");
                String p=Sd.next();
                /*Mask pass=new Mask(i);
                pass.main(args);*/
                if(p.equals(i))
                {
                    do
                    {
                        System.out.println();
                        System.out.println("ENTER YOUR CHOICE");
                        System.out.println("1:PRINT TOTAL NUMBER OF ACCOUNTS");
                        System.out.println("2:PRINT ALL THE ACCOUNTS");
                        System.out.println("3.UPDATE AN ACCOUNT");
                        System.out.println("4:CHECK LAST TRANSACTION AND OTHER DETAILS OF ANY ACCOUNT");
                        System.out.println("5:CHANGE MANAGING PASSWORD");
                        System.out.println("6:CHECK OR WITHDRAW BANK BALANCE");
                        System.out.println("7:GO TO MAIN MENU");
                        System.out.println("ENTER YOUR CHOICE");
                        System.out.println();
                        choice2=var.getInput();
                        switch(choice2)
                        {
                            case 1:
                            System.out.println("Number of accounts:"+myBank.totalAccounts());
                            break;
                            case 2:
                            if(myBank.totalAccounts()>0)
                            {
                                myBank.printAllAccounts();
                            }
                            else
                                System.out.println("No Accounts Found");
                            break;
                            case 3:
                            if(myBank.totalAccounts()>0)
                            {
                                System.out.println("Enter an Account Number");
                                int no=var.getInput();
                                if(no>=1801800000)
                                {
                                    myBank.update(no);
                                }
                                else
                                {
                                    System.out.println("Invalid Account");
                                }
                            }
                            else
                            {
                                System.out.println("No Accounts Found");
                            }
                            break;
                            case 4:
                            if(myBank.totalAccounts()>0)
                            {
                                System.out.println("Enter an Account Number");
                                int an=var.getInput();
                                if(an>=1801800000)
                                {
                                    myBank.printTransactionInfo(an);
                                }
                                else
                                {
                                    System.out.println("Invalid Account");
                                }
                            }
                            else
                            {
                                System.out.println("No Accounts Found");
                            }
                            break;
                            case 5:
                            System.out.println("Enter Previous Managing Password");
                            String p1=Sd.next();
                            if(p1.equals(i))
                            {
                                System.out.println("Enter New Password");
                                String p2=Sd.next();
                                System.out.println("Re-enter New Password");
                                String p3=Sd.next();
                                if(p2.equals(p3))
                                {
                                    i=p2;
                                    System.out.println("!!MANAGING PASSWORD CHANGED!!");
                                    System.out.println("NEW PASSWORD IS: "+i);
                                }
                                else
                                {
                                    System.out.println("SORRY! Both passwords didn't match");
                                }
                            }
                            else
                            {
                                System.out.println("SORRY! Wrong Password");
                            }
                            break;
                            case 6:
                            System.out.println("PRESS 1 TO CHECK BANK'S BALANCE");
                            System.out.println("PRESS 2 TO WITHDRW BANK'S BALANCE");
                            int bch=var.getInput();
                            switch(bch)
                            {
                                case 1:
                                System.out.println("Bank's money is :Rs."+myBank.getBm());
                                break;
                                case 2:
                                if(myBank.getBm()>0)
                                {
                                    System.out.println("Enter amount to be withdrawn");
                                    double abm=Sd.nextDouble();
                                    if(abm<=myBank.getBm())
                                    myBank.withbm(abm);
                                    else
                                    System.out.println("Insufficient balance");
                                }
                                else
                                System.out.println("zero bank's balance");
                                break;
                                default:
                                System.out.println("INVALID CHOICE");
                            }
                            break;
                            case 7:
                            choice2=7;
                            break;
                            default:
                            System.out.println("INVALID OPTION.");
                        }
                    }
                    while(choice2!=7);
                }
                else
                {
                    System.out.println("SORRY! Wrong Password");
                }
                break;
                case 2:
                do
                {
                    System.out.println();
                    System.out.println("YOU CAN PERFORM FOLLOWING FUNCTIONS");
                    System.out.println("1:CREATE YOUR ACCOUNT");
                    System.out.println("2:DEPOSIT MONEY TO YOUR ACCOUNT");
                    System.out.println("3:WITHDRAW MONEY FROM YOUR ACCOUNT");   
                    System.out.println("4:PRINT SHORT ACCOUNT INFORMATION");
                    System.out.println("5:PRINT DETAILED ACCOUNT INFORMATION INCLUDING LAST TRANSACTION");
                    System.out.println("6:PRINT TRANSACTION HISTORY OF AN ACCOUNT");
                    System.out.println("7:CLOSE AN ACCOUNT");
                    System.out.println("8:GO TO MAIN MENU");
                    System.out.println("9:QUIT");
                    System.out.println();
                    System.out.println("ENTER YOUR CHOICE");
                    choice=var.getInput();
                    switch(choice)
                    {
                        case 1:
                        System.out.println("Enter Customer Name:-");
                        System.out.println("Enter First Name-");
                        String fcn=Sd.next();
                        System.out.println("Enter Middle Name-");
                        System.out.println("(If there is no middle name enter '@')");
                        String mcn=Sd.next();
                        System.out.println("Enter Last Name-");
                        String lcn=Sd.next();
                        System.out.println("Enter a opening balance");
                        double d=Sd.nextDouble();
                        if((d>=1000)&&(myBank.compare(d)==true))
                        {
                            System.out.println("Account was created and it has the Account Number:"+myBank.openNewAccount(fcn,mcn,lcn,d));
                        }
                        else if(myBank.compare(d)==false)
                        {
                            System.out.println("AMOUNT TO BE DEPOSITED SHOULD BE IN WHOLE NUMBER");
                        }
                        else
                        {
                            System.out.println("OPENING BALANCE SHOULD BE MINIMUM Rs.1000");
                        }
                        break;
                        case 2:
                        if(myBank.totalAccounts()>0)
                        {
                            System.out.println("Enter the Account Number");
                            int an=var.getInput();
                            if(an>=1801800000)
                            {
                                myBank.depositTo(an);
                            }
                            else
                            {
                                System.out.println("Invalid Account");
                            }
                        }
                        else
                        {
                            System.out.println("No Accounts Found");
                        }
                        break;
                        case 3:
                        if(myBank.totalAccounts()>0)
                        {
                            System.out.println("Enter the Account Number");
                            int acn=var.getInput();
                            if(acn>=1801800000)
                            {
                                myBank.withdrawFrom(acn);
                            }
                            else
                            {
                                System.out.println("Invalid Account");
                            }
                        }
                        else
                        {
                            System.out.println("No Accounts Found");
                        }
                        break;
                        case 4:
                        if(myBank.totalAccounts()>0)
                        {
                            System.out.println("Enter the Account Number");
                            int anum=var.getInput();
                            if(anum>=1801800000)
                            {
                                myBank.printAccountInfo(anum);
                            }
                            else
                            {
                                System.out.println("Invalid Account");
                            }
                        }
                        else
                        {
                            System.out.println("No Accounts Found");
                        }
                        break;
                        case 5:
                        if(myBank.totalAccounts()>0)
                        {
                            System.out.println("Enter the Account Number");
                            int aum=var.getInput();
                            if(aum>=1801800000)
                            {
                                myBank.printTransactionInfo(aum);
                            }
                            else
                            {
                                System.out.println("Invalid Account");
                            }
                        }
                        else
                        {
                            System.out.println("No Accounts Found");
                        }
                        break;
                        case 6:
                        if(myBank.totalAccounts()>0)
                        {
                            System.out.println("Enter the Account Number");
                            int aum1=var.getInput();
                            if(aum1>=1801800000)
                            {
                                myBank.lastTransactions(aum1);
                            }
                            else
                            {
                                System.out.println("Invalid Account");
                            }
                        }
                        else
                        {
                            System.out.println("No Accounts Found");
                        }
                        break;
                        case 7:
                        if(myBank.totalAccounts()>0)
                        {
                            System.out.println("Enter your Account Number");
                            int cero=var.getInput();
                            if(cero>=1801800000)
                            {
                                System.out.println("Are you sure you want to close your account?");
                                System.out.println("Press Y to continue or N to end");
                                String dc=Sd.next();
                                if(dc.equalsIgnoreCase("Y"))
                                {
                                    myBank.close(cero);
                                }
                                else
                                {
                                    break;
                                }
                            }
                            else
                            {
                                System.out.println("Invalid Account");
                            }
                        }
                        else
                        {
                            System.out.println("No Accounts Found");
                        }
                        break;
                        case 8:
                        choice=8;                        
                        break;
                        case 9:
                        c=1;
                        choice=8;
                        System.out.println(" !THANKS! ");
                        break;
                        default:
                        System.out.println("INVALID OPTION.");
                    }
                }
                while(choice!=8);
                break;
                case 3:
                c=1;
                System.out.println(" THANKS.HOPE YOU ENJOYED BANKING. ");
                break;
                default:
                System.out.println("INVALID OPTION.");
            }
        }
        while(c!=1);
    }
}
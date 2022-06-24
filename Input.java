import java.util.*;
public class Input
{
    public int getInput()
    {
        Scanner sc=new Scanner(System.in);
        int d=0,r=0;
        do
        {
            int f=0;
            String c=sc.nextLine();
            int l=c.length();
            for(int i=0;i<l;i++)
            {
                char a=c.charAt(i);
                if(Character.isDigit(a))
                {
                    f=f+1;
                }
            }
            if(f==l)
            {
                d=1;
                r=Integer.parseInt(c);
            }
            else
            {
                System.out.println("INVALID INPUT. Re-enter.");
            }
        }while(d!=1);
        return r;
    }
}

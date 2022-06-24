import java.util.Calendar;
class getdate 
{
    Calendar c=Calendar.getInstance();
    String dat()
    {
        String d=(c.get(Calendar.DATE)+"/"+(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.YEAR));
        return d;
    }
    String made()
    {
        String m=(c.get(Calendar.DATE)+"/"+(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.YEAR));
        return m;
    }
}
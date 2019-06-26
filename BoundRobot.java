//import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class readfile{

    private Scanner x;

    int wid;int len;
    int finwid; int finlen;

    int w;int l;
    int n;
    String a;int y;

    public void openFile(){
        try{
            x = new Scanner(System.in);
        }
        catch(Exception e){
            System.out.print("Input wrong");
        }

    }

    public void dir(String d,int s)
    {
        if(d.equals("l"))
        {
            wid -= s;
        }
        else if(d.equals("r"))
        {
            wid += s;
        }
        else if (d.equals("u"))
        {
            len += s;
        }
        else if(d.equals("d")) {
            len -= s;
        }

    }

    public void dir2(String d2,int s2)
    {
        if(d2.equals("l"))
        {
            finwid -= s2;
        }
        else if(d2.equals("r"))
        {
            finwid += s2;
        }
        else if (d2.equals("u"))
        {
            finlen += s2;
        }
        else if(d2.equals("d")) {
            finlen -= s2;
        }

    }

    public void update(int k,int c) {
        //update width
        if (finwid >= k) {
            finwid = k-1;
            //System.out.println(">=k");
        }
        else if (finwid < 0) {
            finwid = 0;
            //System.out.println("wid<0");
        }
        //update length
        if(finlen >= c)
        {
            finlen = c-1;
            //System.out.println(">=c");
        }
        else if(finlen < 0)
        {
            finlen = 0;
            //System.out.println("len<0");
        }
    }

    public void data(){
        while (x.hasNext()) {
            w = x.nextInt();
            l = x.nextInt();
            wid = 0;
            len = 0;
            finwid = 0;
            finlen = 0;
            if (w == 0 && l == 0) {
                break;
            }
            else {
                n = x.nextInt();
                for (int i = 0; i < n; i++) {
                    a = x.next();
                    y = x.nextInt();
                    robotThinks(a,y);
                    actuallyAt(a,y);
                }
                System.out.println("Robot thinks " + wid + " " + len);
                System.out.println("Actually at " + finwid + " " + finlen);
            }
        }
    }

    public void robotThinks(String a1,int y1){
        dir(a1,y1);
        //System.out.println("Robot thinks " + wid + " " + len);
    }

    public void actuallyAt(String a2,int y2){
        dir2(a2,y2);
        update(w,l);
        //System.out.println("Actually at " + finwid + " " + finlen);
    }


    /*Threads
    public void multiRun()
    {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(this::robotThinks);
        executorService.submit(this::actuallyAt);

        executorService.shutdown();

    }
    */

}
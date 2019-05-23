import java.util.*;
public class Modulo
{
    //generate a list from user
    public static void lst(int[] arr)
    {
        Scanner keyboard = new Scanner(System.in);
        for(int i = 0;i<arr.length;i++)
        {
            arr[i] = keyboard.nextInt();
        }
        //System.out.print(Arrays.toString(arr));
        return;
    }

    public static void mod(int[] arr,int[] arr_2)
    {
        for(int y = 0;y<arr_2.length;y++)
        {
            arr_2[y] = arr[y]%42;
        }
        //System.out.println("mods are "+Arrays.toString(arr_2));
    }

    public static ArrayList remove(ArrayList<Integer> lst)
    {
        for(int i = 0;i<lst.size();i++)
        {
            for(int k = i+1;k<lst.size();k++)
            {
                if(lst.get(i) == lst.get(k))
                {
                    lst.remove(k);
                }
                
                //System.out.println("the fin now is "+lst);
            }
        }
        return lst;
    }

    public static int checkForMod(int[] arr_2, ArrayList<Integer> fin)
    {   //int counter = 1;
        //int[] count = new int[10];

        for(int x = 0;x<arr_2.length;x++)
        {
            fin.add(arr_2[x]);
        }
        //System.out.println("in arraylist form is: "+fin);

        for(int i = 0;i<fin.size();i++)
        {
            for(int k = i+1;k<fin.size();k++)
            {
                remove(fin);
            }
        }
        int len = fin.size();
        if(len==2)
        {
            if(fin.get(0)==fin.get(1))
            {
                return 1;
            }
        }
        return len;
    }
    //main method
    public static void main(String[]agrs)
    {
        int[] list = new int[10];
        int[] list_2 = new int[10];
        ArrayList<Integer> finlst = new ArrayList<>();

        lst(list);
        mod(list,list_2);
        System.out.print(checkForMod(list_2,finlst));
    }
}
 
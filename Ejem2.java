import GeneratedCodeLib.*;
import java.util.*;
import java.io.*;

public class Ejem2
{
  public static void main (String args[])
  {
   IntSet a= new IntSet();
   IntSet b= new IntSet();
   IntSet c= new IntSet();
   IntSet d= new IntSet();
   int numElem= 0;
   int elem= 0;
   int i= 0;

   a = new IntSet(new int[]{0, 1, 3, 5, 7, 9});
   b = new IntSet(new int[]{0, 2, 4, 6, 8});
   c = IntSet.union(a,b);
   d = IntSet.intersec(a,b);
   System.out.println("Cardinal de a= "+(String)Integer.toString(IntSet.card(a)));
   System.out.println("Cardinal de b= "+(String)Integer.toString(IntSet.card(b)));
   System.out.println("Cardinal de c= "+(String)Integer.toString(IntSet.card(c)));
   System.out.println("Cardinal de \"d\"= "+(String)Integer.toString(IntSet.card(d)));
   numElem = IntSet.card(c);
   i = 0;

   while(IntSet.card(c)>0 && i>(-1))
   {
     elem = IntSet.lowest_elem(c);
     System.out.println("Elemento "+(String)Integer.toString(i)+"= "+(String)Integer.toString(elem));
     i = i+1;
     numElem = numElem - 1;
     c = IntSet.menos(c, elem);

     if(!(numElem==IntSet.card(c)))
     {
       i = (-1);

     }

   }
  }

}
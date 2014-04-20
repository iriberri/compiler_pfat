import GeneratedCodeLib.*;
import java.util.*;
import java.io.*;

public class Ejem5
{
  public static void main (String args[])
  {
   IntSet a= new IntSet();
   IntSet b= new IntSet();
   IntSet c= new IntSet();
   IntSet d= new IntSet();
   IntSet e= new IntSet();
   int numElem= 0;
   int elem= 0;
   int i= 0;

   a = new IntSet(new int[]{0, 1, 3, 5, 7, 9});
   b = new IntSet(new int[]{0, (-2), 4, (-6), 82});
   c = IntSet.union(a,b);
   d = IntSet.intersec(a,b);
   System.out.println("Cardinal de a= "+(String)Integer.toString(IntSet.card(a)));
   System.out.println("Cardinal de b= "+(String)Integer.toString(IntSet.card(b)));
   System.out.println("Cardinal de c= "+(String)Integer.toString(IntSet.card(c)));
   System.out.println("Cardinal de \"d\"= "+(String)Integer.toString(IntSet.card(d)));
   i = 0;
   e = IntSet.emptySet;

   while(i<100)
   {
     e = IntSet.union(e,2*i+1);
     i = i+1;

   }
   i = (-10);
   e = IntSet.union(e,b);

   while(i<250)
   {

     if(IntSet.in(e, i))
     {
       System.out.println((String)Integer.toString(i)+" es elemento de e");

     }
     i = i+1;

   }
  }

}
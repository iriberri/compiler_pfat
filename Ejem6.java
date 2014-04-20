import GeneratedCodeLib.*;
import java.util.*;
import java.io.*;

public class Ejem6
{
  public static void main (String args[])
  {
   IntSet a= new IntSet();
   IntSet b= new IntSet();
   IntSet c= new IntSet();
   IntSet d= new IntSet();
   IntSet e= new IntSet();
   int i= 0;
   int sig= 0;

   a = new IntSet(new int[]{0, 1, 3, 5, (-2), 7, 9, 4});
   b = new IntSet(new int[]{0, (-2), 4, (-6), 8, 10});
   c = IntSet.union(a,b);
   d = IntSet.intersec(a,b);
   e = IntSet.menos(a, b);
   System.out.println("Cardinal de a= "+(String)Integer.toString(IntSet.card(a)));
   System.out.println("Cardinal de b= "+(String)Integer.toString(IntSet.card(b)));
   System.out.println("Cardinal de c= "+(String)Integer.toString(IntSet.card(c)));
   System.out.println("Cardinal de d= "+(String)Integer.toString(IntSet.card(d)));
   System.out.println("Cardinal de e= "+(String)Integer.toString(IntSet.card(e)));
   i = 0;

   while(!(e==IntSet.emptySet))
   {
     sig = IntSet.lowest_elem(e);
     System.out.println("Elemento "+(String)Integer.toString(i)+" de e = "+(String)Integer.toString(sig));
     i = i+1;
     e = IntSet.menos(e, sig);

   }
  }

}
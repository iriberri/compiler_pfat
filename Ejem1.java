import GeneratedCodeLib.*;
import java.util.*;
import java.io.*;

public class Ejem1
{
  public static void main (String args[])
  {
   IntSet a= new IntSet();
   IntSet b= new IntSet();
   IntSet c= new IntSet();
   IntSet d= new IntSet();

   a = new IntSet(new int[]{0, 1, 3, 5, 7, 9});
   b = new IntSet(new int[]{0, 2, 4, 6, 8});
   c = IntSet.union(a,b);
   d = IntSet.intersec(a,b);
   System.out.println("Cardinal de a= "+(String)Integer.toString(IntSet.card(a)));
   System.out.println("Cardinal de b= "+(String)Integer.toString(IntSet.card(b)));
   System.out.println("Cardinal de c= "+(String)Integer.toString(IntSet.card(c)));
   System.out.println("Cardinal de d= "+(String)Integer.toString(IntSet.card(d)));
  }

}
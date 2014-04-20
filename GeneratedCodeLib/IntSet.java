package GeneratedCodeLib;
import java.io.*;
import java.util.*;
import java.util.Vector;


public class IntSet{

	public static final IntSet emptySet = null;

	private Vector<Integer> intset = new Vector<Integer>();

	public IntSet(){
	}

	public IntSet(int[] array){

		for (int i = 0; i< array.length; i++){
			if ((intset.contains(array[i]))==true){
			}else{

					intset.add(array[i]);

			}
			//System.out.println(intset.get(i));
		}


	}

	public static int lowest_elem(IntSet set){
		int min = Integer.MAX_VALUE;
		if (set!= null){
		for (int i = 0; i<set.intset.size(); i++){

			if (min > set.intset.get(i)){
				min = set.intset.get(i);
			}

		}
	}
	if (set == null) { 
		return 0;
	}
		return min;
	}

	public static int card(IntSet set){
		if (set!= null){
			return set.intset.size();
		}
		return 0;
	}

	public static IntSet diferencia(IntSet a, int b){
		if (a!=null){
		for (int i = 0; i<a.intset.size(); i++){
			if (b == a.intset.get(i).intValue()){
				a.intset.remove(i);
			}

		}
	}
		return a;
	


	}

	public static IntSet union(IntSet a, IntSet b){
		IntSet union = new IntSet();
	
		for (int i=0; i<a.intset.size();i++){

				if (!(union.intset.contains(a.intset.get(i)))){
					union.intset.add(a.intset.get(i));
				}
		
		}

		for (int j=0; j<b.intset.size();j++){

				if (!(union.intset.contains(b.intset.get(j)))){
					union.intset.add(b.intset.get(j));
				}
		
		}

		return union;

	}

	public static IntSet union(IntSet a, int b){
		IntSet union = new IntSet();
		if (a!= null) union = a;
				if (!(union.intset.contains(b))){
					union.intset.add(b);
				}
		
	
		return union;

	}

	public static boolean in(IntSet a, int num){

		return a.intset.contains(num);
	}

	public static IntSet intersec(IntSet a, IntSet b){
		IntSet intersec = new IntSet();
		int bigsize;
		int delete;
		if (a.intset.size()>b.intset.size()){
			bigsize = a.intset.size();
		}else{
			bigsize=b.intset.size();
		}
		for (int i=0; i<bigsize;i++){
			if (a.intset.size()<b.intset.size()){

				if (a.intset.contains(b.intset.get(i))){
					intersec.intset.add(b.intset.get(i));
				}
				
			}else{

				if (b.intset.contains(a.intset.get(i))){
					intersec.intset.add(a.intset.get(i));
				}

			

			}
		}
		return intersec;


	}

	public static IntSet menos(IntSet a, int b){
		int delete;
		if (a.intset.contains(b)){
			delete = a.intset.indexOf(b);
			a.intset.remove(delete);
		}

		if (a.intset.isEmpty()){
			return null;
		}
		return a;

	}

		public static IntSet menos(IntSet a, IntSet b){
		IntSet menosset = new IntSet();
		menosset = a;
		int delete;
		for (int i =0; i<b.intset.size(); i++){
		if (menosset.intset.contains(b.intset.get(i))){
			delete = menosset.intset.indexOf(b.intset.get(i));
			menosset.intset.remove(delete);
		}
	}

	if (menosset.intset.isEmpty()){
			return null;
		}
		return menosset;

	}

	public static String printSet (IntSet a){
		String set ="";
		for (int i = 0; i<a.intset.size(); i++){
			set +=  Integer.toString((a.intset.get(i))) + " ," ;
		}
		return set;
	}
}

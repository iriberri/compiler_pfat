package Compiler;
import Errors.*;
import java.util.*;

public class SymbolTable{

	public static Vector <TableEntry> table = new Vector <TableEntry>();

	public static void newEntry(String name, int type) throws DoubleDefExc{

		TableEntry e = search(name);
		if (e==null){
			e=new TableEntry(name, type);
			table.add(e);
		}else{
			throw new DoubleDefExc("Variable " + name +" has been defined twice.");
		}
	}

	public static int getType(String name) throws VarNoDefExc{
		TableEntry e = search(name);

		if (e==null){
			throw new VarNoDefExc("Variable " + name +" has not been previously defined.");
		}
		return e.getType();
	}

	private static TableEntry search(String name){
	TableEntry e = null;
	int i = 0;
		while (i<table.size()){
			e = table.get(i);
			if (e.getName().equals(name)) break;
			e = null;
			i++;
		}
	return e;
	}
}
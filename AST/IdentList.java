package AST;
import Errors.*;
import Compiler.*;
import java.io.*;


public class IdentList {
	String ident;
	IdentList il2;
	private int type;

	public IdentList(String ident){
		this.ident = ident;
	}
	public IdentList(String ident, IdentList il2){
		this.ident=ident;
		this.il2 = il2;
	}

	public void computeType(int type) throws SemanticException, DoubleDefExc{
		this.type=type;
		//System.out.println("tipo il" + type + "  "+ ident);
		SymbolTable.newEntry(ident, type);
		if (il2 != null) il2.computeType(type);
	}
	
	public void generateCode(BufferedWriter w, String indent) throws IOException
	{
		//_
		if (type == Types.INT)
		{
			w.write(indent +"  " + Types.getType(type)+ " " + ident +"= 0;");
		}
		else if (type == Types.STR)
		{
			w.write(indent +"  " + Types.getType(type)+ " " + ident +"= \"\";");
		}else if (type == Types.BOOL)
		{
			w.write(indent +"  " + Types.getType(type)+ " " + ident +"= false;");

		}else if (type == Types.INTSET)
		{
			w.write(indent +"  " + Types.getType(type)+ " " + ident +"= new IntSet();");

		}
		w.newLine();
		if (il2 != null) il2.generateCode(w, indent); 
	}

}

package AST;
import Errors.*;
import Compiler.*;
import java.io.*;

public class Asign implements Statement
{
public final String ident;
public final Exp exp;
//private int type;
public Asign(String ident, Exp exp)
	{
		this.ident=ident;
		this.exp=exp;
	}
	
	public void computeType() throws SemanticException, VarNoDefExc
	{	

		//			System.out.println(exp);

		if( SymbolTable.getType(ident) !=exp.computeType()){
		//	System.out.println(SymbolTable.getType(ident)+"get type ident asign");
		//	System.out.println(exp.computeType() + "exp type asign");

			throw new SemanticException("Invalid type in assignment.");
		}
		//type = exp.computeType();

	}

	public void generateCode(BufferedWriter w, String indent) throws IOException
	{//_
		
		//if (type == Types.INTSET){
		//			w.write(indent + "" + ident + "= IntSet(" + exp.generateCode()+ ");");

		//		}else{
		w.write(indent + "" + ident + " = " + exp.generateCode()+ ";");
		//}
		w.newLine();
	}
}

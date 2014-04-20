package AST;
import Errors.*;
import Compiler.*;
import java.io.*;


public class Variable implements Exp
{
	public final String ident;
	

	public Variable(String ident)
	{
		this.ident=ident;

	}

	public int computeType() throws SemanticException, VarNoDefExc{
		return SymbolTable.getType(ident);
	}	


	public String generateCode()
	
	{
	 return (ident); //_
	}
}
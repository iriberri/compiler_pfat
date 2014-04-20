package AST;
import Errors.*;
import java.io.*;



public class Opuesto implements Exp
{
	public final Exp exp1;
	
	public Opuesto(Exp exp1)
	{
		this.exp1=exp1;
	}
	
	public int computeType() throws SemanticException, VarNoDefExc{
		if(exp1.computeType() != 0) throw new SemanticException("Invalid type: Integer expected");
		return 0;
	}

	public String generateCode()
	
	{
		return "(-" + exp1.generateCode() +")";
	}
}
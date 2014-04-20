package AST;
import Errors.*;
import java.io.*;


public class Not implements Exp
{
	public final Exp exp1;
	
	public Not(Exp exp1)
	{
		this.exp1=exp1;
	}
	
	public int computeType() throws SemanticException , VarNoDefExc{
		if(exp1.computeType() != 1) throw new SemanticException("Invalid type: Boolean needed.");
		return 1;
	}

	public String generateCode()
	
	{
		return "!("+exp1.generateCode() + ")";
			
	}
}
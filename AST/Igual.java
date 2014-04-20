package AST;
import Errors.*;
import java.io.*;


public class Igual implements Exp
{
	public final Exp exp1;
	public final Exp exp2;
	
	public Igual(Exp exp1, Exp exp2)
	{
		this.exp1=exp1;
		this.exp2=exp2;
	}

	public int computeType() throws SemanticException, VarNoDefExc{
		if(exp1.computeType() != exp2.computeType()) {
			throw new SemanticException("Invalid types for comparison.");
		} 
		return 1;
	}

	public String generateCode()
	{
		return exp1.generateCode() + "==" +exp2.generateCode();
	}

	
}
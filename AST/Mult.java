package AST;
import Errors.*;
import java.io.*;



public class Mult implements Exp
{
	public final Exp exp1;
	public final Exp exp2;
	
	public Mult(Exp exp1, Exp exp2)
	{
		this.exp1=exp1;
		this.exp2=exp2;
	}
	public int computeType() throws SemanticException, VarNoDefExc{
		if(exp1.computeType() != 0 || exp2.computeType() != 0) throw new SemanticException("Invalid type @Mult: Integer expected.");
		return 0;
	}

	public String generateCode()
	{
		return exp1.generateCode() + "*" +exp2.generateCode();
	}
}
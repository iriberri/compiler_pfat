package AST;
import Errors.*;
import java.io.*;


public class CIntset implements Exp
{
	public final LExp exp;
	

	public CIntset(LExp exp)
	{
		this.exp=exp;


	}

	 public int computeType() throws SemanticException, VarNoDefExc {
	 	if (exp.computeType() != 0) throw new SemanticException("Something different to an integer inside a intset.");
      return 3;
  	}

  		public String generateCode()
	{
		return exp.generateCode();
	}
	
}
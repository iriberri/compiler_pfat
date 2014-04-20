package AST;
import Errors.*;
import java.io.*;


public class Int2str implements Exp
{
	public final Exp exp1;
	
	public Int2str(Exp exp1)
	{
		this.exp1=exp1;
	}
	
	 public int computeType() throws SemanticException , VarNoDefExc{
  	    if(exp1 != null) {
            if(exp1.computeType() != 0) throw new SemanticException("Invalid type @Int2str: Int expected.");
        }
      return 2;
  	}

  		public String generateCode()
	{
		return "(String)Integer.toString("+ exp1.generateCode() +")";
	}
}
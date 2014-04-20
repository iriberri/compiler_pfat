package AST;
import Errors.SemanticException;
import java.io.*;


public class CInt implements Exp{
	public Integer e;
	//public Exp exp;
	
	public CInt(Integer e)
	{
		this.e=e;

	}

	 public int computeType() throws SemanticException {
  	   
      return Types.INT;
  	}

	public String generateCode()
	{
		return ("" + e);
	}
	
}
package AST;
import Errors.SemanticException;
import java.io.*;


public class CStr implements Exp
{
	public final String s1;
	public CStr(String s1)
	{
		this.s1=s1;
	}
	
	public int computeType() throws SemanticException{
		return 2;
	}

	public String generateCode()
	{
		return "" + s1;
	}
}
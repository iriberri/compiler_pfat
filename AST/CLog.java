package AST;
import Errors.*;
import java.io.*;


public class CLog implements Exp
{
	public final boolean b1;
	public CLog(boolean b1)
	{
		this.b1=b1;
	}

	public int computeType() throws SemanticException{
		return Types.BOOL;
	}
	
	public String generateCode()
	{
		if(b1){
			return "true";
		}else{
			return "false";
		}
	}

}
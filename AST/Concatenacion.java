package AST;
import Errors.*;
import java.io.*;


public class Concatenacion implements Exp{
public final Exp exp1;
public final Exp exp2;

public Concatenacion(Exp exp1, Exp exp2)
	{
		this.exp1=exp1;
		this.exp2=exp2;
	}


	public int computeType()  throws SemanticException, VarNoDefExc{
		if((exp1.computeType() != Types.STR || exp2.computeType() != Types.STR)) {
			throw new SemanticException("Invalid type: String needed.");
		} 

		return Types.STR;
	}

		public String generateCode()
	{
		return exp1.generateCode() + "+" +exp2.generateCode();
	}
}

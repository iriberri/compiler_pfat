package AST;
import Errors.*;
import java.io.*;

public class Mas implements Exp
{
	public final Exp exp1;
	public final Exp exp2;
	
	public Mas(Exp exp1, Exp exp2)
	{
		this.exp1=exp1;
		this.exp2=exp2;
	}
	
	public int computeType()  throws SemanticException, VarNoDefExc{

	if (exp1.computeType() == 2 || exp2.computeType() == 2){
		if(exp1.computeType() != 2 || exp2.computeType() != 2) throw new SemanticException("Invalid type @Mas: String expected.");
		return 2;
	}else{
		if(exp1.computeType() != 0 || exp2.computeType() != 0) throw new SemanticException("Invalid type @Mas: Integer expected.");
		return 0;
	}
	}

		public String generateCode()
	{
		return exp1.generateCode() + "+" +exp2.generateCode();
	}
}
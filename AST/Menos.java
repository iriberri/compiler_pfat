package AST;
import Errors.*;
import java.io.*;

public class Menos implements Exp
{
	public final Exp exp1;
	public final Exp exp2;
	public int type1;
	public int type2;
	
	public Menos(Exp exp1, Exp exp2)
	{
		this.exp1=exp1;
		this.exp2=exp2;
	}
	public int computeType() throws SemanticException, VarNoDefExc{
		type1 = exp1.computeType();
		type2 = exp2.computeType();
		

		if (exp1.computeType() == 0 || exp2.computeType() == 0){
		if(exp1.computeType() != 0 || exp2.computeType() != 0) throw new SemanticException("Invalid type @Menos: Integer expected.");
		return 0;
	}
	if (exp1.computeType() == 3 || exp2.computeType() == 3){
		if(exp1.computeType() != 3 || exp2.computeType() != 3) throw new SemanticException("Invalid type @Menos: Intset expected.");
		return 3;
	}
return -1;
	}

	public String generateCode()
	{
		if (!(type1 == 3 && type2 ==3)){
					return exp1.generateCode() + " - " +exp2.generateCode();


	}
				return "IntSet.menos(" + exp1.generateCode() +", "+exp2.generateCode() +")";


	}
}
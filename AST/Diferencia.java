package AST;
import Errors.*;
import java.io.*;


public class Diferencia implements Exp
{
	public final Exp set1;
	public final Exp set2;
	
	public Diferencia(Exp set1, Exp set2)
	{
		this.set1=set1;
		this.set2=set2;
	}


	public int computeType()  throws SemanticException, VarNoDefExc{
		if((set1.computeType() == 3 && set2.computeType() == 0)) {
			throw new SemanticException("Invalid type @Diferencia: Intset and int needed.");
		} 

		return 3;
	}
	
	public String generateCode()
	{
				return set1.generateCode() + ".menos(" +set2.generateCode() +")";
	}
	
}
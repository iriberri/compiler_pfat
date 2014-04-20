package AST;
import Errors.*;
import java.io.*;

public class Union implements Exp
{
	public final Exp set1;
	public final Exp set2;
	
	public Union(Exp set1, Exp set2)
	{
		this.set1=set1;
		this.set2=set2;
	}

	public int computeType()  throws SemanticException, VarNoDefExc{
		if((set1.computeType() != 3 || set2.computeType() != 3)) {
			throw new SemanticException("Invalid type @Union: Intset needed.");
		} 

		return 3;
	}

		public String generateCode()
	{
		return "IntSet.union(" +set1.generateCode() + "," + set2.generateCode() + ")";
	}
	
}
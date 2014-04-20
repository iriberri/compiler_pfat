package AST;
import Errors.*;
import java.io.*;


public class LowestElem implements Exp{
	public final Exp exp;
	public LowestElem(Exp exp){
		this.exp=exp;
	}


public int computeType() throws SemanticException, VarNoDefExc{
		if(exp.computeType() != 3) {
			throw new SemanticException("Invalid types @LowestElem: Intset expected.");
		} 
		return 0;
	}

		public String generateCode()
	{
		return "IntSet.lowest_elem("+exp.generateCode()+")";
	}
}	
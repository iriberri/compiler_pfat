package AST;
import Errors.*;
import java.io.*;


public class Card implements Exp{
	public final Exp exp;
	public Card(Exp exp){
		this.exp=exp;
	}

public int computeType()  throws SemanticException, VarNoDefExc{
		if(exp.computeType() != 3) {
			throw new SemanticException("Invalid type @Card: Intset needed.");
		} 

		return 0;
	}

		public String generateCode()
	{
		return "IntSet.card("+exp.generateCode()+")";
	}
}	
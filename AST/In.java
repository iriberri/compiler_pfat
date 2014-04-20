package AST;
import Errors.*;
import java.io.*;


public class In implements Exp{
	 Exp ints;
	 Exp intset;
	public In(Exp ints, Exp intset){
		this.ints = ints;
		this.intset = intset;
	}	

	public int computeType() throws SemanticException, VarNoDefExc{
		if(ints.computeType() != 0 || intset.computeType()!=3) {
			throw new SemanticException("Invalid types @In: Int expected to be in int.");
		} 
		return 1;
	}

		public String generateCode()
	{
		return "IntSet.in("+intset.generateCode()+", "+ints.generateCode()+")";

		//true if it is, false if not
		//exp 1 es un elmento de  exo2
	}
}
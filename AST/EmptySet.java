package AST;
import Errors.*;
import java.io.*;


public class EmptySet implements Exp{
	public EmptySet(){
		
	}	

	public int computeType() throws SemanticException {
  	   
      return Types.INTSET;
  	}

  		public String generateCode()
	{
		return "IntSet.emptySet";
		//{}
	}

}
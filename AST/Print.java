package AST;
import Errors.*;
import java.io.*;


public class Print implements Statement{
	public final Exp exp;
	public Print(Exp exp){
		this.exp=exp;
	}

	public void computeType() throws SemanticException , VarNoDefExc{
		if(exp.computeType() != 2) throw new SemanticException("Invalid type: String expected.");
	}

	public void generateCode(BufferedWriter w, String indent) throws IOException {

		w.write(indent + "System.out.println(" + exp.generateCode() + ");");
		w.newLine();
	}

}	



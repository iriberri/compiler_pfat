package AST;
import Errors.*;
import java.io.*;


public class Body implements SList{ //statementlist
	StatementList stl;
	public Body (StatementList stl){
		this.stl = stl;

	}

	public void computeType() throws SemanticException, VarNoDefExc{
		stl.computeType();
	}

	public void generateCode(BufferedWriter w, String indent) throws IOException {
		stl.generateCode(w, " ");
	}

}

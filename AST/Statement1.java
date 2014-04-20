package AST;
import Errors.*;
import java.io.*;

public class Statement1 implements Statement
{
	public final Statement s;

	public Statement1(Statement s)
	{
		this.s=s;
	}

		public void computeType() throws SemanticException, VarNoDefExc{
		this.s.computeType();
	}

	public void generateCode(BufferedWriter w, String indent) throws IOException {

		s.generateCode(w, indent);
	}

	
}

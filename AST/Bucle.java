package AST;
import Errors.*;
import java.io.*;

public class Bucle implements Statement{
public final Exp exp;
public final StatementList st;

public Bucle(Exp exp, StatementList st)
	{
		this.exp=exp;
		this.st=st;
	}

	public void computeType() throws SemanticException, VarNoDefExc {
		if(exp.computeType() != 1) throw new SemanticException("Invalid type: Boolean needed.");
		st.computeType();
	}

	public void generateCode(BufferedWriter w, String indent) throws IOException
	{
		w.newLine();
		w.write(indent + "while(" + exp.generateCode() + ")");
		w.newLine();
		w.write(indent + "{");
		w.newLine();
		st.generateCode(w, indent + "  ");
		w.newLine();
		w.write(indent + "}");
		w.newLine();
	}
}

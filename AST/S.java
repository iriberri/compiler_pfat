package AST;
import Errors.*;
import java.io.*;

public class S
{

	public final String ident;
	public LDecl ldecl;
	public final StatementList body;

	public S(String ident, LDecl ldecl, StatementList body)
	{
		this.ident =ident;
		this.ldecl=ldecl;
		this.body=body;
	}

	public S(String ident, StatementList body)
	{
		this.ident =ident;
		this.body=body;
	}

	public void computeType() throws SemanticException, DoubleDefExc, VarNoDefExc{
	//ident.computeType();
	if(ldecl != null) ldecl.computeType();
	body.computeType();
	}

	public String getClassName(){
		return ident;
	}


	public void generateCode(BufferedWriter w, String indent) throws IOException
	{

	  w.write(ident);
      w.newLine();
      w.write("{");
      w.newLine();
      w.write(indent + "public static void main (String args[])");
      w.newLine();
      w.write(indent + "{");
	  w.newLine();
	  ldecl.generateCode(w, indent + " ");
	  w.newLine();
	  body.generateCode(w, indent + " ");
	  w.write(indent + "}");
	  w.newLine();

	}


}
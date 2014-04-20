package AST;
import Errors.*;
import java.io.*;


public class Prog
{

	public final String ident;
	public LDecl ldecl;
	public final StatementList body;

	public Prog(String ident, LDecl ldecl, StatementList body)
	{
		this.ident =ident;
		this.ldecl=ldecl;
		this.body=body;
	}

	public Prog(String ident, StatementList body)
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
	}
}
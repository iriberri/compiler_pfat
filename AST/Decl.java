package AST;
import Errors.*;
import Compiler.*;
import java.io.*;


public class Decl 
{
	public int type;
	public Decl dec;
	public LDecl il2;
	public IdentList il3;
	public Decl(int type, IdentList il)
	{
		this.type=type;
		this.il3=il;
	}
	public Decl(Decl dec, LDecl il)
	{
		this.dec=dec;
		this.il2=il;
	}

	public Decl(Decl dec)
	{
		this.dec=dec;
	}

	public void computeType() throws SemanticException, DoubleDefExc{
				//System.out.println("tipo"+type + il3);
		//		SymbolTable.newEntry(il3, type);
		if(il3!= null)  il3.computeType(type);
	}

	public void generateCode(BufferedWriter w, String indent) throws IOException
	{
		if(il3!= null) il3.generateCode(w, indent);
	}

}
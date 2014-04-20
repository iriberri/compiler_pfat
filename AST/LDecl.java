package AST;
import Errors.*;
import java.io.*;


public class LDecl {
	Decl decl;
	LDecl next;
	public LDecl(Decl decl){
		this.decl = decl;
	}
	public LDecl(Decl decl, LDecl next){
		this.decl = decl;
		this.next = next;
	}

	public void computeType() throws SemanticException, DoubleDefExc{
		decl.computeType();
		if (next != null) next.computeType();
	}

		public void generateCode(BufferedWriter w, String indent) throws IOException
	{
		decl.generateCode(w, " ");
		if (next != null) next.generateCode(w, " ");

	}

}

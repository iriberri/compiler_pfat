package AST;
import Errors.*;
import java.io.*;

public class StatementList implements Statement{
	Statement stat;
	StatementList next;
	public StatementList(Statement stat){
		this.stat = stat;
	}
	public StatementList(Statement stat, StatementList next){
		this.stat = stat;
		this.next = next;
	}
	public StatementList(StatementList next){
		this.next = next;
	}

		public void computeType() throws SemanticException, VarNoDefExc{
		//			System.out.println("SL");

		//if(this.stat != null) System.out.println(stat);
		if(this.stat != null) this.stat.computeType();
		//		if(this.next != null) System.out.println(next);

		if(this.next != null) next.computeType();

	}

	public void generateCode(BufferedWriter w, String indent) throws IOException
	{

		if(this.stat != null) this.stat.generateCode(w, indent);
		if(this.next != null) next.generateCode(w, indent);


	}

}

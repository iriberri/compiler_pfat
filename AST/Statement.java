package AST;
import Errors.*;
import java.io.*;

public interface Statement{
		public void computeType() throws SemanticException, VarNoDefExc;
		public void generateCode(BufferedWriter w, String indent) throws IOException;
}

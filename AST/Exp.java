package AST;
import Errors.*;
import java.io.*;


public interface Exp{
		public int computeType() throws SemanticException, VarNoDefExc;
		public String generateCode();

}

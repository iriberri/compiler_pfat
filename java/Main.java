import Parser.*;
import Lexer.*;
import java.io.*;
import AST.*;


public class Main
{
  public static void main(String args[]) throws Exception{
    java.io.BufferedReader in;
    java.io.BufferedWriter w;
    Yylex sc;
    parser p;
    java_cup.runtime.Symbol sroot;
    boolean error=false;
    S prog;

    //El primer parametro es el nombre del fichero con el programa
    if (args.length < 1) {
      System.out.println(
        "Uso: java Main <nombre_fichero>");
      error=true;
    }

    //Análisis léxico y sintáctico

    if (!error) {  
	try {
	    in = new java.io.BufferedReader(new java.io.FileReader(args[0]));
      sc = new Yylex(in);
	    p = new parser(sc);
	    sroot = p.parse();
      System.out.println("Analisis lexico y sintactico correctos");
      prog=(S) sroot.value;
       String nameFile = prog.getClassName();
      prog.computeType();
      System.out.println("Analisis semantico correcto");
      w = new java.io.BufferedWriter(new java.io.FileWriter(nameFile+".java"));
      w.write("import GeneratedCodeLib.*;");
      w.newLine();
      w.write("import java.util.*;");
      w.newLine();
      w.write("import java.io.*;");
      w.newLine();
      w.newLine();
      w.write("public class ");
      prog.generateCode(w, "  ");
      w.newLine();
      w.write("}");
      w.close();


	} catch(IOException e) {
	    System.out.println("Error abriendo fichero: " + args[0]);
	    error= true;
	}
    }
  }
}

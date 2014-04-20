package Errors;

public class SemanticException extends CompilerExc {

  private String msg;

  public SemanticException(String s) {
     msg = "[Semantic error] "+s;
  }

  public String toString() {
     return msg;
 }
}

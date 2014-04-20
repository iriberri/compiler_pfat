package Errors;

public class VarNoDefExc extends CompilerExc
{
	private String msg;
	public VarNoDefExc(String s) {
     msg = s;
       }

  public String toString() {
     return msg;
       }
}
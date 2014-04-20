package Errors;

public class DoubleDefExc extends CompilerExc
{
	private String msg;
	public DoubleDefExc(String s) {
     msg = s;
       }

  public String toString() {
     return msg;
       }
}
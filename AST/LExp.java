package AST;
import Errors.*;
import java.io.*;


public class LExp implements Exp{
	  LExp lexp;
		Exp exp;
		private int list = 0;
	public LExp(Exp exp){
		this.exp = exp;
		this.list = 0;
	}
	public LExp(Exp exp, LExp lexp){
		this.exp=exp;
		this.lexp = lexp;
		this.list=1;
	}
	public int computeType() throws SemanticException, VarNoDefExc{
	

		if(this.lexp != null) {

				if (exp.computeType() != this.lexp.computeType()) {
					throw new SemanticException("List of elements with different type");
				}



			}
			return exp.computeType();
			

	}

	public String generateCode()
	{

		if (list==1){
			String code ="new IntSet(new int[]{";
			if (lexp != null){
				code +=(exp.generateCode() + ", " + lexp.generateCodeList()) ;
			}else{
			code += exp.generateCode() + "";
			}
			return code;
		}else{

			return exp.generateCode();
		}
	}

	public String generateCodeList(){
		String code ="";
		if (lexp != null){
				code +=(exp.generateCode() + ", " + lexp.generateCodeList()) ;
			}else{
			code += exp.generateCode() + "})";
			}
			return code;

	}

}

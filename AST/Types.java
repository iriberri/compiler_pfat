package AST;
import Errors.*;
import java.io.*;

public class Types
{
public static final int INT=0;
public static final int BOOL=1;
public static final int STR=2;
public static final int INTSET=3;


public static String getType(int type)
	{
		switch (type)
		{
			case INT:
				return "int";
			case BOOL:
				return "boolean";
			case STR:
				return "String";
			case INTSET:
				return "IntSet";
			default:
				return "Not a type";

		}
		
	}


}

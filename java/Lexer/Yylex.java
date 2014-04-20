package Lexer;
import Errors.LexerException;
import Parser.sym;
import AST.*;


public class Yylex implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 128;
	private final int YY_EOF = 129;

private java_cup.runtime.Symbol tok(int k, Object value) {
//  System.out.println("Token: " + k);
  return new java_cup.runtime.Symbol(k, yyline, 0, value); 
}
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	public Yylex (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	public Yylex (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Yylex () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NOT_ACCEPT,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NOT_ACCEPT,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NOT_ACCEPT,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NOT_ACCEPT,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NOT_ACCEPT,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NOT_ACCEPT,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NO_ANCHOR,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NO_ANCHOR,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NO_ANCHOR,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NO_ANCHOR,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NO_ANCHOR,
		/* 86 */ YY_NO_ANCHOR,
		/* 87 */ YY_NO_ANCHOR,
		/* 88 */ YY_NO_ANCHOR,
		/* 89 */ YY_NO_ANCHOR,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NO_ANCHOR,
		/* 92 */ YY_NO_ANCHOR,
		/* 93 */ YY_NO_ANCHOR,
		/* 94 */ YY_NO_ANCHOR,
		/* 95 */ YY_NO_ANCHOR,
		/* 96 */ YY_NO_ANCHOR,
		/* 97 */ YY_NO_ANCHOR,
		/* 98 */ YY_NO_ANCHOR,
		/* 99 */ YY_NO_ANCHOR,
		/* 100 */ YY_NO_ANCHOR,
		/* 101 */ YY_NO_ANCHOR,
		/* 102 */ YY_NO_ANCHOR,
		/* 103 */ YY_NO_ANCHOR,
		/* 104 */ YY_NO_ANCHOR,
		/* 105 */ YY_NO_ANCHOR,
		/* 106 */ YY_NO_ANCHOR,
		/* 107 */ YY_NO_ANCHOR,
		/* 108 */ YY_NO_ANCHOR,
		/* 109 */ YY_NO_ANCHOR,
		/* 110 */ YY_NO_ANCHOR,
		/* 111 */ YY_NO_ANCHOR,
		/* 112 */ YY_NO_ANCHOR,
		/* 113 */ YY_NO_ANCHOR,
		/* 114 */ YY_NO_ANCHOR,
		/* 115 */ YY_NO_ANCHOR,
		/* 116 */ YY_NO_ANCHOR,
		/* 117 */ YY_NO_ANCHOR,
		/* 118 */ YY_NO_ANCHOR,
		/* 119 */ YY_NO_ANCHOR,
		/* 120 */ YY_NO_ANCHOR,
		/* 121 */ YY_NO_ANCHOR,
		/* 122 */ YY_NO_ANCHOR,
		/* 123 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,130,
"44:9,42:2,44,42:2,44:18,42,44,43,44:5,36,37,35,32,38,33,44,34,13,14,12,15,2" +
"6:6,28,27,30,29,31,44:2,41:26,44,45,44:2,23,44,1,4,16,3,5,11,6,19,7,41:2,17" +
",24,2,8,10,41,9,22,20,21,41,18,41,25,41,39,44,40,44:2,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,124,
"0,1,2,3,1:15,4,5,4:2,1:2,4:3,6,4:16,1,7,8,9,7,10,11,7,12,13,14,15,16,4,17,1" +
"8,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,4" +
"3,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,6" +
"8,69,70,4,71,72,73,74,75,76,77,78,79,80")[0];

	private int yy_nxt[][] = unpackFromString(81,46,
"1,2,100,47,108,111,113,51,54,113,114,115,3:4,116,117,118,113,119,120,121,4," +
"113:2,3,5,48,6,7,8,9,10,11,12,13,14,15,16,17,113,18,52,4:2,-1:47,113,56,113" +
":9,58:4,113:7,-1,113:2,58,-1:14,113,-1:16,3:4,-1:10,3,-1:20,113:11,58:4,113" +
":7,-1,113:2,58,-1:14,113,-1:5,113:11,58:4,113:4,28,113:2,-1,113:2,58,-1:14," +
"113,-1:5,113:4,85,113:6,104,58:3,113:6,86,-1,113:2,58,-1:14,113,-1:5,46:42," +
"24,46,50,-1,113:4,61,113:2,19,113:3,58:4,113:7,-1,113:2,58,-1:14,113,-1:33," +
"23,-1:17,46:42,49,46,50,-1,113,20,113:8,21,58:4,113:7,-1,113:2,58,-1:14,113" +
",-1:9,55,-1:41,113:8,22,113:2,58:4,113:7,-1,113:2,58,-1:14,113,-1:21,57,-1:" +
"29,113:2,25,113:8,58:4,113:7,-1,113:2,58,-1:14,113,-1:9,59,-1:64,45,-1:22,1" +
"13:11,58:4,113:4,26,113:2,-1,113:2,58,-1:14,113,-1:5,113:11,58:4,73,113:6,-" +
"1,113:2,58,-1:14,113,-1:5,113:5,112,113:5,58:4,113:7,-1,113:2,58,-1:14,113," +
"-1:5,113:7,74,113:3,58:4,113:7,-1,113:2,58,-1:14,113,-1:5,113:2,27,113:8,58" +
":4,113:7,-1,113:2,58,-1:14,113,-1:5,113:9,75,113,58:4,113:7,-1,113:2,58,-1:" +
"14,113,-1:5,113:6,76,113:4,58:4,113:7,-1,113:2,58,-1:14,113,-1:5,113:11,58:" +
"4,113,77,113:5,-1,113:2,58,-1:14,113,-1:5,113:8,78,113:2,58:4,113:7,-1,113:" +
"2,58,-1:14,113,-1:5,113:11,58:4,113:2,103,113:4,-1,113:2,58,-1:14,113,-1:5," +
"113:11,58:4,113:5,80,113,-1,113:2,58,-1:14,113,-1:5,113:4,81,113:6,58:4,113" +
":7,-1,113:2,58,-1:14,113,-1:5,113:8,29,113:2,58:4,113:7,-1,113:2,58,-1:14,1" +
"13,-1:5,113:11,58:4,113,30,113:5,-1,113:2,58,-1:14,113,-1:5,113:11,58:4,113" +
",31,113:5,-1,113:2,58,-1:14,113,-1:5,113:11,58:4,113:4,84,113:2,-1,113:2,58" +
",-1:14,113,-1:5,113,87,113:9,58:4,113:7,-1,113:2,58,-1:14,113,-1:5,113:11,5" +
"8:4,113:6,88,-1,113:2,58,-1:14,113,-1:5,113:2,32,113:8,58:4,113:7,-1,113:2," +
"58,-1:14,113,-1:5,113:11,58:4,113,90,113:5,-1,113:2,58,-1:14,113,-1:5,113:4" +
",33,113:6,58:4,113:7,-1,113:2,58,-1:14,113,-1:5,113,34,113:9,58:4,113:7,-1," +
"113:2,58,-1:14,113,-1:5,113:7,91,113:3,58:4,113:7,-1,113:2,58,-1:14,113,-1:" +
"5,113,35,113:9,58:4,113:7,-1,113:2,58,-1:14,113,-1:5,113:11,58:4,113:7,-1,1" +
"13,105,58,-1:14,113,-1:5,113:8,110,113:2,58:4,113:7,-1,113:2,58,-1:14,113,-" +
"1:5,113:4,93,113:6,58:4,113:7,-1,113:2,58,-1:14,113,-1:5,113:11,58:4,113:4," +
"36,113:2,-1,113:2,58,-1:14,113,-1:5,113:4,37,113:6,58:4,113:7,-1,113:2,58,-" +
"1:14,113,-1:5,113:11,58:4,113:6,106,-1,113:2,58,-1:14,113,-1:5,113:4,38,113" +
":6,58:4,113:7,-1,113:2,58,-1:14,113,-1:5,113,39,113:9,58:4,113:7,-1,113:2,5" +
"8,-1:14,113,-1:5,113:11,58:4,113:4,96,113:2,-1,113:2,58,-1:14,113,-1:5,113:" +
"11,58:4,113:4,40,113:2,-1,113:2,58,-1:14,113,-1:5,113:11,58:3,41,113:7,-1,1" +
"13:2,58,-1:14,113,-1:5,113:4,98,113:6,58:4,113:7,-1,113:2,58,-1:14,113,-1:5" +
",113:8,42,113:2,58:4,113:7,-1,113:2,58,-1:14,113,-1:5,113:11,58:4,113:7,53," +
"113:2,58,-1:14,113,-1:5,113:11,58:4,113:4,43,113:2,-1,113:2,58,-1:14,113,-1" +
":5,113:11,58:4,44,113:6,-1,113:2,58,-1:14,113,-1:5,113:7,60,113:3,58:4,113:" +
"7,-1,113:2,58,-1:14,113,-1:5,113:11,58:2,94,58,113:7,-1,113:2,58,-1:14,113," +
"-1:5,113:6,79,113:4,58:4,113:7,-1,113:2,58,-1:14,113,-1:5,113:4,89,113:6,58" +
":4,113:7,-1,113:2,58,-1:14,113,-1:5,113:11,58:4,113:6,92,-1,113:2,58,-1:14," +
"113,-1:5,113:11,58:4,113:6,95,-1,113:2,58,-1:14,113,-1:5,113:11,58:4,113:4," +
"97,113:2,-1,113:2,58,-1:14,113,-1:5,113:4,99,113:6,58:4,113:7,-1,113:2,58,-" +
"1:14,113,-1:5,113:4,62,113:2,63,113:3,58:4,113:7,-1,113:2,58,-1:14,113,-1:5" +
",113:6,82,113:4,58:4,113:7,-1,113:2,58,-1:14,113,-1:5,113:11,58:4,113:6,107" +
",-1,113:2,58,-1:14,113,-1:5,113,64,113:9,58:4,113:7,-1,65,113,58,-1:14,113," +
"-1:5,113:6,83,113:4,58:4,113:7,-1,113:2,58,-1:14,113,-1:5,113:8,66,113,123," +
"58:4,113:7,-1,113:2,58,-1:14,113,-1:5,67,113:10,58:4,113:7,-1,113:2,58,-1:1" +
"4,113,-1:5,68,113:10,58:4,113:7,-1,113:2,58,-1:14,113,-1:5,113:7,69,113:3,5" +
"8:4,113:7,-1,113:2,58,-1:14,113,-1:5,113:11,58:4,113:3,102,113:3,-1,113:2,5" +
"8,-1:14,113,-1:5,113:8,70,113:2,58:4,113:3,71,113:3,-1,113:2,58,-1:14,113,-" +
"1:5,113,109,113:9,58:4,113:7,-1,113:2,58,-1:14,113,-1:5,113:11,58:4,113:4,7" +
"2,113:2,-1,113:2,58,-1:14,113,-1:5,113:11,58,101,58:2,113:7,-1,113:2,58,-1:" +
"14,113,-1:5,113:11,122,58:3,113:7,-1,113:2,58,-1:14,113,-1:4");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException, 
LexerException

		{
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {

{return tok(sym.EOF, null); }
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{return tok(sym.IDENT, yytext()); }
					case -3:
						break;
					case 3:
						{return tok(sym.CINT, new Integer(yytext())); }
					case -4:
						break;
					case 4:
						{ System.err.println("Illegal character: "+yytext()); }
					case -5:
						break;
					case 5:
						{return tok(sym.PC, null); }
					case -6:
						break;
					case 6:
						{return tok(sym.IGUAL, null); }
					case -7:
						break;
					case 7:
						{return tok(sym.MENOR, null); }
					case -8:
						break;
					case 8:
						{return tok(sym.MAYOR, null); }
					case -9:
						break;
					case 9:
						{return tok(sym.MAS, null); }
					case -10:
						break;
					case 10:
						{return tok(sym.MENOS, null); }
					case -11:
						break;
					case 11:
						{return tok(sym.DIV, null); }
					case -12:
						break;
					case 12:
						{return tok(sym.MUL, null); }
					case -13:
						break;
					case 13:
						{return tok(sym.PAREN, null); }
					case -14:
						break;
					case 14:
						{return tok(sym.TESIS, null); }
					case -15:
						break;
					case 15:
						{return tok(sym.COMA, null); }
					case -16:
						break;
					case 16:
						{return tok(sym.BRAC, null); }
					case -17:
						break;
					case 17:
						{return tok(sym.KET, null); }
					case -18:
						break;
					case 18:
						{ /* ignore white space. */ }
					case -19:
						break;
					case 19:
						{return tok(sym.DO, null); }
					case -20:
						break;
					case 20:
						{return tok(sym.IN, null); }
					case -21:
						break;
					case 21:
						{return tok(sym.IF, null); }
					case -22:
						break;
					case 22:
						{return tok(sym.OR, null); }
					case -23:
						break;
					case 23:
						{return tok(sym.ASIG, null); }
					case -24:
						break;
					case 24:
						{return tok(sym.CSTR, new String(yytext())); }
					case -25:
						break;
					case 25:
						{return tok(sym.AND, null); }
					case -26:
						break;
					case 26:
						{return tok(sym.NOT, null); }
					case -27:
						break;
					case 27:
						{return tok(sym.END, null); }
					case -28:
						break;
					case 28:
						{return tok(sym.TYPE, new Integer(0)); }
					case -29:
						break;
					case 29:
						{return tok(sym.TYPE, new Integer(2)); }
					case -30:
						break;
					case 30:
						{return tok(sym.DECL, null); }
					case -31:
						break;
					case 31:
						{return tok(sym.TYPE, new Integer(1)); }
					case -32:
						break;
					case 32:
						{return tok(sym.CARD, null); }
					case -33:
						break;
					case 33:
						{return tok(sym.CLOG, new Boolean(true)); }
					case -34:
						break;
					case 34:
						{return tok(sym.THEN, null); }
					case -35:
						break;
					case 35:
						{return tok(sym.BEGIN, null); }
					case -36:
						break;
					case 36:
						{return tok(sym.PRINT, null); }
					case -37:
						break;
					case 37:
						{return tok(sym.CLOG, new Boolean(false)); }
					case -38:
						break;
					case 38:
						{return tok(sym.WHILE, null); }
					case -39:
						break;
					case 39:
						{return tok(sym.UNION, null); }
					case -40:
						break;
					case 40:
						{return tok(sym.TYPE, new Integer(3)); }
					case -41:
						break;
					case 41:
						{return tok(sym.PROG, null); }
					case -42:
						break;
					case 42:
						{return tok(sym.INT2STR, null); }
					case -43:
						break;
					case 43:
						{return tok(sym.EMPTYSET, null); }
					case -44:
						break;
					case 44:
						{return tok(sym.INTERSEC, null); }
					case -45:
						break;
					case 45:
						{return tok(sym.LOWEST_ELEM, null); }
					case -46:
						break;
					case 47:
						{return tok(sym.IDENT, yytext()); }
					case -47:
						break;
					case 48:
						{ System.err.println("Illegal character: "+yytext()); }
					case -48:
						break;
					case 49:
						{return tok(sym.CSTR, new String(yytext())); }
					case -49:
						break;
					case 51:
						{return tok(sym.IDENT, yytext()); }
					case -50:
						break;
					case 52:
						{ System.err.println("Illegal character: "+yytext()); }
					case -51:
						break;
					case 54:
						{return tok(sym.IDENT, yytext()); }
					case -52:
						break;
					case 56:
						{return tok(sym.IDENT, yytext()); }
					case -53:
						break;
					case 58:
						{return tok(sym.IDENT, yytext()); }
					case -54:
						break;
					case 60:
						{return tok(sym.IDENT, yytext()); }
					case -55:
						break;
					case 61:
						{return tok(sym.IDENT, yytext()); }
					case -56:
						break;
					case 62:
						{return tok(sym.IDENT, yytext()); }
					case -57:
						break;
					case 63:
						{return tok(sym.IDENT, yytext()); }
					case -58:
						break;
					case 64:
						{return tok(sym.IDENT, yytext()); }
					case -59:
						break;
					case 65:
						{return tok(sym.IDENT, yytext()); }
					case -60:
						break;
					case 66:
						{return tok(sym.IDENT, yytext()); }
					case -61:
						break;
					case 67:
						{return tok(sym.IDENT, yytext()); }
					case -62:
						break;
					case 68:
						{return tok(sym.IDENT, yytext()); }
					case -63:
						break;
					case 69:
						{return tok(sym.IDENT, yytext()); }
					case -64:
						break;
					case 70:
						{return tok(sym.IDENT, yytext()); }
					case -65:
						break;
					case 71:
						{return tok(sym.IDENT, yytext()); }
					case -66:
						break;
					case 72:
						{return tok(sym.IDENT, yytext()); }
					case -67:
						break;
					case 73:
						{return tok(sym.IDENT, yytext()); }
					case -68:
						break;
					case 74:
						{return tok(sym.IDENT, yytext()); }
					case -69:
						break;
					case 75:
						{return tok(sym.IDENT, yytext()); }
					case -70:
						break;
					case 76:
						{return tok(sym.IDENT, yytext()); }
					case -71:
						break;
					case 77:
						{return tok(sym.IDENT, yytext()); }
					case -72:
						break;
					case 78:
						{return tok(sym.IDENT, yytext()); }
					case -73:
						break;
					case 79:
						{return tok(sym.IDENT, yytext()); }
					case -74:
						break;
					case 80:
						{return tok(sym.IDENT, yytext()); }
					case -75:
						break;
					case 81:
						{return tok(sym.IDENT, yytext()); }
					case -76:
						break;
					case 82:
						{return tok(sym.IDENT, yytext()); }
					case -77:
						break;
					case 83:
						{return tok(sym.IDENT, yytext()); }
					case -78:
						break;
					case 84:
						{return tok(sym.IDENT, yytext()); }
					case -79:
						break;
					case 85:
						{return tok(sym.IDENT, yytext()); }
					case -80:
						break;
					case 86:
						{return tok(sym.IDENT, yytext()); }
					case -81:
						break;
					case 87:
						{return tok(sym.IDENT, yytext()); }
					case -82:
						break;
					case 88:
						{return tok(sym.IDENT, yytext()); }
					case -83:
						break;
					case 89:
						{return tok(sym.IDENT, yytext()); }
					case -84:
						break;
					case 90:
						{return tok(sym.IDENT, yytext()); }
					case -85:
						break;
					case 91:
						{return tok(sym.IDENT, yytext()); }
					case -86:
						break;
					case 92:
						{return tok(sym.IDENT, yytext()); }
					case -87:
						break;
					case 93:
						{return tok(sym.IDENT, yytext()); }
					case -88:
						break;
					case 94:
						{return tok(sym.IDENT, yytext()); }
					case -89:
						break;
					case 95:
						{return tok(sym.IDENT, yytext()); }
					case -90:
						break;
					case 96:
						{return tok(sym.IDENT, yytext()); }
					case -91:
						break;
					case 97:
						{return tok(sym.IDENT, yytext()); }
					case -92:
						break;
					case 98:
						{return tok(sym.IDENT, yytext()); }
					case -93:
						break;
					case 99:
						{return tok(sym.IDENT, yytext()); }
					case -94:
						break;
					case 100:
						{return tok(sym.IDENT, yytext()); }
					case -95:
						break;
					case 101:
						{return tok(sym.IDENT, yytext()); }
					case -96:
						break;
					case 102:
						{return tok(sym.IDENT, yytext()); }
					case -97:
						break;
					case 103:
						{return tok(sym.IDENT, yytext()); }
					case -98:
						break;
					case 104:
						{return tok(sym.IDENT, yytext()); }
					case -99:
						break;
					case 105:
						{return tok(sym.IDENT, yytext()); }
					case -100:
						break;
					case 106:
						{return tok(sym.IDENT, yytext()); }
					case -101:
						break;
					case 107:
						{return tok(sym.IDENT, yytext()); }
					case -102:
						break;
					case 108:
						{return tok(sym.IDENT, yytext()); }
					case -103:
						break;
					case 109:
						{return tok(sym.IDENT, yytext()); }
					case -104:
						break;
					case 110:
						{return tok(sym.IDENT, yytext()); }
					case -105:
						break;
					case 111:
						{return tok(sym.IDENT, yytext()); }
					case -106:
						break;
					case 112:
						{return tok(sym.IDENT, yytext()); }
					case -107:
						break;
					case 113:
						{return tok(sym.IDENT, yytext()); }
					case -108:
						break;
					case 114:
						{return tok(sym.IDENT, yytext()); }
					case -109:
						break;
					case 115:
						{return tok(sym.IDENT, yytext()); }
					case -110:
						break;
					case 116:
						{return tok(sym.IDENT, yytext()); }
					case -111:
						break;
					case 117:
						{return tok(sym.IDENT, yytext()); }
					case -112:
						break;
					case 118:
						{return tok(sym.IDENT, yytext()); }
					case -113:
						break;
					case 119:
						{return tok(sym.IDENT, yytext()); }
					case -114:
						break;
					case 120:
						{return tok(sym.IDENT, yytext()); }
					case -115:
						break;
					case 121:
						{return tok(sym.IDENT, yytext()); }
					case -116:
						break;
					case 122:
						{return tok(sym.IDENT, yytext()); }
					case -117:
						break;
					case 123:
						{return tok(sym.IDENT, yytext()); }
					case -118:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}

# Introduction

This project was developed as a practice exercise for the subject Format processing in telematic applications taught at 2014 @ UC3M (http://www.it.uc3m.es/luis/pfat/p1/)

This compiler from our specific grammar to Java performs:

* Lexical (JLex) and syntactical (CUP) analysis
* Grammar analysis
* Code generation, from our grammar to Java

The build script assumes that we have the folders `java_cup_v10k` ([manual](http://www.cs.princeton.edu/~appel/modern/java/CUP/manual.html), [source](http://pkgs.fedoraproject.org/repo/pkgs/java_cup/java_cup_v10k.tar.gz/8b11edfec13c590ea443d0f0ae0da479/java_cup_v10k.tar.gz)) and `JLex` ([manual](http://www.cs.princeton.edu/~appel/modern/java/JLex/current/manual.html), [source](https://www.cs.princeton.edu/~appel/modern/java/JLex/Archive/1.2.6/Main.java)) in the root folder.

# Source language

```
G=<ET, EN, S, P>

ET= {PROG, IDENT, IN, OUT, LOCAL, PC, TYPE,
COMMA, CBRAC, CKET, ASOP, IF, THEN,
ENDIF, CLOG, CINT, PLUS, BRAC,
KET, EQUALS}

EN= {<Prog>, <In>, <Out>, <Local>, <LDecl>, <Decl>, <Lvar>,
    <Body>, <Statement>, <StSimp>, <Assign>, <Cond>, <Exp>}

S= <Prog>

P= {
<Prog> -> PROG IDENT <In> <Out> <Local> <Body> 
       | PROG IDENT <In> <Out> <Body>,

<In> -> IN <LDecl>,

<Out> -> OUT <LDecl>,

<Local> -> LOCAL <LDecl>,

<LDecl> -> <Decl> PC
       | <Decl> PC <LDecl>,

<Decl> -> TYPE <Lvar>, 

<Lvar> -> IDENT
       | IDENT COMMA <Lvar>,
       
<Body> -> CBRAC <Statement> CKET,

<Statement> -> <StSimp> PC <Statement>,
       | <StSimp> PC,

<StSimp> -> <Assign>
	|   <Print>
	|   <Cond>
	|   <Loop>,

<Assign> -> IDENT ASOP <Exp>,

<Print> -> PRINT BRAC <Exp> KET,

<Cond> -> IF <Exp> THEN <Statement> END,

<Loop> -> WHEN <Exp> DO <Statement> END


```

# Tokens


```
COMA, PC, PAREN, TESIS, BEGIN, END, ASIG, AND, OR, NOT, IF,
THEN, PROG, DECL, WHILE, DO, PRINT, BRAC, KET, IN, UNION,
INTERSEC, CARD, LOWEST_ELEM, MAS, MENOS, MUL, DIV, MAYOR,
MENOR, IGUAL, INT2STR, EMPTYSET, UMINUS, CINT, CLOG, CSTR,
IDENT, TYPE

```

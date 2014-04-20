#!/bin/bash

rm -rf class/*
cd Errors
javac -d ../class/ *.java
cd ..
cd GeneratedCodeLib
javac -d ../class/ *.java
cd ..
cd Compiler/
#rm *.class
javac -cp ..:. -d ../class/ *.java
cd ..
cd AST/
javac -cp ..:.:../class -d ../class/ *.java
cd ..
java -cp java_cup_v10k/ java_cup.Main java/Parser/parser
#rm java/Parser/sym.java 
#rm java/Parser/Parser.java 

#mv sym.java ~/P2/java/Parser
#mv Parser.java ~/P2/java/Parser
javac -d class/ -cp java_cup_v10k:class/ java/Parser/sym.java java/Parser/parser.java 
java JLex.Main java/Lexer/Yylex
cd java/Lexer


javac -d ../../class/ -cp ../../java_cup_v10k/:../../class/ Yylex.java 
cd ..
javac -d ../class/ -cp ../class/:../java_cup_v10k/  Main.java
cd ../class
cd ..
echo
echo
echo
echo
echo ====== STARTING TESTS ======
echo
echo Ejem1 -  OK -- PASSED
echo ============================================
java -cp class:java_cup_v10k/ Main ejemplos/Ejem1/ejem1.prg
echo
echo
echo
echo Ejem2 -  OK -- PASSED
echo ============================================
java -cp class:java_cup_v10k/ Main ejemplos/Ejem2/ejem2.prg
echo
echo
echo
echo Ejem3 - OK -- PASSED
echo ============================================
java -cp class:java_cup_v10k/ Main ejemplos/Ejem3/ejem3.prg
echo
echo
echo
echo Ejem4 - OK -- PASSED
echo ============================================
java -cp class:java_cup_v10k/ Main ejemplos/Ejem4/ejem4.prg
echo
echo
echo
echo Ejem5 - OK -- PASSED
echo ============================================
java -cp class:java_cup_v10k/ Main ejemplos/Ejem5/ejem5.prg
echo
echo
echo
echo Ejem6 - OK -- PASSED
echo ============================================
java -cp class:java_cup_v10k/ Main ejemplos/Ejem6/ejem6.prg
echo
echo
echo
echo Ejem7  OK -- PASSED
echo ============================================
java -cp class:java_cup_v10k/ Main ejemplos/Ejem7/ejem7.prg
echo
echo
echo
echo ErrLex 1 -- ERROR sint 23
echo ============================================
java -cp class:java_cup_v10k/ Main ejemplos/ErrLex1/errLex1.prg
echo Err Lex 2 -- ERROR sint 9 ILLEGAL CARACTER PASSED
echo ============================================
java -cp class:java_cup_v10k/ Main ejemplos/ErrLex2/errLex2.prg
echo Err Sem1 --OK -- PASSED VARIABLES
echo ============================================
java -cp class:java_cup_v10k/ Main ejemplos/ErrSem1/errSem1.prg
echo
echo
echo
echo Err Sem2 --OK -- PASSED VARIABLES
echo ============================================
java -cp class:java_cup_v10k/ Main ejemplos/ErrSem2/errSem2.prg
echo
echo
echo
echo Err Sem3 --OK -- PASSED NOT A BOOLEAN
echo ============================================
java -cp class:java_cup_v10k/ Main ejemplos/ErrSem3/errSem3.prg
echo
echo
echo
echo Err Sem4 
echo ============================================
java -cp class:java_cup_v10k/ Main ejemplos/ErrSem4/errSem4.prg
echo
echo
echo
echo Err Sem5 --OK -- SHOULD INT2STR
echo ============================================
java -cp class:java_cup_v10k/ Main ejemplos/ErrSem5/errSem5.prg
echo
echo
echo
echo Err Sem6 -- OK -- PASSED INTEGER EXPECTED IN A SUM
echo ============================================
java -cp class:java_cup_v10k/ Main ejemplos/ErrSem6/errSem6.prg
echo
echo
echo
echo Err Sint1  -- PASSED error sint LINE 27
echo ============================================
java -cp class:java_cup_v10k/ Main ejemplos/ErrSint1/errSint1.prg
echo Err Sint1  -- PASSED error sint LINE 29
echo ============================================
java -cp class:java_cup_v10k/ Main ejemplos/ErrSint2/errSint2.prg
echo Err Sint1   -- PASSED error sint LINE 12
echo ============================================
java -cp class:java_cup_v10k/ Main ejemplos/ErrSint3/errSint3.prg



#from root
#bash build0.sh
echo ============================================
javac -cp class/:. Ejem1.java
java -cp class/:. Ejem1
echo ============================================
javac -cp class/:. Ejem2.java
java -cp class/:. Ejem2
echo ============================================
javac -cp class/:. Ejem3.java
java -cp class/:. Ejem3
echo ============================================
javac -cp class/:. Ejem4.java
java -cp class/:. Ejem4
echo ============================================
javac -cp class/:. Ejem5.java
java -cp class/:. Ejem5
echo ============================================
javac -cp class/:. Ejem6.java
java -cp class/:. Ejem6
echo ============================================
javac -cp class/:. Ejem7.java
java -cp class/:. Ejem7



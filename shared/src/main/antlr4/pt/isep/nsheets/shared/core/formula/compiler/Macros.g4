grammar Macros;

@header {
//    package pt.isep.nsheets.shared.core.formula.compiler;
}



macro
    : ((setVar NL?)+  | CCOMMENT)+
    ;

setVar
    :  EQUAL plusOrMinus
    ;


plusOrMinus
    : plusOrMinus PLUS multOrDiv    # Plus
    | plusOrMinus MINUS multOrDiv   # Minus
    | multOrDiv                     # ToMultOrDiv
    ;

multOrDiv
    : multOrDiv MULT pow    # Multiplication
    | multOrDiv DIV pow     # Division
    | pow                   # ToPow
    ;

pow
    : unaryMinus (POW pow)?     # Power
    ;

unaryMinus
    : MINUS unaryMinus      # ChangeSign
    | atom                  # ToAtom
    ;

atom
    : PI            # ConstantPI
    | E             # ConstantE
    | DOUBLE        # Double
    | INT           # Int
    | CELL_REF      # Cell
    | MACRO_REF     # Mac
    | LPAR plusOrMinus RPAR     # Braces
    ;


CELL_REF    :
     		    ( ABS )? LETTER ( LETTER )?
     		    ( ABS )? ( INT )+
     	        ;

MACRO_REF :
                ( AT ) ID
                ;


INT    : [0-9]+;
DOUBLE : [0-9]+'.'[0-9]+;
LETTER : [A-Z];
PI     : 'pi';
E      : 'e';
POW    : '^';
NL     : '\n';
WS     : [ \t\r]+ -> skip;
ID     : [a-zA-Z_][a-zA-Z_0-9]*;

fragment ABS : '$' ;
fragment AT : '@' ;

PLUS  : '+';
EQUAL : '=';
MINUS : '-';
MULT  : '*';
DIV   : '/';
LPAR  : '(';
RPAR  : ')';

CCOMMENT : ';' .*? '\n';
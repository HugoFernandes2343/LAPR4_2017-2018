grammar Macros;

@header {
//    package pt.isep.nsheets.shared.core.formula.compiler;
}



macro
    : ((setVar NL?)+  | CCOMMENT)+
    ;

setVar
    : ID EQUAL plusOrMinus  # SetVariable
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
    | ID            # Variable
    | CELL_REF      # Ref
    | LPAR plusOrMinus RPAR     # Braces
    ;

CELL_REF:
     		( ABS )? LETTER ( LETTER )?
     		( ABS )? ( INT )+
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

PLUS  : '+';
EQUAL : '=';
MINUS : '-';
MULT  : '*';
DIV   : '/';
LPAR  : '(';
RPAR  : ')';

CCOMMENT : ';' .*? '\n';
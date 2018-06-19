grammar Formula;
@header {
//    package pt.isep.nsheets.shared.core.formula.compiler;
}

expression
	: EQ comparison /* EOF */
	| EX assignment
	;

comparison
	: concatenation ( ( EQ | NEQ | GT | LT | LTEQ | GTEQ ) concatenation )?
	;

concatenation
        : ( MINUS )? atom
        | concatenation PERCENT
        | <assoc=right> concatenation POWER concatenation
        | concatenation ( MULTI | DIV ) concatenation
        | concatenation ( PLUS | MINUS ) concatenation
        | concatenation AMP concatenation
        ;

atom
	:	function_call
	|	reference
	|	literal
	|	LPAR comparison RPAR
    |   assignment
    |   block
    |   loopfor
    |   eval
    |   dowhile
    |   whiledo
	;

function_call
	:	FUNCTION LPAR
		( comparison ( SEMI comparison )* )?
		RPAR
	;

reference
	:	CELL_REF
		( ( COLON ) CELL_REF )?
                | VARIABLE
                | spreadsheet_reference
                | GLOBAL
	;

spreadsheet_reference
        :       spreadsheet_name PT reference
        ;

spreadsheet_name
                  : STRING
                  ;

literal
	:	NUMBER
	|	STRING
	;

VARIABLE
        : UND LETTER ( NUMBER | LETTER) *
        ;
GLOBAL
        : ARR LETTER ( NUMBER | LETTER) *
        ;

assignment
        :       reference ASSIGN comparison
        |       spreadsheet_reference ASSIGN comparison
        ;

block
        :       LCBRA comparison (SEMI comparison)* RCBRA
        ;

loopfor
        :       FOR LCBRA assignment SEMI comparison (SEMI comparison | SEMI assignment)+ RCBRA
        ;

dowhile
        :       DOWHILE LPAR comparison RPAR  LPAR eval RPAR
        ;

whiledo
        :       WHILEDO LPAR eval RPAR LCBRA comparison RCBRA
        ;

eval
    : EVAL LPAR STRING RPAR
;

/* loopfor operator */
EVAL    :       'EVAL'
        ;

FOR     : 'FOR';

DOWHILE      : 'DOWHILE';

WHILEDO   :'WHILEDO';

fragment LETTER: ('a'..'z'|'A'..'Z') ;

FUNCTION :
	  ( LETTER )+
	;


CELL_REF
     	:
     		( ABS )? LETTER ( LETTER )?
     		( ABS )? ( DIGIT )+
     	;

/* String literals, i.e. anything inside the delimiters */

STRING  : QUOT ('\\"' | ~'"')* QUOT
        ;


QUOT: '"'
	;

/* Numeric literals */
NUMBER: ( DIGIT )+ ( COMMA ( DIGIT )+ )? ;

fragment
DIGIT : '0'..'9' ;

/* Comparison operators */
EQ		: '=' ;
NEQ		: '<>' ;
LTEQ    : '<=' ;
GTEQ    : '>=' ;
GT		: '>' ;
LT		: '<' ;
EX      : '!';
PT      : '.';

/* Text operators */
AMP		: '&' ;
UND     : '_' ;
ARR     : '@' ;

/* Arithmetic operators */
PLUS	: '+' ;
MINUS	: '-' ;
MULTI	: '*' ;
DIV	: '/' ;
POWER	: '^' ;
PERCENT : '%' ;


/* Reference operators */
fragment ABS : '$' ;
fragment EXCL:  '!'  ;
COLON	: ':' ;

/* Miscellaneous operators */
COMMA	: ',' ;
SEMI	: ';' ;
LPAR	: '(' ;
RPAR	: ')' ;
LCBRA   : '{' ;
RCBRA   : '}' ;

/* assignment operator */
ASSIGN  : ':=';

/* White-space (ignored) */
WS: ( ' ' | '\r' '\n' | '\n' | '\t' ) -> skip ;

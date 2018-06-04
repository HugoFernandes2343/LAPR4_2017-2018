grammar Formula;
@header {
//    package pt.isep.nsheets.shared.core.formula.compiler;
}
	         
expression
	: EQ comparison /* EOF */
	;
	
comparison
	: concatenation
		( ( EQ | NEQ | GT | LT | LTEQ | GTEQ ) concatenation )?
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
        |       assignment
        |       block
        |       loopfor
	;

function_call
	:	FUNCTION LPAR
		( comparison ( SEMI comparison )* )?
		RPAR
	;

reference
	:	CELL_REF
		( ( COLON ) CELL_REF )?
	;

literal
	:	NUMBER
	|	STRING
	;

assignment  
        :       reference ASSIGN comparison
        ;

block
        :       LCBRA comparison (SEMI comparison)* RCBRA
        ;

loopfor
        :       FOR LCBRA assignment SEMI comparison (SEMI comparison | SEMI assignment)+ RCBRA
        ;

/* loopfor operator */
FOR     : 'FOR';

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
LTEQ            : '<=' ;
GTEQ            : '>=' ;
GT		: '>' ;
LT		: '<' ;

/* Text operators */
AMP		: '&' ;

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
	
	
 
grammar MonetaryLanguage;
@header {
//    package pt.isep.nsheets.shared.core.formula.compiler;
}

expressionMonetary
	: START (expression) /* EOF */
	;

expression
    : (EURO_FUN|POUND_FUN|DOLLAR_FUN) LCBRA (concatenation) RCBRA
    ;


concatenation
     : atom
     | concatenation ( MULTI | DIV ) concatenation
     | concatenation ( PLUS | MINUS ) concatenation
     ;

atom    
    :	literalMonetary
    | LPAR expression RPAR
    ;

literalMonetary
    :NUMBER (EURO_SIG|POUND_SIG|DOLLAR_SIG)
    ;

NUMBER: ( DIGIT )+ ( COMMA ( DIGIT )+ )? ;
DIGIT : '0'..'9' ;

EURO_FUN    :'euro';
POUND_FUN   :'pound';
DOLLAR_FUN  :'dollar';

EURO_SIG    :'e';
POUND_SIG   :'£';
DOLLAR_SIG  :'$';



/* Arithmetic operators */
PLUS	: '+' ;
MINUS	: '-' ;
MULTI	: '*' ;
DIV 	: '/' ;


/* Miscellaneous operators */
LCBRA   : '{' ;
RCBRA   : '}' ;
COMMA	: ',' ;
START   : '#';
LPAR	: '(' ;
RPAR	: ')' ;
grammar MonetaryLanguage;
@header {
//    package pt.isep.nsheets.shared.core.formula.compiler;
}

expressionMonetary
	: START (euroExpression|poundExpression|dollarExpression) /* EOF */
	;

euroExpression
    : EURO_FUN LCBRA (euroExpression|poundExpression|dollarExpression|concatenation) RCBRA
    ;

poundExpression
    : POUND_FUN LCBRA (euroExpression|poundExpression|dollarExpression|concatenation) RCBRA
    ;

dollarExpression
    : DOLLAR_FUN LCBRA (euroExpression|poundExpression|dollarExpression|concatenation) RCBRA
    ;

concatenation
     : atom
     | concatenation ( MULTI | DIV ) concatenation
     | concatenation ( PLUS | MINUS ) concatenation
     ;

atom
	:	literalMonetary
    |   (euroExpression|poundExpression|dollarExpression)
    ;

literalMonetary
    :NUMBER (EURO_SIG|POUND_SIG|DOLLAR_SIG)
    ;

NUMBER: ( DIGIT )+ ( COMMA ( DIGIT )+ )? ;
DIGIT : '0'..'9' ;

EURO_FUN    :'EURO'|'euro';
POUND_FUN   :'POUND'|'pound';
DOLLAR_FUN  :'DOLLAR'|'dollar';

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
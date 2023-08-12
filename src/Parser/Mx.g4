grammar Mx;

program: declaration*;

declaration:
    mainFn
    | varDef
    | classDef
    | funcDef
;
Void : 'void';
Bool : 'bool';
Int : 'int';
String : 'string';
New : 'new';
Class : 'class';
Null : 'null';
True : 'true';
False : 'false';
This : 'this';
If : 'if';
Else : 'else';
For : 'for';
While : 'while';
Break : 'break';
Continue : 'continue';
Return : 'return';

Plus : '+';
Minus : '-';
Multiply : '*';
Divide : '/';
Modulo : '%';

Less : '<';
LessEqual : '<=';
Greater : '>';
GreaterEqual : '>=';
Equal : '==';
NotEqual : '!=';

AndAnd : '&&';
OrOr : '||';
Not : '!';

LeftShift : '<<';
RightShift : '>>';
And : '&';
Or : '|';
Caret : '^';
Tilde : '~';

Assign : '=';
PlusPlus : '++';
MinusMinus : '--';
Dot : '.';
Semicolon : ';';
Comma : ',';

Leftparen: '(';
Rightparen: ')';
Leftbrace: '{';
Rightbrace: '}';

mainFn: 'int' 'main' '(' ')' suite;

//varDef : type Identifier ('=' expression)? (',' Identifier ('=' expression)?)* ';';

varDef : type varDefUnit (',' varDefUnit)* ';';

varDefUnit : Identifier ('=' expression)?;

constructionFuncDef : Identifier '(' ')' suite;

classComponent :
    varDef                  #classMember
    | constructionFuncDef   #constructionFunc
    | funcDef               #classMethod
;
classDef : Class classIdentifier=Identifier '{'
    classComponent*
'}'';';

//funcCall : Identifier '(' (expression (',' expression)*)? ')';
funcCall : Identifier '(' funcCallArglist? ')';

funcCallArglist : (expression (',' expression)*);

parameterList : type Identifier (',' type Identifier)*;

funcDef : returnType Identifier '(' parameterList? ')' suite;

suite : '{' statement* '}';

statement
    : suite                                                 #block
    | varDef                                                #vardefStmt
    | If '(' expression ')' trueStmt=statement
        (Else falseStmt=statement)?                         #ifStmt

    | While '(' expression ')' statement                    #whileStmt
//    | For '(' (initializationStatement=statement | ';')
//            (forConditionExpression=expression)? ';'
//            (stepExpression=expression)? ')' statement      #forStmt
    | For '(' init = varDef condition = expression? ';' step = expression? ')' statement            #vardefForStmt
    | For '(' init = expression? ';' condition = expression? ';' step = expression? ')' statement   #exprForStmt
    | Return expression? ';'                                #returnStmt
    | Break ';'                                             #breakStmt
    | Continue ';'                                          #continueStmt
    | expression ';'                                        #pureExprStmt
    | ';'                                                   #emptyStmt
    ;

expression
    :
    expression op=('++'|'--')                             #sufFixExpr
    | funcCall                                              #functionCallExpr
    | 'new' newType ('(' ')')?                                 #newExpr
    | expression '[' expression ']'                         #arrayExpr
    | expression '.' Identifier                             #memberVariableExpr
    | expression '.' funcCall                               #memberFuncExpr
    | <assoc=right> op=('++'|'--') expression               #preFixExpr
    | <assoc=right> Plus expression                         #unaryPlus
    | <assoc=right> Minus expression                        #unaryMinus
    | <assoc=right> Not expression                          #logicalNot
    | <assoc=right> Tilde expression                        #bitwiseNot
    | l=expression op=('*'|'/'|'%') r=expression                #binaryExpr
    | l=expression op=('+' | '-') r=expression                  #binaryExpr
    | l=expression op=('<<'|'>>') r=expression                  #binaryExpr
    | l=expression op=('<' | '<=' | '>' | '>=') r=expression    #binaryExpr
    | l=expression op=('==' | '!=' ) r=expression               #binaryExpr
    | l=expression op='&' r=expression                          #binaryExpr
    | l=expression op='^' r=expression                          #binaryExpr
    | l=expression op='|' r=expression                          #binaryExpr
    | l=expression op='&&' r=expression                         #binaryExpr
    | l=expression op='||' r=expression                         #binaryExpr
    | <assoc=right>expression '?' expression ':' expression     #ternaryConditional
    | <assoc=right> l=expression '=' r=expression               #assignExpr
    | primary                                               #atomExpr
;


primary
    : '(' expression ')'
    | literal
    | This
    | Identifier
    ;

literal
    : DecimalInteger
    | StringLiteral
    | logicalLiteral
    | Null
    ;



//type : singleType ('['expression']')* ('[]')*;
type
    : singleTypeName    #singleType
    | Identifier        #classType
    | type '[' ']'      #arrayType
;

newType
    : singleTypeName newArrayExprCount+ newArrayEmptyCount*     #newSingleArray
    | Identifier newArrayExprCount+ newArrayEmptyCount*         #newClassArray
    | Identifier                                                #newClass
;

newArrayExprCount : '[' expression ']';
newArrayEmptyCount : '[' expression? ']';

singleTypeName : Int | Bool | String;
returnType : Void | type;

Identifier
    : [a-zA-Z] [a-zA-Z_0-9]*
    ;

DecimalInteger
    : [1-9] [0-9]*
    | '0'
    ;

logicalLiteral : True | False;

StringLiteral
    : '"' ( ~["\\\n\r\u2028\u2029]
               | '\\' ('n' | '\\' | '"'))*  '"'
    ;

Whitespace
    :   [ \t]+
        -> skip
    ;

Newline
    :   (   '\r' '\n'?
        |   '\n'
        )
        -> skip
    ;

BlockComment
    :   '/*' .*? '*/'
        -> skip
    ;

LineComment
    :   '//' ~[\r\n]*
        -> skip
    ;
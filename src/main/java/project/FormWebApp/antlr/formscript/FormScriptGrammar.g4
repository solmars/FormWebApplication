// FormScriptGrammar.g4

grammar FormScriptGrammar;

start : expr ;


expr: formPhrase+; 





    
// this is enough for form phrases, because the answers will be passed by parameter on the visitor. and it is just a matter of verifying them.
formPhrase: IF variableAttribution THEN variableAttribution ENDLINE #twoVariableAttributionConditional
            |IF variableAttribution THEN obligatoriness ENDLINE  #variableAttributionObligatorinessConditional // default will assume non-obligatory
            |variableComparison ENDLINE #variableComparisonPhrase
            |obligatoriness ENDLINE # obligatorinessPhrase // default will assume non-obligatory
            |declaration ENDLINE # declarationPhrase
            |variableCompCalculation ENDLINE # variableComparisonCalculation
            ; 
    

value: INTEGER|BOOLEAN|FILE|STRING|DATE;

variableComparison: VARIABLE COMPARISON_OPERATORS VARIABLE;

variableAttribution: VARIABLE COMPARISON_OPERATORS value;

variableCompCalculation: VARIABLE COMPARISON_OPERATORS formCalculation;

declaration: name=VARIABLE 'IS' type=ATTRIBUTION; // for usage outside of helpdeskaservice application context.

obligatoriness: VARIABLE OBLIGATORY;

formCalculation : 	left=formCalculation op=('*'|'/') right=formCalculation # mulDiv
      | left=formCalculation op=('+'|'-') right=formCalculation # sumDif
      | atom=VARIABLE #calculationAtom
      ;
// LEXER

fragment A:('a'|'A');
fragment B:('b'|'B');
fragment C:('c'|'C');
fragment D:('d'|'D');
fragment E:('e'|'E');
fragment F:('f'|'F');
fragment G:('g'|'G');
fragment H:('h'|'H');
fragment I:('i'|'I');
fragment J:('j'|'J');
fragment K:('k'|'K');
fragment L:('l'|'L');
fragment M:('m'|'M');
fragment N:('n'|'N');
fragment O:('o'|'O');
fragment P:('p'|'P');
fragment Q:('q'|'Q');
fragment R:('r'|'R');
fragment S:('s'|'S');
fragment T:('t'|'T');
fragment U:('u'|'U');
fragment V:('v'|'V');
fragment W:('w'|'W');
fragment X:('x'|'X');
fragment Y:('y'|'Y');
fragment Z:('z'|'Z');
fragment DAY: [0-2][0-9]|'30'|'31';
fragment MONTH: [0][1-9]|'10'|'11'|'12';
fragment YEAR: [0-9][0-9][0-9][0-9];
fragment FILE_FRAGMENT: F I L E ':';

DATE: DAY '-' MONTH '-' YEAR;
FILE: FILE_FRAGMENT '"' .*? '"';
INTEGER : ('0'..'9')+;
STRING : '"' .*? '"';
BOOLEAN : T R U E | F A L S E;
IF: I F;
THEN: T H E N;
VARIABLE: V '_' [0-9]+;
ATTRIBUTION: I N T E G E R | B O O L E A N | F I L E| S T R I N G | D A T E;
COMPARISON_OPERATORS : '=' | '<' | '>';
OBLIGATORY: O B L I G A T O R Y; // default will be non-obligatory for each attribute
ENDLINE: ';';
WS : [ \t\r\n]+ -> skip ;
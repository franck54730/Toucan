package toucan.analyse ;

import java_cup.runtime.*;
      
%%
   
%class AnalyseurLexical
%public

%line
%column
    
%type Symbol
%eofval{
        return symbol(CodesLexicaux.EOF) ;
%eofval}

%cup
   
%{
  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn) ;
  }

  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value) ;
  }
%}
%state commentaire

commentaireSlashSlash = [/][/].*
commentaireSlashEtoile = [/][*]
commentaireEtoileSlash = [*][/]

chiffre = [0-9]
cste = {chiffre}+

idf = [a-z][a-zA-Z0-9]*

typePrimitif = "byte"|"short"|"long"|"float"|"int"|"double"|"boolean"|"char"
op = "+"|"-"|"/"|"*"

%%

<YYINITIAL>";"                		{ return symbol(CodesLexicaux.POINTVIRGULE); }

<YYINITIAL>"="                		{ return symbol(CodesLexicaux.EGAL); }

<YYINITIAL>"("                		{ return symbol(CodesLexicaux.PAROUV); }

<YYINITIAL>")"                		{ return symbol(CodesLexicaux.PARFER); }

<YYINITIAL>"["                		{ return symbol(CodesLexicaux.CROOUV); }

<YYINITIAL>"]"                		{ return symbol(CodesLexicaux.CROFER); }

<YYINITIAL>"tab"                	{ return symbol(CodesLexicaux.TAB); }

<YYINITIAL>{typePrimitif}		{ return symbol(CodesLexicaux.TYPEPRIMITIF, yytext()); }

<YYINITIAL>{idf}			{ return symbol(CodesLexicaux.IDF, yytext()) ; }

<YYINITIAL>{cste}			{ return symbol(CodesLexicaux.CSTE, yytext()) ; }

<YYINITIAL>{op}				{ return symbol(CodesLexicaux.OP, yytext()) ; }

<YYINITIAL> {commentaireSlashSlash} 	{ }

<YYINITIAL> {commentaireSlashEtoile}	{ yybegin(commentaire) ; }

<commentaire> {commentaireEtoileSlash} 	{ yybegin(YYINITIAL) ; }
.                       {}
\n                      {}

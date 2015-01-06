package compteurs ;
%%
%{
private int nbTab ;
private int nbNbCases ;
public int nbNbCasesOccurence() {
return nbNbCases ;
}
public int nbTabOccurence() {
return nbTab ;
}
%}
%init{
nbTab = 0 ;
%init}
%init{
nbNbCases = 0 ;
%init}
%public
%class CptEgal
%function analyser
%integer
%%
"tab" { nbTab++ ;}
"nbCases" { nbNbCases++ ;}
\n {}
. {}
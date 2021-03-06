
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Fri Jan 09 04:07:42 CET 2015
//----------------------------------------------------

package toucan.analyse;

import java_cup.runtime.*;
import toucan.model.arbre.*;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Fri Jan 09 04:07:42 CET 2015
  */
public class AnalyseurSyntaxique extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public AnalyseurSyntaxique() {super();}

  /** Constructor which sets the default scanner. */
  public AnalyseurSyntaxique(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public AnalyseurSyntaxique(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\022\000\002\002\004\000\002\002\003\000\002\005" +
    "\004\000\002\005\003\000\002\006\004\000\002\006\004" +
    "\000\002\004\004\000\002\004\006\000\002\004\011\000" +
    "\002\007\013\000\002\007\010\000\002\007\010\000\002" +
    "\007\005\000\002\010\005\000\002\010\005\000\002\010" +
    "\003\000\002\010\003\000\002\003\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\053\000\014\005\016\011\010\015\011\016\005\017" +
    "\004\001\002\000\014\004\ufff1\007\ufff1\010\ufff1\012\ufff1" +
    "\020\ufff1\001\002\000\014\004\ufff2\007\ufff2\010\ufff2\012" +
    "\ufff2\020\ufff2\001\002\000\004\002\055\001\002\000\016" +
    "\002\ufffe\005\ufffe\011\ufffe\015\ufffe\016\ufffe\017\ufffe\001" +
    "\002\000\010\011\010\016\005\017\004\001\002\000\004" +
    "\017\044\001\002\000\004\010\036\001\002\000\004\004" +
    "\035\001\002\000\004\004\034\001\002\000\016\002\000" +
    "\005\016\011\010\015\011\016\005\017\004\001\002\000" +
    "\004\006\022\001\002\000\010\007\ufff0\010\ufff0\020\020" +
    "\001\002\000\010\011\010\016\005\017\004\001\002\000" +
    "\014\004\ufff4\007\ufff4\010\ufff4\012\ufff4\020\ufff4\001\002" +
    "\000\010\011\010\016\005\017\004\001\002\000\004\007" +
    "\024\001\002\000\004\010\025\001\002\000\012\005\026" +
    "\011\010\016\005\017\004\001\002\000\004\006\030\001" +
    "\002\000\006\004\ufff7\020\020\001\002\000\010\011\010" +
    "\016\005\017\004\001\002\000\004\007\032\001\002\000" +
    "\004\004\ufff8\001\002\000\016\002\uffff\005\uffff\011\uffff" +
    "\015\uffff\016\uffff\017\uffff\001\002\000\016\002\ufffc\005" +
    "\ufffc\011\ufffc\015\ufffc\016\ufffc\017\ufffc\001\002\000\016" +
    "\002\ufffd\005\ufffd\011\ufffd\015\ufffd\016\ufffd\017\ufffd\001" +
    "\002\000\012\005\037\011\010\016\005\017\004\001\002" +
    "\000\004\006\041\001\002\000\006\004\ufff5\020\020\001" +
    "\002\000\010\011\010\016\005\017\004\001\002\000\004" +
    "\007\043\001\002\000\004\004\ufff6\001\002\000\006\004" +
    "\ufffb\010\045\001\002\000\012\005\046\011\010\016\005" +
    "\017\004\001\002\000\004\006\050\001\002\000\006\004" +
    "\ufffa\020\020\001\002\000\010\011\010\016\005\017\004" +
    "\001\002\000\004\007\052\001\002\000\004\004\ufff9\001" +
    "\002\000\006\012\054\020\020\001\002\000\014\004\ufff3" +
    "\007\ufff3\010\ufff3\012\ufff3\020\ufff3\001\002\000\004\002" +
    "\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\053\000\020\002\005\003\011\004\012\005\014\006" +
    "\006\007\013\010\016\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\010" +
    "\052\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\014\003\011\004\012\006" +
    "\032\007\013\010\016\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\010\020\001\001\000\002\001\001\000" +
    "\006\003\022\010\016\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\010\026\001\001\000\002\001\001\000" +
    "\002\001\001\000\006\003\030\010\016\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\010\037\001\001\000\002" +
    "\001\001\000\002\001\001\000\006\003\041\010\016\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\010\046\001\001\000\002\001\001\000\002\001" +
    "\001\000\006\003\050\010\016\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$AnalyseurSyntaxique$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$AnalyseurSyntaxique$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$AnalyseurSyntaxique$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    /* Change the method report_error so it will display the line and column of where the error
       occurred in the input as well as the reason for the error which is passed into the method
       in the String 'message'. */
    public void report_error(String message, Object info) {
   
        /* Create a StringBuffer called 'm' with the string 'Error' in it. */
        StringBuffer m = new StringBuffer("Error");
   
        /* Check if the information passed to the method is the same type as the type 
           java_cup.runtime.Symbol. */
        if (info instanceof java_cup.runtime.Symbol) {
            /* Declare a java_cup.runtime.Symbol object 's' with the information in the object 
               info that is being typecasted as a java_cup.runtime.Symbol object. */
            java_cup.runtime.Symbol s = ((java_cup.runtime.Symbol) info);
   
            /* Check if the line number in the input is greater or equal to zero. */
            if (s.left >= 0) {                
                /* Add to the end of the StringBuffer error message the line number of the error 
                   in the input. */
                m.append(" in line "+(s.left+1));   
                /* Check if the column number in the input is greater or equal to zero. */
                if (s.right >= 0)                    
                    /* Add to the end of the StringBuffer error message the column number of the 
                       error in the input. */
                    m.append(", column "+(s.right+1));
            }
        }
        /* Add to the end of the StringBuffer error message created in this method the message that
           was passed into this method. */
        m.append(" : "+message);
   
        /* Print the contents of the StringBuffer 'm', which contains an error message, out on 
           a line. */
        //System.err.println(m);
    }
    /* Change the method report_fatal_error so when it reports a fatal error it will display the 
       line and column number of where the fatal error occurred in the input as well as the reason
       for the fatal error which is passed into the method in the object 'message' and then exit.*/
    public void report_fatal_error(String message, Object info) {
        report_error(message, info);
        //System.exit(1);
    }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$AnalyseurSyntaxique$actions {

 /* vide pour le moment */
	    
  private final AnalyseurSyntaxique parser;

  /** Constructor */
  CUP$AnalyseurSyntaxique$actions(AnalyseurSyntaxique parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$AnalyseurSyntaxique$do_action(
    int                        CUP$AnalyseurSyntaxique$act_num,
    java_cup.runtime.lr_parser CUP$AnalyseurSyntaxique$parser,
    java.util.Stack            CUP$AnalyseurSyntaxique$stack,
    int                        CUP$AnalyseurSyntaxique$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$AnalyseurSyntaxique$result;

      /* select the action based on the action number */
      switch (CUP$AnalyseurSyntaxique$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // INDICE ::= EXP 
            {
              ArbreAbstrait RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		ArbreAbstrait e = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new AutreInstruction(e.getCodeDecorer()) ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("INDICE",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // EXP ::= IDF 
            {
              ArbreAbstrait RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new AutreInstruction(i) ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXP",6, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // EXP ::= CSTE 
            {
              ArbreAbstrait RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		String c = (String)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new AutreInstruction(c) ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXP",6, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // EXP ::= PAROUV EXP PARFER 
            {
              ArbreAbstrait RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		ArbreAbstrait e1 = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		 RESULT = new AutreInstruction("("+e1.getCodeDecorer()+")"); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXP",6, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // EXP ::= EXP OP EXP 
            {
              ArbreAbstrait RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		ArbreAbstrait e1 = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int oleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int oright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		String o = (String)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		ArbreAbstrait e2 = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new AutreInstruction(e1.getCodeDecorer() + " " + o + " " + e2.getCodeDecorer()) ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXP",6, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // AFF ::= INDICE EGAL EXP 
            {
              ArbreAbstrait RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int vright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		ArbreAbstrait v = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		ArbreAbstrait e = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new InstructionAffectationVariable(e.getCodeDecorer(), v.getCodeDecorer()); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("AFF",5, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // AFF ::= INDICE EGAL TAB CROOUV INDICE CROFER 
            {
              ArbreAbstrait RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-5)).left;
		int vright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-5)).right;
		ArbreAbstrait v = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-5)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		ArbreAbstrait a = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		 RESULT = new InstructionAffectationCaseVariable(a.getCodeDecorer(),v.getCodeDecorer()) ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("AFF",5, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-5)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // AFF ::= TAB CROOUV INDICE CROFER EGAL EXP 
            {
              ArbreAbstrait RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-3)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-3)).right;
		ArbreAbstrait a = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-3)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		ArbreAbstrait e = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new InstructionAffectationVariableCase(a.getCodeDecorer(),e.getCodeDecorer()); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("AFF",5, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-5)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // AFF ::= TAB CROOUV INDICE CROFER EGAL TAB CROOUV INDICE CROFER 
            {
              ArbreAbstrait RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-6)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-6)).right;
		ArbreAbstrait a = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-6)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		ArbreAbstrait b = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		 RESULT = new InstructionAffectationCaseCase(a.getCodeDecorer(),b.getCodeDecorer()); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("AFF",5, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-8)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // DECL ::= TYPEPRIMITIF IDF EGAL TAB CROOUV INDICE CROFER 
            {
              ArbreAbstrait RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-6)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-6)).right;
		String t = (String)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-6)).value;
		int ileft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-5)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-5)).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-5)).value;
		int nleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int nright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		ArbreAbstrait n = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		 RESULT = new DeclarationAffectationCaseVariable(t, i, n.getCodeDecorer()); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("DECL",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-6)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // DECL ::= TYPEPRIMITIF IDF EGAL EXP 
            {
              ArbreAbstrait RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-3)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-3)).right;
		String t = (String)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-3)).value;
		int ileft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		ArbreAbstrait e = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new DeclarationAffectationVariable(t, i, e.getCodeDecorer()); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("DECL",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-3)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // DECL ::= TYPEPRIMITIF IDF 
            {
              ArbreAbstrait RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		String t = (String)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		int ileft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Declaration(t, i); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("DECL",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // INST ::= AFF POINTVIRGULE 
            {
              ArbreAbstrait RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		ArbreAbstrait a = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		 RESULT = new AutreInstruction(a.getCodeDecorer()+" ;"); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("INST",4, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // INST ::= DECL POINTVIRGULE 
            {
              ArbreAbstrait RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		ArbreAbstrait d = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		 RESULT = new AutreInstruction(d.getCodeDecorer()+" ;"); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("INST",4, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // LINST ::= INST 
            {
              ArbreAbstrait RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		ArbreAbstrait i = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		  RESULT = new BlocDInstruction(); 
			((BlocDInstruction)RESULT).ajouter(i); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("LINST",3, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // LINST ::= LINST INST 
            {
              ArbreAbstrait RESULT =null;
		int lileft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int liright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		ArbreAbstrait li = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		int ileft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		ArbreAbstrait i = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		  ((BlocDInstruction)li).ajouter(i);
			RESULT = li; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("LINST",3, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // PROG ::= LINST 
            {
              ArbreAbstrait RESULT =null;
		int lileft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int liright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		ArbreAbstrait li = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = li; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("PROG",0, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= PROG EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		ArbreAbstrait start_val = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		RESULT = start_val;
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$AnalyseurSyntaxique$parser.done_parsing();
          return CUP$AnalyseurSyntaxique$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.blue.s1.lang.s1150371.macros;




import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.lang.Language;
import pt.isep.nsheets.shared.core.formula.lang.LanguageManager;

/**
 *
 * @author josea
 */
public class Antlr4Macros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ANTLRInputStream input = new ANTLRInputStream("a=6+2+2 b=a+2 c=b+3");
        MacrosLexer lexer = new MacrosLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MacrosParser parser = new MacrosParser(tokens);
        ParseTree tree = parser.input();
       
        MacrosBaseVisitorImp calcVisitor = new  MacrosBaseVisitorImp();
        Double result = calcVisitor.visit(tree);
        System.out.println("Result: " + result);
        
       
         
         
    }
    
}

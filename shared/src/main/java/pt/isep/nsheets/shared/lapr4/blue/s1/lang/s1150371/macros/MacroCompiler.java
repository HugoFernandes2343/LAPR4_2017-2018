/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.blue.s1.lang.s1150371.macros;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import pt.isep.nsheets.shared.core.formula.compiler.MacrosLexer;
import pt.isep.nsheets.shared.core.formula.compiler.MacrosParser;

/**
 *
 * @author josea
 */

public class MacroCompiler {
    private Macro m;
    
    public MacroCompiler(Macro m){
        this.m=m;
    }
    
    public Double compile(){
        ANTLRInputStream input = new ANTLRInputStream(this.m.getInput());
        MacrosLexer lexer = new MacrosLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MacrosParser parser = new MacrosParser(tokens);
        ParseTree tree = parser.macro();
       
        MacrosBaseVisitorImp calcVisitor = new  MacrosBaseVisitorImp();
        Double result = calcVisitor.visit(tree);
        return result;
    }
    
}

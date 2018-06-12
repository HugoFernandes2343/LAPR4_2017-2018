/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core.formula.compiler;

import java.util.Collections;
import java.util.List;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.tree.ParseTree;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.lang.Language;
import pt.isep.nsheets.shared.core.formula.lang.LanguageManager;

/**
 *
 * @author Paulo Jorge
 */
public class ExcelMonetaryExpressionCompiler implements ExpressionCompiler {

    /**
     * The character that signals that a cell's content is a formula ('#')
     */
    public static final char FORMULA_STARTER = '#';

    private Language language = null;

    public ExcelMonetaryExpressionCompiler() {
        language = LanguageManager.getInstance().getLanguage("excelMonetary");
    }

    @Override
    public char getStarter() {
        return FORMULA_STARTER;
    }

    @Override
    public Expression compile(Cell cell, String source) throws FormulaCompilationException {
        ANTLRInputStream input = new ANTLRInputStream(source);

        MonetaryLanguageLexer lexer = new MonetaryLanguageLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        MonetaryLanguageParser parser = new MonetaryLanguageParser(tokens);

        FormulaErrorListener formulaErrorListener = new FormulaErrorListener();
        parser.removeErrorListeners(); // remove default ConsoleErrorListener
        parser.addErrorListener(formulaErrorListener); // add ours

        ParseTree tree = parser.expressionMonetary();
        if (parser.getNumberOfSyntaxErrors() > 0) {
            throw new FormulaCompilationException(formulaErrorListener.getErrorMessage());
        }

        // Visit the expression and returns it
        MonetaryEvalVisitor eval = new MonetaryEvalVisitor(cell, language);
        Expression result = eval.visit(tree);
        if (eval.getNumberOfErrors() > 0) {
            throw new FormulaCompilationException(eval.getErrorsMessage());
        }

        return result;
    }

    public static class FormulaErrorListener extends BaseErrorListener {

        private StringBuilder buf;

        public String getErrorMessage() {
            return buf.toString();
        }

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer,
                Object offendingSymbol,
                int line, int charPositionInLine,
                String msg,
                RecognitionException e) {
            List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
            Collections.reverse(stack);

            buf = new StringBuilder();
            buf.append("line ").append(line).append(":").append(charPositionInLine).append(": ").append(msg);
        }
    }

}

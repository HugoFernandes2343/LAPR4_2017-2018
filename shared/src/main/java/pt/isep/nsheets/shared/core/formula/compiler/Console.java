/*
 * Copyright (c) 2005 Einar Pehrson <einar@pehrson.nu>.
 *
 * This file is part of
 * CleanSheets - a spreadsheet application for the Java platform.
 *
 * CleanSheets is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * CleanSheets is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CleanSheets; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 * 
 * ATB (April, 2014): Updated to use antlr3 generated parser and lexer
 * JRT (May, 2017): Uptated to use antlr4
 */
package pt.isep.nsheets.shared.core.formula.compiler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import org.antlr.v4.runtime.RecognitionException;
// import org.antlr.v4.collections.AST;
import pt.isep.nsheets.shared.core.Address;
import pt.isep.nsheets.shared.core.Cell;
import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.Formula;

/**
 * A test-class for processing formulas from an input stream.
 *
 * @author Einar Pehrson
 */
public class Console {

	/**
	 * Creates a new console for the given input stream.
	 *
	 * @param in
	 *            the input stream from which formulas are read
	 * @param out
	 *            the output stream to which messages are written
	 */
	public Console(InputStream in, OutputStream out) {
		// Wraps the output stream
		PrintStream printer;
		if (out instanceof PrintStream) {
			printer = (PrintStream) out;
		} else {
			printer = new PrintStream(out);
		}

		// Fetches a cell
		Workbook workbook = new Workbook("Workbook", "New Workbook 123","");
		Spreadsheet sheet = workbook.getSheet();
		Cell cell = sheet.getCell(new Address(0, 0));

		// Reads and compiles input
		// ExcelExpressionCompiler compiler = new ExcelExpressionCompiler();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				try {
					Formula formula = FormulaCompiler.getInstance().compile(cell, line);

					Expression expression = formula.getExpression();
					printer.println("Formula: " + expression + " = " + expression.evaluate());

					// ANTLRInputStream input = new ANTLRInputStream(line);
					//
					// // create the buffer of tokens between the lexer and parser
					// FormulaLexer lexer = new FormulaLexer(input);
					// CommonTokenStream tokens = new CommonTokenStream(lexer);
					//
					// FormulaParser parser = new FormulaParser(tokens);
					// try {
					// ParseTree tree = parser.expression();
					// FormulaEvalVisitor eval = new FormulaEvalVisitor(cell);
					// Expression expression = eval.visit(tree);
					// printer.println("Formula: " + expression + " = " + expression.evaluate());
					// }

				} catch (RecognitionException e) {
					// String message="Fatal recognition exception " + e.getClass().getName()+ " : "
					// + e;
					// String message = parser.getErrorMessage(e, parser.tokenNames);
					// printer.println("At (" + e.line + ";" + e.charPositionInLine + "): " +
					// message);
					printer.println(e.getLocalizedMessage());
				} catch (IllegalValueTypeException e) {
					// System.err.println(e);
					printer.println(e.getLocalizedMessage());
				} catch (FormulaCompilationException e) {
					printer.println(e.getLocalizedMessage());
				}

			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	/**
	 * Creates a new console for the command-line.
	 *
	 * @param args
	 *            the command-line arguments (ignored)
	 */
	public static void main(String[] args) {
		new Console(System.in, System.out);
	}
}

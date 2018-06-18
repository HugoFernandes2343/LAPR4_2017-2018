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
 */
package pt.isep.nsheets.shared.core.formula.lang;

import pt.isep.nsheets.shared.core.IllegalValueTypeException;
import pt.isep.nsheets.shared.core.Value;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.Function;
import pt.isep.nsheets.shared.core.formula.FunctionParameter;

/**
 * A function that returns the factorial of its argument.
 * @author Einar Pehrson
 */
public class Factorial implements Function {

	/** The only parameter: a numeric term */
	public static final FunctionParameter[] parameters = new FunctionParameter[] {
		new FunctionParameter(Value.Type.NUMERIC, "Number", false,
			"The positive integer for which to calculate the factorial")
	};

	/**
	 * Creates a new instance of the FACT function.
	 */
	public Factorial() {}

	public String getIdentifier() {
		return "FACT";
	}

	public Value applyTo(Expression[] arguments) throws IllegalValueTypeException {
		double number = arguments[0].evaluate().toDouble();
		if (number >= 1 && number == Math.round(number)) {
			int factorial = 1;
			for (int i = 2; i <= number; i++)
				factorial *= i;
			return new Value(factorial);
		} else
			return new Value(new IllegalArgumentException("Argument must be a positive integer"));
	}

	public FunctionParameter[] getParameters() {
		return parameters;
	}

	public boolean isVarArg() {
		return false;
	}

	@Override
	public String funcDescription() {
		return null;
	}

	@Override
	public String funcName() {
		return null;
	}

	@Override
	public String funcSyntax() {
		return null;
	}
}
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
 * A function that returns the boolean value false.
 * @author Einar Pehrson
 */
public class False implements Function {

	/** The empty parameter list */
	public static final FunctionParameter[] parameters = new FunctionParameter[]{};

	/**
	 * Creates a new instance of the FALSE function.
	 */
	public False() {}

	public String getIdentifier() {
		return "FALSE";
	}

	public Value applyTo(Expression[] arguments) throws IllegalValueTypeException {
		return new Value(false);
	}

	public FunctionParameter[] getParameters() {
		return parameters;
	}

	public boolean isVarArg() {
		return false;
	}

	@Override
	public String funcDescription() {
		return "dETERMINATES FALSE";
	}

	@Override
	public String funcName() {
		return "False";
	}

	@Override
	public String funcSyntax() {
		return "FALSE()";
	}
}
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
package pt.isep.nsheets.shared.core.formula.util;

import pt.isep.nsheets.shared.core.formula.BinaryOperation;
import pt.isep.nsheets.shared.core.formula.Expression;
import pt.isep.nsheets.shared.core.formula.FunctionCall;
import pt.isep.nsheets.shared.core.formula.Literal;
import pt.isep.nsheets.shared.core.formula.Reference;
import pt.isep.nsheets.shared.core.formula.UnaryOperation;
import pt.isep.nsheets.shared.core.formula.lapr4.blue.s1.lang.n1140420.tempVariables.VariableReference;

/**
 * A default implementation of an expression visitor, that simply visits all
 * the nodes in the tree. All methods return the expression that was visited.
 * @author Einar Pehrson
 */
public abstract class AbstractExpressionVisitor implements ExpressionVisitor {

	/**
	 * Creates a new expression visitor.
	 */
	public AbstractExpressionVisitor() {}

	public Object visitLiteral(Literal literal) {
		return literal;
	}

	public Object visitUnaryOperation(UnaryOperation operation) {
		operation.getOperand().accept(this);
		return operation;
	}

	public Object visitBinaryOperation(BinaryOperation operation) {
		operation.getLeftOperand().accept(this);
		operation.getRightOperand().accept(this);
		return operation;
	}

	public Object visitReference(Reference reference) {
		return reference;
	}

        public Object visitVariableReference(VariableReference varReference) {
		return varReference;
	}
        
	public Object visitFunctionCall(FunctionCall call) {
		for (Expression argument : call.getArguments())
			argument.accept(this);
		return call;
	}
        
//        public Object visitNaryOperation(NaryOperation operation) {
//            Expression[] operands=operation.getOperands();
//        
//            for (Expression expr: operands) {
//                expr.accept(this);
//            }
//        
//            return operation;
//        }
}
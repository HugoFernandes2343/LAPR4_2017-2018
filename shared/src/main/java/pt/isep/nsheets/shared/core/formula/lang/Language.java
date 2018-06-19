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

import pt.isep.nsheets.shared.lapr4.blue.s1.lang.s1091234.blockOfInstructions.Assignment;
import pt.isep.nsheets.shared.lapr4.blue.s1.lang.s1091234.blockOfInstructions.For;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//import pt.isep.nsheets.shared.CleanSheets;
import pt.isep.nsheets.shared.core.formula.BinaryOperator;
import pt.isep.nsheets.shared.core.formula.Function;
import pt.isep.nsheets.shared.core.formula.UnaryOperator;
import pt.isep.nsheets.shared.lapr4.blue.s1.lang.s1091234.blockOfInstructions.Block;

/**
 * A factory for creating certain types of language elements.
 *
 * @author Einar Pehrson
 */
public class Language {

//	/** The singleton instance */
//	private static final Language instance = new Language();
//
//	/** The name of the file in which language properties are stored */
//	private static final String PROPERTIES_FILENAME = "res/language.props";
    /**
     * The unary operators that are supported by the language
     */
    protected List<UnaryOperator> unaryOperators = new ArrayList<UnaryOperator>();

    /**
     * The binary operators that are supported by the language
     */
    protected List<BinaryOperator> binaryOperators = new ArrayList<BinaryOperator>();

    final List<RelationalOperator> relOperators = new ArrayList<>();

    public List<RelationalOperator> relationalOperators() {
        relOperators.add(new Equal());
        relOperators.add(new NotEqual());
        relOperators.add(new GreaterThan());
        relOperators.add(new GreaterThanOrEqual());
        relOperators.add(new LessThan());
        relOperators.add(new LessThanOrEqual());

        return relOperators;
    }

    /**
     * The functions that are supported by the language
     */
    protected List<Function> functions = new ArrayList<Function>();

    private final String name;

    public String getName() {
        return this.name;
    }

    protected void initFunctions() {
        functions.add(new Average());
        functions.add(new And());
        functions.add(new Count());
        functions.add(new Do());
        functions.add(new Factorial());
        functions.add(new False());
        functions.add(new If());
        functions.add(new Not());
        //functions.add(new NumericFunction());
        functions.add(new Or());
        functions.add(new Sum());
        functions.add(new True());
        functions.add(new For());
        functions.add(new Block());
       //functions.add(new Eval());
     //  functions.add(new DoWhile());
   //    functions.add(new WhileDo());
    }

    protected void initBinaryOperators() {
        binaryOperators.add(new Adder());
        binaryOperators.add(new Concatenator());
        binaryOperators.add(new Divider());
        binaryOperators.add(new Equal());
        binaryOperators.add(new Exponentiator());
        binaryOperators.add(new GreaterThan());
        binaryOperators.add(new GreaterThanOrEqual());
        binaryOperators.add(new LessThan());
        binaryOperators.add(new LessThanOrEqual());
        binaryOperators.add(new Multiplier());
        binaryOperators.add(new NotEqual());
        binaryOperators.add(new RangeReference());
        binaryOperators.add(new Subtracter());
        binaryOperators.add(new Assignment());
    }

    protected void initUnaryOperators() {
        // functions.add(new Average());
        unaryOperators.add(new Negator());
        unaryOperators.add(new Percent());
    }

    /**
     * Creates a new language.
     */
    public Language(String name) {
        this.name = name;
        initFunctions();
        initBinaryOperators();
        initUnaryOperators();
    }

//	private Language() {
//		// Loads properties
//		Properties language = new Properties();
//		InputStream stream = null; // = CleanSheets.class.getResourceAsStream(PROPERTIES_FILENAME);
//		if (stream != null) {
//			try {
//				language.load(stream);
//			} catch (IOException e) {
//				System.err.println("An I/O error occurred when loading language" + " properties file ("
//						+ PROPERTIES_FILENAME + ").");
//				return;
//			} finally {
//				try {
//					if (stream != null)
//						stream.close();
//				} catch (IOException e) {
//				}
//			}
//
//			// Loads elements
//			for (Object className : language.keySet()) {
//				// Loads class and instantiates element
//				Class elementClass;
//				Object element;
//				try {
//					elementClass = Class.forName(getClass().getPackage().getName() + "." + (String) className);
//					element = elementClass.newInstance();
//				} catch (Exception e) {
//					// Skip this element, regardless of what went wrong
//					continue;
//				}
//
//				// Stores element
//				if (Function.class.isAssignableFrom(elementClass))
//					functions.add(Function.class.cast(element));
//				if (BinaryOperator.class.isAssignableFrom(elementClass))
//					binaryOperators.add(BinaryOperator.class.cast(element));
//				if (UnaryOperator.class.isAssignableFrom(elementClass))
//					unaryOperators.add(UnaryOperator.class.cast(element));
//
//			}
//		} else
//			System.err.println("Could not find language properties file (" + PROPERTIES_FILENAME + ").");
//
//		// Loads static methods from java.lang.Math that use double precision
//		for (Method method : Math.class.getMethods())
//			if (Modifier.isStatic(method.getModifiers()) && method.getReturnType() == Double.TYPE)
//				functions.add(new NumericFunction(method));
//	}
    /**
     * Returns the singleton instance.
     *
     * @return the singleton instance
     */
//	public static Language getInstance() {
//		return instance;
//	}
    /**
     * Returns the unary operator with the given identifier.
     *
     * @param identifier identifier
     * @return the unary operator with the given identifier
     * @throws csheets.core.formula.lang.UnknownElementException exception
     */
    public UnaryOperator getUnaryOperator(String identifier) throws UnknownElementException {
        for (UnaryOperator operator : unaryOperators) {
            if (identifier.equalsIgnoreCase(operator.getIdentifier())) {
                return operator; // .clone()
            }
        }
        throw new UnknownElementException(identifier);
    }

    /**
     * Returns the binary operator with the given identifier.
     *
     * @param identifier identifier
     * @return the binary operator with the given identifier
     * @throws csheets.core.formula.lang.UnknownElementException exception
     */
    public BinaryOperator getBinaryOperator(String identifier) throws UnknownElementException {
        for (BinaryOperator operator : binaryOperators) {
            if (identifier.equalsIgnoreCase(operator.getIdentifier())) {
                return operator; // .clone()
            }
        }
        throw new UnknownElementException(identifier);
    }

    /**
     * Returns the function with the given identifier.
     *
     * @param identifier identifier
     * @return the function with the given identifier
     * @throws csheets.core.formula.lang.UnknownElementException exception
     */
    public Function getFunction(String identifier) throws UnknownElementException {
        for (Function function : functions) {
            if (identifier.equalsIgnoreCase(function.getIdentifier())) {
                return function; // .clone()
            }
        }
        throw new UnknownElementException(identifier);
    }

    /**
     * Returns whether there is a function with the given identifier.
     *
     * @param identifier identifier
     * @return whether there is a function with the given identifier
     */
    public boolean hasFunction(String identifier) {
        try {
            return getFunction(identifier) != null;
        } catch (UnknownElementException e) {
            return false;
        }
    }

    /**
     * Returns the functions that are supported by the syntax.
     *
     * @return the functions that are supported by the syntax
     */
    public Function[] getFunctions() {
        return functions.toArray(new Function[functions.size()]);
    }
}

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package eapli.framework.actions;

/**
 * @author Paulo Gandra Sousa
 */
public class NullAction implements Action {

	// FIXME use lazy holder idiom
	private static final NullAction theInstance = new NullAction();

	private NullAction() {
	}

	public static NullAction instance() {
		return theInstance;
	}

	@Override
	public boolean execute() {
		return false;
	}
}

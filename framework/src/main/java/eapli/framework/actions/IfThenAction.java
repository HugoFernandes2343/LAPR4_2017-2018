/**
 *
 */
package eapli.framework.actions;

/**
 * @author Paulo Gandra Sousa
 *
 */
public class IfThenAction extends CompoundAction {

    private final Action condition;

    /**
     *
     * @param condition
     * @param then
     */
    public IfThenAction(Action condition, Action then) {
        super(then);
        this.condition = condition;
    }

    public boolean execute() {
        if (condition.execute()) {
            return next();
        }
        return false;
    }

}

package pt.isep.nsheets.shared.lapr4.red.s1160777.ext;

import pt.isep.nsheets.shared.core.Spreadsheet;

public class PositiveNegativeExtension extends Extension {

    private static final String name = "";

    /**
     * Is the extension activated
     */
    private boolean state;

    /**
     * Creates a new extension whose purpose is to set colors of cells
     * for the positive/negative threshold of values automatically
     *
     * @param name the name of the extension
     */
    public PositiveNegativeExtension(String name, boolean state) {
        super(name);
        this.state = state;
    }

    /**
     * returns the state of the instance. If its active then the extension is being used by the huser
     * @return
     */
    public boolean isActive(){
        return this.state;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.blue.s1.lang.s1150371.macros;

/**
 *
 * @author josea
 */
public class Macro {

    private String input;
    private String name;
    private String macroType;
    
    public Macro(String name,String input,String macroType) {
        this.input = input;
        this.name=name;
        this.macroType=macroType;
    }

    public Macro() {

    }

    /**
     * @return the input
     */
    public String getInput() {
        return input;
    }

    /**
     * @param input the input to set
     */
    public void setInput(String input) {
        this.input = input;
    }
    
    public Double runMacro(){
    return null;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}

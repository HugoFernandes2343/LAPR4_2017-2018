/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.client.lapr4.red.s1.s1160777.application.extensionmanager;

/**
 *
 * @author josea
 */
public class LocalExtension {

    private String color1 = "";

    private String color2 = "";

    private static LocalExtension singleton = new LocalExtension();

    /**
     * @return the color1
     */
    public String getColor1() {
        return color1;
    }

    /**
     * @param color1 the color1 to set
     */
    public void setColor1(String color1) {
        this.color1 = color1;
    }

    /**
     * @return the color2
     */
    public String getColor2() {
        return color2;
    }

    /**
     * @param color2 the color2 to set
     */
    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public static LocalExtension getInstance() {
        return singleton;
    }
}

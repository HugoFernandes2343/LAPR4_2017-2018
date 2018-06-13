/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.core;

/**
 *
 * @author Paulo Jorge
 */
public class ConvertCurrencie {

    static double pound_dollar = 1.338;
    static double euro_dollar = 1.178;
    static double pound_euro = 1.135;

    public static double getPound_dollar() {
        return pound_dollar;
    }

    public static double getEuro_dollar() {
        return euro_dollar;
    }

    public static double getPound_euro() {
        return pound_euro;
    }

    public static void setPound_dollar(double pound_dollar) {
        ConvertCurrencie.pound_dollar = pound_dollar;
    }

    public static void setEuro_dollar(double euro_dollar) {
        ConvertCurrencie.euro_dollar = euro_dollar;
    }

    public static void setPound_euro(double pound_euro) {
        ConvertCurrencie.pound_euro = pound_euro;
    }

}

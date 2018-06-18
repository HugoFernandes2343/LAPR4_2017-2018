/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.green.s1.core.n1160696.StylesCell;

import com.google.gwt.dom.client.Style;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.TextAlign;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 *
 * @author João Santiago <1160696@isep.ipp.pt>
 */
//@Entity
public class StylesCellInterfaceImp implements StylesCellInterface {

  //  @Id
    @GeneratedValue
    private Long id;

   // @Version
    private Long version;

    private Style.FontWeight fWeight;
    private Style.FontStyle fStyle;
    private TextAlign txtAlign;
    private Color bgColor;
    private Color txtColor;
    private Style.TextDecoration underline;

    public StylesCellInterfaceImp() {
    }

    public StylesCellInterfaceImp(Style.FontWeight f, Style.FontStyle s, TextAlign align, Color bg, Color txt, Style.TextDecoration ud) {

        fWeight = f;
        fStyle = s;
        txtAlign = align;
        underline = ud;
        bgColor = bg;
        this.txtColor = txt;

    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * @return the fWeight
     */
    public Style.FontWeight getfWeight() {
        return fWeight;
    }

    /**
     * @return the fStyle
     */
    public Style.FontStyle getfStyle() {
        return fStyle;
    }

    /**
     * @return the txtAlign
     */
    public TextAlign getTxtAlign() {
        return txtAlign;
    }

    /**
     * @return the bgColor
     */
    public Color getBgColor() {
        return bgColor;
    }

    /**
     * @return the txtColor
     */
    public Color getTxtColor() {
        return txtColor;
    }

    /**
     * @return the underline
     */
    public Style.TextDecoration getUnderline() {
        return underline;
    }
    
    
}
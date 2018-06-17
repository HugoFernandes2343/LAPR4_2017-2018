/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.green.s1.lang.n1160696.StylesCell;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.TextDecoration;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.TextAlign;
import pt.isep.nsheets.shared.lapr4.red.s1160777.ext.Extension;

/**
 *
 * @author João Santiago <1160696@isep.ipp.pt>
 */
public class StylesCellExt extends Extension{
    
    
    public static final String N = "StylesCellExt";
    
    private TextDecoration underline;
    private TextAlign txtAlign;
    private FontWeight fontWeight;
    private FontStyle fontStyle;
    private Color backgroundColor;
    private Color textColor;
    
    public TextDecoration DEFAULT_UNDERLINE = TextDecoration.NONE;
    public TextAlign DFLT_TEXT_ALIGN = TextAlign.CENTER;
    public Color DEFAULT_BACKGROUND_COLOR = Color.WHITE;
    public Color DEFAULT_TEXT_COLOR = Color.BLACK;
    public FontWeight DEFAULT_FONT_WEIGHT = FontWeight.NORMAL;
    public FontStyle DEFAULT_FONT_STYLE = FontStyle.NORMAL;
    
    
    
    public StylesCellExt() {
        super(N);
        txtAlign = DFLT_TEXT_ALIGN;
        backgroundColor = DEFAULT_BACKGROUND_COLOR;
        textColor = DEFAULT_TEXT_COLOR;
        fontWeight = DEFAULT_FONT_WEIGHT;
        fontStyle = DEFAULT_FONT_STYLE;
        underline = DEFAULT_UNDERLINE;
    }
    
    
    public TextDecoration getUnderline(){
        return underline;
    }
    
    public void setUnderline(TextDecoration ud){
        if (underline.compareTo(ud) == 0) {
            this.underline = DEFAULT_UNDERLINE;
        } else {
            this.underline = ud;
        }
    }

    
    public TextAlign getTextAlign(){
        return txtAlign;
    }
    
    public void setTextAlign(TextAlign na){
        this.txtAlign = na;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color newColor) {
        this.backgroundColor = newColor;
    }
    
    public FontStyle getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(FontStyle newStyle) {
        
        
        if(fontStyle.compareTo(newStyle)==0){
            
        this.fontStyle = DEFAULT_FONT_STYLE;
        
        
        }else{
            
            this.fontStyle = newStyle;
        }
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color newColor) {
        this.textColor = newColor;
    }

    public FontWeight getFontWeight() {
        return fontWeight;
    }

    public void setFontWeight(FontWeight font) {
        if (fontWeight.compareTo(font)==0) {
            this.fontWeight = DEFAULT_FONT_WEIGHT;
        } else {
            this.fontWeight = font;
        }
    }
    
    @Override
    public String toString() {
        return N;
    }
   
}

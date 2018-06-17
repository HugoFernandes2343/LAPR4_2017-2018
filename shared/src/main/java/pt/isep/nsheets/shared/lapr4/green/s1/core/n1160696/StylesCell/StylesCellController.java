/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.lapr4.green.s1.core.n1160696.StylesCell;

import gwt.material.design.client.ui.MaterialListValueBox;
import pt.isep.nsheets.shared.lapr4.red.s1160777.ext.Extension;
import pt.isep.nsheets.shared.lapr4.red.s1160777.ext.ExtensionManager;

/**
 *
 * @author João Santiago <1160696@isep.ipp.pt>
 */
public class StylesCellController {
    
    private Extension selectedExtension;
     
     public StylesCellController(){
         
     }
    
    public void addExtensionsToListValueBox(MaterialListValueBox<Extension> lstFunctions){
        ExtensionManager em = ExtensionManager.getInstance();
        
        for(Extension e:em.getExtensions()){
            lstFunctions.add(e);
        }
    }

    public void setChosenExtension(Extension selectedValue) {
        selectedExtension = selectedValue;
    }

    public Extension getExtensionChosen() {
        return selectedExtension;
    }
   
   
}

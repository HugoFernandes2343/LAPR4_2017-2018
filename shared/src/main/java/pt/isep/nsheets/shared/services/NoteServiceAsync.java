/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.List;

/**
 *
 * @author David Santiago <1161109@isep.ipp.pt>
 */
public interface NoteServiceAsync {
    
    NoteDTO addNote(NoteDTO wdDto) throws DataException;
    void getNotes(AsyncCallback<List<NoteDTO>> callback) throws DataException;

}

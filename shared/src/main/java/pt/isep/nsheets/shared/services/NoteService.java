/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.ArrayList;


/**
 *
 * @author David Santiago <1161109@isep.ipp.pt>
 */
@RemoteServiceRelativePath("noteService")
public interface NoteService extends RemoteService{
    
    
   ArrayList<NoteDTO> getNotes();
   
   NoteDTO addNote(NoteDTO ntDto) throws DataException;

    
    
}

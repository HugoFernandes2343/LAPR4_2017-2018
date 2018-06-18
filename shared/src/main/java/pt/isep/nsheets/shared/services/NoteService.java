/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 *
 * @author Paulo Jorge
 */
@RemoteServiceRelativePath("noteService")
public interface NoteService extends RemoteService {

    NoteDTO addNote(NoteDTO noteDTO) throws DataException;

    Iterable<NoteDTO> getNotes(UserDTO userDTO);

    void deleteNote(NoteDTO noteDTO);

    void editNote(String title, String text, String oldName) throws DataException;
}

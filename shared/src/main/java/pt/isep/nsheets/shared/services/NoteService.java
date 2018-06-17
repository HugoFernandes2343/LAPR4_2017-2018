/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.List;

/**
 *
 * @author Paulo Jorge
 */
@RemoteServiceRelativePath("noteService")
public interface NoteService extends RemoteService {

    NoteDTO addNote(NoteDTO noteDTO) throws DataException;

    List<NoteDTO> getListNoteUser(UserDTO userDTO);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.ArrayList;

/**
 *
 * @author Paulo Jorge
 */
public interface NoteServiceAsync {

    void getNotes(UserDTO userDTO, AsyncCallback<ArrayList<NoteDTO>> callback);

    void addNote(NoteDTO noteDTO, AsyncCallback<NoteDTO> async);

    void deleteNote(NoteDTO noteDTO, AsyncCallback<NoteDTO> async);

    void editNote(String title, String text, String oldName, AsyncCallback<NoteDTO> async);
}

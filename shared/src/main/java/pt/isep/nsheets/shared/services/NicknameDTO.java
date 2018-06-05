
package pt.isep.nsheets.shared.services;

import java.io.Serializable;

/**
 *
 * @author Paulo Jorge
 */
@SuppressWarnings("serial")
public class NicknameDTO implements Serializable{

    private final String nickName;

    public NicknameDTO(String nickName) {
        this.nickName = nickName;

    }

    // It is mandatory to have a default constructor with no arguments to be serializable!
    public NicknameDTO() {
        this.nickName = "";

    }

    public String getNickName() {
        return this.nickName;
    }

}


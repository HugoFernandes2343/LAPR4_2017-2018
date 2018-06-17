package pt.isep.nsheets.server.lapr4.blue.s3.ipc.s1161248.PrivateChat.domain;

import pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class Invite implements Serializable {

    @Id
    @GeneratedValue
    private Long pk;

    @OneToOne
    private
    User user;

    private Long chatPk;

    public Invite(){
        setUser(null);
    }

    public Invite(User user, Long chatPk){
        this.setUser(user);
        this.setChatPk(chatPk);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getChatPk() {
        return chatPk;
    }

    public void setChatPk(Long chatPk) {
        this.chatPk = chatPk;
    }

}

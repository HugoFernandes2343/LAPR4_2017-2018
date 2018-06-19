/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.green.s1.core.n1160570.login.domain;

import javax.persistence.Embeddable;
import pt.isep.nsheets.shared.services.UserTypeDTO;

/**
 *
 * @author Paulo Jorge
 */

public enum UserType {

    USER {

        @Override
        public String toString() {
            return "User";
        }
    },
    ADMIN {

        @Override
        public String toString() {
            return "Admin";
        }
    }
}

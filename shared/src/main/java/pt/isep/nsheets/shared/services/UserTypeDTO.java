/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import java.io.Serializable;

/**
 *
 * @author Paulo Jorge
 */
@SuppressWarnings("serial")
public enum UserTypeDTO implements Serializable {

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

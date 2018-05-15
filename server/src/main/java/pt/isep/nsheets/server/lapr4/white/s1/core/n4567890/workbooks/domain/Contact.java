/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain;

/**
 *
 * @author alexandrebraganca
 */
//import eapli.framework.domain.AggregateRoot;
import eapli.framework.domain.AggregateRoot;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Contact
 *
 * @author ATB
 *
 */
@Entity
public class Contact implements AggregateRoot<Long>, Serializable { 
   
    // ORM primary key
    @Id
    @GeneratedValue
    private Long pk=null;    
    
    // This should be the Business ID
    @Column(unique = true)
    private String name=null;
    
    private String firstName=null;
    
    private String lastName=null;
    
    private String photo=null;
    
//    @OneToOne(cascade = CascadeType.ALL) //(cascade = CascadeType.MERGE)
//    private Agenda agenda=null;

    protected Contact() {
        // for ORM
    }

    public Contact(final String name, final String firstName, final String lastName) {
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        // TODO implement rest of the method
        
//        // Create a the contact Agenda
//        this.agenda=agenda;
    }
    
    @Override
    public String toString() {
        if (this.name==null)
            return super.toString();
        else
            return this.name()+" ("+this.lastName+", "+this.firstName+")";
    }
        
//    public Contact(final String name, final String firstName, final String lastName) {
//
//        // create with empty agenda
//        this(name, firstName, lastName, new Agenda());
//    }
    
    public String name() {
        return this.name;
    }
    
    public String setName(String name) {
        return this.name=name;
    }

    public String firstName() {
        return this.firstName;
    }

    public String setFirstName(String firstName) {
        return this.firstName=firstName;
    }
    
    public String lastName() {
        return this.lastName;
    }
    
    public String setLastName(String lastName) {
        return this.lastName=lastName;
    }
    
//    public Agenda agenda() {
//        return this.agenda;
//    }

    @Override
    public boolean sameAs(Object other) {
        // FIXME implement this method
        return false;
    }

    @Override
    public boolean is(Long id) {
        return (this.pk.compareTo(id)==0);
    }

    @Override
    public Long id() {
        return this.pk;
    }
}
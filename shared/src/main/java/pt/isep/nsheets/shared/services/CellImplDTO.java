/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import java.io.Serializable;
import java.util.SortedSet;

/**
 *
 * @author João Santiago <1160696@isep.ipp.pt>
 */
public class CellImplDTO implements Serializable{
    
    public Long id;
    public Long version;
    public AddressDTO address;
    public String content;
    public SortedSet<CellImplDTO> precedents;
    public SortedSet<CellImplDTO> dependents;
    
    private CellImplDTO() {
    
    };
    
    public CellImplDTO(Long id, Long version, AddressDTO address, String content, SortedSet<CellImplDTO> precedents, SortedSet<CellImplDTO> dependents){
        this.id = id;
        this.version = version;
        this.address = address;
        this.content = content;
        this.precedents = precedents;
        this.dependents = dependents;
    }
    
    public void setContent(String content){
        this.content = content;
    }
    
}

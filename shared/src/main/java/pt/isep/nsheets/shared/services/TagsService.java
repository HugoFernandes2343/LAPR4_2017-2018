/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

/**
 *
 * @author João Vieira
 */
public interface TagsService {
    TagsDTO getTags(String workbookTag, String worksheetTag, String cellTag);
}

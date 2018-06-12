/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.shared.services;

import java.io.Serializable;

/**
 *
 * @author dftsf
 */
@SuppressWarnings("serial")
public class TaskDTO implements Serializable {

    private String title;

    /**
     * Description of the task
     */
    private String description;

    /**
     * Priority of the task
     */
    private int priority;

    /**
     * Percentage of completion of the task
     */
    private int percentage;

    // It is mandatory to have a default constructor with no arguments to be serializable!
    public TaskDTO() {
    }

    /**
     * Complete constructor
     */
    public TaskDTO(String title, String description, int priority, int percentage) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.percentage = percentage;
    }

    public boolean setTitle(String title) {
        this.title = title;
        return true;
    }

    public boolean description(String description) {
        this.description = description;
        return true;
    }

    public boolean setPriority(int priority) {
        this.priority = priority;
        return true;
    }

    public boolean setPercentage(int percentage) {
        this.percentage = percentage;
        return true;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public int getPercentage() {
        return percentage;
    }

    public boolean sameAs(Object other) {

        final TaskDTO that = (TaskDTO) other;

        if (!this.title.equals(that.title)) {
            return false;
        }
        if (!this.description.equals(that.description)) {
            return false;
        }

        if (this.priority != that.priority) {
            return false;
        }
        if (this.percentage != that.percentage) {
            return false;
        }

        return true;
    }

}

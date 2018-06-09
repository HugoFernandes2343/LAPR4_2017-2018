/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.blue.s2.core.n1150585.tasks.domain;

import eapli.framework.domain.AggregateRoot;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import pt.isep.nsheets.shared.services.TaskDTO;

/**
 *
 * @author Daniel Fernandes n1150585
 */
@Entity
@Table(name = "TASK")
public class Task implements Serializable, AggregateRoot<Long> {

    // ORM primary key
    @Id
    @GeneratedValue
    private Long pk;

    /**
     * Title of the task.
     */
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

    /**
     * Constructor for ORM
     */
    protected Task() {
    }

    /**
     * Complete constructor
     */
    public Task(String title, String description, int priority, int percentage) {
       /* if (title == null || description == null) {
            throw new IllegalArgumentException("Error in the input data");
        }*/
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.percentage = percentage;

    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Task)) {
            return false;
        }

        Task e = (Task) other;
        return true;
    }

    @Override
    public boolean is(Long id) {
        return this.pk.equals(id);
    }

    @Override
    public Long id() {
        return this.pk;
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

    public TaskDTO toDTO() {
        return new TaskDTO(title, description, priority, percentage);
    }

    public static Task fromDTO(TaskDTO dto) {
        return new Task(dto.getTitle(), dto.getDescription(), dto.getPriority(), dto.getPercentage());
    }
}

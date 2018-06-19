package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain;

/**
 * @author alexandrebraganca
 */
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import eapli.framework.domain.AggregateRoot;
import javax.persistence.OneToOne;
import pt.isep.nsheets.shared.core.Workbook;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;

/**
 * Contact
 *
 * @author ATB
 *
 */
@Entity
public class WorkbookDescription implements AggregateRoot<Long>, Serializable {

    // ORM primary key
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;

    /**
     * The user email of the user that created this workbook, empty if public
     * workbook
     */
    private String userMail;

    @OneToOne
    private Workbook workbook;

    public WorkbookDescription(String name, String description, Workbook workbook, String mail) throws IllegalArgumentException {
        if (name == null || description == null) {
            throw new IllegalArgumentException("name or description must be non-null");
        }
        this.name = name;
        this.description = description;
        this.workbook = workbook;
        this.userMail = mail;
    }

    public WorkbookDescription(String name, String description, String mail) throws IllegalArgumentException {
        if (name == null || description == null) {
            throw new IllegalArgumentException("name or description must be non-null");
        }
        this.name = name;
        this.description = description;
        this.workbook = new Workbook();
        this.userMail = mail;
    }

    // It is mandatory to have a default constructor with no arguments to be
    // serializable and for ORM!
    protected WorkbookDescription() {
        this.name = "";
        this.description = "";
        this.workbook = new Workbook();
        this.userMail = "";
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getUserMail() {
        return userMail;
    }

    @Override
    public String toString() {
        if (this.name == null) {
            return super.toString();
        } else {
            return this.name + " " + this.description;
        }
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof WorkbookDescription)) {
            return false;
        }

        final WorkbookDescription that = (WorkbookDescription) other;
        if (this == that) {
            return true;
        }
        if (!this.name.equals(that.name)) {
            return false;
        }
        if (!this.description.equals(that.description)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean is(Long id) {
        return (this.id.compareTo(id) == 0);
    }

    @Override
    public Long id() {
        return this.id;
    }

    public WorkbookDescriptionDTO toDTO() {
        return new WorkbookDescriptionDTO(this.name, this.description, this.userMail);
    }

    public static WorkbookDescription fromDTO(WorkbookDescriptionDTO dto) throws IllegalArgumentException {
        return new WorkbookDescription(dto.getName(), dto.getDescription(), dto.getUserMail());
    }

    public boolean editName(String newName) {
        this.name = newName;
        return true;
    }

    public boolean editDescription(String newDescription) {
        this.description = newDescription;
        return true;
    }

    public Workbook getWorkbook() {
        return this.workbook;
    }

}

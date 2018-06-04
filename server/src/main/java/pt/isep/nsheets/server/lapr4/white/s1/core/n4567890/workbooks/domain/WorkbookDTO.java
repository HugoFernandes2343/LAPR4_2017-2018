package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain;

import eapli.framework.domain.AggregateRoot;
import pt.isep.nsheets.shared.core.Spreadsheet;
import pt.isep.nsheets.shared.core.Workbook;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class WorkbookDTO implements AggregateRoot<Long>, Serializable {

    // ORM primary key
    @Id
    @GeneratedValue
    private Long pk = null;

    @Column(unique = true)
    private String name;
    private String description;
    private Spreadsheet sheet;
    public ArrayList<Spreadsheet> spreadsheets = new ArrayList<>();
    public int existingSpreadsheets;

    public WorkbookDTO(String name, String description, Spreadsheet sheet) {
        this.name = name;
        this.description = description;
        this.sheet = sheet;
    }

    public WorkbookDTO(String name, String description, ArrayList<Spreadsheet> s){
        
        this.name = name;
        this.description = description;
        this.spreadsheets = s;
        this.existingSpreadsheets = s.size();
        
    }
    
    
    public WorkbookDTO() {
        this.name = "";
        this.description = "";
        this.sheet = null;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean is(Long id) {
        return (this.pk.compareTo(id) == 0);
    }

    @Override
    public Long id() {
        return this.pk;
    }

    public String getDescription() {
        return description;
    }

    public Spreadsheet getSheet() {
        return sheet;
    }

    public Workbook toWorkbook() {
        return new Workbook(this.name, this.description, this.sheet);
    }

    public static WorkbookDTO fromWorkbook(Workbook wb) throws IllegalArgumentException {
        return new WorkbookDTO(wb.getName(), wb.getDescription(), wb.getSheet());
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof WorkbookDTO)) {
            return false;
        }

        final WorkbookDTO that = (WorkbookDTO) other;
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
}

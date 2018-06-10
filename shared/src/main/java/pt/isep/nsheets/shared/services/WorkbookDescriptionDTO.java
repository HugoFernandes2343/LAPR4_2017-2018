package pt.isep.nsheets.shared.services;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;

@SuppressWarnings("serial")
public class WorkbookDescriptionDTO implements IsSerializable, Serializable {

    private String name;
    private String description;
    private String userMail;

    private WorkbookDTO wbdto;

    public WorkbookDescriptionDTO(String name, String description, WorkbookDTO workbook, String mail) {
        this.name = name;
        this.description = description;
        this.wbdto = workbook;
        this.userMail = mail;
    }

    public WorkbookDescriptionDTO(String name, String description, String mail) {
        this.name = name;
        this.description = description;
        this.wbdto = new WorkbookDTO();
        this.userMail = mail;
    }

    // It is mandatory to have a default constructor with no arguments to be serializable!
    public WorkbookDescriptionDTO() {
        this.name = "";
        this.description = "";
        this.wbdto = new WorkbookDTO();
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkbookDTO getWorkbook() {
        return this.wbdto;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getUserMail() {
        return this.userMail;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

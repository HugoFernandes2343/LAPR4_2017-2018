package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain;

/**
*
* @author alexandrebraganca
*/

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import eapli.framework.domain.AggregateRoot;
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
	private Long pk = null;

	private String name;
	private String description;

	public WorkbookDescription(String name, String description) {
		this.name = name;
		this.description = description;
	}

	// It is mandatory to have a default constructor with no arguments to be
	// serializable and for ORM!
	protected WorkbookDescription() {
		this.name = "";
		this.description = "";
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	@Override
	public String toString() {
		if (this.name == null)
			return super.toString();
		else
			return this.name + " " + this.description;
	}

	@Override
	public boolean sameAs(Object other) {
		// FIXME implement this method
		return false;
	}

	@Override
	public boolean is(Long id) {
		return (this.pk.compareTo(id) == 0);
	}

	@Override
	public Long id() {
		return this.pk;
	}
	
	public WorkbookDescriptionDTO toDTO() {
		return new WorkbookDescriptionDTO(this.name, this.description);
	}
}
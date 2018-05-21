package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.application;

import static org.junit.Assert.assertTrue;

import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.domain.WorkbookDescription;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceSettings;
import pt.isep.nsheets.shared.services.WorkbookDescriptionDTO;

public class AddWokbookDescriptionControllerTest {

	public AddWokbookDescriptionControllerTest() {
	}

	@BeforeClass
	public static void setUpClass() {
		System.out.println("AddWokbookDescriptionControllerTest");

		// Setup the context to use a memory database for testing
		Properties props = new Properties();
		props.put("persistence.repositoryFactory",
				"pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.jpa.JpaRepositoryFactory");
		props.put("persistence.persistenceUnit", "lapr4.NSheetsPU");

		// Other JPA properties that one might want to override from the ones in
		// persistence.xml
		props.put("javax.persistence.jdbc.url", "jdbc:h2:mem:");
		props.put("javax.persistence.schema-generation.database.action", "create");
		// appProps.put("javax.persistence.jdbc.password", "");
		// appProps.put("javax.persistence.jdbc.driver", "org.h2.Driver");
		// appProps.put("javax.persistence.jdbc.user", "");
		// appProps.put("eclipselink.logging.level", "FINE");

		PersistenceSettings extensionSettings = new PersistenceSettings(props);

		PersistenceContext.setSettings(extensionSettings);
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	// @Ignore
	@Test
	public void testNormalBehaviour() throws Exception {
		System.out.println("testNormalBehaviour");
		
		final String name = "Workbook1";
		final String description = "Description for Workbook1";

		final WorkbookDescription expected = new WorkbookDescription(name, description);

		AddWorkbookDescriptionController ctrl = new AddWorkbookDescriptionController();

		WorkbookDescription result = ctrl.addWorkbookDescription(name, description);

		assertTrue("the added WorkbookDescription does not have the same data as input", expected.sameAs(result));
	}
}
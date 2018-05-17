/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks;

/**
 *
 * @author alexandrebraganca
 */
import java.util.Properties;

public class ExtensionSettings {

	private static final String REPOSITORY_FACTORY_KEY = "persistence.repositoryFactory";
	private static final String PERSISTENCE_UNIT_KEY = "persistence.persistenceUnit";
	private Properties extensionProperties = null;

	public ExtensionSettings() {
		extensionProperties = new Properties();
		setDefaultProperties();
	}

	public ExtensionSettings(Properties props) {
		extensionProperties = props;
	}

	private void setDefaultProperties() {
		this.extensionProperties.setProperty(REPOSITORY_FACTORY_KEY, "JpaRepositoryFactory");
		this.extensionProperties.setProperty(PERSISTENCE_UNIT_KEY, "lapr4.NSheetsPU");
	}

	public String getPersistenceUnitName() {
		return this.extensionProperties.getProperty(PERSISTENCE_UNIT_KEY);
	}

	public String getRepositoryFactory() {
		return this.extensionProperties.getProperty(REPOSITORY_FACTORY_KEY);
	}

	// Test if this will work in acceptance tests...
	public Properties properties() {
		return extensionProperties;
	}
}
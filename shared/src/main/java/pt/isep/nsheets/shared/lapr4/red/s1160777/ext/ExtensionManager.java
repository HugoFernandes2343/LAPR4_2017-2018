/*
 * Copyright (c) 2005 Einar Pehrson <einar@pehrson.nu>.
 *
 * This file is part of
 * CleanSheets - a spreadsheet application for the Java platform.
 *
 * CleanSheets is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * CleanSheets is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CleanSheets; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package pt.isep.nsheets.shared.lapr4.red.s1160777.ext;

import pt.isep.nsheets.shared.core.Spreadsheet;

import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

//import csheets.CleanSheets;

/**
 * The class that manages extensions to the CleanSheets application.
 *
 * @author Einar Pehrson
 */
public class ExtensionManager {

    /**
     * The singleton instance
     */
    private static final ExtensionManager instance = new ExtensionManager();

    /**
     * The name of the files in which extension properties are stored
     */
    private static final String PROPERTIES_FILENAME = "extensions.props";

    private static final String ACTIVE_EXTENSION = "ACTIVE";
    private static final String INACTIVE_EXTENSION = "INACTIVE";

    /**
     * The extensions that have been loaded
     */
    private SortedMap<String, Extension> extensionMap
            = new TreeMap<>();

    /**
     * Creates the extension manager.
     */
    private ExtensionManager() {
        //Loads the pre-coded extensions
        //loadExtensions();
    }

    /**
     * Example for hardcoded extensions. further down the road the map might be used to diferenciate which extensions
     * are in use and those that are not by using the k variable
     */
    private void loadExtensions() {

        //Load All premade extensions
       // Extension exampleColor = new PositiveNegativeExtension("PositiveNegativeExtension", true);
        //Add Maia's

        //Add them to the treemap
       // this.extensionMap.put(exampleColor.getName(),exampleColor);
        //extensionMap.put(ACTIVE_EXTENSION, exampleColor);
        //add maia's


    }


    /**
     * Returns the singleton instance.
     *
     * @return the singleton instance
     */
    public static ExtensionManager getInstance() {
        return instance;
    }

    /**
     * Returns the extensions that have been loaded.
     *
     * @return the extensions that have been loaded
     */
    public Extension[] getExtensions() {
        Collection<Extension> extensions = extensionMap.values();
        return extensions.toArray(new Extension[extensions.size()]);
    }

    /**
     * Returns the extension with the given name.
     *
     * @param name name
     * @return the extension with the given name or null if none was found
     */
    public Extension getExtension(String name) {
        return extensionMap.get(name);
    }

    /**
     * Adds the given url to the class path, and loads the extension with the
     * given class name.
     * @param className the complete class name of a class that extends
     * the abstract Extension class
     * @param url the URL of the JAR-file or directory that contains the class
     * @return the extension that was loaded, or null if none was found.
     */
    // not supported in gwt
//	public Extension load(String className, URL url) {
//		loader.addURL(url);
//		try {
//			Class extensionClass = Class.forName(className, true, loader);
//			return load(extensionClass);
//		} catch (Exception e) {
//			System.err.println("Failed to load extension class " + className + ".");
//			return null;
//		}
//	}

    /**
     * Loads the extension with the given class name.
     * @param className the complete class name of a class that extends
     * the abstract Extension class
     * @return the extension that was loaded, or null if none was found.
     */
    // not supported in gwt
//	public Extension load(String className) {
//		try {
//			Class extensionClass = Class.forName(className);
//			return load(extensionClass);
//		} catch (Exception e) {
//			System.err.println("Failed to load extension class " + className + ".");
//			return null;
//		}
//	}

    /**
     * Instantiates the given extension class.
     * @param extensionClass a class that extends the abstract Extension class
     * @return the extension that was loaded, or null if none was found.
     */
    // not supported in gwt
//	public Extension load(Class extensionClass) {
//		try {
//			Extension extension = (Extension)extensionClass.newInstance();
//			extensionMap.put(extension.getName(), extension);
//			return extension;
//		} catch (IllegalAccessException iae) {
//			System.err.println("Could not access extension " + extensionClass.getName() + ".");
//			return null;
//		} catch (InstantiationException ie) {
//			System.err.println("Could not load extension from " + extensionClass.getName() + ".");
//			ie.printStackTrace();
//			return null;
//		}
//	}

    /**
     * Returns the class loader used to load extensions.
     * @return the class loader used to load extensions
     */
    // not supported in gwt
//	public ClassLoader getLoader() {
//		return loader;
//	}

    /**
     * The class loader used to load extensions.
     */
    // not supported in gwt
//	public static class Loader extends URLClassLoader {
//
//		/**
//		 * Creates a new extension loader.
//		 */
//		public Loader() {
//			super(new URL[]{}, Loader.class.getClassLoader());
//		}
//
//		/**
//		 * Appends the specified URL to the list of URLs to search for classes
//		 * and resources.
//		 * @param url the URL to be added to the search path of URL:s
//		 */
//		protected void addURL(URL url) {
//			super.addURL(url);
//		}
//	}
}
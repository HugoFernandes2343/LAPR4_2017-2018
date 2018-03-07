package pt.isep.nsheets.shared.core.formula.lang;

import java.util.ArrayList;
import java.util.List;

import pt.isep.nsheets.shared.core.formula.Function;

public class LanguageManager {

	/** The singleton instance */
	private static final LanguageManager instance = new LanguageManager();

	/** The languages */
	private List<Language> languages = new ArrayList<Language>();

	/**
	 * Creates a new language.
	 */
	private LanguageManager() {
		// setup all languages

		languages.add(new ExcelLanguage("excel"));
	}

	/**
	 * Returns the singleton instance.
	 * 
	 * @return the singleton instance
	 */
	public static LanguageManager getInstance() {
		return instance;
	}

	public Language getLanguage(String name)  {
		for (Language lang : languages)
			if (name == lang.getName()) {
				return lang;
			}
		return null;
	}
	
	public Function getFunction(String identifier) throws UnknownElementException {
		for (Language lang: languages) {
			try {
				Function function=lang.getFunction(identifier);
				return function;
			}
			catch (UnknownElementException e) {
				// nothing to do, move to next language
			}
		}
		// funtion was not found in any of the languages
		throw new UnknownElementException(identifier);		
	}	
}

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package pt.isep.nsheets.client.place;

public class NameTokens {

    public static final String home = "home";

    public static final String agenda = "agenda";

    public static final String about = "about";

    public static final String workbook = "workbook";

    public static final String macros = "macros";

    public static final String settings = "settings";

    public static final String contacts = "contacts";

    public static final String requests = "requests";

    public static final String exportToXMLWindow = "exportToXMLWindow";
    
    public static final String exportToCSVWindow = "exportToCSVWindow";

    public static final String login = "login";
    
    public static final String logout = "logout";

    public static final String extensionmanager = "extensionmanager";

    public static final String xmlupload = "xmlupload";

    public static String getWorkbook() {
        return workbook;
    }

    public static String getMacros() { return macros; }

    public static String getAbout() {
        return about;
    }

    public static String getHome() {
        return home;
    }

    public static String getContacts() {
        return contacts;
    }

    public static String getRequests() { return requests; }

    public static String getRequestsNumbers(){return "2";}

    public static String getLogin() {
        return login;
    }
     public static String getLogout() {
        return logout;
    }
    

    public static String getSettings() {
        return settings;
    }

    public static String getExportToXMLWindow() {
        return exportToXMLWindow;
    }
    
    public static String getExportToCSVWindow() {
        return exportToCSVWindow;
    }

    public static String getExtensionManager() { return extensionmanager; }

    public static String getXmlupload() { return xmlupload; }

    public static String getAgenda(){ return agenda;}

}

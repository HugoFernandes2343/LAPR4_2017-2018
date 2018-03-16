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
package pt.isep.nsheets.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface AppResources extends ClientBundle {
	
	AppResources INSTANCE = GWT.create(AppResources.class);
	
    interface Normalize extends CssResource {
    }

    interface Style extends CssResource {
    }

    @Source("css/normalize.gss")
    Normalize normalize();

    @Source("css/style.gss")
    Style style();
    
	@Source("img/lapr4.png")
	ImageResource lapr4();    
	
	@Source("img/csheets.png")
	ImageResource csheets(); 	
}

/*******************************************************************************
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Filipp A. - Initial implementation
 *******************************************************************************/
package org.eclipse.gemini.ext.di;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.eclipse.e4.core.di.extensions.Preference;

@Target({})
@Retention(RUNTIME)
public @interface GeminiPersistenceProperty {

    /** The name of the property */
    String name();

    /** The value of the property */
    String value() default "";

    Preference valuePref() default @Preference(value = "", nodePath = "");
}

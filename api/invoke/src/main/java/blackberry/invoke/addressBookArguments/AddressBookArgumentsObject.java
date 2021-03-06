/*
* Copyright 2010-2011 Research In Motion Limited.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package blackberry.invoke.addressBookArguments;

import javax.microedition.pim.Contact;

import blackberry.core.ScriptField;
import blackberry.core.ScriptableObjectBase;
import blackberry.pim.contact.ContactObject;

/**
 * This class represents the AddressBookArgumentsObject
 * 
 * @author sgolod
 * 
 */
public class AddressBookArgumentsObject extends ScriptableObjectBase {
    private final ContactObject _contactObject;

    public static final String FIELD_VIEW = "view";

    /**
     * Default constructor, constructs a new AddressBookArgumentsObject object.
     * 
     */
    public AddressBookArgumentsObject() {
        _contactObject = null;
        initial();
    }

    /**
     * Constructs a new AddressBookArgumentsObject object.
     * 
     * @param c
     *            Contact to view in Contacts application.
     */
    public AddressBookArgumentsObject( final ContactObject c ) {
        _contactObject = c;
        initial();
    }

    // Injects fields and methods
    private void initial() {
        addItem( new ScriptField( FIELD_VIEW, new Integer( AddressBookArgumentsConstructor.VIEW_NEW ), ScriptField.TYPE_INT,
                false, false ) );
    }

    /**
     * @see blackberry.core.ScriptableObjectBase#verify(blackberry.core.ScriptField, java.lang.Object)
     */
    protected boolean verify( final ScriptField field, final Object newValue ) throws Exception {
        return true;
    }

    /**
     * Internal helper method to get direct access to the AddressBookArgumentsObject's underlying content.
     * 
     * @return the reference of JAM Contact Object.
     */
    public ContactObject getContactObject() {
        return _contactObject;
    }

    /**
     * Internal helper method to get direct access to the AddressBookArgumentsObject's underlying content.
     * 
     * @return the reference of BlackBerry Contact Object.
     */
    public Contact getContact() {
        if( _contactObject == null ) {
            return null;
        }

        return _contactObject.getContact();
    }

    /**
     * Internal helper method to get direct access to the AddressBookArgumentsObject's underlying content.
     * 
     * @return the type of view when opening Contacts application.
     */
    public int getView() {
        final Integer i = (Integer) getItem( FIELD_VIEW ).getValue();
        final int view = i.intValue();
        return view;
    }
}

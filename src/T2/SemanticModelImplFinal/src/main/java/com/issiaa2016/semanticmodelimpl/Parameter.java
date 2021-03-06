package com.issiaa2016.semanticmodelimpl;

import java.net.URI;
import java.util.Collection;
import javax.xml.datatype.XMLGregorianCalendar;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: Parameter <br>
 * @version generated on Thu Oct 27 23:15:00 BST 2016 by dmrgo
 */

public interface Parameter extends WrappedIndividual {

    /* ***************************************************
     * Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#Description
     */
     
    /**
     * Gets all property values for the Description property.<p>
     * 
     * @returns a collection of values for the Description property.
     */
    Collection<? extends String> getDescription();

    /**
     * Checks if the class has a Description property value.<p>
     * 
     * @return true if there is a Description property value.
     */
    boolean hasDescription();

    /**
     * Adds a Description property value.<p>
     * 
     * @param newDescription the Description property value to be added
     */
    void addDescription(String newDescription);

    /**
     * Removes a Description property value.<p>
     * 
     * @param oldDescription the Description property value to be removed.
     */
    void removeDescription(String oldDescription);



    /* ***************************************************
     * Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#Friendly_Name
     */
     
    /**
     * Gets all property values for the Friendly_Name property.<p>
     * 
     * @returns a collection of values for the Friendly_Name property.
     */
    Collection<? extends String> getFriendly_Name();

    /**
     * Checks if the class has a Friendly_Name property value.<p>
     * 
     * @return true if there is a Friendly_Name property value.
     */
    boolean hasFriendly_Name();

    /**
     * Adds a Friendly_Name property value.<p>
     * 
     * @param newFriendly_Name the Friendly_Name property value to be added
     */
    void addFriendly_Name(String newFriendly_Name);

    /**
     * Removes a Friendly_Name property value.<p>
     * 
     * @param oldFriendly_Name the Friendly_Name property value to be removed.
     */
    void removeFriendly_Name(String oldFriendly_Name);



    /* ***************************************************
     * Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#ID
     */
     
    /**
     * Gets all property values for the ID property.<p>
     * 
     * @returns a collection of values for the ID property.
     */
    Collection<? extends String> getID();

    /**
     * Checks if the class has a ID property value.<p>
     * 
     * @return true if there is a ID property value.
     */
    boolean hasID();

    /**
     * Adds a ID property value.<p>
     * 
     * @param newID the ID property value to be added
     */
    void addID(String newID);

    /**
     * Removes a ID property value.<p>
     * 
     * @param oldID the ID property value to be removed.
     */
    void removeID(String oldID);



    /* ***************************************************
     * Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#SimpleSkills
     */
     
    /**
     * Gets all property values for the SimpleSkills property.<p>
     * 
     * @returns a collection of values for the SimpleSkills property.
     */
    Collection<? extends Object> getSimpleSkills();

    /**
     * Checks if the class has a SimpleSkills property value.<p>
     * 
     * @return true if there is a SimpleSkills property value.
     */
    boolean hasSimpleSkills();

    /**
     * Adds a SimpleSkills property value.<p>
     * 
     * @param newSimpleSkills the SimpleSkills property value to be added
     */
    void addSimpleSkills(Object newSimpleSkills);

    /**
     * Removes a SimpleSkills property value.<p>
     * 
     * @param oldSimpleSkills the SimpleSkills property value to be removed.
     */
    void removeSimpleSkills(Object oldSimpleSkills);



    /* ***************************************************
     * Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#Type
     */
     
    /**
     * Gets all property values for the Type property.<p>
     * 
     * @returns a collection of values for the Type property.
     */
    Collection<? extends String> getType();

    /**
     * Checks if the class has a Type property value.<p>
     * 
     * @return true if there is a Type property value.
     */
    boolean hasType();

    /**
     * Adds a Type property value.<p>
     * 
     * @param newType the Type property value to be added
     */
    void addType(String newType);

    /**
     * Removes a Type property value.<p>
     * 
     * @param oldType the Type property value to be removed.
     */
    void removeType(String oldType);



    /* ***************************************************
     * Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#Value
     */
     
    /**
     * Gets all property values for the Value property.<p>
     * 
     * @returns a collection of values for the Value property.
     */
    Collection<? extends String> getValue();

    /**
     * Checks if the class has a Value property value.<p>
     * 
     * @return true if there is a Value property value.
     */
    boolean hasValue();

    /**
     * Adds a Value property value.<p>
     * 
     * @param newValue the Value property value to be added
     */
    void addValue(String newValue);

    /**
     * Removes a Value property value.<p>
     * 
     * @param oldValue the Value property value to be removed.
     */
    void removeValue(String oldValue);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}

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
 * Source Class: Skill <br>
 * @version generated on Sun Oct 16 15:26:31 BST 2016 by dmrgo
 */

public interface Skill extends WrappedIndividual {

    /* ***************************************************
     * Property http://www.semanticweb.org/issiaa2016/ontologies/myOntology#contains
     */
     
    /**
     * Gets all property values for the contains property.<p>
     * 
     * @returns a collection of values for the contains property.
     */
    Collection<? extends Parameter> getContains();

    /**
     * Checks if the class has a contains property value.<p>
     * 
     * @return true if there is a contains property value.
     */
    boolean hasContains();

    /**
     * Adds a contains property value.<p>
     * 
     * @param newContains the contains property value to be added
     */
    void addContains(Parameter newContains);

    /**
     * Removes a contains property value.<p>
     * 
     * @param oldContains the contains property value to be removed.
     */
    void removeContains(Parameter oldContains);


    /* ***************************************************
     * Property http://www.semanticweb.org/issiaa2016/ontologies/myOntology#Description
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
     * Property http://www.semanticweb.org/issiaa2016/ontologies/myOntology#Friendly_Name
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
     * Property http://www.semanticweb.org/issiaa2016/ontologies/myOntology#ID
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
     * Property http://www.semanticweb.org/issiaa2016/ontologies/myOntology#Parameters
     */
     
    /**
     * Gets all property values for the Parameters property.<p>
     * 
     * @returns a collection of values for the Parameters property.
     */
    Collection<? extends Object> getParameters();

    /**
     * Checks if the class has a Parameters property value.<p>
     * 
     * @return true if there is a Parameters property value.
     */
    boolean hasParameters();

    /**
     * Adds a Parameters property value.<p>
     * 
     * @param newParameters the Parameters property value to be added
     */
    void addParameters(Object newParameters);

    /**
     * Removes a Parameters property value.<p>
     * 
     * @param oldParameters the Parameters property value to be removed.
     */
    void removeParameters(Object oldParameters);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}

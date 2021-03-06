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
 * Source Class: Disturbance <br>
 * @version generated on Thu Oct 27 23:15:00 BST 2016 by dmrgo
 */

public interface Disturbance extends WrappedIndividual {

    /* ***************************************************
     * Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#perform
     */
     
    /**
     * Gets all property values for the perform property.<p>
     * 
     * @returns a collection of values for the perform property.
     */
    Collection<? extends Resource> getPerform();

    /**
     * Checks if the class has a perform property value.<p>
     * 
     * @return true if there is a perform property value.
     */
    boolean hasPerform();

    /**
     * Adds a perform property value.<p>
     * 
     * @param newPerform the perform property value to be added
     */
    void addPerform(Resource newPerform);

    /**
     * Removes a perform property value.<p>
     * 
     * @param oldPerform the perform property value to be removed.
     */
    void removePerform(Resource oldPerform);


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
     * Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#Resource
     */
     
    /**
     * Gets all property values for the Resource property.<p>
     * 
     * @returns a collection of values for the Resource property.
     */
    Collection<? extends Object> getResource();

    /**
     * Checks if the class has a Resource property value.<p>
     * 
     * @return true if there is a Resource property value.
     */
    boolean hasResource();

    /**
     * Adds a Resource property value.<p>
     * 
     * @param newResource the Resource property value to be added
     */
    void addResource(Object newResource);

    /**
     * Removes a Resource property value.<p>
     * 
     * @param oldResource the Resource property value to be removed.
     */
    void removeResource(Object oldResource);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}

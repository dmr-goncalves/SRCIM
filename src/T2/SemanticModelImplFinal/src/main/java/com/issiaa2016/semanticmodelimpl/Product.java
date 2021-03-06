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
 * Source Class: Product <br>
 * @version generated on Thu Oct 27 23:15:00 BST 2016 by dmrgo
 */

public interface Product extends WrappedIndividual {

    /* ***************************************************
     * Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#Consumes
     */
     
    /**
     * Gets all property values for the Consumes property.<p>
     * 
     * @returns a collection of values for the Consumes property.
     */
    Collection<? extends ComplexSkill> getConsumes();

    /**
     * Checks if the class has a Consumes property value.<p>
     * 
     * @return true if there is a Consumes property value.
     */
    boolean hasConsumes();

    /**
     * Adds a Consumes property value.<p>
     * 
     * @param newConsumes the Consumes property value to be added
     */
    void addConsumes(ComplexSkill newConsumes);

    /**
     * Removes a Consumes property value.<p>
     * 
     * @param oldConsumes the Consumes property value to be removed.
     */
    void removeConsumes(ComplexSkill oldConsumes);


    /* ***************************************************
     * Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#ComplexSkills
     */
     
    /**
     * Gets all property values for the ComplexSkills property.<p>
     * 
     * @returns a collection of values for the ComplexSkills property.
     */
    Collection<? extends Object> getComplexSkills();

    /**
     * Checks if the class has a ComplexSkills property value.<p>
     * 
     * @return true if there is a ComplexSkills property value.
     */
    boolean hasComplexSkills();

    /**
     * Adds a ComplexSkills property value.<p>
     * 
     * @param newComplexSkills the ComplexSkills property value to be added
     */
    void addComplexSkills(Object newComplexSkills);

    /**
     * Removes a ComplexSkills property value.<p>
     * 
     * @param oldComplexSkills the ComplexSkills property value to be removed.
     */
    void removeComplexSkills(Object oldComplexSkills);



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
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}

package com.issiaa2016.semanticmodelimpl.impl;

import com.issiaa2016.semanticmodelimpl.*;


import java.net.URI;
import java.util.Collection;
import javax.xml.datatype.XMLGregorianCalendar;

import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.WrappedIndividualImpl;

import org.protege.owl.codegeneration.inference.CodeGenerationInference;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;


/**
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: DefaultDisturbance <br>
 * @version generated on Thu Oct 27 23:15:00 BST 2016 by dmrgo
 */
public class DefaultDisturbance extends WrappedIndividualImpl implements Disturbance {

    public DefaultDisturbance(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Object Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#perform
     */
     
    public Collection<? extends Resource> getPerform() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_PERFORM,
                                               DefaultResource.class);
    }

    public boolean hasPerform() {
	   return !getPerform().isEmpty();
    }

    public void addPerform(Resource newPerform) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_PERFORM,
                                       newPerform);
    }

    public void removePerform(Resource oldPerform) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_PERFORM,
                                          oldPerform);
    }


    /* ***************************************************
     * Data Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#Description
     */
     
    public Collection<? extends String> getDescription() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_DESCRIPTION, String.class);
    }

    public boolean hasDescription() {
		return !getDescription().isEmpty();
    }

    public void addDescription(String newDescription) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_DESCRIPTION, newDescription);
    }

    public void removeDescription(String oldDescription) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_DESCRIPTION, oldDescription);
    }


    /* ***************************************************
     * Data Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#Friendly_Name
     */
     
    public Collection<? extends String> getFriendly_Name() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_FRIENDLY_NAME, String.class);
    }

    public boolean hasFriendly_Name() {
		return !getFriendly_Name().isEmpty();
    }

    public void addFriendly_Name(String newFriendly_Name) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_FRIENDLY_NAME, newFriendly_Name);
    }

    public void removeFriendly_Name(String oldFriendly_Name) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_FRIENDLY_NAME, oldFriendly_Name);
    }


    /* ***************************************************
     * Data Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#ID
     */
     
    public Collection<? extends String> getID() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_ID, String.class);
    }

    public boolean hasID() {
		return !getID().isEmpty();
    }

    public void addID(String newID) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_ID, newID);
    }

    public void removeID(String oldID) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_ID, oldID);
    }


    /* ***************************************************
     * Data Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#Resource
     */
     
    public Collection<? extends Object> getResource() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_RESOURCE, Object.class);
    }

    public boolean hasResource() {
		return !getResource().isEmpty();
    }

    public void addResource(Object newResource) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_RESOURCE, newResource);
    }

    public void removeResource(Object oldResource) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_RESOURCE, oldResource);
    }


}

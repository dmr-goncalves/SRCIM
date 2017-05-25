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
 * Source Class: DefaultCell <br>
 * @version generated on Thu Oct 27 23:15:00 BST 2016 by dmrgo
 */
public class DefaultCell extends WrappedIndividualImpl implements Cell {

    public DefaultCell(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Object Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#Produces
     */
     
    public Collection<? extends Product> getProduces() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_PRODUCES,
                                               DefaultProduct.class);
    }

    public boolean hasProduces() {
	   return !getProduces().isEmpty();
    }

    public void addProduces(Product newProduces) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_PRODUCES,
                                       newProduces);
    }

    public void removeProduces(Product oldProduces) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_PRODUCES,
                                          oldProduces);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#complete
     */
     
    public Collection<? extends ComplexSkill> getComplete() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_COMPLETE,
                                               DefaultComplexSkill.class);
    }

    public boolean hasComplete() {
	   return !getComplete().isEmpty();
    }

    public void addComplete(ComplexSkill newComplete) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_COMPLETE,
                                       newComplete);
    }

    public void removeComplete(ComplexSkill oldComplete) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_COMPLETE,
                                          oldComplete);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#consistsOf
     */
     
    public Collection<? extends Resource> getConsistsOf() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_CONSISTSOF,
                                               DefaultResource.class);
    }

    public boolean hasConsistsOf() {
	   return !getConsistsOf().isEmpty();
    }

    public void addConsistsOf(Resource newConsistsOf) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_CONSISTSOF,
                                       newConsistsOf);
    }

    public void removeConsistsOf(Resource oldConsistsOf) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_CONSISTSOF,
                                          oldConsistsOf);
    }


    /* ***************************************************
     * Data Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#ComplexSkills
     */
     
    public Collection<? extends Object> getComplexSkills() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_COMPLEXSKILLS, Object.class);
    }

    public boolean hasComplexSkills() {
		return !getComplexSkills().isEmpty();
    }

    public void addComplexSkills(Object newComplexSkills) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_COMPLEXSKILLS, newComplexSkills);
    }

    public void removeComplexSkills(Object oldComplexSkills) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_COMPLEXSKILLS, oldComplexSkills);
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
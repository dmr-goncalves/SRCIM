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
 * Source Class: DefaultResource <br>
 * @version generated on Thu Oct 27 23:15:00 BST 2016 by dmrgo
 */
public class DefaultResource extends WrappedIndividualImpl implements Resource {

    public DefaultResource(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Object Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#ExecutesComplex
     */
     
    public Collection<? extends ComplexSkill> getExecutesComplex() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_EXECUTESCOMPLEX,
                                               DefaultComplexSkill.class);
    }

    public boolean hasExecutesComplex() {
	   return !getExecutesComplex().isEmpty();
    }

    public void addExecutesComplex(ComplexSkill newExecutesComplex) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_EXECUTESCOMPLEX,
                                       newExecutesComplex);
    }

    public void removeExecutesComplex(ComplexSkill oldExecutesComplex) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_EXECUTESCOMPLEX,
                                          oldExecutesComplex);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#ExecutesSimple
     */
     
    public Collection<? extends SimpleSkill> getExecutesSimple() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_EXECUTESSIMPLE,
                                               DefaultSimpleSkill.class);
    }

    public boolean hasExecutesSimple() {
	   return !getExecutesSimple().isEmpty();
    }

    public void addExecutesSimple(SimpleSkill newExecutesSimple) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_EXECUTESSIMPLE,
                                       newExecutesSimple);
    }

    public void removeExecutesSimple(SimpleSkill oldExecutesSimple) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_EXECUTESSIMPLE,
                                          oldExecutesSimple);
    }


    /* ***************************************************
     * Object Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#incorporate
     */
     
    public Collection<? extends Disturbance> getIncorporate() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_INCORPORATE,
                                               DefaultDisturbance.class);
    }

    public boolean hasIncorporate() {
	   return !getIncorporate().isEmpty();
    }

    public void addIncorporate(Disturbance newIncorporate) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_INCORPORATE,
                                       newIncorporate);
    }

    public void removeIncorporate(Disturbance oldIncorporate) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_INCORPORATE,
                                          oldIncorporate);
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
     * Data Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#Disturbance
     */
     
    public Collection<? extends Object> getDisturbance() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_DISTURBANCE, Object.class);
    }

    public boolean hasDisturbance() {
		return !getDisturbance().isEmpty();
    }

    public void addDisturbance(Object newDisturbance) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_DISTURBANCE, newDisturbance);
    }

    public void removeDisturbance(Object oldDisturbance) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_DISTURBANCE, oldDisturbance);
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
     * Data Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#Manufacturer
     */
     
    public Collection<? extends String> getManufacturer() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_MANUFACTURER, String.class);
    }

    public boolean hasManufacturer() {
		return !getManufacturer().isEmpty();
    }

    public void addManufacturer(String newManufacturer) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_MANUFACTURER, newManufacturer);
    }

    public void removeManufacturer(String oldManufacturer) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_MANUFACTURER, oldManufacturer);
    }


    /* ***************************************************
     * Data Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#SimpleSkills
     */
     
    public Collection<? extends Object> getSimpleSkills() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_SIMPLESKILLS, Object.class);
    }

    public boolean hasSimpleSkills() {
		return !getSimpleSkills().isEmpty();
    }

    public void addSimpleSkills(Object newSimpleSkills) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_SIMPLESKILLS, newSimpleSkills);
    }

    public void removeSimpleSkills(Object oldSimpleSkills) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_SIMPLESKILLS, oldSimpleSkills);
    }


}

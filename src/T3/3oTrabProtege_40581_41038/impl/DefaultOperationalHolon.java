package 3oTrabProtege.impl;

import 3oTrabProtege.*;


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
 * Source Class: DefaultOperationalHolon <br>
 * @version generated on Wed Dec 28 18:45:57 GMT 2016 by dmrg
 */
public class DefaultOperationalHolon extends WrappedIndividualImpl implements OperationalHolon {

    public DefaultOperationalHolon(CodeGenerationInference inference, IRI iri) {
        super(inference, iri);
    }





    /* ***************************************************
     * Object Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#Answer
     */
     
    public Collection<? extends SupervisorHolon> getAnswer() {
        return getDelegate().getPropertyValues(getOwlIndividual(),
                                               Vocabulary.OBJECT_PROPERTY_ANSWER,
                                               DefaultSupervisorHolon.class);
    }

    public boolean hasAnswer() {
	   return !getAnswer().isEmpty();
    }

    public void addAnswer(SupervisorHolon newAnswer) {
        getDelegate().addPropertyValue(getOwlIndividual(),
                                       Vocabulary.OBJECT_PROPERTY_ANSWER,
                                       newAnswer);
    }

    public void removeAnswer(SupervisorHolon oldAnswer) {
        getDelegate().removePropertyValue(getOwlIndividual(),
                                          Vocabulary.OBJECT_PROPERTY_ANSWER,
                                          oldAnswer);
    }


    /* ***************************************************
     * Data Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#HardwareType
     */
     
    public Collection<? extends String> getHardwareType() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HARDWARETYPE, String.class);
    }

    public boolean hasHardwareType() {
		return !getHardwareType().isEmpty();
    }

    public void addHardwareType(String newHardwareType) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HARDWARETYPE, newHardwareType);
    }

    public void removeHardwareType(String oldHardwareType) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_HARDWARETYPE, oldHardwareType);
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
     * Data Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#Location
     */
     
    public Collection<? extends String> getLocation() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_LOCATION, String.class);
    }

    public boolean hasLocation() {
		return !getLocation().isEmpty();
    }

    public void addLocation(String newLocation) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_LOCATION, newLocation);
    }

    public void removeLocation(String oldLocation) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_LOCATION, oldLocation);
    }


    /* ***************************************************
     * Data Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#Name
     */
     
    public Collection<? extends String> getName() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_NAME, String.class);
    }

    public boolean hasName() {
		return !getName().isEmpty();
    }

    public void addName(String newName) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_NAME, newName);
    }

    public void removeName(String oldName) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_NAME, oldName);
    }


    /* ***************************************************
     * Data Property http://www.semanticweb.org/dmrgo/ontologies/2016/9/finalOntology#Priority
     */
     
    public Collection<? extends Integer> getPriority() {
		return getDelegate().getPropertyValues(getOwlIndividual(), Vocabulary.DATA_PROPERTY_PRIORITY, Integer.class);
    }

    public boolean hasPriority() {
		return !getPriority().isEmpty();
    }

    public void addPriority(Integer newPriority) {
	    getDelegate().addPropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_PRIORITY, newPriority);
    }

    public void removePriority(Integer oldPriority) {
		getDelegate().removePropertyValue(getOwlIndividual(), Vocabulary.DATA_PROPERTY_PRIORITY, oldPriority);
    }


}

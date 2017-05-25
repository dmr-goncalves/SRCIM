package com.issiaa2016.semanticmodelimpl;

import com.issiaa2016.semanticmodelimpl.impl.*;


import java.util.Collection;

import org.protege.owl.codegeneration.CodeGenerationFactory;
import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.FactoryHelper;
import org.protege.owl.codegeneration.impl.ProtegeJavaMapping;
import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.protege.owl.codegeneration.inference.SimpleInference;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

/**
 * A class that serves as the entry point to the generated code providing access
 * to existing individuals in the ontology and the ability to create new individuals in the ontology.<p>
 * 
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: MyFactory<br>
 * @version generated on Sun Oct 16 15:26:31 BST 2016 by dmrgo
 */
public class MyFactory implements CodeGenerationFactory {
    private OWLOntology ontology;
    private ProtegeJavaMapping javaMapping = new ProtegeJavaMapping();
    private FactoryHelper delegate;
    private CodeGenerationInference inference;

    public MyFactory(OWLOntology ontology) {
	    this(ontology, new SimpleInference(ontology));
    }
    
    public MyFactory(OWLOntology ontology, CodeGenerationInference inference) {
        this.ontology = ontology;
        this.inference = inference;
        javaMapping.initialize(ontology, inference);
        delegate = new FactoryHelper(ontology, inference);
    }

    public OWLOntology getOwlOntology() {
        return ontology;
    }
    
    public void saveOwlOntology() throws OWLOntologyStorageException {
        ontology.getOWLOntologyManager().saveOntology(ontology);
    }
    
    public void flushOwlReasoner() {
        delegate.flushOwlReasoner();
    }
    
    public boolean canAs(WrappedIndividual resource, Class<? extends WrappedIndividual> javaInterface) {
    	return javaMapping.canAs(resource, javaInterface);
    }
    
    public  <X extends WrappedIndividual> X as(WrappedIndividual resource, Class<? extends X> javaInterface) {
    	return javaMapping.as(resource, javaInterface);
    }
    
    public Class<?> getJavaInterfaceFromOwlClass(OWLClass cls) {
        return javaMapping.getJavaInterfaceFromOwlClass(cls);
    }
    
    public OWLClass getOwlClassFromJavaInterface(Class<?> javaInterface) {
	    return javaMapping.getOwlClassFromJavaInterface(javaInterface);
    }
    
    public CodeGenerationInference getInference() {
        return inference;
    }

    /* ***************************************************
     * Class http://www.semanticweb.org/issiaa2016/ontologies/myOntology#Parameter
     */

    {
        javaMapping.add("http://www.semanticweb.org/issiaa2016/ontologies/myOntology#Parameter", Parameter.class, DefaultParameter.class);
    }

    /**
     * Creates an instance of type Parameter.  Modifies the underlying ontology.
     */
    public Parameter createParameter(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_PARAMETER, DefaultParameter.class);
    }

    /**
     * Gets an instance of type Parameter with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Parameter getParameter(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_PARAMETER, DefaultParameter.class);
    }

    /**
     * Gets all instances of Parameter from the ontology.
     */
    public Collection<? extends Parameter> getAllParameterInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_PARAMETER, DefaultParameter.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/issiaa2016/ontologies/myOntology#Product
     */

    {
        javaMapping.add("http://www.semanticweb.org/issiaa2016/ontologies/myOntology#Product", Product.class, DefaultProduct.class);
    }

    /**
     * Creates an instance of type Product.  Modifies the underlying ontology.
     */
    public Product createProduct(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_PRODUCT, DefaultProduct.class);
    }

    /**
     * Gets an instance of type Product with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Product getProduct(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_PRODUCT, DefaultProduct.class);
    }

    /**
     * Gets all instances of Product from the ontology.
     */
    public Collection<? extends Product> getAllProductInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_PRODUCT, DefaultProduct.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/issiaa2016/ontologies/myOntology#Resource
     */

    {
        javaMapping.add("http://www.semanticweb.org/issiaa2016/ontologies/myOntology#Resource", Resource.class, DefaultResource.class);
    }

    /**
     * Creates an instance of type Resource.  Modifies the underlying ontology.
     */
    public Resource createResource(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_RESOURCE, DefaultResource.class);
    }

    /**
     * Gets an instance of type Resource with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Resource getResource(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_RESOURCE, DefaultResource.class);
    }

    /**
     * Gets all instances of Resource from the ontology.
     */
    public Collection<? extends Resource> getAllResourceInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_RESOURCE, DefaultResource.class);
    }


    /* ***************************************************
     * Class http://www.semanticweb.org/issiaa2016/ontologies/myOntology#Skill
     */

    {
        javaMapping.add("http://www.semanticweb.org/issiaa2016/ontologies/myOntology#Skill", Skill.class, DefaultSkill.class);
    }

    /**
     * Creates an instance of type Skill.  Modifies the underlying ontology.
     */
    public Skill createSkill(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_SKILL, DefaultSkill.class);
    }

    /**
     * Gets an instance of type Skill with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Skill getSkill(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_SKILL, DefaultSkill.class);
    }

    /**
     * Gets all instances of Skill from the ontology.
     */
    public Collection<? extends Skill> getAllSkillInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_SKILL, DefaultSkill.class);
    }


}

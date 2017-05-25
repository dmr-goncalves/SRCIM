/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.issiaa2016.semanticmodelimpl.*;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

/**
 *
 * @author Andre Rocha
 */
public class testQuery {

    /**
     * @param args the command line arguments
     * @throws org.semanticweb.owlapi.model.OWLOntologyCreationException
     * @throws java.io.IOException
     * @throws org.semanticweb.owlapi.model.OWLOntologyStorageException
     */
    public static void main(String[] args) throws OWLOntologyCreationException, IOException, OWLOntologyStorageException {
        //Loading the Semantic Model
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        File file = new File("myOntology.owl");
        OWLOntology ontology = manager.loadOntologyFromOntologyDocument(file);
        MyFactory myFact = new MyFactory(ontology);

        //Defining the IRI
        String myIRI = "http://www.semanticweb.org/dmrgo/ontologies/2016/9/";
        
        Cell myCell = myFact.getCell(myIRI + "Cell 2");
        System.out.println("Cell Cell 2:");
        System.out.println("ID: " + myCell.getID());
        System.out.println("Frindly Name: " + myCell.getFriendly_Name());
        System.out.println("Description: " + myCell.getDescription());
        System.out.println("Produces: " + myCell.getProduces());
        System.out.println("Contains: " + myCell.getResource());
       
        Resource myResource = myFact.getResource(myIRI + "Robot5");
        System.out.println("Resource Robot5:");
        System.out.println("ID: " + myResource.getID());
        System.out.println("Frindly Name: " + myResource.getFriendly_Name());
        System.out.println("Description: " + myResource.getDescription());
        System.out.println("Manufacturer: " + myResource.getManufacturer());
        System.out.println("Executes Complex: " + myResource.getExecutesComplex());
        System.out.println("Has disturbances: " + myResource.getIncorporate());
        
        ComplexSkill myComplexSkill = myFact.getComplexSkill(myIRI + "PickAndPlace");
        System.out.println("Skill PickAndPlace");
        System.out.println("ID: " + myComplexSkill.getID());
        System.out.println("Frindly Name: " + myComplexSkill.getFriendly_Name());
        System.out.println("Description: " + myComplexSkill.getDescription());
        System.out.println("Contains: " + myComplexSkill.getHave());
        
        SimpleSkill mySimpleSkill = myFact.getSimpleSkill(myIRI + "Pick");
        System.out.println("Skill Pick");
        System.out.println("ID: " + mySimpleSkill.getID());
        System.out.println("Frindly Name: " + mySimpleSkill.getFriendly_Name());
        System.out.println("Description: " + mySimpleSkill.getDescription());
        System.out.println("Consumes: " + mySimpleSkill.getContains());
        
        Product myProduct = myFact.getProduct(myIRI + "ProductY");
        System.out.println("Product ProductY");
        System.out.println("ID: " + myProduct.getID());
        System.out.println("Frindly Name: " + myProduct.getFriendly_Name());
        System.out.println("Description: " + myProduct.getDescription());
        System.out.println("Consumes: " + myProduct.getConsumes());

        Disturbance myDisturbance = myFact.getDisturbance(myIRI + "Jammed");
        System.out.println("Disturbance Jammed");
        System.out.println("ID: " + myDisturbance.getID());
        System.out.println("Frindly Name: " + myDisturbance.getFriendly_Name());
        System.out.println("Description: " + myDisturbance.getDescription());
        System.out.println("Performs: " + myDisturbance.getPerform());
        System.out.println("Have: " + myDisturbance.getResource());       
    }
}

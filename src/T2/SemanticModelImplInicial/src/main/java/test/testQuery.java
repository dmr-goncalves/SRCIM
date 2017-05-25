/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.issiaa2016.semanticmodelimpl.MyFactory;
import com.issiaa2016.semanticmodelimpl.Parameter;
import com.issiaa2016.semanticmodelimpl.Product;
import com.issiaa2016.semanticmodelimpl.Resource;
import com.issiaa2016.semanticmodelimpl.Skill;
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
        String myIRI = "http://www.semanticweb.org/issiaa2016/ontologies/";

        Resource myResource = myFact.getResource(myIRI + "RobotX");
        System.out.println("Resource RobotX:");
        System.out.println("ID: " + myResource.getID());
        System.out.println("Frindly Name: " + myResource.getFriendly_Name());
        System.out.println("Description: " + myResource.getDescription());
        System.out.println("Manufacturer: " + myResource.getManufacturer());
        System.out.println("Executes: " + myResource.getExecutes());

        Product myProduct = myFact.getProduct(myIRI + "ProductY");
        System.out.println("Product ProductY");
        System.out.println("ID: " + myProduct.getID());
        System.out.println("Frindly Name: " + myProduct.getFriendly_Name());
        System.out.println("Description: " + myProduct.getDescription());
        System.out.println("Consumes: " + myProduct.getConsumes());

        Skill mySkill1 = myFact.getSkill(myIRI + "Press");
        System.out.println("Skill Press");
        System.out.println("ID: " + mySkill1.getID());
        System.out.println("Frindly Name: " + mySkill1.getFriendly_Name());
        System.out.println("Description: " + mySkill1.getDescription());
        System.out.println("Consumes: " + mySkill1.getContains());
    }
}

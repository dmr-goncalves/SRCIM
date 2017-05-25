/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import com.issiaa2016.semanticmodelimpl.*;
import java.io.File;
import java.io.IOException;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

/**
 *
 * @author andrerocha
 */
public class testEditOWL {

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
        
        //Creating a new resource
        Resource myResource = myFact.createResource("RobotX");
        myResource.addDescription("3 Axis Robot Model X");
        myResource.addID("12");
        myResource.addFriendly_Name("3 Axis Robot");
        myResource.addManufacturer("My Manufacturer");
        
        //Creating a skill
        Skill mySkill1 = myFact.createSkill("PickAndPlace");
        mySkill1.addID("1");
        mySkill1.addFriendly_Name("PickAndPlace");
        mySkill1.addDescription("Pick and Place from position BEGIN to END");
        
        //Creating a skill
        Skill mySkill2 = myFact.createSkill("Press");
        mySkill2.addID("2");
        mySkill2.addFriendly_Name("Press");
        mySkill2.addDescription("Press a part");
                
        //Creating a parameter
        Parameter myParameter1 = myFact.createParameter("BEGIN");
        myParameter1.addID("1");
        myParameter1.addFriendly_Name("BEGIN");
        myParameter1.addDescription("Begin of the movement");
        myParameter1.addType("Integer");
        myParameter1.addValue("3");
        
        //Creating a parameter
        Parameter myParameter2 = myFact.createParameter("END");
        myParameter2.addID("2");
        myParameter2.addFriendly_Name("END");
        myParameter2.addDescription("End of the movement");
        myParameter2.addType("Integer");
        myParameter2.addValue("5");
        
        //Creating a parameter
        Parameter myParameter3 = myFact.createParameter("FORCE");
        myParameter3.addID("3");
        myParameter3.addFriendly_Name("FORCE");
        myParameter3.addDescription("Force performed by the robot");
        myParameter3.addType("Integer");
        myParameter3.addValue("8");
        
        //Joining the data
        //Resource contains Skill1 (Parameter1 + Parameter2)
        mySkill1.addContains(myParameter1);
        mySkill1.addContains(myParameter2);
        myResource.addExecutes(mySkill1);
        
        //Resource contains Skill2 (Parameter3)
        mySkill2.addContains(myParameter3);
        myResource.addExecutes(mySkill2);
        
        //Creating a Product
        Product myProduct = myFact.createProduct("ProductY");
        myProduct.addID("1");
        myProduct.addDescription("Product executes Pick and Place and Press");
        myProduct.addFriendly_Name("ProductY");
        myProduct.addConsumes(mySkill1);
        myProduct.addConsumes(mySkill2);
        
        //Saving the ontology
        manager.saveOntology(ontology);
        
    }

}

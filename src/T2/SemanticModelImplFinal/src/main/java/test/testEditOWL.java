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
        File file = new File("finalOntology.owl");
        OWLOntology ontology = manager.loadOntologyFromOntologyDocument(file);
        MyFactory myFact = new MyFactory(ontology);
        
        //Creating a Disturbance
        Disturbance myDisturbance = myFact.createDisturbance("Jammed");
        myDisturbance.addID("101");
        myDisturbance.addDescription("Resource Jammed");
        myDisturbance.addFriendly_Name("Jammed"); 
        
        //Creating a new resource
        Resource myResource1 = myFact.createResource("Robot 1");
        myResource1.addDescription("3 Axis Robot Model X");
        myResource1.addID("12");
        myResource1.addFriendly_Name("3 Axis Robot");
        myResource1.addManufacturer("My Manufacturer");
        myResource1.addIncorporate(myDisturbance);
        myDisturbance.addPerform(myResource1);
        
        //Creating a new resource
        Resource myResource2 = myFact.createResource("Robot 2");
        myResource2.addDescription("3 Axis Robot Model X");
        myResource2.addID("123");
        myResource2.addFriendly_Name("3 Axis Robot");
        myResource2.addManufacturer("My Manufacturer");
        myResource2.addIncorporate(myDisturbance);
        myDisturbance.addPerform(myResource2);
        
        //Creating a new resource
        Resource myResource3 = myFact.createResource("Robot 3");
        myResource3.addDescription("3 Axis Robot Model X");
        myResource3.addID("12");
        myResource3.addFriendly_Name("3 Axis Robot");
        myResource3.addManufacturer("My Manufacturer");
        myResource3.addIncorporate(myDisturbance);
        myDisturbance.addPerform(myResource3);
        
        //Creating a new resource
        Resource myResource4 = myFact.createResource("Convoyer 1");
        myResource4.addDescription("Convoyer");
        myResource4.addID("123");
        myResource4.addFriendly_Name("Convoyer");
        myResource4.addManufacturer("My Manufacturer");
        myResource4.addIncorporate(myDisturbance);
        myDisturbance.addPerform(myResource4);
        
        //Creating a new resource
        Resource myResource5 = myFact.createResource("Robot 4");
        myResource5.addDescription("3 Axis Robot Model X");
        myResource5.addID("123");
        myResource5.addFriendly_Name("3 Axis Robot");
        myResource5.addManufacturer("My Manufacturer");
        myResource5.addIncorporate(myDisturbance);
        myDisturbance.addPerform(myResource5);
        
        //Creating a new resource
        Resource myResource6 = myFact.createResource("Robot 5");
        myResource6.addDescription("3 Axis Robot Model X");
        myResource6.addID("123");
        myResource6.addFriendly_Name("3 Axis Robot");
        myResource6.addManufacturer("My Manufacturer");
        myResource6.addIncorporate(myDisturbance);
        myDisturbance.addPerform(myResource6);
                
        //Creating a simple skill
        SimpleSkill SimpleSkill1 = myFact.createSimpleSkill("Pick");
        SimpleSkill1.addID("112");
        SimpleSkill1.addFriendly_Name("Pick");
        SimpleSkill1.addDescription("Pick from position BEGIN");
        
        //Creating a simple skill
        SimpleSkill SimpleSkill2 = myFact.createSimpleSkill("Place");
        SimpleSkill2.addID("113");
        SimpleSkill2.addFriendly_Name("Place");
        SimpleSkill2.addDescription("Place on position END");
        
        //Creating a Complex Skill
        ComplexSkill ComplexSkill1 = myFact.createComplexSkill("PickAndPlace");
        ComplexSkill1.addID("121");
        ComplexSkill1.addFriendly_Name("Pick_and_Place");
        ComplexSkill1.addDescription("Pick and Place from position BEGIN to END");
        ComplexSkill1.addHave(SimpleSkill1);
        ComplexSkill1.addHave(SimpleSkill2);
        
        //Creating a simple skill
        SimpleSkill SimpleSkill3 = myFact.createSimpleSkill("Move");
        SimpleSkill3.addID("11");
        SimpleSkill3.addFriendly_Name("Move");
        SimpleSkill3.addDescription("Start moving");
        
        //Creating a simple skill
        SimpleSkill SimpleSkill4 = myFact.createSimpleSkill("Stop");
        SimpleSkill4.addID("13");
        SimpleSkill4.addFriendly_Name("Stop");
        SimpleSkill4.addDescription("Stop Moving");
        
        //Creating a Complex Skill
        ComplexSkill ComplexSkill2 = myFact.createComplexSkill("MoveAndStop");
        ComplexSkill2.addID("121");
        ComplexSkill2.addFriendly_Name("Move_And_Stop");
        ComplexSkill2.addDescription("Move and Stop");
        ComplexSkill2.addHave(SimpleSkill3);
        ComplexSkill2.addHave(SimpleSkill4);
        
        //Creating a simple skill
        SimpleSkill SimpleSkill5 = myFact.createSimpleSkill("Paint");
        SimpleSkill5.addID("43");
        SimpleSkill5.addFriendly_Name("Paint");
        SimpleSkill5.addDescription("Paint Object");
        
        //Creating a simple skill
        SimpleSkill SimpleSkill6 = myFact.createSimpleSkill("Dry");
        SimpleSkill6.addID("44");
        SimpleSkill6.addFriendly_Name("Dry");
        SimpleSkill6.addDescription("Dry Object");
        
        //Creating a Complex Skill
        ComplexSkill ComplexSkill3 = myFact.createComplexSkill("PaintAndDry");
        ComplexSkill3.addID("10");
        ComplexSkill3.addFriendly_Name("Paint_And_Dry");
        ComplexSkill3.addDescription("Paint and Dry");
        ComplexSkill3.addHave(SimpleSkill5);
        ComplexSkill3.addHave(SimpleSkill6);
       
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
        Parameter myParameter3 = myFact.createParameter("Color");
        myParameter3.addID("3");
        myParameter3.addFriendly_Name("Color");
        myParameter3.addDescription("Color to paint");
        myParameter3.addType("String");
        myParameter3.addValue("128");
        
         //Creating a parameter
        Parameter myParameter4 = myFact.createParameter("TimeToDry");
        myParameter4.addID("4");
        myParameter4.addFriendly_Name("TimeToDry");
        myParameter4.addDescription("Time to dry");
        myParameter4.addType("Int");
        myParameter4.addValue("128");
        
        //Joining the data
        SimpleSkill1.addContains(myParameter1);
        SimpleSkill2.addContains(myParameter2);
        
        SimpleSkill3.addContains(myParameter3);
        SimpleSkill4.addContains(myParameter4);
        
        myResource1.addExecutesComplex(ComplexSkill1); //to Cell 1
        myResource2.addExecutesComplex(ComplexSkill3);
        
        myResource3.addExecutesComplex(ComplexSkill1); //To Cell 2
        myResource4.addExecutesComplex(ComplexSkill2);
        myResource5.addExecutesComplex(ComplexSkill3);
        
        myResource6.addExecutesComplex(ComplexSkill3); //To Cell 3
        
        //Creating a Product
        Product myProduct1 = myFact.createProduct("ProductY");
        myProduct1.addID("1");
        myProduct1.addDescription("Product executes Pick and Place and Press");
        myProduct1.addFriendly_Name("ProductY");
        
        //Creating a Product
        Product myProduct2 = myFact.createProduct("ProductX");
        myProduct2.addID("2");
        myProduct2.addDescription("Product executes ");
        myProduct2.addFriendly_Name("ProductX");
        
        //Creating a Product
        Product myProduct3 = myFact.createProduct("ProductZ");
        myProduct3.addID("3");
        myProduct3.addDescription("Product executes");
        myProduct3.addFriendly_Name("ProductX");
        
        //Creating a Cell
        Cell myCell1 = myFact.createCell("Cell 1");
        myCell1.addID("1");
        myCell1.addFriendly_Name("Cell 1");
        myCell1.addDescription("Manufacturing Cell 1");
        myCell1.addProduces(myProduct1);
        myCell1.addResource(myResource1);
        myCell1.addResource(myResource2);
        
        //Creating a Cell
        Cell myCell2 = myFact.createCell("Cell 2");
        myCell2.addID("1");
        myCell2.addFriendly_Name("Cell 2");
        myCell2.addDescription("Manufacturing Cell 2");
        myCell2.addProduces(myProduct2);
        myCell2.addResource(myResource3);
        myCell2.addResource(myResource4);
        myCell2.addResource(myResource5);
        
        //Creating a Cell
        Cell myCell3 = myFact.createCell("Cell 3");
        myCell3.addID("1");
        myCell3.addFriendly_Name("Cell 3");
        myCell3.addDescription("Manufacturing Cell 3");
        myCell3.addProduces(myProduct3);
        myCell3.addResource(myResource3);
        
        //Saving the ontology
        manager.saveOntology(ontology);
    }

}

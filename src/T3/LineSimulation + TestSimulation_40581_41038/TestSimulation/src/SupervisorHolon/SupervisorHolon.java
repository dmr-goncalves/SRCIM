/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupervisorHolon;

import static Utilities.Constants.ONTOLOGY_SUPERVISOR;
import static Utilities.DFInteraction.RegisterInDF;
import static Utilities.DFInteraction.SearchInDFExtra;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author André
 */
public class SupervisorHolon extends Agent {

    protected String id;
    protected String name;
    protected LinkedList<String> hwList;
    protected LinkedList<String> OperationalHolons;
    protected DFAgentDescription[] OH;
    protected LinkedList<String> listOHAccepted;
    protected LinkedList<String> listOHFound = new LinkedList<>();
    protected SupervisorHolon SH;
    protected String Product;
    ACLMessage msgToOH = new ACLMessage(ACLMessage.CFP);
    protected MessageTemplate CFP2SH = MessageTemplate.MatchPerformative(ACLMessage.CFP);
    protected String ResourceLocation;
    protected boolean firstTime = true;
    protected boolean OHFound = false;

    public SupervisorHolon(String _id, String _name, LinkedList<String> _OperationHolons) {
        this.id = _id;
        this.name = _name;
        this.hwList = new LinkedList<>();
        this.OperationalHolons = _OperationHolons;
        this.SH = this;
    }

    @Override
    protected void setup() {

        //Argumets [0]resource location [1]skills taht resource can perform 
        Object[] args = getArguments();
        try {
            RegisterInDF(this, name, ONTOLOGY_SUPERVISOR);
        } catch (FIPAException ex) {
            Logger.getLogger(SupervisorHolon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        msgToOH.setOntology("SupReq");
        this.addBehaviour(new AnswerTH(this, CFP2SH));
    }

    @Override
    protected void takeDown() {
        try {
            DFService.deregister(this);
        } catch (FIPAException ex) {
            Logger.getLogger(SupervisorHolon.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.takeDown();
    }
}

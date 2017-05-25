package OperationalHolon;

import static Utilities.DFInteraction.RegisterInDF;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author André
 */
public class OperationalHolon extends Agent {

    protected String id;
    protected String name;
    protected String hardwaretype;
    protected DFAgentDescription SH;
    protected String ResourceLocation;
    protected DFAgentDescription SO;
    protected int priority;
    MessageTemplate response = MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.CFP), MessageTemplate.MatchOntology("SupReq"));

//[0]- id, [1] resource location , [2] hardware type, [3] skills
    public OperationalHolon(String id, String name, String ResourceLocation, String hardwaretype, String _priority) {
        this.id = id;
        this.name = name;
        this.hardwaretype = hardwaretype;
        this.ResourceLocation = ResourceLocation;
        this.priority = Integer.parseInt(_priority);
    }

    @Override
    protected void setup() {

        try {//Register in DF here
            RegisterInDF(this, name, "Operational");
        } catch (FIPAException ex) {
            Logger.getLogger(OperationalHolon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.addBehaviour(new AnswerSH(this, response));
    }

    @Override
    protected void takeDown() {
        try {
            DFService.deregister(this);
        } catch (FIPAException ex) {
            Logger.getLogger(OperationalHolon.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.takeDown();
    }
}

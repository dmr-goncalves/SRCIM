/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OperationalHolon;

import jade.domain.FIPAAgentManagement.FailureException;
import jade.domain.FIPAAgentManagement.NotUnderstoodException;
import jade.domain.FIPAAgentManagement.RefuseException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.ContractNetResponder;

/**
 *
 * @author dmrg
 */
public class AnswerSH extends ContractNetResponder {

    private OperationalHolon OH;

    public AnswerSH(OperationalHolon a, MessageTemplate mt) {
        super(a, mt);
        this.OH = a;
    }

    @Override
    protected ACLMessage handleCfp(ACLMessage cfp) throws NotUnderstoodException, RefuseException, FailureException {
        //System.out.println("Operational: Processing CFP message");
        ACLMessage msg = cfp.createReply();
        msg.setPerformative(ACLMessage.PROPOSE);
        msg.setContent(OH.hardwaretype + "," + OH.priority);
        return msg;
    }

    @Override
    protected ACLMessage handleAcceptProposal(ACLMessage cfp, ACLMessage propose, ACLMessage accept) throws FailureException {
        //System.out.println(myAgent.getLocalName() + ": Preparing result of CFP");

        ACLMessage msg = cfp.createReply();
        msg.setContent(OH.id + ',' + OH.ResourceLocation);
        msg.setPerformative(ACLMessage.INFORM);

        return msg;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleTaskHolon;

import jade.lang.acl.ACLMessage;
import jade.proto.ContractNetInitiator;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author dmrg
 */
public class ContractToSH extends ContractNetInitiator {

    private SimpleTaskHolon STH;

    public ContractToSH(SimpleTaskHolon a, ACLMessage msg) {
        super(a, msg);
        this.STH = a;
    }

    @Override
    protected void handleAllResponses(Vector responses, Vector acceptances) {
        //System.out.println(myAgent.getLocalName() + ": All PROPOSALS received");
        ACLMessage auxMsg = (ACLMessage) responses.get(0);
        if (auxMsg.getPerformative() == ACLMessage.REFUSE) {
            STH.addBehaviour(new ContractToSH(STH, STH.msgCFP));
        }
        if (auxMsg.getPerformative() == ACLMessage.PROPOSE) {
            ACLMessage reply = auxMsg.createReply();
            reply.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
            reply.setContent(auxMsg.getContent());
            acceptances.add(reply);
        }
    }

    @Override
    protected void handleInform(ACLMessage inform) {
        System.out.println(myAgent.getLocalName() + ": INFORM message received");
        StringTokenizer st = new StringTokenizer(inform.getContent(), Utilities.Constants.TOKEN_GENERAL);
        String prod = st.nextToken(), pos = st.nextToken();
        STH.productTaskFinished.put(prod, true);
        STH.taskLocation.put(prod, pos);
    }
}

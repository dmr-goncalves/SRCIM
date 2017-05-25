/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleTaskHolon;

import jade.domain.FIPAAgentManagement.FailureException;
import jade.domain.FIPAAgentManagement.NotUnderstoodException;
import jade.domain.FIPAAgentManagement.RefuseException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.AchieveREResponder;
import java.util.StringTokenizer;

/**
 *
 * @author dmrg
 */
public class AnswerComplexTH extends AchieveREResponder {

    private SimpleTaskHolon STH;

    public AnswerComplexTH(SimpleTaskHolon a, MessageTemplate mt) {
        super(a, mt);
        this.STH = a;
    }

    @Override
    protected ACLMessage handleRequest(ACLMessage request) throws NotUnderstoodException, RefuseException {
        //System.out.println("Task: Processing REQUEST message");
        ACLMessage msg = request.createReply();
        StringTokenizer st = new StringTokenizer(request.getContent(), Utilities.Constants.TOKEN_GENERAL);
        STH.prodName = st.nextToken();

        if (STH.productFirstTimeContract.get(STH.prodName) == null) {
            STH.productFirstTimeContract.put(STH.prodName, true);
        }

        //Communicate with supervisors
        if (STH.productFirstTimeContract.get(STH.prodName)) {

            STH.productFirstTimeContract.remove(STH.prodName);
            STH.productFirstTimeContract.put(STH.prodName, false);

            STH.productTaskFinished.remove(STH.prodName);
            STH.productTaskFinished.put(STH.prodName, false);
            STH.msgCFP.setContent(STH.hardwareNeeded + "," + STH.prodName);
            STH.addBehaviour(new ContractToSH(STH, STH.msgCFP));
        }

        if (!STH.productTaskFinished.get(STH.prodName)) {
            msg.setPerformative(ACLMessage.REFUSE);
        } else {
            msg.setPerformative(ACLMessage.AGREE);
        }
        return msg;
    }

    @Override
    protected ACLMessage prepareResultNotification(ACLMessage request, ACLMessage respost) throws FailureException {
        ACLMessage msg = request.createReply();

        STH.productTaskFinished.remove(STH.prodName);
        STH.productTaskFinished.put(STH.prodName, false);
        STH.productFirstTimeContract.remove(STH.prodName);
        STH.productFirstTimeContract.put(STH.prodName, true);
        msg.setContent(STH.taskLocation.get(STH.prodName));
        msg.setPerformative(ACLMessage.INFORM);
        return msg;
    }
}

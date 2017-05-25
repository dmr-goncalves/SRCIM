/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComplexTaskHolon;

import static Utilities.Constants.ONTOLOGY_TASK;
import static Utilities.DFInteraction.SearchInDFExtra;
import jade.domain.FIPAAgentManagement.FailureException;
import jade.domain.FIPAAgentManagement.NotUnderstoodException;
import jade.domain.FIPAAgentManagement.RefuseException;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.AchieveREResponder;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmrg
 */
public class ComplexAnswerPH extends AchieveREResponder {

    private ComplexTaskHolon CTH;

    public ComplexAnswerPH(ComplexTaskHolon a, MessageTemplate mt) {
        super(a, mt);
        this.CTH = a;
    }

    @Override
    protected ACLMessage handleRequest(ACLMessage request) throws NotUnderstoodException, RefuseException {
        //System.out.println("Task: Processing REQUEST message");
        ACLMessage msg = request.createReply();
        StringTokenizer st = new StringTokenizer(request.getContent(), Utilities.Constants.TOKEN_GENERAL);
        CTH.prodName = st.nextToken();

        if (CTH.firstTime) {
            try {
                CTH.subTaskHolon = SearchInDFExtra(ONTOLOGY_TASK, CTH, CTH.subTasks.get(CTH.i));
                //After having the Simple Task Holon tha make our groupe we will make a Request when a Request arrives from the product
                for (int j = 0; j < CTH.subTaskHolon.length; j++) {
                    CTH.msgReqSubTask.addReceiver(CTH.subTaskHolon[j].getName());
                }
            } catch (FIPAException ex) {
                Logger.getLogger(CTH.getName()).log(Level.SEVERE, null, ex);
            }
            CTH.msgReqSubTask.setContent(CTH.prodName);
            CTH.addBehaviour(new RequestSimpleTH(CTH, CTH.msgReqSubTask));
            CTH.firstTime = false;
        }

        if (CTH.simpleTasksFinished) {
            msg.setPerformative(ACLMessage.AGREE);
        } else {
            msg.setPerformative(ACLMessage.REFUSE);
        }
        return msg;
    }

    @Override
    protected ACLMessage prepareResultNotification(ACLMessage request, ACLMessage respost) throws FailureException {
        ACLMessage msg = request.createReply();
        //System.out.println(myAgent.getLocalName() + ": Preparing result of REQUEST");
        for (int g = 0; g < CTH.simpleTasksLocations.size(); g++) {
            if (CTH.simpleTasksLoc == null) {
                CTH.simpleTasksLoc = CTH.simpleTasksLocations.get(g);
            } else {
                CTH.simpleTasksLoc = CTH.simpleTasksLoc + "," + CTH.simpleTasksLocations.get(g);
            }
        }

        CTH.informCounter = 0;
        CTH.msgReqSubTask.clearAllReceiver();

        msg.setContent(CTH.simpleTasksLoc);
        CTH.simpleTasksLoc = null;
        CTH.simpleTasksLocations = new LinkedList<>();
        CTH.i = 0;
        msg.setPerformative(ACLMessage.INFORM);
        CTH.firstTime = true;
        CTH.simpleTasksFinished = false;
        return msg;
    }
}

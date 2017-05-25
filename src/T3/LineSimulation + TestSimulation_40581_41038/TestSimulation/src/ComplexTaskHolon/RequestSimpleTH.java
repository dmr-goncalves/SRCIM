/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComplexTaskHolon;

import ProductHolon.*;
import static Utilities.Constants.ONTOLOGY_TASK;
import static Utilities.DFInteraction.SearchInDFExtra;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmrg
 */
public class RequestSimpleTH extends AchieveREInitiator {

    int c = 0, i = 0, v = 0;
    private ComplexTaskHolon CTH;
    protected boolean agreed = false;

    public RequestSimpleTH(ComplexTaskHolon a, ACLMessage msg) {
        super(a, msg);
        this.CTH = a;
        this.i = CTH.i;
    }

    @Override
    protected void handleAgree(ACLMessage agree) {
        //System.out.println(myAgent.getLocalName() + ": AGREE message received");
        if (!agreed) {
            CTH.holonsAgreed.add(agree.getSender().getLocalName());
            agreed = true;
        }
    }

    @Override
    protected void handleRefuse(ACLMessage refuse) {
        //System.out.println(myAgent.getLocalName() + ": REFUSE message received");
        CTH.addBehaviour(new RequestSimpleTH(CTH, CTH.msgReqSubTask));
    }

    @Override
    protected void handleInform(ACLMessage inform) {
        System.out.println("ComplexT: Inform Received");
        if (CTH.holonsAgreed.contains(inform.getSender().getLocalName())) {
            if (inform.getPerformative() == ACLMessage.INFORM) {
                CTH.informCounter++;
                CTH.simpleTasksLocations.add(inform.getContent());
                if (CTH.informCounter == CTH.subTasks.size()) {
                    CTH.simpleTasksFinished = true;
                } else {
                    for (c = 0; c < CTH.subTaskHolon.length; c++) {
                        CTH.msgReqSubTask.removeReceiver(CTH.subTaskHolon[c].getName());
                    }

                    i++;
                    CTH.i++;

                    if (i >= CTH.subTasks.size()) {
                        i = CTH.subTasks.size() - 1;
                    }
                    
                    try {
                        CTH.subTaskHolon = SearchInDFExtra(ONTOLOGY_TASK, CTH, CTH.subTasks.get(i));
                        agreed = false;

                    } catch (FIPAException ex) {
                        Logger.getLogger(ProductHolon.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //After having the Task Holons we will make a FIPA Request for the execution 
                    for (v = 0; v < CTH.subTaskHolon.length; v++) {
                        CTH.msgReqSubTask.addReceiver(CTH.subTaskHolon[v].getName());
                    }
                    CTH.addBehaviour(new RequestSimpleTH(CTH, CTH.msgReqSubTask));
                }
            }
        }
    }
}

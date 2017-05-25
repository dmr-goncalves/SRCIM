/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductHolon;

import static Utilities.Constants.ONTOLOGY_TASK;
import static Utilities.DFInteraction.SearchInDFExtra;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmrg
 */
public class RequestTH extends AchieveREInitiator {

    int c = 0, i = 0, v = 0;
    private ProductHolon PH;
    protected boolean agreed = false;

    public RequestTH(ProductHolon a, ACLMessage msg) {
        super(a, msg);
        this.PH = a;
        this.i = PH.i;
    }

    @Override
    protected void handleAgree(ACLMessage agree) {
        //System.out.println(myAgent.getLocalName() + ": AGREE message received");
        if (!agreed) {
            PH.holonsAgreed.add(agree.getSender().getLocalName());
            agreed = true;
        }
    }

    @Override
    protected void handleRefuse(ACLMessage refuse) {
        //System.out.println(myAgent.getLocalName() + ": REFUSE message received");
        PH.addBehaviour(new RequestTH(PH, PH.msgReq));
    }

    @Override
    protected void handleInform(ACLMessage inform) {
        System.out.println("Product: Inform Received");
        if (PH.holonsAgreed.contains(inform.getSender().getLocalName())) {
            if (inform.getPerformative() == ACLMessage.INFORM) {

                StringTokenizer st = new StringTokenizer(inform.getContent(), Utilities.Constants.TOKEN_GENERAL);
                while (st.hasMoreTokens()) {
                    PH.locations.add(st.nextToken());
                }

                PH.informCounter++;

                if (PH.informCounter == PH.myTasks.size()) {
                    PH.msgTransport.setContent(PH.name + "," + PH.locations.pop()); //Posicao Final
                    PH.addBehaviour(new RequestTransport(PH, PH.msgTransport));
                } else {
                    for (c = 0; c < PH.taskHolon.length; c++) {
                        PH.msgReq.removeReceiver(PH.taskHolon[c].getName());
                    }

                    i++;
                    PH.i++;

                    if (i >= PH.myTasks.size()) {
                        i = PH.myTasks.size() - 1;
                    }

                    try {
                        PH.taskHolon = SearchInDFExtra(ONTOLOGY_TASK, PH, PH.myTasks.get(i));
                        agreed = false;

                    } catch (FIPAException ex) {
                        Logger.getLogger(ProductHolon.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //After having the Task Holons we will make a FIPA Request for the execution 
                    for (v = 0; v < PH.taskHolon.length; v++) {
                        PH.msgReq.addReceiver(PH.taskHolon[v].getName());
                    }

                    PH.addBehaviour(new RequestTH(PH, PH.msgReq));
                }
            }
        }
    }
}

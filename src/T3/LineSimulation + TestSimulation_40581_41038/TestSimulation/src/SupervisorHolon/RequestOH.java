/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupervisorHolon;

import jade.core.AID;
import jade.lang.acl.ACLMessage;
import jade.proto.ContractNetInitiator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author dmrg
 */
public class RequestOH extends ContractNetInitiator {

    private SupervisorHolon SH;
    private int priority = 0;
    private AID OH;
    private boolean accepted = true;
    private boolean hasHardware = true;

    public RequestOH(SupervisorHolon a, ACLMessage msg) {
        super(a, msg);
        this.SH = a;
    }

    @Override
    protected void handleInform(ACLMessage inform) {
        System.out.println("Supervisor: Inform received");

        SH.listOHAccepted = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(inform.getContent(), Utilities.Constants.TOKEN_GENERAL);
        String a = st.nextToken();
        SH.listOHAccepted.add(a);
        SH.ResourceLocation = st.nextToken();
        priority = 0;
        OH = new AID();
    }

    @Override
    protected void handleAllResponses(Vector responses, Vector acceptances) {
        //System.out.println(myAgent.getLocalName() + ": All PROPOSALS received");
        for (int j = 0; j < responses.size(); j++) {
            ACLMessage auxMsg = (ACLMessage) responses.get(j);
            StringTokenizer st = new StringTokenizer(auxMsg.getContent(), Utilities.Constants.TOKEN_GENERAL);

            String hardwareGiven = st.nextToken();
            int priorityGiven = Integer.parseInt(st.nextToken());

            ACLMessage reply = auxMsg.createReply();
            if (auxMsg.getPerformative() == ACLMessage.PROPOSE) {
                for (int i = 0; i < SH.hwList.size(); i++) {
                    if (SH.hwList.get(i).equals(hardwareGiven)) {

                        if (priorityGiven > priority) {
                            priority = priorityGiven;
                            OH = auxMsg.getSender();
                        }
                        hasHardware = true;

                    } else {
                        hasHardware = false;
                    }

                    if (!hasHardware) {
                        reply.setPerformative(ACLMessage.REJECT_PROPOSAL);
                        acceptances.add(reply);
                    }
                }
            }
        }

        for (int j = 0; j < responses.size(); j++) {
            ACLMessage auxMsg = (ACLMessage) responses.get(j);

            ACLMessage reply = auxMsg.createReply();
            if (auxMsg.getPerformative() == ACLMessage.PROPOSE) {
                for (int i = 0; i < SH.hwList.size(); i++) {

                    if (auxMsg.getSender() == OH) {
                        reply.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                        acceptances.add(reply);
                        accepted = true;
                        break;
                    }
                    accepted = false;
                }
                if (!accepted) {
                    reply.setPerformative(ACLMessage.REJECT_PROPOSAL);
                    acceptances.add(reply);
                }
            }
        }
    }
}

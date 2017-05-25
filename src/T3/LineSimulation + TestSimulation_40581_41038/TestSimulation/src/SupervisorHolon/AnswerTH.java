/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupervisorHolon;

import static Utilities.DFInteraction.SearchInDFExtra;
import jade.domain.FIPAAgentManagement.FailureException;
import jade.domain.FIPAAgentManagement.NotUnderstoodException;
import jade.domain.FIPAAgentManagement.RefuseException;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.ContractNetResponder;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmrg
 */
public class AnswerTH extends ContractNetResponder {

    private SupervisorHolon SH;

    public AnswerTH(SupervisorHolon a, MessageTemplate mt) {
        super(a, mt);
        this.SH = a;
    }

    @Override
    protected ACLMessage handleCfp(ACLMessage cfp) throws NotUnderstoodException, RefuseException, FailureException {
        //System.out.println("Supervisor: Processing CFP message");
        ACLMessage msg = cfp.createReply();
        StringTokenizer st = new StringTokenizer(cfp.getContent(), Utilities.Constants.TOKEN_GENERAL);

        String HWNeeded = st.nextToken();
        String Prod = st.nextToken();
        SH.Product = Prod;

        if (SH.listOHAccepted != null) {
            for (int z = 0; z < SH.listOHFound.size(); z++) {
                if (SH.listOHAccepted.contains(SH.listOHFound.get(z))) {
                    SH.OHFound = true;
                    break;
                }
            }
        }

        if (!SH.OHFound) {
            msg.setPerformative(ACLMessage.REFUSE);
            if (SH.firstTime) {

                for (int i = 0; i < SH.OperationalHolons.size(); i++) {
                    try {
                        SH.OH = SearchInDFExtra(Utilities.Constants.ONTOLOGY_OPERATIONAL, SH, SH.OperationalHolons.get(i));

                        for (int j = 0; j < SH.OH.length; j++) {
                            SH.listOHFound.add(SH.OH[j].getName().getLocalName());
                            SH.msgToOH.addReceiver(SH.OH[j].getName());
                        }
                    } catch (FIPAException ex) {
                        Logger.getLogger(SupervisorHolon.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                SH.hwList.add(HWNeeded);
                SH.firstTime = false;
                SH.addBehaviour(new RequestOH(SH, SH.msgToOH));
            }
        } else {
            msg.setContent(SH.ResourceLocation);
            msg.setPerformative(ACLMessage.PROPOSE);
        }

        return msg;
    }

    @Override
    protected ACLMessage handleAcceptProposal(ACLMessage cfp, ACLMessage propose, ACLMessage accept) throws FailureException {
        //System.out.println(myAgent.getLocalName() + ": Preparing result of CFP");

        ACLMessage msg = cfp.createReply();

        SH.firstTime = true;
        SH.OHFound = false;
        SH.listOHAccepted = null;

        SH.hwList.clear();
        SH.msgToOH.clearAllReceiver();
        msg.setContent(SH.Product + "," + propose.getContent());
        msg.setPerformative(ACLMessage.INFORM);

        return msg;
    }
}

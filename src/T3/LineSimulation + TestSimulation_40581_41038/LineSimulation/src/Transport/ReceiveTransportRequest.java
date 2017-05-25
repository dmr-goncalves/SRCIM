/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Transport;

import jade.core.Agent;
import jade.domain.FIPAAgentManagement.NotUnderstoodException;
import jade.domain.FIPAAgentManagement.RefuseException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.AchieveREResponder;
import java.util.StringTokenizer;

/**
 *
 * @author André Dionisio Rocha
 */
public class ReceiveTransportRequest extends AchieveREResponder {

    public ReceiveTransportRequest(Agent a, MessageTemplate mt) {
        super(a, mt);
    }

    @Override
    protected ACLMessage handleRequest(ACLMessage request) throws NotUnderstoodException, RefuseException {

        System.out.println("Transport Request");

        ACLMessage informToSend = request.createReply();
        informToSend.setPerformative(ACLMessage.INFORM);

        StringTokenizer st = new StringTokenizer(request.getContent(), Utilities.Constants.TOKEN_GENERAL);
        String ProdID = st.nextToken();
        String Position = st.nextToken();

        if (((TransportAgent) myAgent).setNewDestiny(ProdID, Position, informToSend)) {
            //registerPrepareResultNotification(((TransportAgent) myAgent).updateState);
            ACLMessage reply = request.createReply();
            reply.setPerformative(ACLMessage.AGREE);
            return reply;
        } else {
            ACLMessage reply = request.createReply();
            reply.setPerformative(ACLMessage.REFUSE);
            return reply;
        }
    }

}

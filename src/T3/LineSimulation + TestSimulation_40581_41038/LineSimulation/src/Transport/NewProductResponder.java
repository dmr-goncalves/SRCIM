/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Transport;

import Utilities.Constants;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import java.util.StringTokenizer;

/**
 *
 * @author André Dionisio Rocha
 */
public class NewProductResponder extends TickerBehaviour {

    private TransportAgent TA;

    public NewProductResponder(Agent a, long period) {
        super(a, period);
        this.TA = (TransportAgent) a;
    }

    @Override
    protected void onTick() {
        ACLMessage msg = myAgent.receive(MessageTemplate.and(MessageTemplate.MatchOntology(Constants.ONTOLOGY_PRODUCT), MessageTemplate.MatchPerformative(ACLMessage.INFORM)));
        if (msg != null) {
            //Put Product in the queue to be launched
            StringTokenizer st = new StringTokenizer(msg.getContent(), Utilities.Constants.TOKEN_GENERAL);
            TA.name = st.nextToken();
            TA.id = st.nextToken();
            String aux = st.nextToken();
            TA.myTasks.clear();

            StringTokenizer st2 = new StringTokenizer(aux, Utilities.Constants.TOKEN_PRODUCT_TASKS);
            while (st2.hasMoreTokens()) {
                TA.myTasks.add(st2.nextToken());
            }

            TA.prodQueue.add(msg.getContent());
        }
    }
}

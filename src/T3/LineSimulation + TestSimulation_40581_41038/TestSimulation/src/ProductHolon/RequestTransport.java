/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductHolon;

import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;

/**
 *
 * @author André Dionisio Rocha
 */
public class RequestTransport extends AchieveREInitiator {

    private ProductHolon PH;

    public RequestTransport(ProductHolon a, ACLMessage msg) {
        super(a, msg);
        this.PH = a;

    }

    @Override
    protected void handleAgree(ACLMessage agree) {
        System.out.println("Transporting");
    }

    @Override
    protected void handleRefuse(ACLMessage refuse) {
        System.out.println("Transport refused");
    }

    @Override
    protected void handleInform(ACLMessage inform) {
        System.out.println("Transport finished: Arrived");
        
        if (PH.locations.size() == 0) {
            if (!PH.sinked) {
                PH.msgTransport.setContent(PH.name + "," + "Si"); //Posicao Final
                PH.addBehaviour(new RequestTransport(PH, PH.msgTransport));
                PH.sinked = true;
            } else {
                PH.doDelete();
            }
        } else {
            PH.msgTransport.setContent(PH.name + "," + PH.locations.pop()); //Posicao Final
            PH.addBehaviour(new RequestTransport(PH, PH.msgTransport));
        }
    }
}

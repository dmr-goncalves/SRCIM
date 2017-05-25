/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;

/**
 *
 * @author André Dionisio Rocha
 */
public class DFInteraction {

    //Regista o serviço com o nome name e do tipo type relativo ao myAgent
    public static void RegisterInDF(Agent myAgent, String name, String type) throws FIPAException {

        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(myAgent.getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType(type);
        sd.setName(name);
        dfd.addServices(sd);

        DFService.register(myAgent, dfd);

    }

    public static DFAgentDescription[] SearchInDF(String type, Agent myAgent) throws FIPAException {

        DFAgentDescription dfd = new DFAgentDescription();
        ServiceDescription sd = new ServiceDescription();
        sd.setType(type);
        dfd.addServices(sd);

        DFAgentDescription[] resultado = DFService.search(myAgent, dfd);

        return resultado;

    }

    //Procura no DF por serviços do tipo type
    //Retorno: Vector com os registos encontrados
    public static DFAgentDescription[] SearchInDFExtra(String type, Agent myAgent, String name) throws FIPAException {

        DFAgentDescription dfd = new DFAgentDescription();
        ServiceDescription sd = new ServiceDescription();
        sd.setType(type);
        sd.setName(name);
        dfd.addServices(sd);

        DFAgentDescription[] resultado = DFService.search(myAgent, dfd);

        return resultado;
    }

}

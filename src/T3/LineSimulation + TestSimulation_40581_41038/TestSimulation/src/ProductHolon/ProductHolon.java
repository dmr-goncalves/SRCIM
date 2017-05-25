package ProductHolon;

import static Utilities.Constants.ONTOLOGY_PRODUCT;
import static Utilities.Constants.ONTOLOGY_TASK;
import static Utilities.DFInteraction.*;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author André
 */
public class ProductHolon extends Agent {

    protected LinkedList<String> myTasks;
    protected String name;
    protected String id;
    protected DFAgentDescription[] taskHolon;
    public int informCounter = 0;
    protected ACLMessage msgReq = new ACLMessage(ACLMessage.REQUEST);
    protected ACLMessage msgTransport = new ACLMessage(ACLMessage.REQUEST);
    protected int z = 0, x = 0, i = 0;
    protected LinkedList<String> holonsAgreed;
    protected LinkedList<String> locations = new LinkedList<>();
    protected boolean sinked = false;

    public ProductHolon(String _id, String _name, LinkedList<String> _myTasks) {
        this.id = _id;
        this.name = _name;
        this.myTasks = _myTasks;
        this.holonsAgreed = new LinkedList<String>();
    }

    @Override
    protected void setup() {
        int j;
        //Argumets [0]id [1]name [2] tasks

        //Register in DF here
        try {
            RegisterInDF(this, name, ONTOLOGY_PRODUCT);
        } catch (FIPAException ex) {
            Logger.getLogger(ProductHolon.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Search Tasks Holons in DF
        try {
            taskHolon = SearchInDFExtra(ONTOLOGY_TASK, this, myTasks.get(i));
            msgTransport.addReceiver(SearchInDF(Utilities.Constants.DFSERVICE_TRANSPORT, this)[0].getName());

            //After having the Task Holons we will make a FIPA Request for the execution 
            for (j = 0; j < taskHolon.length; j++) {
                msgReq.addReceiver(taskHolon[j].getName());
            }
        } catch (FIPAException ex) {
            Logger.getLogger(ProductHolon.class.getName()).log(Level.SEVERE, null, ex);
        }

        msgTransport.setOntology(Utilities.Constants.ONTOLOGY_TRANSPORT);
        msgReq.setOntology("ProdRequest");
        msgReq.setContent(name);
        this.addBehaviour(new RequestTH(this, msgReq));
    }

    @Override
    protected void takeDown() {
        try {
            DFService.deregister(this);

        } catch (FIPAException ex) {
            Logger.getLogger(ProductHolon.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        super.takeDown();
    }
}

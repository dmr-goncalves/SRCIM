package SimpleTaskHolon;

import static Utilities.Constants.ONTOLOGY_TASK;
import static Utilities.Constants.ONTOLOGY_SUPERVISOR;
import static Utilities.DFInteraction.RegisterInDF;
import static Utilities.DFInteraction.SearchInDFExtra;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmrg
 */
public class SimpleTaskHolon extends Agent {

    protected String id;
    protected String name;
    protected String hardwareNeeded;
    protected String prodName;
    protected LinkedList<String> mySupervisors;
    protected LinkedList<String> subTasks;
    protected DFAgentDescription[] supervisorHolon;
    protected DFAgentDescription[] taskHolon;
    protected ACLMessage msgReq = new ACLMessage(ACLMessage.REQUEST);
    protected ACLMessage msgCFP = new ACLMessage(ACLMessage.CFP);
    protected MessageTemplate mtRequestResponder = MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.REQUEST), MessageTemplate.MatchOntology("ProdRequest"));
    protected MessageTemplate mtComplexRequestResponder = MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.REQUEST), MessageTemplate.MatchOntology("ComplexTHRequest"));
    protected HashMap<String, Boolean> productTaskFinished = new HashMap<>();
    protected HashMap<String, Boolean> productFirstTimeContract = new HashMap<>();
    protected HashMap<String, String> taskLocation = new HashMap<>();

    public SimpleTaskHolon(String _id, String _name, LinkedList<String> _subTasks, String _hardwareNeeded, LinkedList<String> _mySupervisors) {
        this.id = _id;
        this.name = _name;
        this.hardwareNeeded = _hardwareNeeded;
        this.mySupervisors = _mySupervisors;
        this.subTasks = _subTasks;
    }

    @Override
    protected void setup() {
        int i, j;
        //Argumets [0]id [1] name [2] hardwareNeeded [3] supervisors

        //Register in DF
        try {//Register in DF here
            RegisterInDF(this, name, ONTOLOGY_TASK);
        } catch (FIPAException ex) {
            Logger.getLogger(SimpleTaskHolon.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Search supervisors in DF 
        for (i = 0; i < mySupervisors.size(); i++) {
            try {
                supervisorHolon = SearchInDFExtra(ONTOLOGY_SUPERVISOR, this, mySupervisors.get(i));
                //After having the Supervisor Holon we will make a Request when a Request arrives from the product
                for (j = 0; j < supervisorHolon.length; j++) {
                    msgCFP.addReceiver(supervisorHolon[j].getName());
                    msgReq.addReceiver(supervisorHolon[j].getName());
                }
            } catch (FIPAException ex) {
                Logger.getLogger(SimpleTaskHolon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.addBehaviour(new AnswerPH(this, mtRequestResponder));
        this.addBehaviour(new AnswerComplexTH(this, mtComplexRequestResponder));
    }

    @Override
    protected void takeDown() {
        try {
            DFService.deregister(this);
        } catch (Exception e) {
            Logger.getLogger(SimpleTaskHolon.class.getName()).log(Level.SEVERE, null, e);
        }
        super.takeDown();
    }
}

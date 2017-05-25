package ComplexTaskHolon;

import static Utilities.Constants.ONTOLOGY_TASK;
import static Utilities.DFInteraction.RegisterInDF;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmrg
 */
public class ComplexTaskHolon extends Agent {

    protected String id;
    protected String name;
    protected LinkedList<String> subTasks;
    protected DFAgentDescription[] subTaskHolon;
    protected ACLMessage msgReqSubTask = new ACLMessage(ACLMessage.REQUEST);
    protected MessageTemplate mtRequestResponder = MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.REQUEST), MessageTemplate.MatchOntology("ProdRequest"));
    protected MessageTemplate mtRequestResponder2 = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
    protected LinkedList<String> taskFinished;
    protected int informCounter = 0;
    protected int z = 0, x = 0, i = 0;
    protected boolean firstTime = true;
    protected String simpleTasksLoc;
    protected String prodName;
    protected boolean simpleTasksFinished = false;
    protected LinkedList<String> holonsAgreed;
    protected String protocol;
    protected LinkedList<String> simpleTasksLocations = new LinkedList<>();

    public ComplexTaskHolon(String _id, String _name, LinkedList<String> _subTasks) {
        this.id = _id;
        this.name = _name;
        this.subTasks = _subTasks;
        this.holonsAgreed = new LinkedList<>();
    }

    @Override
    protected void setup() {
        int i = 0;
        //Argumets [0]id [1] name [2] hardwareNeeded [3] supervisors

        //Register in DF
        try {//Register in DF here
            RegisterInDF(this, name, ONTOLOGY_TASK);
        } catch (FIPAException ex) {
            Logger.getLogger(ComplexTaskHolon.class.getName()).log(Level.SEVERE, null, ex);
        }

        msgReqSubTask.setOntology("ComplexTHRequest");
        this.addBehaviour(new ComplexAnswerPH(this, mtRequestResponder2));
    }

    @Override
    protected void takeDown() {
        try {
            DFService.deregister(this);
        } catch (Exception e) {
            Logger.getLogger(ComplexTaskHolon.class.getName()).log(Level.SEVERE, null, e);
        }
        super.takeDown();
    }
}

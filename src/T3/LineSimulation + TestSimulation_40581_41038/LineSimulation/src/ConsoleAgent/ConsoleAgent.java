package ConsoleAgent;

import OperationalHolon.OperationalHolon;
import SupervisorHolon.SupervisorHolon;
import SimpleTaskHolon.SimpleTaskHolon;
import ComplexTaskHolon.ComplexTaskHolon;
import Transport.TransportAgent;
import Utilities.DFInteraction;
import jade.core.Agent;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Duarte Gonçalves & André Lourenço
 */
public class ConsoleAgent extends Agent implements frameToAgentCom {

    ConsoleFrame myFrame;

    @Override
    protected void setup() {
        myFrame = new ConsoleFrame(this);
        myFrame.setVisible(true);
    }

    @Override
    public boolean launchNewSimulationEnvironment(String RulesLib, String HardwareLib) {
        try {
            TransportAgent newTA = new TransportAgent();
            newTA.setArguments(new Object[]{RulesLib, HardwareLib});
            AgentController agent = this.getContainerController().acceptNewAgent("TransportAgent", newTA);
            agent.start();
            return false;
        } catch (StaleProxyException ex) {
            Logger.getLogger(ConsoleAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public void launchNewOperational(String ResourceID, String name, String hardwareType, String ResourceLocation, String priority) {
        try {
            //Launch OperationalHolon
            OperationalHolon newOperational = new OperationalHolon(ResourceID, name, ResourceLocation, hardwareType, priority);
            newOperational.setArguments(new Object[]{ResourceID, name, ResourceLocation, hardwareType, priority});
            AgentController agent = this.getContainerController().acceptNewAgent(ResourceID, newOperational);
            agent.start();
        } catch (StaleProxyException ex) {
            Logger.getLogger(ConsoleAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void launchNewSupervisor(String id, String name, String operationals) {
        try {
            LinkedList<String> myOperationals = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(operationals, Utilities.Constants.TOKEN_SUPERVISOR_OPERATIONALS);
            while (st.hasMoreTokens()) {
                myOperationals.add(st.nextToken());
            }
            //Launch SupervisorHolon
            SupervisorHolon newSupervisor = new SupervisorHolon(id, name, myOperationals);
            newSupervisor.setArguments(new Object[]{id, name, myOperationals});
            AgentController agent = this.getContainerController().acceptNewAgent(id, newSupervisor);
            agent.start();
        } catch (StaleProxyException ex) {
            Logger.getLogger(ConsoleAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void launchNewTask(String id, String name, String hardwareNeeded, String supervisors, String subtasks) {
        try {
            LinkedList<String> mySupervisors = new LinkedList<>();
            LinkedList<String> subTasks = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(supervisors, Utilities.Constants.TOKEN_SUPERVISOR_OPERATIONALS);
            while (st.hasMoreTokens()) {
                mySupervisors.add(st.nextToken());
            }

            StringTokenizer st2 = new StringTokenizer(subtasks, Utilities.Constants.TOKEN_SUPERVISOR_OPERATIONALS);
            while (st2.hasMoreTokens()) {
                subTasks.add(st2.nextToken());
            }

            if (subTasks.size() == 0) {
                //Launch SimpleTaskHolon
                SimpleTaskHolon newTask = new SimpleTaskHolon(id, name, subTasks, hardwareNeeded, mySupervisors);
                newTask.setArguments(new Object[]{id, name, hardwareNeeded, mySupervisors});
                AgentController agent = this.getContainerController().acceptNewAgent(id, newTask);
                agent.start();
            } else {
                //Launch ComplexTaskHolon
                ComplexTaskHolon newTask = new ComplexTaskHolon(id, name, subTasks);
                newTask.setArguments(new Object[]{id, name, hardwareNeeded, mySupervisors});
                AgentController agent = this.getContainerController().acceptNewAgent(id, newTask);
                agent.start();
            }
        } catch (StaleProxyException ex) {
            Logger.getLogger(ConsoleAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void launchNewProduct(String id, String name, String tasks) {
        try {
            LinkedList<String> myTasks = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(tasks, Utilities.Constants.TOKEN_PRODUCT_TASKS);
            while (st.hasMoreTokens()) {
                myTasks.add(st.nextToken());
            }

            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
            msg.setContent(id + "," + name + "," + tasks);
            msg.addReceiver(DFInteraction.SearchInDF(Utilities.Constants.DFSERVICE_TRANSPORT, this)[0].getName());
            msg.setOntology(Utilities.Constants.ONTOLOGY_PRODUCT);
            this.send(msg);

        } catch (FIPAException ex) {
            Logger.getLogger(ConsoleAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

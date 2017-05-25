/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsoleAgent;

/**
 *
 * @author André Dionisio Rocha
 */
interface frameToAgentCom {

    /*
     * Arguments -  [0] RulesLib Name
     *              [1] HardwareLib Name
     */
    boolean launchNewSimulationEnvironment(String RulesLib, String HardwareLib);

    /*
     * Arguments -  List of Skills
     */
    public void launchNewOperational(String id, String name, String hardwareType, String location, String priority);

    public void launchNewSupervisor(String id, String name, String operationals);

    public void launchNewTask(String id, String name, String hardwareNeeded, String supervisors, String subtasks);

    void launchNewProduct(String id, String name, String task);

}

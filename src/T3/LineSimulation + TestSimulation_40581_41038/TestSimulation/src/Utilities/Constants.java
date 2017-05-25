/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

/**
 *
 * @author André Dionisio Rocha
 */
public class Constants {

    //DF Services
    public static final String DFSERVICE_TRANSPORT = "dfservice_transport";

    //Ontologies
    public static final String ONTOLOGY_TRANSPORT = "ont_tra_req";
    public static final String ONTOLOGY_START_SIMULATION = "ont_start_sim";
    public static final String ONTOLOGY_KILL_PRODUCT = "ont_kill_prod";
    public static final String ONTOLOGY_PRODUCT = "Product";
    public static final String ONTOLOGY_TASK = "Task";
    public static final String ONTOLOGY_SUPERVISOR = "Supervisor";
    public static final String ONTOLOGY_OPERATIONAL = "Operational";

    //Tokens
    public static final String TOKEN = " #";
    public static final String TOKEN_OPERATIONAL_SKILLS = ";";
    public static final String TOKEN_SUPERVISOR_OPERATIONALS = ";";
    public static final String TOKEN_TASKS_SUPERVISORS = ";";
    public static final String TOKEN_PRODUCT_TASKS = ";";
    public static final String TOKEN_TASK_ID_TO_NAME = "_";
    public static final String TOKEN_GENERAL = ",";

    //Timers
    public static final long TIMER_LAUNCH_PROD = 1000;                          //ms
    public static long TIMER_CHECK_NEW_PROD_MSG = 250;                          //ms

}

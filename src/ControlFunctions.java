/*****************
 * iSimplex ************************** Layer 2 TOP - Control Device Functions * * Use this
 * source-code to add functions to * control the iSimplex's Devices * * *
 * 
 * @author Dário Nascimento - dfnascimento@hotmail.com *
 * @version 2.0.0 *
 * @since 16-07-2012 *
 *******************************************************/
import java.util.HashMap;
import java.util.Map;

import controlo.GetOperators;
import controlo.PostOperators;


public class ControlFunctions {

    static HashMap<String, DomoticElement> domoticList = new HashMap<String, DomoticElement>();

    static final String READ_ONLY = "Read-Only";
    static final String PERCENTAGE = "Percentagem";
    static final String STATE = "Estado";


    public static void main(String args[]) throws Exception {
        ControlFunctions.init();
        // System.out.println(ControlFunctions.read("Ext_Temperature"));
        ControlFunctions.write("Light_Middle_Board", 0);
    }

    public static void init() {
        // Lights
        createElement(43, 2, "Light_Board", DomType.newOffset);
        createElement(34, 2, "Light_Middle_Board", DomType.newOffset);
        createElement(35, 2, "Light_Middle_TV", DomType.newOffset);
        createElement(36, 2, "Light_TV", DomType.newOffset);

        createElement(13, 2, "Light_Board_Left", DomType.newOffset);
        createElement(14, 2, "Light_Board_Right", DomType.newOffset);
        createElement(15, 2, "Light_Middle_Board_Left", DomType.newOffset);
        createElement(16, 2, "Light_Middle_Board_Right", DomType.newOffset);


        createElement(17, 2, "Light_Middle_TV_Left", DomType.newOffset);
        createElement(18, 2, "Light_Middle_TV_Right", DomType.newOffset);
        createElement(19, 2, "Light_TV_Left", DomType.newOffset);
        createElement(20, 2, "Light_TV_Right", DomType.newOffset);

        createElement(32, 5, "Light_All", DomType.newOffset); // TODO



        /* ------------ Sockets -------------------- */
        createElement(1, 1, "Tomada_1", DomType.newValue);
        createElement(2, 1, "Tomada_2", DomType.newValue);
        createElement(3, 1, "Tomada_3", DomType.newValue);
        createElement(4, 1, "Tomada_4", DomType.newValue);
        createElement(5, 1, "Tomada_5", DomType.newValue);
        createElement(6, 1, "Tomada_6", DomType.newValue);
        createElement(7, 1, "Tomada_7", DomType.newValue);
        createElement(8, 1, "Tomada_8", DomType.newValue);
        createElement(9, 1, "Tomada_9", DomType.newValue);
        createElement(10, 1, "Tomada_10", DomType.newValue);
        createElement(11, 1, "Tomada_11", DomType.newValue);
        createElement(12, 1, "Tomada_12", DomType.newValue);
        createElement(21, 2, "Light_Leds_TV", DomType.newValue);


        // Sensors
        createElement(22, 3, "Ext_Temperature", DomType.readOnly);
        createElement(23, 3, "Ext_Wind", DomType.readOnly);
        createElement(24, 3, "Ext_Luminosity", DomType.readOnly);
        createElement(25, 4, "Sensor_Door", DomType.readOnly);
        createElement(26, 4, "Sensor_Window", DomType.readOnly);
        createElement(27, 4, "Sensor_C02", DomType.readOnly);
        createElement(28, 4, "Sensor_Humidity", DomType.readOnly);
        createElement(29, 4, "Sensor_DoorTemp", DomType.readOnly);
        createElement(30, 4, "Sensor_Luminosity", DomType.readOnly);
        createElement(31, 4, "Sensor_Roof", DomType.readOnly);



        // Lamelas
        createElement(38, 6, "Blind_1", DomType.newOffset);
        createElement(39, 6, "Blind_2", DomType.newOffset);
        createElement(40, 6, "Blind_3", DomType.newOffset);
        createElement(41, 6, "Blind_All", DomType.newOffset);

        // Door
        createElement(44, 5, "Door", DomType.newValue);


        // AirConditionaire
        createElement(45, 7, "AC_OnOff", DomType.newValue);
        createElement(46, 7, "AC_Heat/Cool", DomType.newValue);
        createElement(47, 7, "AC_V0", DomType.newValue);
        createElement(48, 7, "AC_V1", DomType.newValue);
        createElement(49, 7, "AC_V2", DomType.newValue);
        createElement(50, 7, "AC_V3", DomType.newValue);

        createElement(51, 7, "AC_Door_Temp", DomType.readOnly);
        createElement(52, 7, "AC_Roof_Temp", DomType.readOnly);
    }

    public static void createElement(int id, int division, String name, DomType type) {
        domoticList.put(name, new DomoticElement(id, division, name, type));
    }







    /**
     * Action to Set
     * 
     * @throws Exception
     */
    public static boolean write(String domotic_name, int value) throws Exception {
        DomoticElement domotic = domoticList.get(domotic_name);
        if (domotic == null) {
            throw new Exception("Wrong domotic name");
        }
        int id = domotic.id;

        System.out.println(domotic);
        switch (domotic.type) {
        case newOffset:
            System.out.println("Post Operator");
            return PostOperators.newOffset(id, value);
        case newValue:
            System.out.println("Post Operator");
            return PostOperators.newValue(id, value);
        default:
            throw new Exception("Invalid WRITE operation: " + domotic_name + " write: "
                    + value);
        }
    }

    public static int read(String domotic_name) throws Exception {
        DomoticElement domotic = domoticList.get(domotic_name);
        if (domotic == null) {
            throw new Exception("Wrong domotic name");
        }
        int id = domotic.id;
        int division = domotic.division;

        Map<String, String> data = GetOperators.getInfo(division, id);
        String command;

        switch (domotic.type) {
        case newOffset:
            command = PERCENTAGE;
            break;
        case newValue:
            command = STATE;
            break;
        case readOnly:
            command = READ_ONLY;
            break;
        default:
            throw new Exception("Invalid READ operation: " + domotic_name);
        }
        return Integer.parseInt(data.get(command));
    }
}

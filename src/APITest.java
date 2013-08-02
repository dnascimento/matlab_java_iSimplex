import ist.ControlFunctions;

import org.junit.Test;


public class APITest {

    @Test
    public void test() throws Exception {
        ControlFunctions.init();
        ControlFunctions.read("AC_Door_Temp");
        ControlFunctions.read("Light_Board");
        ControlFunctions.read("Light_Middle_Board");
        ControlFunctions.read("Light_Middle_TV");
        ControlFunctions.read("Light_TV");
        ControlFunctions.read("Light_Board_Left");
        ControlFunctions.read("Light_Board_Right");
        ControlFunctions.read("Light_Middle_Board_Left");
        ControlFunctions.read("Light_Middle_Board_Right");
        ControlFunctions.read("Light_Middle_TV_Left");
        ControlFunctions.read("Light_Middle_TV_Right");
        ControlFunctions.read("Light_TV_Left");
        ControlFunctions.read("Light_TV_Right");
        ControlFunctions.read("Light_All");
        ControlFunctions.read("Tomada_1");
        ControlFunctions.read("Tomada_2");
        ControlFunctions.read("Tomada_3");
        ControlFunctions.read("Tomada_4");
        ControlFunctions.read("Tomada_5");
        ControlFunctions.read("Tomada_6");
        ControlFunctions.read("Tomada_7");
        ControlFunctions.read("Tomada_8");
        ControlFunctions.read("Tomada_9");
        ControlFunctions.read("Tomada_10");
        ControlFunctions.read("Tomada_11");
        ControlFunctions.read("Tomada_12");
        ControlFunctions.read("Ext_Temperature");
        ControlFunctions.read("Ext_Luminosity");
        ControlFunctions.read("IntC02");
        ControlFunctions.read("Sensor_Humidity");
        ControlFunctions.read("Sensor_DoorTemp");
        ControlFunctions.read("Sensor_Luminosity");
        ControlFunctions.read("Sensor_Roof");
        ControlFunctions.read("Blind_1");
        ControlFunctions.read("Blind_2");
        ControlFunctions.read("Blind_3");
        ControlFunctions.read("Blind_All");

        ControlFunctions.read("AC_OnOff");
        ControlFunctions.read("AC_Heat/Cool");
        ControlFunctions.read("AC_Door_Temp");
        ControlFunctions.read("AC_Roof_Temp");

        // ControlFunctions.read("Light_Leds_TV");
        // ControlFunctions.read("Ext_Wind");
        // ControlFunctions.read("Sensor_Door");
        // ControlFunctions.read("Sensor_Window");
        // ControlFunctions.read("AC_V0");
        // ControlFunctions.read("AC_V1");
        // ControlFunctions.read("AC_V2");
        // ControlFunctions.read("AC_V3");
        // ControlFunctions.read("Door");
    }
}

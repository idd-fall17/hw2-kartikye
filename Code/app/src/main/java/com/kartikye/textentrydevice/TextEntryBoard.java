package com.kartikye.textentrydevice;

import android.util.Log;
import android.widget.TextView;

import com.google.android.things.pio.Gpio;

/**
 * Created by Kartikye Mittal on 9/4/2017.
 */

public class TextEntryBoard extends SimplePicoPro{

    float swivelVoltage;
    String[][] characters = {{"z", ".", "", " ", "\n"},
                             {"P", "Q", "J", "X", "V"},
                             {"Y", "L", "G", "K", "M"},
                             {"S", "R", "C", "D", "E"},
                             {"H", "E", "I", "U", "N"},
                             {"T", "O", "A", "W", "B"}};
    int keyset;

    TextView textbox;
    String text;

    public void setup(){
        setup(null);
    }

    public void setup(TextView tb) {
        textbox = tb;
        text = "";
        //Initialize Analog
        analogInit();

        //Initialize GPIO
        pinMode(GPIO_128, Gpio.DIRECTION_IN);
        pinMode(GPIO_39,  Gpio.DIRECTION_IN);
        pinMode(GPIO_37,  Gpio.DIRECTION_IN);
        pinMode(GPIO_35,  Gpio.DIRECTION_IN);
        pinMode(GPIO_34,  Gpio.DIRECTION_IN);

        //Set Callback
        setEdgeTrigger(GPIO_128, Gpio.EDGE_RISING);
        setEdgeTrigger(GPIO_39,  Gpio.EDGE_RISING);
        setEdgeTrigger(GPIO_37,  Gpio.EDGE_RISING);
        setEdgeTrigger(GPIO_35,  Gpio.EDGE_RISING);
        setEdgeTrigger(GPIO_34,  Gpio.EDGE_RISING);
    }

    @Override
    public void loop() {
        swivelVoltage = analogRead(A0);
        if (swivelVoltage <= 0.1) {
            keyset = 0;
        } else if (swivelVoltage > .5 && swivelVoltage < .8) {
            keyset = 1;
        } else if (swivelVoltage > 1.2 && swivelVoltage < 1.45) {
            keyset = 2;
        } else if (swivelVoltage > 1.8 && swivelVoltage < 2.2) {
            keyset = 3;
        } else if (swivelVoltage > 2.6 && swivelVoltage < 2.98) {
            keyset = 4;
        } else if (swivelVoltage > 3.05 && swivelVoltage < 3.4) {
            keyset = 5;
        }

        textbox.setText(text);

    }

    void digitalEdgeEvent(Gpio pin, boolean value){
        if (pin == GPIO_128){
            Log.d("Press", characters[keyset][0]);
            text += characters[keyset][0];
        } else if (pin == GPIO_39) {
            Log.d("Press", characters[keyset][1]);
            text += characters[keyset][1];
        } else if (pin == GPIO_37) {
            Log.d("Press", characters[keyset][2]);
            if (keyset == 0){
                text =  text.substring(0, text.length() - 1);
            }
            text += characters[keyset][2];
        } else if (pin == GPIO_35) {
            Log.d("Press", characters[keyset][3]);
            text += characters[keyset][3];
        } else if (pin == GPIO_34) {
            Log.d("Press", characters[keyset][4]);
            text += characters[keyset][4];
        }
    }
}
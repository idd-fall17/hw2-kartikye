package com.kartikye.textentrydevice;

import android.util.Log;

import com.google.android.things.pio.Gpio;

/**
 * Created by Kartikye Mittal on 9/4/2017.
 */

public class TextEntryBoard extends SimplePicoPro{

    float swivelVoltage;

    @Override
    public void setup() {
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
        Log.d("Analog 0", "" + swivelVoltage);
        if (swivelVoltage == 0) {

        } else if (swivelVoltage == 1) {

        } else if (swivelVoltage == 2) {

        } else if (swivelVoltage == 3) {

        } else if (swivelVoltage == 4) {

        } else if (swivelVoltage == 5) {

        }

    }

    void digitalEdgeEvent(Gpio pin, boolean value){
        if (pin == GPIO_128){

        } else if (pin == GPIO_39) {

        } else if (pin == GPIO_37) {

        } else if (pin == GPIO_35) {

        } else if (pin == GPIO_34) {

        }
    }
}
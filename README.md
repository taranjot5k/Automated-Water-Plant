# Automated-Water-Plant
Automated Water Plant utilizing Java and an Arduino (jSerialComm)

### YouTube Video Link : https://youtu.be/lZ0GkuZE4t8


## Introduction
I utilized Java's Object-Oriented Programming (OOP) principles to develop an 
Automated Plant Watering System capable of monitoring soil moisture levels 
and initiating or discontinuing the watering process automatically. 
The system incorporated various hardware components, including a 
MOSFET Board, Pump, Arduino Grove board, and a Moisture Sensor, 
to enable the program's seamless operation.


## Context
Whether it's nurturing a lush garden oasis, maintaining a productive 
crop field, or simply ensuring that houseplants thrive, this Automated 
Plant Watering System represents a significant leap forward in plant care. 
It embodies the fusion of cutting-edge technology with our commitment to 
environmental stewardship, providing a practical, sustainable, and 
user-friendly solution for plant enthusiasts of all kinds. The consensus
is that if the moisture levels is equal to 3.4V(reallyDryValue) then 
it will water the plant but if the value is greater then 2.5V(wetValue) 
then it will stop watering the plant. 


## Technical Requirements / Specifications
● Acquire real-time moisture levels in ppm and TVOC (Total Volatile Organic
Compounds) levels in ppb from VOC and eCO2 Gas Sensor (SGP30)

● Acquire real-time moisture levels of the soil from
moisture sensor

● Print real-time moisture level to OLED
display (SSD1315)

● Send real-time moisture levels over serial port interface, so Java can be
utilised

● Plot real-time moisture levels using JavaFX library


## Components List

● Seeedstudio Grove Arduino UNO compatible board (1x)

● Grove OLED Display 0.96 inch - SGP1315 (1x)

● Moisture Sensor - DHT11 (1x)

● DC Motor (1x)

● DC Motor Driver Components (1x PN2222 Transistor, 1x 1N4001 diode, 1x
270 Ohm Resistor, 1x Breadboard)


![Diagram of the system and its associated components](![image](https://github.com/taranjot5k/Automated-Water-Plant/assets/125500381/0629f846-baac-4c1f-bf2c-b78a130f19d0)
)

Diagram of the system and its associated components






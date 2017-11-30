/**
 *  Virtual Switch
 *
 *  Copyright 2014 Juan Risso
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
metadata {
        definition (name: "ESP8266 Outlet", namespace: "juano2310", author: "Juan Risso") {
        capability "Switch"
        capability "Refresh"        
    }
    
    preferences {
        section("Settings") {
            input("MACAddr", "string", title:"MQTT Device ID of EcoPlug", description: "Enter the MQTT Device ID of the EcoPlug", required: true, displayDuringSetup: true)
            input("Location", "string", title:"Location of EcoPlug", description: "Enter the Location of the EcoPlug", required: false, displayDuringSetup: true)
            //input("MQTTCommand", "string", title:"MQTT Command Topic", description: "Enter the MQTT Command Topic", required: false, displayDuringSetup: true)
            //input("MQTTState", "string", title:"MQTT State Topic", description: "Enter the MQTT State Topic", required: false, displayDuringSetup: true)
            //input("MQTTOnValue", "string", title:"MQTT Switch On Value", description: "Enter the MQTT On Value (i.e. true or on)", required: false, displayDuringSetup: true)
            //input("MQTTOffValue", "string", title:"MQTT Switch Off Value", description: "Enter the MQTT Off Value (i.e. false or off)", required: false, displayDuringSetup: true)
        }
    }


	// simulator metadata
	simulator {
	}

	// UI tile definitions
	tiles {
		standardTile("button", "device.switch", width: 2, height: 2, canChangeIcon: false) {
			state "off", label: 'Off', action: "switch.on", icon: "st.Kids.kid10", backgroundColor: "#ffffff", nextState: "on"
			state "on", label: 'On', action: "switch.off", icon: "st.Kids.kid10", backgroundColor: "#79b821", nextState: "off"
		}
		standardTile("refresh", "device.switch", inactiveLabel: false, decoration: "flat") {
			state "default", label:'', action:"refresh.refresh", icon:"st.secondary.refresh"
		}        
		main "button"
		details(["button", "refresh"])
	}
}

def parse(String description) {
    log.debug "Parsing 123 '${description}'"
}

def on() {
    //log.debug MACAddr + ",plug,on/set"

	//sendEvent(name: MACAddr + ",plug,on/set", value: "true")
    //log.debug "on"
    
	//sendEvent(name: "plug/on/set", value: "true")
    sendEvent (name: "switch", value: "on")
    sendEvent (name: "switch/state/set", value: "on")
    //sendEvent (name: MACAddr + ",switch", value: "on")
    //sendEvent (name: MACAddr + ",switch/state/set", value: "on")

}

def off() {

    //log.debug MACAddr + ",plug,on/set"
	//sendEvent(name: MACAddr + ",plug,on/set", value: "false")
    //log.debug "off"
	//sendEvent(name: "plug/on/set", value: "false")
    sendEvent (name: "switch", value: "off")
    sendEvent (name: "switch/state/set", value: "off")
    //sendEvent (name: MACAddr + ",switch", value: "off")
    //sendEvent (name: MACAddr + ",switch/state/set", value: "off")

}
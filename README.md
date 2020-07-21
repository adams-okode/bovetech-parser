# Bovetech Parser
Works with BECO X and B91 VW (Prepaid Meter)

# Installation
- Clone repo and install to local repository

```bash
    mvn clean install
```

- Add to pom.xml
```xml
<dependency>
    <groupId>com.kaiote.parsers.bovetech</groupId>
    <artifactId>bove</artifactId>
    <packaging>jar</packaging>
    <version>1.0.1</version>
</dependency> 
```

# Usage
```java
Bove bove = new Bove("6812563413016801020000d3", "242352", CommunicationProtocol.SIGFOX);
Meter meter = bove.getMeter();

meter.getMeterReading();//13345612
meter.getSendingInterVal();//360
meter.getAlerts();//["Empty Pipe Alarm"]
```

# API 
```java
/**
* @param meterHex
* @param meterId
* @param communicationProtocol
* @throws MessageLengthException
  */
public Bove(String meterHex, String meterId, CommunicationProtocol communicationProtocol)
            throws MessageLengthException
```

Meter Object
|                   |                           |
|---	            |---	                    |
|   key	            |   String	                |
|   deviceId	    |   String	                |
|   meterHex	    |   String	                |
|   protocol	    |   SIGFOX, LORA	        |
|   sendingInterVal	|   Integer:minutes	        |
|   meterReading	|   Double:Litres	        |
|   alerts	        |  Low Battery Alarm,Empty Pipe Alar,Reverse Flow Alarm,Over Range Alarm,Over Temperature Alarm,EEPROM error,Transducer In Error,Transducer Out Error 	|
|   type	        | BECOX,B91VW 	            |
|   valveState      | OPENED,CLOSED,VALVERROR  	|



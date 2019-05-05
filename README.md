# MDS - Mosip Device Service .
Proxy service to simulate the behaviour of the biometric device used by the registeration client.

## Device Identity
** Physical Id ** 12 digit serial number, make and model.
** Digital Id ** 
```
{  serialNo: <serial_no>,
    make: <make>,
    type: [‘Fingerprint’, ‘Slab Fingerprint’ , ‘Iris’, ‘Vein’, ‘Face’ ],
    dp:  <device provider name>,
    dpId: <device provider id>,
    dateTime: <datetime> // ISO format with timezone.  Identity request time
}

```

## Device Service
`port range 4501 - 4600`
java -jar MDS-0.0.1-SNAPSHOT.jar --server.port=4525
### Device Discovery
Request:
	`{ "type":  <type of the device>}`
	Accepted Values 
	type: "Biometric Device" , "Fingerprint",  "Face" , "Iris", "Vein" 
	Note: "Biometric Device" - is a special type and used in case if you are looking for any biometric device.

Response:
	```
		[
			{ 
				“type” :  <exact type>, 
				“deviceId” : <internal id>, 
				“subType”:  <subtypes of the biometric device>, 
				“deviceStatus”:  <device status>
				“certification” :  <certification level>,
				“serviceVersion” : <device service version>,
				“deviceSubId”: <device sub id’s>,
				“callbackId”: <how to reach to the device> 
			}
		]
	```
Accepted values:


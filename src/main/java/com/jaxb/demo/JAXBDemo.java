package com.jaxb.demo;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import demo.webservices.basics.patient.Patient;

public class JAXBDemo {

	public static void main(String[] args) {
		
		try {
			JAXBContext newInstance = JAXBContext.newInstance(Patient.class);
			Marshaller createMarshaller = newInstance.createMarshaller();
			
			Patient patient = new Patient();
			patient.setId(12);
			patient.setName("Tim");
			
			StringWriter stringWriter = new StringWriter();
			createMarshaller.marshal(patient, stringWriter);
			
			System.out.println(stringWriter.toString());
			
			Unmarshaller createUnmarshaller = newInstance.createUnmarshaller();
			Patient patientUnmarshal = (Patient) createUnmarshaller.unmarshal(new StringReader(stringWriter.toString()));
			
			System.out.println(patientUnmarshal.getId());
			System.out.println(patientUnmarshal.getName());
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}

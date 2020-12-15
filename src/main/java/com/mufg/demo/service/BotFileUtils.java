package com.mufg.demo.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mufg.demo.data.OutputResponse;

public class BotFileUtils {

    public static void writeToFile(final OutputResponse request, String filePath) throws JAXBException, PropertyException, IOException {
        StringWriter sw = new StringWriter();
        final JAXBContext context = JAXBContext.newInstance("com.mufg.demo.data");

        final Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(request, sw);

        FileWriter myWriter = new FileWriter(new File("").getAbsolutePath() + filePath);
        myWriter.write(sw.toString().trim());
        myWriter.close();
    }

    public static String readFromFile(String filePath) throws JAXBException, PropertyException, IOException {
        FileInputStream stream;
        String response = null;
        try {
            // reading file from resource folder
            stream = new FileInputStream(new File("").getAbsolutePath() + filePath);
            Reader reader = new BufferedReader(new InputStreamReader(stream));

            final JAXBContext context = JAXBContext.newInstance("com.mufg.demo.data");
            final Unmarshaller unmarshaller = context.createUnmarshaller();
            OutputResponse outputResponse = (OutputResponse) unmarshaller.unmarshal(reader);
            response = new ObjectMapper().writeValueAsString(outputResponse);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return response;
    }
}

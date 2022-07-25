package com.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class ConsumeWithDomeApi {

    private static final File COLLEGE_LIST = new File("/Users/ashutoshsingh/eclipse-workspace/JavaToJson/college.json");

    public static void main(String[] args) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(COLLEGE_LIST);
//        ObjectWriter objWriter = objectMapper.writerWithDefaultPrettyPrinter();
//        System.out.println(objWriter.writeValueAsString(jsonNode));


        validateDates(jsonNode);
    }

    private static void validateDates(final JsonNode jsonNode) {

        Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();

        while(fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            String fieldName = field.getKey();
            JsonNode value = field.getValue();
            System.out.println(fieldName+" : "+value);
            validateDates(value);
        }


    }
}



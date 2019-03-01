package info.vbychkoviak.json;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.Test;

public class JsonParserTest {

  @Test
  public void test() throws ParseException {
    String data = "{\n" + 
        "  \"firstName\": \"John\",\n" + 
        "  \"lastName\": \"Smith\",\n" + 
        "  \"isAlive\": true,\n" + 
        "  \"age\": 27,\n" + 
        "  \"address\": {\n" + 
        "    \"streetAddress\": \"21 2nd Street\",\n" + 
        "    \"city\": \"New York\",\n" + 
        "    \"state\": \"NY\",\n" + 
        "    \"postalCode\": \"10021-3100\"\n" + 
        "  },\n" + 
        "  \"phoneNumbers\": [\n" + 
        "    {\n" + 
        "      \"type\": \"home\",\n" + 
        "      \"number\": \"212 555-1234\"\n" + 
        "    },\n" + 
        "    {\n" + 
        "      \"type\": \"office\",\n" + 
        "      \"number\": \"646 555-4567\"\n" + 
        "    },\n" + 
        "    {\n" + 
        "      \"type\": \"mobile\",\n" + 
        "      \"number\": \"123 456-7890\"\n" + 
        "    }\n" + 
        "  ],\n" + 
        "  \"children\": [],\n" + 
        "  \"spouse\": null\n" + 
        "}";
    
    JsonBaseObject obj = JsonParser.parse(data);
    assertTrue(obj.isMap());
    
    JsonMap map = (JsonMap) obj;
    assertTrue(map.get("firstName").isString());
    

  }

}

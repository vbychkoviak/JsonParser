package info.vbychkoviak.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.Test;

public class JsonMapTest {

  @Test
  public void test() throws ParseException {
    JsonMap jm = new JsonMap();
    assertEquals(28, jm.parse("{\"key\": \"value\", \"key2\": 10}", 0));
    JsonBaseObject value = jm.get("key");
    assertTrue(value.isString());
    assertEquals("value", ((JsonString) value).getValue());

    JsonBaseObject num = jm.get("key2");
    assertTrue(num.isNumber());
    assertEquals(10, ((JsonNumber) num).getValue().intValue());
  }

}

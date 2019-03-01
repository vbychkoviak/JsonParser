package info.vbychkoviak.json;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Test;

public class JsonStringTest {

  @Test
  public void test() throws ParseException {
    JsonString js = new JsonString();
    assertEquals(6,js.parse("\"data\"", 0));
    assertEquals("data", js.getValue());
    
    assertEquals(9,js.parse("1\"da\\rta\"", 1));
    assertEquals("da\rta", js.getValue());
  }

}

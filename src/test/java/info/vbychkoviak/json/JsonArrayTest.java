package info.vbychkoviak.json;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Test;

public class JsonArrayTest {

  @Test
  public void test() throws ParseException {
    JsonArray ja = new JsonArray();
    assertEquals(2, ja.parse("[]", 0));
    assertEquals(5, ja.parse("[1,2]", 0));
    assertEquals(2, ja.getLength());
  }

}

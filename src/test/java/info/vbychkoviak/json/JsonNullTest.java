package info.vbychkoviak.json;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Test;

public class JsonNullTest {

  @Test
  public void test() throws ParseException {
    JsonNull json = new JsonNull();
    assertEquals(4, json.parse("null", 0));
    assertEquals(5, json.parse("null ", 0));
  }

  @Test(expected = ParseException.class)
  public void testFail() throws ParseException {
    JsonNull json = new JsonNull();
    assertEquals(4, json.parse(" afasde", 0));

  }

}

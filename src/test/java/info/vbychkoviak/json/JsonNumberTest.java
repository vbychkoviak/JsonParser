package info.vbychkoviak.json;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Test;

public class JsonNumberTest {

  @Test
  public void test() throws ParseException {
    JsonNumber jn = new JsonNumber();
    assertEquals(3, jn.parse("123", 0));
    assertEquals("123", jn.getValue().toPlainString());
    
    assertEquals(7, jn.parse("-123.01", 0));
    assertEquals("-123.01", jn.getValue().toPlainString());
    
    assertEquals(7, jn.parse("3.14E-2", 0));
    assertEquals("0.0314", jn.getValue().toPlainString());
    
  }

}

package info.vbychkoviak.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.Test;

public class JsonBooleanTest {

  @Test
  public void test() throws ParseException {
    JsonBoolean jb = new JsonBoolean();
    assertEquals(4, jb.parse("true", 0));
    assertTrue(jb.getValue());

    assertEquals(5, jb.parse("false", 0));
    assertFalse(jb.getValue());

  }

  @Test(expected = ParseException.class)
  public void testFail() throws ParseException {
    JsonBoolean jb = new JsonBoolean();
    jb.parse("not boolean", 0);
  }

}

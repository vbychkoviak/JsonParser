package info.vbychkoviak.json;

import java.text.ParseException;
import java.util.BitSet;

public abstract class JsonBaseObject {

  public boolean isNumber() {
    return false;
  }

  public boolean isString() {
    return false;
  }

  public boolean isBoolean() {
    return false;
  }

  public boolean isArray() {
    return false;
  }

  public boolean isMap() {
    return false;
  }

  public boolean isNull() {
    return false;
  }

  public static JsonBaseObject parseObject(String data, int index) throws ParseException {
    JsonBaseObject obj = null;
    index = skipCharacters(data, index, WHITE_SPACE);

    char firstChar = data.charAt(index);
    if (firstChar == '{') {
      obj = new JsonMap();
    } else if (firstChar == '[') {
      obj = new JsonArray();
    } else if (firstChar == '"') {
      obj = new JsonString();
    } else if (firstChar == '-' || Character.isDigit(firstChar)) {
      obj = new JsonNumber();
    } else if (data.startsWith("true", index) || data.startsWith("false", index)) {
      obj = new JsonBoolean();
    } else if (data.startsWith("null", index)) {
      obj = new JsonNull();
    } else {
      throw new ParseException("can't determine value type", index);
    }

    index = obj.parse(data, index);
    index = skipCharacters(data, index, WHITE_SPACE);

    obj.setEndOffset(index);

    return obj;
  }

  // used only during parsing to pass index after object parsing
  private int endOffset;

  private void setEndOffset(int index) {
    endOffset = index;
  }

  int getEndOffset() {
    return endOffset;
  }

  abstract protected int parse(String data, int index) throws ParseException;

  protected static int skipCharacters(String data, int index, BitSet chars) {
    if (index >= data.length()) {
      return index;
    }

    for (; index < data.length(); index++) {
      char c = data.charAt(index);
      if (!chars.get(c)) {
        return index;
      }
    }

    return index;
  }

  public int skipWhiteSpace(String data, int index) {
    return skipCharacters(data, index, WHITE_SPACE);
  }

  private static BitSet generateBitSet(char... chars) {
    BitSet bs = new BitSet();
    for (int i = 0; i < chars.length; i++) {
      bs.set(chars[i]);
    }
    return bs;
  }

  protected static BitSet WHITE_SPACE = generateBitSet(' ', '\r', '\n', '\t');
  protected static BitSet MINUS = generateBitSet('-');
  protected static BitSet DIGITS = generateBitSet('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
  protected static BitSet FRACTION = generateBitSet('.');
  protected static BitSet EXP = generateBitSet('E', 'e');
  protected static BitSet SIGN = generateBitSet('+', '-');

}

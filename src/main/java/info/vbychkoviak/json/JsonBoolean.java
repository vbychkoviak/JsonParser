package info.vbychkoviak.json;

import java.text.ParseException;

public class JsonBoolean extends JsonBaseObject {

  private boolean value;

  @Override
  protected int parse(String data, int index) throws ParseException {
    if (data.startsWith("true", index)) {
      value = true;
      index += 4;
    } else if (data.startsWith("false", index)) {
      value = false;
      index += 5;
    } else {
      throw new ParseException("can't parse boolean value", index);
    }
    index = skipWhiteSpace(data, index);

    return index;
  }

  @Override
  public boolean isBoolean() {
    return true;
  }

  public boolean getValue() {
    return value;
  }

}

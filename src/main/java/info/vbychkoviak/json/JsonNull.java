package info.vbychkoviak.json;

import java.text.ParseException;

public class JsonNull extends JsonBaseObject {

  @Override
  public int parse(String data, int index) throws ParseException {
    if (!data.startsWith("null",index)) {
      throw new ParseException("wrong value type", index);
    }
    index +=4;
    index = skipWhiteSpace(data, index);
    return index;
  }
  
  @Override
  public boolean isNull() {
    return true;
  }

}

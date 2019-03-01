package info.vbychkoviak.json;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class JsonArray extends JsonBaseObject {

  private List<JsonBaseObject> elements;

  @Override
  protected int parse(String data, int index) throws ParseException {
    if (data.charAt(index) != '[') {
      throw new ParseException("array should open with [", index);
    }
    index++;
    elements = new ArrayList<JsonBaseObject>();

    while (true) {
      index = skipWhiteSpace(data, index);
      char nextChar = data.charAt(index);
      if (nextChar == ']') {
        index++;
        break;
      } else if (nextChar == ',') {
        index++;
      }
      JsonBaseObject obj = JsonBaseObject.parseObject(data, index);
      elements.add(obj);
      index = obj.getEndOffset();
    }

    return index;
  }

  @Override
  public boolean isArray() {
    return true;
  }

  public int getLength() {
    return elements.size();
  }

  public JsonBaseObject getElement(int index) {
    return elements.get(index);
  }

}

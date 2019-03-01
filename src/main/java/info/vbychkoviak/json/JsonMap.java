package info.vbychkoviak.json;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JsonMap extends JsonBaseObject {

  private Map<JsonString, JsonBaseObject> map;

  @Override
  protected int parse(String data, int index) throws ParseException {
    if (data.charAt(index) != '{') {
      throw new ParseException("map should open with {", index);
    }
    index++;

    map = new HashMap<JsonString, JsonBaseObject>();
    while (true) {
      index = skipWhiteSpace(data, index);
      char nextChar = data.charAt(index);
      if (nextChar == '}') {
        index++;
        break;
      } else if (nextChar == ',') {
        index++;
        continue;
      }
      JsonString key = new JsonString();
      index = key.parse(data, index);
      if (data.charAt(index) != ':') {
        throw new ParseException("key should be followed by \":\"", index);
      }
      index++;
      index = skipWhiteSpace(data, index);

      JsonBaseObject value = JsonBaseObject.parseObject(data, index);
      index = value.getEndOffset();

      map.put(key, value);

    }

    return index;
  }

  @Override
  public boolean isMap() {
    return true;
  }

  public Set<JsonString> keys() {
    return map.keySet();
  }

  public JsonBaseObject get(JsonString key) {
    return map.get(key);
  }
  
  public JsonBaseObject get(String key) {
    return map.get(new JsonString(key));
  }

}

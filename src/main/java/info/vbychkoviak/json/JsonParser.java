package info.vbychkoviak.json;

import java.text.ParseException;

public class JsonParser {

  public static JsonBaseObject parse(String data) throws ParseException {
    int index = 0;

    JsonBaseObject object = JsonBaseObject.parseObject(data, index);

    return object;
  }

}

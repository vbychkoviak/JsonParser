package info.vbychkoviak.json;

import java.text.ParseException;

public class JsonString extends JsonBaseObject {

  String value;

  public JsonString() {
  }
  
  public JsonString(String key) {
    this.value = key;
  }

  @Override
  protected int parse(String data, int index) throws ParseException {
    if (data.charAt(index) != '"') {
      throw new ParseException("string should start with \"", index);
    }
    index++;
    StringBuilder sb = new StringBuilder();
    while (true) {
      char c = data.charAt(index++);
      if (c == '"') {
        break;
      }
      if (c == '\\') {
        char escaped = data.charAt(index++);
        switch (escaped) {
        case 'b':
          escaped = '\b';
          break;
        case 'n':
          escaped = '\n';
          break;
        case 'r':
          escaped = '\r';
          break;
        case 't':
          escaped = '\t';
          break;
        case 'u':
          escaped = parseHexUnicode(data, index);
          index += 4;
          break;
        default:
          break;
        }
        c = escaped;

      }
      sb.append(c);
    }
    value = sb.toString();

    index = skipWhiteSpace(data, index);

    return index;
  }

  private char parseHexUnicode(String data, int index) {
    int value = Integer.parseInt(data.substring(index, index + 4));
    return (char) value;
  }

  @Override
  public boolean isString() {
    return true;
  }

  public String getValue() {
    return value;
  }

  @Override
  public int hashCode() {
    return value.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    JsonString other = (JsonString) obj;
    if (value == null) {
      if (other.value != null)
        return false;
    } else if (!value.equals(other.value))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

}

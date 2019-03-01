package info.vbychkoviak.json;

import java.math.BigDecimal;
import java.text.ParseException;

public class JsonNumber extends JsonBaseObject {

  BigDecimal number;

  @Override
  protected int parse(String data, int index) throws ParseException {
    index = skipWhiteSpace(data, index);

    int startIndex = index;
    index = skipCharacters(data, index, MINUS);
    index = skipCharacters(data, index, DIGITS);
    index = skipCharacters(data, index, FRACTION);
    index = skipCharacters(data, index, DIGITS);
    index = skipCharacters(data, index, EXP);
    index = skipCharacters(data, index, SIGN);
    index = skipCharacters(data, index, DIGITS);

    number = new BigDecimal(data.substring(startIndex, index));

    index = skipWhiteSpace(data, index);
    return index;
  }

  @Override
  public boolean isNumber() {
    return true;
  }

  public BigDecimal getValue() {
    return number;
  }

}

/*MIT License

Copyright (c) 2018 Milena dos Santos Macedo, Carlos André Cordeiro da Silva,
Adrielly Calado Sales, Lucas Mendes Cavalcanti. 

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package br.edu.ifpe.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Milena Macedo  <milenasantosmcd@gmail.com>
 */
@FacesConverter("facesConverterLocalDateTime")
public class FacesConvertLocalDateTime implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String stringValue) {
        
        System.out.println(context+" "+component +" "+ stringValue+"\n\n\n\n\n\n\n\n\n\n\n\n\n\n ---------------------");
        
        if (null == stringValue || stringValue.isEmpty()) {
            return null;
        }

        LocalDateTime localDateTime = null;

        try {

            localDateTime = LocalDateTime.parse(
                    stringValue.trim(),
                    DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss").withZone(ZoneId.systemDefault()));

        } catch (DateTimeParseException e) {

            throw new ConverterException("O formato da data e hora deve ser 13/11/2015 12:00:00.");
        }

        return localDateTime;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object localDateTimeValue) {

        if (null == localDateTimeValue) {

            return "";
        }
        return ((LocalDateTime) localDateTimeValue).format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss").withZone(ZoneId.systemDefault()));
    }

}

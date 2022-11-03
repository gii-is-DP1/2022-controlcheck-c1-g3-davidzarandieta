package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class RecoveryRoomTypeFormatter implements Formatter<RecoveryRoomType>{

    private final RecoveryRoomService rroom;
    @Autowired
    public RecoveryRoomTypeFormatter(RecoveryRoomService recRoom){
        this.rroom = recRoom;
    }


    @Override
    public String print(RecoveryRoomType object, Locale locale) {
        return object.getName();
    }

    @Override
    public RecoveryRoomType parse(String text, Locale locale) throws ParseException {
        RecoveryRoomType findRecoveryRoomType = this.rroom.getRecoveryRoomType(text);
        if( findRecoveryRoomType == null){
            throw new ParseException(text+"no se ha podido encontrar", 0);
        }
          return findRecoveryRoomType;
            }
}

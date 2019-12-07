package co.com.appmusicszeb.appmusic.services.application.trasformers;

import co.com.appmusicszeb.appmusic.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseTransformer{
    public static ResponseEntity transformFromResponse(Response res){
        HttpStatus estado=HttpStatus.valueOf(res.getCodeMessage());
        if(res.getState()){
            return new ResponseEntity(res.getMessageBody(), estado);
        }else{
            return new ResponseEntity(estado);
        }
    }
}

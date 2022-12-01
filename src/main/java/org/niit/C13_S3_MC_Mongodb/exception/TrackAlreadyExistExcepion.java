package org.niit.C13_S3_MC_Mongodb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason ="Track already exists" )
public class TrackAlreadyExistExcepion extends Exception{

}

package org.niit.C13_S3_MC_Mongodb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Artist not found")
public class ArtistNotFoundException extends Exception{

}

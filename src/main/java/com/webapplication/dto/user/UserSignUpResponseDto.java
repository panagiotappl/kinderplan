package com.webapplication.dto.user;

import org.springframework.http.HttpStatus;

/**
 * Created by dimitris on 5/19/2017.
 */
public class UserSignUpResponseDto {
   private HttpStatus status;
   private String message;

   public UserSignUpResponseDto(HttpStatus status,String message){
      this.status=status;
      this.message=message;
   }

   public HttpStatus getStatus() {
      return status;
   }

   public void setStatus(HttpStatus status) {
      this.status = status;
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }
}


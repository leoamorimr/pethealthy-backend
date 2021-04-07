package br.com.leoamorimr.pethealthy.pethealthybackend.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorDetail {

   private LocalDateTime currentDateTime;
   private String message;

   /**
    * @param currentDate
    * @param message
    */
   public ErrorDetail(LocalDateTime currentDate, String message) {
      this.currentDateTime = currentDate;
      this.message = message;
   }

   /**
    * 
    */
   public ErrorDetail() {
   }

}

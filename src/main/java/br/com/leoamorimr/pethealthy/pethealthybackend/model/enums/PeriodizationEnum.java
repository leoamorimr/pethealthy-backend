package br.com.leoamorimr.pethealthy.pethealthybackend.model.enums;

public enum PeriodizationEnum {

   YEARLY("Every year"), MONTLY("Every month"), WEEKLY("Every x weeks");

   private String periodization;

   private PeriodizationEnum(String periodization) {
      this.periodization = periodization;
   }

   /**
    * @return the periodization
    */
   public String getPeriodization() {
      return periodization;
   }

}

/**
  * Copyright 2021 bejson.com 
  */
package com.cloud.reptile.dto.law.detail;

/**
 * Auto-generated: 2021-02-26 15:22:23
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class LawFirmReptileDetailDTO {

    private int code;
    private String description;
    private String secretKey;
    private Result result;
    private String exception;
    private boolean success;
    public void setCode(int code) {
         this.code = code;
     }
     public int getCode() {
         return code;
     }

    public void setDescription(String description) {
         this.description = description;
     }
     public String getDescription() {
         return description;
     }

    public void setSecretKey(String secretKey) {
         this.secretKey = secretKey;
     }
     public String getSecretKey() {
         return secretKey;
     }

    public void setResult(Result result) {
         this.result = result;
     }
     public Result getResult() {
         return result;
     }

    public void setException(String exception) {
         this.exception = exception;
     }
     public String getException() {
         return exception;
     }

    public void setSuccess(boolean success) {
         this.success = success;
     }
     public boolean getSuccess() {
         return success;
     }

}
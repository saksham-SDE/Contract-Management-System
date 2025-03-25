package com.demo.DTO;

import org.springframework.http.HttpStatus;

public class FileResponse {
    private String fileName;
    private String message;
    private HttpStatus status;


    public FileResponse(String fileName, String message, HttpStatus status) {
        this.fileName = fileName;
        this.message = message;
        this.status= status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "FileResponse{" +
                "fileName='" + fileName + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

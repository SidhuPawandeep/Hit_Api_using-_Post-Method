package com.example.lenovo.fetchgrouplistwithimage;

import java.util.List;

/**
 * Created by lENOVO on 7/25/2017.
 */

public class MyPojo {

    private String message;

    private String errorMessage;

    private String status;

    private List<FetchGroupList> fetch_group_list;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<FetchGroupList> getFetch_group_list() {
        return fetch_group_list;
    }

    public void setFetch_group_list(List<FetchGroupList> fetch_group_list) {
        this.fetch_group_list = fetch_group_list;
    }
}


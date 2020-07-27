package com.example.dto;

import java.util.ArrayList;


public class PageDTO extends AbstractDTO{

    private ArrayList<AbstractDTO> list;
    private Integer totalPages;

    public ArrayList<AbstractDTO> getList() {
        return list;
    }

    public void setList(ArrayList<AbstractDTO> list) {
        this.list = list;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}

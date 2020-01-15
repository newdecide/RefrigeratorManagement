package com.study.refrigeratormanagement;

import java.util.ArrayList;

public class RefrigeratorData {
    public ArrayList<String> childname;
    public String parentname;

    public RefrigeratorData(String name){
        parentname = name;
        childname = new ArrayList<String>();
    }
}

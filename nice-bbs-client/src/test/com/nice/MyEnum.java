package com.nice;

public enum MyEnum {

    NUM(1);

    private Integer i;

    MyEnum(Integer i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return i.toString();
    }

    //    public void setI(Integer i) {
//        this.i = i;
//    }
//
//    public Integer getI() {
//        return i;
//    }

//    public void setI(Integer i) {
//        this.i = i;
//    }
}

package com.example.administrator.inspectsystem.net.entity;

/**
 * Created by Administrator on 2017/4/26.
 * 巡检系统主实体类
 */

public class MainInspect {
    //任务巡查区域
    public String area;
    //任务进行程度
    public String assign;
    //负责人
    public String name;
    //巡查日期
    public  String datatime;

    public MainInspect(String area, String assign, String name, String datatime) {
        this.area = area;
        this.assign = assign;
        this.name = name;
        this.datatime = datatime;
    }
}

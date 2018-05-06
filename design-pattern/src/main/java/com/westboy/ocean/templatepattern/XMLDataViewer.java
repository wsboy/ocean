package com.westboy.ocean.templatepattern;

public class XMLDataViewer extends DataViewer {

    @Override
    protected void getData() {
        System.out.println("从XML文件中获取数据。");
    }

    @Override
    protected void displayData() {
        System.out.println("以柱状图显示数据。");
    }

    @Override
    protected boolean isNotXMLData() {
        return false;
    }
}

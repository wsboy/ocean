package com.westboy.ocean.templatepattern;

public abstract class DataViewer {

    //抽象方法：获取数据
    protected abstract void getData();

    //具体方法：转换数据
    private void convertData() {
        System.out.println("将数据转换为XML格式。");
    }

    //钩子方法：判断是否为XML格式的数据
    protected boolean isNotXMLData() {
        return true;
    }

    //模板方法
    public void Process() {
        this.getData();
        if (this.isNotXMLData()) {
            this.convertData();
        }
        this.displayData();
    }

    //抽象方法：显示数据
    protected abstract void displayData();
}

package com.mada.factory.factory_method;

/**
 * Created by madali on 2018/5/2.
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

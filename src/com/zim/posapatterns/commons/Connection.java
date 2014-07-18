package com.zim.posapatterns.commons;

/**
 * Developed by martin.zangl@globant.com
 */
public class Connection implements Resource {

    private Identity identity;

    @Override
    public void method1() {
        
    }

    @Override
    public void method2() {

    }

    @Override
    public Identity getIdentity() {
        return identity;
    }

    @Override
    public ResourceType type() {
        return null;
    }
}

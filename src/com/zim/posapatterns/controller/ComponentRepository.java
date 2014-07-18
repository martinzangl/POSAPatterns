package com.zim.posapatterns.controller;

import com.zim.posapatterns.commons.Component;

import java.util.Map;

/**
 * Developed by martin.zangl@globant.com
 */
public class ComponentRepository {

    Map<String, Component> repository;

    public void insert(Component component) {
        if (!repository.containsKey(component.getClass().getName())) {
            repository.put(component.getClass().getName(), component);
        }
    }

    public boolean remove(Component component) {
        Component c = null;
        if (repository.containsKey(component.getClass().getName())) {
            c = repository.remove(component.getClass().getName());
        }
        return c != null;
    }

}

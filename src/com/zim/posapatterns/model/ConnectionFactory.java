package com.zim.posapatterns.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Developed by martin.zangl@globant.com
 */
public class ConnectionFactory implements ResourceFactory {

    private List<Connection> connections;
    private static final int INITIAL_CONNECTIONS = 10;

    public ConnectionFactory () {
        connections = new ArrayList<Connection>();
        for (int i = 0; i < INITIAL_CONNECTIONS; i++) {
            Connection connection = new Connection ();
            connections.add(connection);
        }
    }
    @Override
    public ManagedResource create() {
        if (!connections.isEmpty())
            return (Connection)connections.remove(0);

        Connection connection = new Connection ();
        return connection;
    }
}

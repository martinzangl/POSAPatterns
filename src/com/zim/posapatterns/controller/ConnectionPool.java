package com.zim.posapatterns.controller;

import com.zim.posapatterns.model.Connection;
import com.zim.posapatterns.model.Resource;
import com.zim.posapatterns.pattern.lifecycle.Pool;

import java.util.Vector;

/**
 * Developed by martin.zangl@globant.com
 */
public class ConnectionPool implements Pool {

    private Vector<Connection> connectionPool;

    /**
     * Acquire a connection from the pool.
     *
     * @return Resource a connection from the pool.
     */
    public Resource acquire() {
        Connection connection = findFreeConnection();
        if (connection == null) {
            connection = new Connection();
            connectionPool.add(connection);
        }
        return connection;
    }

    /**
     * Release the connection back to the pool.
     *
     * @param resource the connection that should be put back in the pool.
     */
    public void release(Resource resource) {
        if (resource instanceof Connection)
            this.recycleOrEvictConnection((Connection) resource);
    }

    private Connection findFreeConnection() {
        Connection connection = null;
        // ...
        return connection;
    }


    private void recycleOrEvictConnection(Connection con) {

        // ...

    }

}

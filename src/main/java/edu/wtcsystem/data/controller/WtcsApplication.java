package edu.wtcsystem.data.controller;

import java.util.Set;
import java.util.HashSet;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author cwinebrenner
 * @since 2016-11-04
 */

@ApplicationPath("/")
public class WtcsApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(WtcsFile.class);
        return h;
    }

}

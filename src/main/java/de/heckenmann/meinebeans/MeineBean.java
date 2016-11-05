package de.heckenmann.meinebeans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class MeineBean {

    public String sagHallo(final String name) {
        return "Hallo " + name;
    }

}

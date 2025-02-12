package org.fundaciobit.powertoys.commons.utils;

/**
 *
 * @author anadal
 *
 */
public interface Constants {

  public static final String POWERTOYS_PROPERTY_BASE="org.fundaciobit.powertoys.";

    public static final String MAIL_SERVICE = "java:/org.fundaciobit.powertoys.mail";

    // TRUE ROLES
    public static final String PWT_ADMIN="PWT_ADMIN";
    public static final String PWT_USER="PWT_USER";
    public static final String PWT_WS="PWT_WS";

    // VIRTUAL SECURITY ROLES
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";
    
    // EJB HIGH LEVEL ROLES
    public static final String ROLE_EJB_FULL_ACCESS  = PWT_ADMIN;
    public static final String ROLE_EJB_BASIC_ACCESS = PWT_USER;
    public static final String ROLE_EJB_WS_ACCESS = PWT_WS;
}


package com.PayU;

/**
 * <p>Java class for apiVersion.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="apiVersion">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ONE_ZERO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
public enum ApiVersion {

    ONE_ZERO;

    public static ApiVersion fromValue(String v) {
        return valueOf(v);
    }

    public String value() {
        return name();
    }

}

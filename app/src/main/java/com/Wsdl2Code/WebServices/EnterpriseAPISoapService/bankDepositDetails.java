package com.Wsdl2Code.WebServices.EnterpriseAPISoapService;

//------------------------------------------------------------------------------
// <wsdl2code-generated>
//    This code was generated by http://www.wsdl2code.com version  2.5
//
// Date Of Creation: 7/4/2014 4:34:19 PM
//    Please dont change this code, regeneration will override your changes
//</wsdl2code-generated>
//
//------------------------------------------------------------------------------
//
//This source code was auto-generated by Wsdl2Code  Version
//

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.Hashtable;

public class bankDepositDetails implements KvmSerializable {

    public String accountNumber;
    public String amountInCents;
    public String bankName;
    public String branchCode;
    public String defaultPM;
    public String pmId;

    public bankDepositDetails() {
    }

    public bankDepositDetails(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("accountNumber")) {
            Object obj = soapObject.getProperty("accountNumber");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                accountNumber = j.toString();
            } else if (obj != null && obj instanceof String) {
                accountNumber = (String) obj;
            }
        }
        if (soapObject.hasProperty("amountInCents")) {
            Object obj = soapObject.getProperty("amountInCents");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                amountInCents = j.toString();
            } else if (obj != null && obj instanceof String) {
                amountInCents = (String) obj;
            }
        }
        if (soapObject.hasProperty("bankName")) {
            Object obj = soapObject.getProperty("bankName");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                bankName = j.toString();
            } else if (obj != null && obj instanceof String) {
                bankName = (String) obj;
            }
        }
        if (soapObject.hasProperty("branchCode")) {
            Object obj = soapObject.getProperty("branchCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                branchCode = j.toString();
            } else if (obj != null && obj instanceof String) {
                branchCode = (String) obj;
            }
        }
        if (soapObject.hasProperty("defaultPM")) {
            Object obj = soapObject.getProperty("defaultPM");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                defaultPM = j.toString();
            } else if (obj != null && obj instanceof String) {
                defaultPM = (String) obj;
            }
        }
        if (soapObject.hasProperty("pmId")) {
            Object obj = soapObject.getProperty("pmId");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                pmId = j.toString();
            } else if (obj != null && obj instanceof String) {
                pmId = (String) obj;
            }
        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return accountNumber;
            case 1:
                return amountInCents;
            case 2:
                return bankName;
            case 3:
                return branchCode;
            case 4:
                return defaultPM;
            case 5:
                return pmId;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 6;
    }

    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch (index) {
            case 0:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "accountNumber";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "amountInCents";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "bankName";
                break;
            case 3:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "branchCode";
                break;
            case 4:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "defaultPM";
                break;
            case 5:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "pmId";
                break;
        }
    }

    @Override
    public void setProperty(int arg0, Object arg1) {
    }

}

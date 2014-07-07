package com.Wsdl2Code.WebServices.EnterpriseAPISoapService;

/**
 * Created by PJ on 2014/07/04.
 */
public class SetTransaction {
    private additionalInfo _AdditionalInfo;
    private customer _Customer;
    private basket _baBasket;
    private String _Api;
    private String _SafeKey;
    private WS_Enums.transactionType _TransactionType;

    public additionalInfo get_AdditionalInfo() {
        return _AdditionalInfo;
    }

    public void set_AdditionalInformation(additionalInfo _AdditionalInfo) {
        this._AdditionalInfo = _AdditionalInfo;
    }

    public customer get_Customer() {
        return _Customer;
    }

    public void set_Customer(customer _Customer) {
        this._Customer = _Customer;
    }

    public basket get_baBasket() {
        return _baBasket;
    }

    public void set_Basket(basket _baBasket) {
        this._baBasket = _baBasket;
    }

    public String get_Api() {
        return _Api;
    }

    public void set_Api(String _Api) {
        this._Api = _Api;
    }

    public String get_SafeKey() {
        return _SafeKey;
    }

    public void set_Safekey(String _SafeKey) {
        this._SafeKey = _SafeKey;
    }

    public WS_Enums.transactionType get_TransactionType() {
        return _TransactionType;
    }

    public void set_TransactionType(WS_Enums.transactionType _TransactionType) {
        this._TransactionType = _TransactionType;
    }
}

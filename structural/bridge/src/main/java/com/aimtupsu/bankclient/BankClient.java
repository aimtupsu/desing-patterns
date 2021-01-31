package com.aimtupsu.bankclient;

import com.aimtupsu.bankclient.model.BankInfo;
import com.aimtupsu.bankclient.model.Request;
import com.aimtupsu.bankclient.model.Response;

public interface BankClient {

    Response sendRequest(Request request);

    BankInfo getBankInfo();

}

package com.binance.connector.client.impl.spot;

import com.binance.connector.client.enums.HttpMethod;
import com.binance.connector.client.utils.ParameterChecker;
import com.binance.connector.client.utils.RequestHandler;

import java.util.LinkedHashMap;

/**
 * <h2>Gift Card Endpoints</h2>
 * All endpoints under the
 * <a href="https://binance-docs.github.io/apidocs/spot/en/#binance-code-endpoints">Gift Card Endpoint</a>
 * section of the API documentation will be implemented in this class.
 * <br>
 * Response will be returned in <i>String format</i>.
 */
public class GiftCard {
    private final String baseUrl;
    private final RequestHandler requestHandler;
    private final boolean showLimitUsage;

    public GiftCard(String baseUrl, String apiKey, String secretKey, boolean showLimitUsage) {
        this.baseUrl = baseUrl;
        this.requestHandler = new RequestHandler(apiKey, secretKey);
        this.showLimitUsage = showLimitUsage;
    }

    private final String CREATE_CODE = "/sapi/v1/giftcard/createCode";
    /**
     * This API is for creating a Binance Code. To get started with, please make sure:
     *
     * You have a Binance account <br>
     * You have passed kyc <br>
     * You have a sufﬁcient balance in your Binance funding wallet <br>
     * You need Enable Withdrawals for the API Key which requests this endpoint. <br>
     * <br><br>
     * POST /sapi/v1/giftcard/createCode
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * token -- mandatory/string -- The coin type contained in the Binance Code <br>
     * amount -- mandatory/double -- The amount of the coin <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://binance-docs.github.io/apidocs/spot/en/#create-a-binance-code-user_data">
     *     https://binance-docs.github.io/apidocs/spot/en/#create-a-binance-code-user_data</a>
     */
    public String createCode(LinkedHashMap<String,Object> parameters) {
        ParameterChecker.checkParameter(parameters, "token", String.class);
        ParameterChecker.checkParameter(parameters, "amount", Double.class);
        return requestHandler.sendSignedRequest(baseUrl, CREATE_CODE, parameters, HttpMethod.POST, showLimitUsage);
    }

    private final String REDEEM_CODE = "/sapi/v1/giftcard/redeemCode";
    /**
     * This API is for redeeming the Binance Code. Once redeemed, the coins will be deposited in your funding wallet. <br>
     * Please note that if you enter the wrong code 5 times within 24 hours,
     * you will no longer be able to redeem any Binance Code that day. <br>
     * <br><br>
     * POST /sapi/v1/giftcard/redeemCode
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * code -- mandatory/string -- Binance code <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://binance-docs.github.io/apidocs/spot/en/#redeem-a-binance-code-user_data">
     *     https://binance-docs.github.io/apidocs/spot/en/#redeem-a-binance-code-user_data</a>
     */
    public String redeemCode(LinkedHashMap<String,Object> parameters) {
        ParameterChecker.checkParameter(parameters, "code", String.class);
        return requestHandler.sendSignedRequest(baseUrl, REDEEM_CODE, parameters, HttpMethod.POST, showLimitUsage);
    }

    private final String VERIFY = "/sapi/v1/giftcard/verify";
    /**
     * This API is for verifying whether the Binance Code is valid or not by entering Binance Code or reference number. <br>
     * Please note that if you enter the wrong binance code 5 times within an hour,
     * you will no longer be able to verify any binance code for that hour. <br>
     * <br><br>
     * GET /sapi/v1/giftcard/verify
     * <br>
     * @param
     * parameters LinkedHashedMap of String,Object pair
     *            where String is the name of the parameter and Object is the value of the parameter
     * <br><br>
     * referenceNo -- mandatory/string -- reference number <br>
     * recvWindow -- optional/long <br>
     * @return String
     * @see <a href="https://binance-docs.github.io/apidocs/spot/en/#verify-a-binance-code-user_data">
     *     https://binance-docs.github.io/apidocs/spot/en/#verify-a-binance-code-user_data</a>
     */
    public String verify(LinkedHashMap<String,Object> parameters) {
        ParameterChecker.checkParameter(parameters, "referenceNo", String.class);
        return requestHandler.sendSignedRequest(baseUrl, VERIFY, parameters, HttpMethod.GET, showLimitUsage);
    }
}

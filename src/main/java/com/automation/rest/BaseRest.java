package com.automation.rest;

import com.automation.common.Resources;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

public class BaseRest {

    public JSONObject getResponseJO(String response) {
        JSONObject responseJO;
        responseJO = new JSONObject(response);
        return responseJO;
    }

    public String createUniqueTimeStamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Resources.simpleDateFormatMMddHHmmss);
        Timestamp ts = new Timestamp(new Date().getTime());
        return simpleDateFormat.format(ts);
    }

}

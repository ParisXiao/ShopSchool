package com.liuzhi.eschool.gjson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

/**
 * Created by YANGLIN on 2018/5/12.
 */

public class FloatDefault0Adapter implements JsonSerializer<Float>, JsonDeserializer<Float> {
    @Override
    public Float deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            if (json.getAsString().equals("") || json.getAsString().equals("null")) {//定义为Float类型,如果后台返回""或者null,则返回0.00
                return 0.00f;
            }
        } catch (Exception ignore) {
        }
        try {
            return json.getAsFloat();
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
        }
    }

    @Override
    public JsonElement serialize(Float src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src);
    }
}
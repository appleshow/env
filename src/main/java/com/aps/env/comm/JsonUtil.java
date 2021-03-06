package com.aps.env.comm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Map;

/**
 * <dl>
 * <dt>com.aps.env.comm.JsonUtil</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/7</dd>
 * </dl>
 *
 * @author appleshow
 */
public class JsonUtil {

    private static Logger logger = LogManager.getLogger(JsonUtil.class.getName());
    private static ObjectMapper jsonMapper = new ObjectMapper();

    static {
        jsonMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        jsonMapper.setDateFormat(DateUtil.SIMPLE_DATE_FORMAT1);
    }

    /**
     *
     * @Title: getObjectMapper
     * @Description: TODO
     * @return ObjectMapper
     * @throws:
     * @since 1.0.0
     */
    public static ObjectMapper getObjectMapper() {
        return jsonMapper;
    }

    /**
     *
     * @Title: getObjectNodeInstance
     * @Description: TODO
     * @param: @return
     * @return: ObjectNode
     * @throws @since
     *             1.0.0
     */
    public static ObjectNode getObjectNodeInstance() {
        return jsonMapper.createObjectNode();
    }

    /**
     *
     * @Title: getArrayNodeInstance
     * @Description: TODO
     * @return ArrayNode
     * @throws:
     * @since 1.0.0
     */
    public static ArrayNode getArrayNodeInstance() {
        return jsonMapper.createArrayNode();
    }

    /**
     *
     * @Title: writeValueAsString
     * @Description: TODO
     * @param: @param
     *             object
     * @param: @return
     * @return: String
     * @throws @since
     *             1.0.0
     */
    public static String writeValueAsString(Object object) {
        String jsonString;
        try {
            jsonString = jsonMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            jsonString = null;
        }

        return jsonString;
    }

    /**
     *
     * @param <T>
     * @Title: writeResponsAsString
     * @Description: TODO
     * @param: @param
     *             object
     * @param: @return
     * @return: String
     * @throws @since
     *             1.0.0
     */
    public static String writeResponseAsString(ResponseData responseData) {
        String jsonString;

        try {
            jsonString = jsonMapper.writeValueAsString(responseData);
        } catch (JsonProcessingException e) {
            jsonString = ErrorUtil.nomarlException(e);
        }

        System.out.println("--------------------------RESPONSE----------------------------------------");
        System.out.println(jsonString);
        System.out.println("--------------------------RESPONSE----------------------------------------");

        return jsonString;
    }

    /**
     *
     * @Title: readValueAsObject
     * @Description: TODO
     * @param: @param
     *             data
     * @param: @param
     *             object
     * @param: @return
     * @return: Object
     * @throws JsonProcessingException
     * @throws @since
     *             1.0.0
     */
    public static Object readValueAsObject(Map<String, String> data, Class<?> object) {
        String jsonData;
        Object instance;

        try {
            jsonData = jsonMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            logger.debug(e);
            jsonData = null;
        }

        if (null != jsonData) {
            try {
                instance = jsonMapper.readValue(jsonData, object);
            } catch (IOException e) {
                logger.debug(e);
                instance = null;
            }
        } else {
            instance = null;
        }

        return instance;
    }

    /**
     *
     * @Title: readRequestPar
     * @Description: TODO
     * @param: @param
     *             inpar
     * @param: @return
     * @return: RequestPar
     * @throws @since
     *             1.0.0
     */
    public static RequestRefPar readRequestRefPar(String inPar) {
        RequestRefPar requestRefPar = new RequestRefPar();

        requestRefPar.setParCount(0);
        try {
            requestRefPar = jsonMapper.readValue(inPar, RequestRefPar.class);
        } catch (IOException e) {
        }

        System.out.println("--------------------------INPAR----------------------------------------");
        System.out.println(inPar);
        System.out.println("--------------------------INPAR----------------------------------------");

        return requestRefPar;
    }

    /**
     *
     * @Title: readRequestMdyPar
     * @Description: TODO
     * @param: @param
     *             inpar
     * @param: @return
     * @return: RequestMdyPar
     * @throws @since
     *             1.0.0
     */
    public static RequestMdyPar readRequestMdyPar(String inpar) {
        RequestMdyPar requestMdyPar = new RequestMdyPar();

        requestMdyPar.setParCount(0);
        try {
            requestMdyPar = jsonMapper.readValue(inpar, RequestMdyPar.class);
        } catch (IOException e) {
        }

        System.out.println("--------------------------MDY----------------------------------------");
        System.out.println(inpar);
        System.out.println("--------------------------MDY----------------------------------------");

        return requestMdyPar;
    }

    /**
     *
     * @Title: valueToArrayNode
     * @Description: TODO
     * @param: @param
     *             object
     * @param: @return
     * @return: ArrayNode
     * @throws @since
     *             1.0.0
     */
    public static ArrayNode valueToArrayNode(Object object) {
        ArrayNode arrayNode;

        try {
            arrayNode = jsonMapper.valueToTree(object);
        } catch (IllegalArgumentException e) {
            return null;
        }

        return arrayNode;
    }
}

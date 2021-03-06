package com.vkapi.app.core;

import com.google.gson.Gson;
import com.models.app.*;
import com.models.app.VkError;
import com.vkapi.app.*;

import org.apache.http.Header;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.zip.GZIPInputStream;

public class ResponseParser {

    public static <T extends BaseModel> WebResponse<T> tryParseResponse(byte[] bytes, Header[] headers, Type type) {

        WebResponse<T> result = null;
        if (bytes != null) {
            String responseContent = getResponseContent(bytes, headers);
            if (responseContent != null && !responseContent.isEmpty()) {
                Gson gson = new Gson();
                result =  gson.fromJson(responseContent, type);
            } else {
                result = new WebResponse<>();
                result.error = createParsingError();
            }
        }

        return result;
    }

    public static boolean isGziped(Header[] headers) {
        boolean result = false;
        for (Header header : headers) {
            if (header.getName().contains("Content-Encoding")) {
                result = header.getValue().contains("gzip");
                break;
            }
        }

        return result;
    }

    public static String decompress(byte[] compressed) throws IOException {
        ByteArrayInputStream inputStr = new ByteArrayInputStream(compressed);
        GZIPInputStream gzipInputStream = new GZIPInputStream(inputStr);
        byte[] decompressed = new byte[compressed.length];
        gzipInputStream.read(decompressed, 0, decompressed.length);
        String result = new String(decompressed);
        gzipInputStream.close();
        inputStr.close();
        return result;
    }


    private static String getResponseContent(byte[] bytes, Header[] headers) {
        String responseContent = "";
        if (isGziped(headers)) {

            try {
                responseContent = decompress(bytes);
            } catch (IOException ex) {
                responseContent = new String(bytes);
                // TODO: implement logging
            }
        } else  {
            responseContent = new String(bytes);
        }

        return responseContent;
    }

    private static VkError createParsingError() {
        VkError error = new VkError();
        error.code = ApiConstants.ErrorsCodes.PARSING_ERROR_CODE;
        return error;
    }

}

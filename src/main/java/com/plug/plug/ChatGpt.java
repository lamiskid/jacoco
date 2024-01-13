package com.plug.plug;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

public class ChatGpt {


    private static final String OPENAI_API_KEY = "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";
    private static final String OPENAI_API_ENDPOINT = "https://api.openai.com/v1/chat/completions";


    public static void main(String[] args) {
        String prompt = "Translate the following English text to French: ";
        String response = makeOpenAIAPIRequest(prompt);
        System.out.println(response);
    }

    private static String makeOpenAIAPIRequest(String prompt) {
        String  model = "text-embedding-ada-002";


        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(OPENAI_API_ENDPOINT);

            httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + OPENAI_API_KEY);
            httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");

            String requestBody = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + prompt + "\"}]}";
            httpPost.setEntity(new StringEntity(requestBody));

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();

            if (httpEntity != null) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(httpEntity.getContent()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    return response.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }










}

package com.deankamali;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.StringWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        Undertow server = Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler(new HttpHandler() {
                    public void handleRequest(HttpServerExchange exchange) throws Exception {
                        if (!"GET".equalsIgnoreCase(exchange.getRequestMethod().toString())) {
                            exchange.setStatusCode(405);
                            return;
                        }

                        StringWriter writer = new StringWriter();
                        writer.append(" __     __           _ _ \n");
                        writer.append(" \\ \\   / /          | (_)\n");
                        writer.append("  \\ \\_/ /_ _ _ __ __| |_ \n");
                        writer.append("   \\   / _` | '__/ _` | |\n");
                        writer.append("    | | (_| | | | (_| | |\n");
                        writer.append("    |_|\\__,_|_|  \\__,_|_|\n");
                        writer.append("\n");

                        JSONObject result = new JSONObject();
                        for (String host : new String[]{"www.google.com", "www.amazon.com", "www.facebook.com"}) {
                            JSONArray ipArray = new JSONArray();
                            try {
                                for (InetAddress ip : InetAddress.getAllByName(host)) {
                                    ipArray.put(ip.getHostAddress());
                                }
                            } catch (UnknownHostException e) {
                                ipArray.put("Error: " + host);
                            }
                            result.put(host, ipArray);
                        }

                        writer.append(result.toString(4));
                        String resultString = writer.toString();
                        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
                        exchange.getResponseSender().send(resultString);
                    }
                }).build();
        server.start();
        System.out.println("Server started at http://localhost:8080");
    }
}

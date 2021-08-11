package com.example.jsonexample;

import android.util.JsonWriter;

import java.io.IOException;
import java.io.Writer;

public class WriterJSONExample {
    public static void writeJsonStream(Writer output, Company company) throws IOException {
        JsonWriter jsonWriter = new JsonWriter(output);

        jsonWriter.beginObject();//begin root

        jsonWriter.name("id").value(company.getId());
        jsonWriter.name("name").value(company.getName());

        String[] websites = company.getWebsites();

        // "websites": [ ....]
        jsonWriter.name("websites").beginArray();
        for(String website: websites) {
            jsonWriter.value(website);
        }
        jsonWriter.endArray(); //end websites

        // "address": { ... }
        jsonWriter.name("address").beginObject();
        jsonWriter.name("street").value(company.getAddress().getStreet());
        jsonWriter.name("city").value(company.getAddress().getCity());
        jsonWriter.endObject(); //end address

        //end root
        jsonWriter.endObject();
    }
    public static Company createCompany() {
        Company company = new Company();
        company.setId(123);
        company.setName("Apple");

        String[] websites = {"http://apple.com", "https://jobs.apple.com"};
        company.setWebsites(websites);

        Address address = new Address();
        address.setCity("Cupertino");
        address.setStreet("1 Infinite Loop");
        company.setAddress(address);

        return company;
    }
}

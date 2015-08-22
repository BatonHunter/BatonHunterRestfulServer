package org.batonhunter.server.restful.model;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MediaType;

/**
 * Created by ianchiu on 2015/8/22.
 */
public class Email {
    private String content;
    private String subject;
    private String to;

    public Email(String content, String subject, String from, String to) {
        this.content = content;
        this.subject = subject;
        this.to = to;
    }

    public String send(){
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter("api",
                "key-0161e5b776fc8e1831e7103fcfd0aa81"));
        WebResource webResource =
                client.resource("https://api.mailgun.net/v3/sandbox3e6dc85a296c43e69e07d3502143c0a4.mailgun.org" +
                        "/messages");
        MultivaluedMapImpl formData = new MultivaluedMapImpl();
        formData.add("from", "Excited User <mailgun@sandbox3e6dc85a296c43e69e07d3502143c0a4.mailgun.org>");
        formData.add("to", this.to);
        formData.add("subject", this.subject);
        formData.add("text", this.content);

        return String.valueOf(webResource.type(MediaType.APPLICATION_FORM_URLENCODED).
                post(ClientResponse.class, formData).getStatus());
    }
}

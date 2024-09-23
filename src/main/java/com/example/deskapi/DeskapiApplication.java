package com.example.deskapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zoho.desk.exception.ZDeskException;
import com.zoho.desk.init.ZDesk;
import com.zoho.desk.ticket.Ticket;
import com.zoho.desk.ticket.TicketAPI;
import com.zoho.oauth.client.ZohoOAuthClient;
import com.zoho.oauth.client.ZohoOAuthTokens;
import com.zoho.oauth.common.ZohoOAuthException;

@SpringBootApplication
public class DeskapiApplication {

	public static void main(String[] args) {
		System.setProperty("desk.sdk.config", "src/main/resources/desk_sdk_config.properties");

		SpringApplication.run(DeskapiApplication.class, args);

		try {
            ZohoOAuthClient client = ZohoOAuthClient.getInstance();
            ZohoOAuthTokens tokens = client.generateAccessToken("1000.fa8b90d1ed25fe4fb830f55045602d98.b42efd2c2d361b461213e2df21f83c1f"); //self_client_grant_token is passed as arg of the method
			
			System.out.println("Tokens " + tokens.getClass());
            // System.out.println(tokens.getAccessToken() + " ::: " + tokens.getRefreshToken());
        } catch(ZohoOAuthException ex) {
            ex.printStackTrace();
        }

		// try {
        //     TicketAPI ticketAPI = ZDesk.getTicketAPIInstance("findyandx@gmail.com");
        //     Ticket ticket = new Ticket();
        //     ticket.setSubject("Ticket From Java Client");
        //     ticket.setDepartmentId("291783000000006907");
        //     ticket.setContactId("291783000000101077");
        //     ticket.setStatus("Open");
        //     Ticket response = ticketAPI.createTicket(ticket);
        //     System.out.println(response);
        // } catch(ZDeskException | ZohoOAuthException ex) {
        //     ex.printStackTrace();
        // }
	}

}

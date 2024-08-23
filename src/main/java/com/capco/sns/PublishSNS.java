package com.capco.sns;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;
import software.amazon.awssdk.services.sns.model.SnsException;

public class PublishSNS {

	public static void main(String[] args) {
		try {
			SnsClient snsClient = SnsClient.builder()
		            .region(Region.US_EAST_1)
		            .build();

            PublishRequest request = PublishRequest.builder()
                .message("{\npolicyNumber:XPTO, \n taskName:New and Open Requirements, \n businessEvent:NewBusinessCreateEvent \n}")
                .topicArn("arn:aws:sns:us-east-1:058264210113:capco-test-sns-email")
                .build();

            PublishResponse result = snsClient.publish(request);
            System.out.println(result.messageId() + " Message sent. Status is " + result.sdkHttpResponse().statusCode());
            snsClient.close();
         } catch (SnsException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
         }
	}
}
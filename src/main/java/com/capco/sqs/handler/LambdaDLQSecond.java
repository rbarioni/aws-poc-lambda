package com.capco.sqs.handler;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;
import software.amazon.awssdk.services.sns.model.SnsException;

public class LambdaDLQSecond implements RequestHandler<SQSEvent, Void> {

	@Override
	public Void handleRequest(SQSEvent event, Context context) {
		LambdaLogger logger = context.getLogger();
		logger.log("DLQ #2 event found: " + event);
		logger.log("Date/time: " + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));

	    for (SQSMessage msg : event.getRecords()) {
	    	logger.log("Message: "+msg);

			try {
				SnsClient snsClient = SnsClient.builder()
			            .region(Region.US_EAST_1)
			            .build();

	            PublishRequest request = PublishRequest.builder()
	                .message(msg.getBody())
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

		return null;
	}
}
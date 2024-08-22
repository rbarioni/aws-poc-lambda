package com.capco.sqs.handler;

import java.util.UUID;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

public class LambdaKinesis implements RequestHandler<Void, Void> {

	@Override
	public Void handleRequest(Void event, Context context) {

		SqsClient sqsClient = SqsClient.builder()
                .region(Region.US_EAST_1)
                .build();

//		try {
//            SendMessageBatchRequest sendMessageBatchRequest = SendMessageBatchRequest.builder()
//            		.queueUrl("https://sqs.us-east-1.amazonaws.com/058264210113/sqs-notification-enrichment.fifo")
//                    .entries(SendMessageBatchRequestEntry.builder().id("id1").messageBody("\"{\"policy\":\"123\",\"task\":\"create\"}\"")
//                    		.messageGroupId(UUID.randomUUID().toString())
//                            .messageDeduplicationId(UUID.randomUUID().toString()).build(),
//                            SendMessageBatchRequestEntry.builder().id("id2").messageBody("\"{\"policy\":\"456\",\"task\":\"create\"}\"")
//                    		.messageGroupId(UUID.randomUUID().toString())
//                            .messageDeduplicationId(UUID.randomUUID().toString()).build(),
//                            SendMessageBatchRequestEntry.builder().id("id3").messageBody("\"{\"policy\":\"789\",\"task\":\"create\"}\"")
//                    		.messageGroupId(UUID.randomUUID().toString())
//                            .messageDeduplicationId(UUID.randomUUID().toString()).build(),
//                            SendMessageBatchRequestEntry.builder().id("id4").messageBody("\"{\"policy\":\"258\",\"task\":\"create\"}\"")
//                    		.messageGroupId(UUID.randomUUID().toString())
//                            .messageDeduplicationId(UUID.randomUUID().toString()).build())
//                    .build();
//            sqsClient.sendMessageBatch(sendMessageBatchRequest);
//        } catch (SqsException e) {
//            System.err.println(e.awsErrorDetails().errorMessage());
//            System.exit(1);
//        }

		sqsClient.sendMessage(SendMessageRequest.builder()
                .queueUrl("https://sqs.us-east-1.amazonaws.com/058264210113/sqs-notification-enrichment.fifo")
                .messageBody("\"{\"policy\":\"123\",\"task\":\"create\"}\"")
                .messageGroupId(UUID.randomUUID().toString())
                .messageDeduplicationId(UUID.randomUUID().toString())
                .build());

		sqsClient.sendMessage(SendMessageRequest.builder()
                .queueUrl("https://sqs.us-east-1.amazonaws.com/058264210113/sqs-notification-enrichment.fifo")
                .messageBody("\"{\"policy\":\"456\",\"task\":\"create\"}\"")
                .messageGroupId(UUID.randomUUID().toString())
                .messageDeduplicationId(UUID.randomUUID().toString())
                .build());

		sqsClient.sendMessage(SendMessageRequest.builder()
                .queueUrl("https://sqs.us-east-1.amazonaws.com/058264210113/sqs-notification-enrichment.fifo")
                .messageBody("\"{\"policy\":\"789\",\"task\":\"create\"}\"")
                .messageGroupId(UUID.randomUUID().toString())
                .messageDeduplicationId(UUID.randomUUID().toString())
                .build());

		sqsClient.sendMessage(SendMessageRequest.builder()
                .queueUrl("https://sqs.us-east-1.amazonaws.com/058264210113/sqs-notification-enrichment.fifo")
                .messageBody("\"{\"policy\":\"246\",\"task\":\"create\"}\"")
                .messageGroupId(UUID.randomUUID().toString())
                .messageDeduplicationId(UUID.randomUUID().toString())
                .build());

		return null;
	}
}
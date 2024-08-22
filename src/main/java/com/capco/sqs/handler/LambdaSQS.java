package com.capco.sqs.handler;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;

public class LambdaSQS implements RequestHandler<SQSEvent, Void> {

	@Override
	public Void handleRequest(SQSEvent event, Context context) {
		LambdaLogger logger = context.getLogger();
	    logger.log("Event found: " + event);
	    logger.log("Date/time: " + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));

	    for (SQSMessage msg : event.getRecords()) {
	    	logger.log("Message: "+msg);

	    	if(!msg.getBody().contains("123")) {
	    		throw new RuntimeException();
	    	}
	    }
		return null;
	}
}
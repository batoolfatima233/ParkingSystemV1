package com.example.parkingsystemv1.Queue;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.simpleworkflow.flow.JsonDataConverter;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.*;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.example.parkingsystemv1.Objects.Registration;
import com.google.gson.Gson;

import java.util.List;

public class sqsQueue {

    static AmazonSQS sqs= AmazonSQSClientBuilder.standard().withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:4566", "us-east-2"))
            .build();

    static String queueUrl="http://192.182.172.145:4566/000000000000/test";

    public static void SendRegistrationMessage(String registration_msg){
        try {
            SendMessageRequest send_msg_req = new SendMessageRequest().withQueueUrl(queueUrl)
                    .withMessageBody(registration_msg)
                    .withDelaySeconds(0);
            SendMessageResult send_msg_rslt = sqs.sendMessage(send_msg_req);
            System.out.println("Message Sent Successfully!");
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Failed");
        }
    }
    public static Registration ReadRegistrationMessage(String queueName) {

        //Creating Receive Message Request
        //ReceiveMessageRequest receive_msg_req = new ReceiveMessageRequest().withQueueUrl(getQueueUrl(queueName)).withMaxNumberOfMessages(1).withVisibilityTimeout(10);
        ReceiveMessageRequest receive_msg_req=new ReceiveMessageRequest().withQueueUrl(queueUrl).withVisibilityTimeout(10).withWaitTimeSeconds(10);
        //Getting a list of messages
        List<Message> messages = sqs.receiveMessage(receive_msg_req).getMessages();
        //Printing the size of Queue
        System.out.println(messages.size());
        if(messages.size()!=0) {
            //Printing Message
            System.out.println(messages.get(0).getBody());
            System.out.println(messages.get(0).toString());
            //return messages.get(0).getReceiptHandle();
            Registration reg =null;
            try
            {
                String json= messages.get(0).getBody();
                Gson g = new Gson();


                String ne = json.substring(12,json.length());
                reg= g.fromJson(ne,Registration.class);

                System.out.println("now after removed "+ ne);
                //JsonDataConverter jsonDataConverter = new JsonDataConverter();
                //reg = jsonDataConverter.deserializeFromJson(messages.get(0).getBody()), Registration.class);
                //MessageBody body = gson.fromJson(messages.get(0).getBody(), MessageBody.class);
                return reg;
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
                System.out.println("exception:" + reg);
                //return messages.get(0).getBody();
                return reg;
            }

        }
        else
        {
            System.out.println("Error; Cant read the top most message as the queue is empty");
        }
        System.out.println("kim");
        return null;
    }
    public int getQueueSize(String queueName)
    {
        //Creating Receive Message Request
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest().withQueueUrl(queueUrl).withMaxNumberOfMessages(30).withVisibilityTimeout(1);
        //Getting a list of messages
        List<Message> messages = sqs.receiveMessage(receiveMessageRequest).getMessages();
        //Printing the size of Queue
        return messages.size();
    }
}


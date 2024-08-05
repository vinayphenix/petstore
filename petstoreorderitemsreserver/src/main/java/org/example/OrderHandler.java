package org.example;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.BlobOutput;
import com.microsoft.azure.functions.annotation.FixedDelayRetry;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.ServiceBusQueueTrigger;
import com.microsoft.azure.functions.annotation.StorageAccount;
import org.springframework.stereotype.Component;

@Component
public class OrderHandler {

  @FunctionName("reserver")
  @StorageAccount("BlobConnectionString")
  @FixedDelayRetry(maxRetryCount = 3, delayInterval = "00:00:01")
  @BlobOutput(
      name = "target",
      dataType = "string",
      path = "orders/{id}")
  public Order execute(
      @ServiceBusQueueTrigger(name = "message",
          queueName = "reservations",
          connection = "ServiceBusConnectionString") Order order,
      final ExecutionContext context) {
    return order;
  }

//  @FunctionName("reserver")
//  public HttpResponseMessage execute(
//      @HttpTrigger(name = "request",
//          methods = {HttpMethod.POST},
//          authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<Order>> request,
//      ExecutionContext context) throws IOException {
//    var blobContainerClient = blobServiceClient.createBlobContainerIfNotExists("orders");
//    var blobClient = blobContainerClient.getBlobClient(String.format("%s.json",
//        request.getBody().orElseGet(Order::new).getId()));
//    var data = BinaryData.fromBytes(
//        objectMapper.writeValueAsBytes(request.getBody().orElseGet(Order::new)));
//    var headers = new BlobHttpHeaders().setContentType("application/json");
//    var options = new BlobParallelUploadOptions(data)
//        .setRequestConditions(new BlobRequestConditions()).setHeaders(headers);
//    blobClient.uploadWithResponse(options, null, Context.NONE);
//    return request.createResponseBuilder(HttpStatus.OK)
//        .body(request.getBody())
//        .header("Content-Type", "application/json")
//        .build();
//  }

}
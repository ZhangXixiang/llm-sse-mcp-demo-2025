package vn.cloud.llm_mcp_client_demo;

import java.util.List;

import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.spec.McpSchema;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LlmMcpClientDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LlmMcpClientDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner run(List<McpSyncClient> clients, AiService aiService) {
		return args -> {
//			McpSyncClient mcpSyncClient = clients.get(0);
//
//			McpSchema.ListToolsResult listToolsResult = mcpSyncClient.listTools();
//			listToolsResult.tools().stream().map(McpSchema.Tool::name).forEach(System.out::println);
//
//			McpSchema.CallToolResult getCurrentDateTime = mcpSyncClient.callTool(new McpSchema.CallToolRequest("getCurrentDateTime", "{}"));
//			getCurrentDateTime.content().stream().map(Object::toString).forEach(System.out::println);
//
//			String params = """
//		{
//		  "number1" : 5.0,
//		  "number2" : 4.0
//		}
//		""";
//			McpSchema.CallToolResult multiplyNumbers = mcpSyncClient.callTool(new McpSchema.CallToolRequest("multiplyNumbers", params));
//			multiplyNumbers.content().stream().map(Object::toString).forEach(System.out::println);

//			String complete = aiService.complete("5*4+7=? Use tools if possible");
//			System.out.println(complete);
		};
	}

}

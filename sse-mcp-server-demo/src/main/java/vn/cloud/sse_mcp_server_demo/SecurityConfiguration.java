package vn.cloud.sse_mcp_server_demo;

import org.springframework.ai.mcp.server.autoconfigure.McpServerProperties;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.actuate.metrics.export.prometheus.PrometheusScrapeEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	SecurityFilterChain jwtSecurityFilterChain(HttpSecurity http, McpServerProperties mcpServerProperties) throws Exception {
		http
				.authorizeHttpRequests((requests) ->
						requests.requestMatchers(EndpointRequest.to(PrometheusScrapeEndpoint.class)).permitAll()
								.requestMatchers(HttpMethod.GET, mcpServerProperties.getSseEndpoint()).hasAuthority("SCOPE_mcp")
								.requestMatchers(HttpMethod.POST, mcpServerProperties.getSseMessageEndpoint()).hasAuthority("SCOPE_mcp")
								.anyRequest().authenticated())
				.oauth2ResourceServer(
						(resourceServer) ->
								resourceServer.jwt(Customizer.withDefaults()));
		return http.build();
	}
}

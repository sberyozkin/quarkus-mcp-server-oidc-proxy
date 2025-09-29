package org.acme;

import io.quarkiverse.mcp.server.TextContent;
import io.quarkiverse.mcp.server.Tool;
import io.quarkus.oidc.UserInfo;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.inject.Inject;

public class ServerFeatures {

    @Inject
    SecurityIdentity identity;
    
    @Tool(name = "user-name-provider", description = "Provides a name of the current user")
    TextContent provideUserName() {
        return new TextContent(identity.getPrincipal().getName());
    }
}

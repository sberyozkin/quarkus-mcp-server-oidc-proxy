# Secure MCP HTTP Server with OIDC Proxy

This demo shows how [https://github.com/modelcontextprotocol/inspector](MCP Inspector) can use OAuth2 to access Quarkus MCP HTTP server, with Quarkus OIDC Proxy delegating to Keycloak.

## Start application in the dev mode

Start the application in the dev mode:

```shell script
./mvnw quarkus:dev
```

It also starts a [Keycloak Dev Services container](https://quarkus.io/guides/security-openid-connect-dev-services#dev-services-for-keycloak) and uploads a `quarkus-mcp-realm` realm.

## Launch MCP Inspector:

Launch MCP Inspector:

```shell script
npx @modelcontextprotocol/inspector
```

### Use OAuth2 Flow to register OAuth2 client and connect to Quarkus MCP Alpha Streamable HTTP Server

Choose `Streamable HTTP` Transport Type and set an `http://localhost:8080/mcp` URL address.

Select the Authentication OAuth 2.0 Flow, keep the Client ID and Scope values empty.

Click on `Open OAuth Settings` on the right, select a `Guilded OAuth2 Flow` option.
Start with `Discover Metadata` and `Client Registration`. 
Once the client is registered, and before proceeding with the rest of the `Guilded OAuth2 Flow` sequence,
click on `Keycloak Admin` in the `OpenId Connect` card at `http://localhost:8080/q/dev`, login as `admin:admin`,
select the `quarkus-mcp-server` realm, then the registered client, and add `quarkus-mcp-server` and `profile` scopes as default scopes.

Continue with completing the remaining `Guilded OAuth2 Flow` sequence steps.

Press `Connect`, you will be redirected to the Keycloak `Alpha` realm authentication form, use `alice` as a user name and password to login.
Keycloak will now request you to authorize access to `Quarkus MCP Server`, press `Yes`.

Select and run the `user-name-provider` tool, and you should get `alice` returned.

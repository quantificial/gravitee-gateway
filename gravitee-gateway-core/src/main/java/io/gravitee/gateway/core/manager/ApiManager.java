/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.gateway.core.manager;

import io.gravitee.gateway.core.definition.Api;

import java.util.Collection;

/**
 * This manager interface acts as a bridge between the source of {@link Api} (*.json files in case of
 * local registry and sync scheduler when using the sync mode) and the {@link io.gravitee.gateway.core.Reactor}.
 * This means that all actions handled by the reactor must be done by using this manager and not directly by emitting
 * internal event.
 *
 * @author David BRASSELY (brasseld at gmail.com)
 */
public interface ApiManager {

    /**
     * Deploy an API definition.
     * @param api API definition to deploy.
     */
    void deploy(Api api);

    /**
     * Update an API definition already registered.
     * @param api API definition to update.
     */
    void update(Api api);

    /**
     * Undeploy an API from the {@link io.gravitee.gateway.core.Reactor}.
     * @param apiName The name of the API to undeploy.
     */
    void undeploy(String apiName);

    /**
     * Returns a collection of deployed {@link Api}s.
     * @return A collection of deployed  {@link Api}s.
     */
    Collection<Api> apis();

    /**
     * Retrieve a deployed {@link Api} using its name.
     * @param name The name of the deployed API.
     * @return A deployed {@link Api}
     */
    Api get(String name);
}

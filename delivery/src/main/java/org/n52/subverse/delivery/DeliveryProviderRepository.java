/*
 * Copyright 2016 52°North.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.n52.subverse.delivery;

import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Matthes Rieke <m.rieke@52north.org>
 */
@Component
public class DeliveryProviderRepository {

    @Autowired(required = false)
    private Collection<DeliveryProvider> providers;


    public DeliveryProvider getProvider(Optional<DeliveryDefinition> deliveryDefinition) {
        if (deliveryDefinition.isPresent()) {
            String id = deliveryDefinition.get().getIdentifier();

            for (DeliveryProvider provider : providers) {
                if (provider.supportsDeliveryIdentifier(id)) {
                    return provider;
                }
            }
        }

        return null;
    }

}
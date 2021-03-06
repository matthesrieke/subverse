/*
 * Copyright (C) 2016-2016 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published
 * by the Free Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of
 * the following licenses, the combination of the program with the linked
 * library is not considered a "derivative work" of the program:
 *
 *     - Apache License, version 2.0
 *     - Apache Software License, version 1.0
 *     - GNU Lesser General Public License, version 3
 *     - Mozilla Public License, versions 1.0, 1.1 and 2.0
 *     - Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed
 * under the aforementioned licenses, is permitted by the copyright holders
 * if the distribution is compliant with both the GNU General Public
 * License version 2 and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 */
package org.n52.subverse.subscription;

import com.google.common.base.Objects;
import java.io.Serializable;
import org.n52.subverse.delivery.DeliveryDefinition;
import org.n52.subverse.delivery.DeliveryEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author <a href="mailto:m.rieke@52north.org">Matthes Rieke</a>
 */
public class SubscriptionEndpoint implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(SubscriptionEndpoint.class);
    private final DeliveryEndpoint deliveryEndpoint;
    private final DeliveryDefinition deliveryDefinition;

    public SubscriptionEndpoint(DeliveryEndpoint deliveryEndpoint, DeliveryDefinition deliveryDef) {
        this.deliveryEndpoint = deliveryEndpoint;
        this.deliveryDefinition = deliveryDef;
    }

    public DeliveryEndpoint getDeliveryEndpoint() {
        return deliveryEndpoint;
    }

    public DeliveryDefinition getDeliveryDefinition() {
        return deliveryDefinition;
    }

    public void destroy() {
        if (deliveryEndpoint != null) {
            deliveryEndpoint.destroy();
        }
        else {
            LOG.warn("Could not destroy delivery endpoint: null");
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
            this.deliveryEndpoint);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SubscriptionEndpoint other = (SubscriptionEndpoint) obj;
        return Objects.equal(this.deliveryEndpoint, other.deliveryEndpoint);
    }

}

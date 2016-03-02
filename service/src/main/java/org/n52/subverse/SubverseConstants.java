/*
 * Copyright 2015 52°North Initiative for Geospatial Open Source Software GmbH.
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
package org.n52.subverse;

/**
 *
 * @author <a href="mailto:d.nuest@52north.org">Daniel Nüst</a>
 */
public interface SubverseConstants {

    String WS_N_NAMESPACE = "http://docs.oasis-open.org/wsn/b-2";

    String SERVICE = "PubSub";

    String VERSION = "1.0.0";

    String OPERATION_GET_CAPABILITIES = "GetCapabilities";

    String OPERATION_SUBSCRIBE = "Subscribe";

    String OPERATION_RENEW = "Renew";

    String OPERATION_UNSUBSCRIBE = "Unsubscribe";

    String OPERATION_GET_SUBSCRIPTION = "GetSubscription";

    String OPERATION_NOTIFY = "Notify";

    interface DemoParam {

        String OUTPUT_FORMAT = "outputFormat";

    }

    interface OperationParameter {

        String service = "service"; // OWSConstants.RequestParams.service.name().toLowerCase();

        String version = "version"; // OWSConstants.RequestParams.version.name().toLowerCase();

        String request = "request";
    }

    interface GetCapabilitiesParameter {

        String acceptversions = "acceptversions";
    }

    interface DemoParameter {

        String one = "one";

        String two = "two";

    }

}

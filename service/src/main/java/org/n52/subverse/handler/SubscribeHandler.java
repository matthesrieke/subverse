package org.n52.subverse.handler;

import java.util.Collections;
import java.util.Set;
import org.n52.iceland.ds.OperationHandler;
import org.n52.iceland.ds.OperationHandlerKey;
import org.n52.iceland.exception.ows.OwsExceptionReport;
import org.n52.iceland.ogc.ows.OwsOperation;
import org.n52.subverse.SubverseConstants;
import org.n52.subverse.subscription.SubscribeOptions;
import org.n52.subverse.response.SubscribeResponse;

/**
 * Handlers are a second level layer under the operations and allow to combine business logic across several operators
 *
*/
public class SubscribeHandler implements OperationHandler {

    private static final OperationHandlerKey KEY
            = new OperationHandlerKey(SubverseConstants.SERVICE,
                    SubverseConstants.OPERATION_SUBSCRIBE);

    public SubscribeResponse subscribe(SubscribeOptions request) throws OwsExceptionReport {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getOperationName() {
        return KEY.getOperationName();
    }

    @Override
    public OwsOperation getOperationsMetadata(String service, String version) throws OwsExceptionReport {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<OperationHandlerKey> getKeys() {
        return Collections.singleton(KEY);
    }
}

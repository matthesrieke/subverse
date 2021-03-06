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
package org.n52.subverse.engine;

import org.n52.epos.event.EposEvent;
import org.n52.epos.event.MapEposEvent;

/**
 *
 * @author <a href="mailto:m.rieke@52north.org">Matthes Rieke</a>
 */
public class GenericEposEvent implements EposEvent {

    private final Object originalObject;
    private final long creationTime;
    private final String contentType;
    private String publication;

    public GenericEposEvent(Object message) {
        this(message, null);
    }

    public GenericEposEvent(Object message, String ct) {
        this.originalObject = message;
        this.creationTime = System.currentTimeMillis();
        this.contentType = ct == null ? "text/plain" : ct;
    }

    @Override
    public void setValue(CharSequence key, Object value) {
        if (PublicationFilter.KEY.equals(key)) {
            this.publication = (String) value;
        }
    }

    @Override
    public Object getValue(CharSequence key) {
        if (key.equals(MapEposEvent.ORIGNIAL_OBJECT_KEY)) {
            return getOriginalObject();
        }
        else if (PublicationFilter.KEY.equals(key)) {
            return publication;
        }
        return null;
    }

    @Override
    public Object getOriginalObject() {
        return this.originalObject;
    }

    @Override
    public long getStartTime() {
        return creationTime;
    }

    @Override
    public long getEndTime() {
        return creationTime;
    }

    @Override
    public void addCausalAncestor(EposEvent event) {
    }

    @Override
    public void setOriginalObject(Object input) {
    }

    @Override
    public String getContentType() {
        return this.contentType;
    }

}

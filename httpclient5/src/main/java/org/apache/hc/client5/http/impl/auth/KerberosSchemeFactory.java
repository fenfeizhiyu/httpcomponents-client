/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */
package org.apache.hc.client5.http.impl.auth;

import org.apache.hc.client5.http.DnsResolver;
import org.apache.hc.client5.http.auth.AuthScheme;
import org.apache.hc.client5.http.auth.AuthSchemeProvider;
import org.apache.hc.client5.http.auth.KerberosConfig;
import org.apache.hc.core5.annotation.Contract;
import org.apache.hc.core5.annotation.Experimental;
import org.apache.hc.core5.annotation.ThreadingBehavior;
import org.apache.hc.core5.http.protocol.HttpContext;

/**
 * {@link AuthSchemeProvider} implementation that creates and initializes
 * {@link KerberosScheme} instances.
 * <p>
 * Please note this class is considered experimental and may be discontinued or removed
 * in the future.
 * </p>
 *
 * @since 4.2
 */
@Contract(threading = ThreadingBehavior.STATELESS)
@Experimental
public class KerberosSchemeFactory implements AuthSchemeProvider {

    private final KerberosConfig config;
    private final DnsResolver dnsResolver;

    /**
     * @since 5.0
     */
    public KerberosSchemeFactory(final KerberosConfig config, final DnsResolver dnsResolver) {
        super();
        this.config = config;
        this.dnsResolver = dnsResolver;
    }

    @Override
    public AuthScheme create(final HttpContext context) {
        return new KerberosScheme(this.config, this.dnsResolver);
    }

}

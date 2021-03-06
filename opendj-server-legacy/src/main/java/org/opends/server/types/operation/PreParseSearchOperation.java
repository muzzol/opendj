/*
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions Copyright [year] [name of copyright owner]".
 *
 * Copyright 2006-2008 Sun Microsystems, Inc.
 * Portions Copyright 2013-2016 ForgeRock AS.
 */
package org.opends.server.types.operation;

import java.util.List;
import java.util.Set;

import org.forgerock.opendj.ldap.ByteString;
import org.forgerock.opendj.ldap.DN;
import org.forgerock.opendj.ldap.DereferenceAliasesPolicy;
import org.forgerock.opendj.ldap.SearchScope;
import org.opends.server.types.*;

/**
 * This class defines a set of methods that are available for use by
 * pre-parse plugins for search operations.  Note that this interface
 * is intended only to define an API for use by plugins and is not
 * intended to be implemented by any custom classes.
 */
@org.opends.server.types.PublicAPI(
     stability=org.opends.server.types.StabilityLevel.UNCOMMITTED,
     mayInstantiate=false,
     mayExtend=false,
     mayInvoke=true)
public interface PreParseSearchOperation
       extends PreParseOperation
{
  /**
   * Retrieves the raw, unprocessed base DN as included in the request
   * from the client.  This may or may not contain a valid DN, as no
   * validation will have been performed.
   *
   * @return  The raw, unprocessed base DN as included in the request
   *          from the client.
   */
  ByteString getRawBaseDN();



  /**
   * Specifies the raw, unprocessed base DN for this search operation.
   *
   * @param  rawBaseDN  The raw, unprocessed base DN for this search
                        operation.
   */
  void setRawBaseDN(ByteString rawBaseDN);



  /**
   * Retrieves the scope for this search operation.
   *
   * @return  The scope for this search operation.
   */
  SearchScope getScope();



  /**
   * Specifies the scope for this search operation.
   *
   * @param  scope  The scope for this search operation.
   */
  void setScope(SearchScope scope);



  /**
   * Retrieves the alias dereferencing policy for this search
   * operation.
   *
   * @return  The alias dereferencing policy for this search
   *          operation.
   */
  DereferenceAliasesPolicy getDerefPolicy();



  /**
   * Specifies the alias dereferencing policy for this search
   * operation.
   *
   * @param  derefPolicy  The alias dereferencing policy for this
   *                      search operation.
   */
  void setDerefPolicy(DereferenceAliasesPolicy derefPolicy);



  /**
   * Retrieves the size limit for this search operation.
   *
   * @return  The size limit for this search operation.
   */
  int getSizeLimit();



  /**
   * Specifies the size limit for this search operation.
   *
   * @param  sizeLimit  The size limit for this search operation.
   */
  void setSizeLimit(int sizeLimit);



  /**
   * Retrieves the time limit for this search operation.
   *
   * @return  The time limit for this search operation.
   */
  int getTimeLimit();



  /**
   * Specifies the time limit for this search operation.
   *
   * @param  timeLimit  The time limit for this search operation.
   */
  void setTimeLimit(int timeLimit);



  /**
   * Retrieves the typesOnly flag for this search operation.
   *
   * @return  The typesOnly flag for this search operation.
   */
  boolean getTypesOnly();



  /**
   * Specifies the typesOnly flag for this search operation.
   *
   * @param  typesOnly  The typesOnly flag for this search operation.
   */
  void setTypesOnly(boolean typesOnly);



  /**
   * Retrieves the raw, unprocessed search filter as included in the
   * request from the client.  It may or may not contain a valid
   * filter (e.g., unsupported attribute types or values with an
   * invalid syntax) because no validation will have been performed on
   * it.
   *
   * @return  The raw, unprocessed search filter as included in the
   *          request from the client.
   */
  RawFilter getRawFilter();



  /**
   * Specifies the raw, unprocessed search filter as included in the
   * request from the client.
   *
   * @param  rawFilter  The raw, unprocessed search filter.
   */
  void setRawFilter(RawFilter rawFilter);



  /**
   * Retrieves the set of requested attributes for this search
   * operation.  Its contents should not be altered.
   *
   * @return  The set of requested attributes for this search
   *          operation.
   */
  Set<String> getAttributes();



  /**
   * Specifies the set of requested attributes for this search
   * operation.
   *
   * @param  attributes  The set of requested attributes for this
   *                     search operation.
   */
  void setAttributes(Set<String> attributes);



  /**
   * Returns the provided entry to the client.
   *
   * @param  entry     The entry that should be returned.
   * @param  controls  The set of controls to include with the entry
   *                   (may be {@code null} if no controls should be
   *                   included with the entry).
   *
   * @return  {@code true} if the caller should continue processing
   *          the search request and sending additional entries and
   *          references, or {@code false} if not for some reason
   *          (e.g., the size limit has been reached or the search has
   *          been abandoned).
   */
  boolean returnEntry(Entry entry, List<Control> controls);



  /**
   * Returns the provided search result reference to the client.
   *
   * @param  reference  The search reference that should be returned.
   * @param  dn         A DN related to the specified search reference.
   * @return  {@code true} if the caller should continue processing
   *          the search request and sending additional entries and
   *          references, or {@code false} if not for some reason
   *          (e.g., the size limit has been reached or the search has
   *          been abandoned).
   */
  boolean returnReference(DN dn, SearchResultReference reference);
}


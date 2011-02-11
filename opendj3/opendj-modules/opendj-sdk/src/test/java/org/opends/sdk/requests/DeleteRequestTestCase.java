/*
 * CDDL HEADER START
 *
 * The contents of this file are subject to the terms of the
 * Common Development and Distribution License, Version 1.0 only
 * (the "License").  You may not use this file except in compliance
 * with the License.
 *
 * You can obtain a copy of the license at
 * trunk/opends/resource/legal-notices/OpenDS.LICENSE
 * or https://OpenDS.dev.java.net/OpenDS.LICENSE.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL HEADER in each
 * file and include the License file at
 * trunk/opends/resource/legal-notices/OpenDS.LICENSE.  If applicable,
 * add the following below this CDDL HEADER, with the fields enclosed
 * by brackets "[]" replaced with your own identifying information:
 *      Portions Copyright [yyyy] [name of copyright owner]
 *
 * CDDL HEADER END
 *
 *
 *      Copyright 2010 Sun Microsystems, Inc.
 */

package org.opends.sdk.requests;



import org.opends.sdk.DN;
import org.testng.annotations.DataProvider;



/**
 * Tests the delete request.
 */
public class DeleteRequestTestCase extends RequestTestCase
{
  @DataProvider(name = "DeleteRequests")
  public Object[][] getDeleteRequests() throws Exception
  {
    final DeleteRequest[] requests = {
        Requests.newDeleteRequest(DN.valueOf("uid=Deleterequest1")),
        Requests.newDeleteRequest("cn=Deleterequesttestcase"),
        Requests.newDeleteRequest("uid=user.999,ou=people,o=test") };
    final Object[][] objArray = new Object[requests.length][1];
    for (int i = 0; i < requests.length; i++)
    {
      objArray[i][0] = requests[i];
    }
    return objArray;
  }



  @Override
  protected DeleteRequest[] createTestRequests() throws Exception
  {
    final Object[][] objs = getDeleteRequests();
    final DeleteRequest[] ops = new DeleteRequest[objs.length];
    for (int i = 0; i < objs.length; i++)
    {
      ops[i] = (DeleteRequest) objs[i][0];
    }
    return ops;
  }
}
